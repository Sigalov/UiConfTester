package com.linux;

/**
 * http://www.jcraft.com/jsch/examples/ScpFrom.java.html
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class ScpFrom{
	static Session session;

	public ScpFrom(String remoteFilePath, String localFilePath) throws Exception{
		session = SSHClient.getSession();
		if (session!=null){
			getFile(remoteFilePath, localFilePath);
		}else{
				throw new Exception("session = null");
		}
	}
	
	private boolean getFile(String remoteFilePath, String localFilePath){
		FileOutputStream fos=null;
		try{
			String prefix=null;
			if(new File(localFilePath).isDirectory()){
				prefix=localFilePath+File.separator;
			}

			String command="scp -f "+remoteFilePath;
			Channel channel=session.openChannel("exec");
			((ChannelExec)channel).setCommand(command);

			// get I/O streams for remote scp
			OutputStream out=channel.getOutputStream();
			InputStream in=channel.getInputStream();

			channel.connect();

			byte[] buf=new byte[1024];

			// send '\0'
			buf[0]=0; out.write(buf, 0, 1); out.flush();

			while(true){
				int c=checkAck(in);
				if(c!='C'){
					break;
				}

				// read '0644 '
				in.read(buf, 0, 5);

				long filesize=0L;
				while(true){
					if(in.read(buf, 0, 1)<0){
						// error
						break; 
					}
					if(buf[0]==' ')break;
					filesize=filesize*10L+(long)(buf[0]-'0');
				}

				String file=null;
				for(int i=0;;i++){
					in.read(buf, i, 1);
					if(buf[i]==(byte)0x0a){
						file=new String(buf, 0, i);
						break;
					}
				}

				// send '\0'
				buf[0]=0; out.write(buf, 0, 1); out.flush();

				// read a content of lfile
				fos=new FileOutputStream(prefix==null ? localFilePath : prefix+file);
				int foo;
				while(true){
					if(buf.length<filesize) foo=buf.length;
					else foo=(int)filesize;
					foo=in.read(buf, 0, foo);
					if(foo<0){
						// error 
						break;
					}
					fos.write(buf, 0, foo);
					filesize-=foo;
					if(filesize==0L) break;
				}
				fos.close();
				fos=null;

				if(checkAck(in)!=0){
					System.exit(0);
				}

				// send '\0'
				buf[0]=0; out.write(buf, 0, 1); out.flush();
			}
			channel.disconnect();
		}
		catch(Exception e){
			System.out.println(e);
			try{if(fos!=null)fos.close();}catch(Exception ee){}
			return false;
		}
		return true;
	}

	static int checkAck(InputStream in) throws IOException{
		int b=in.read();
		// b may be 0 for success,
		//          1 for error,
		//          2 for fatal error,
		//          -1
		if(b==0) return b;
		if(b==-1) return b;

		if(b==1 || b==2){
			StringBuffer sb=new StringBuffer();
			int c;
			do {
				c=in.read();
				sb.append((char)c);
			}
			while(c!='\n');
			if(b==1){ // error
				System.out.print(sb.toString());
			}
			if(b==2){ // fatal error
				System.out.print(sb.toString());
			}
		}
		return b;
	}
}