package com.linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.kaltura.client.KalturaLogger;
import com.uiconf.MainWindow;

public class SSHClient {
	private static String username="";
	private static String host="";
	private static String password="";
	private static int port=22;

	private static InputStream outputstream_from_the_channel;
	public static Channel channel;
	private static Session session;
	private static PrintStream commander;

	private static SSHClient sSHClient = new SSHClient(); 

	private static BufferedReader fromServer;

	static KalturaLogger logger = KalturaLogger.getLogger(SSHClient.class);

	private SSHClient(){
		setLoginParameters();
		String errorMsg = "Failed to connect to apache machine: "
				+ "Host = " + MainWindow.LINUX_HOSTNAME + "\n"
				+ "User = " + MainWindow.LINUX_USERNAME + "\n"
				+ "Password = " + MainWindow.LINUX_PASSWORD;
		try {
			JSch jsch=new JSch();
			session=jsch.getSession(username, host, port);
			session.setPassword(password);
			java.util.Properties config = new java.util.Properties(); 
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();

			channel = session.openChannel("shell");

			OutputStream inputstream_for_the_channel = channel.getOutputStream();
			commander = new PrintStream(inputstream_for_the_channel, true);

			channel.connect();

			fromServer = new BufferedReader(new InputStreamReader(channel.getInputStream()));
			commander.println("sudo -i");  


		} catch (JSchException e) {
			logger.error(errorMsg);
			logger.debug(e.getMessage());
		} catch (IOException e) {
			logger.error(errorMsg);
			logger.debug(e.getMessage());
		}
	}

	private void setLoginParameters() {
		username = 	MainWindow.LINUX_USERNAME;
		if (username.equals("")){
			//TODO msg
		}

		host = MainWindow.LINUX_HOSTNAME;
		if (host.equals("")){
			//TODO msg
		}

		password = MainWindow.LINUX_PASSWORD;
		if (password.equals("")){
			//TODO msg
		}    
	}

	@SuppressWarnings("unused")
	private void disconnect() throws IOException {
		commander.close();
		outputstream_from_the_channel.close();
		channel.disconnect();
		session.disconnect();
	}

	public static SSHClient getInstance(){
		return sSHClient;
	}

	public static Session getSession(){
		return session;
	}

	public String executeCommand(String cmd){
		String msg  = null;
		try {
			commander.println(cmd);
			msg = printPromt();
			logger.info(msg);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return msg;
	}



	public String printPromt() throws IOException, InterruptedException {
		StringBuilder builder = new StringBuilder();  
		String line = "";  
		while(line != null) {  
			line = fromServer.readLine();
			builder.append(line).append("\n");
			if (line.trim().endsWith("#") || line.trim().endsWith(">")){
				break;
			}
		}  
		String result = builder.toString();  
		System.out.println(result);
		return result;
	}

}
