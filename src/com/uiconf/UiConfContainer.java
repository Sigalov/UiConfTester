/**
 * 
 */
package com.uiconf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.kaltura.client.KalturaLogger;
import com.linux.ScpTo;

/**
 * @author oleg.sigalov
 *
 */
public class UiConfContainer {
	private KalturaLogger logger = KalturaLogger.getLogger(UiConfContainer.class);

	public static List<UiConfEntry> uiConfList;

	public static final String IFRAME_TEMPLATE_STRING = "<p>&uiconf_details&</p></br>"
			+ "<iframe frameborder=\"0\" "
			+ "src = \"$uiconf_html_url$\" "
			+ "scrolling=\"no\" "
			+ "width=\"800\" "
			+ "height=\"400\">"
			+ "</iframe></br>";

	public UiConfContainer(){
		uiConfList = new ArrayList<UiConfEntry>();
	}

	public void preparePlayerHTMLfiles(){
		String uiConfURL = null;
		String fileContent = null;
		String fileContentAllPlayers = "List of all players\n\n";
		String fileContentAllKcw = "List of all KCW\n\n";
		String fileName = null;
		String localFilePath = null;
		String templateName = null;

		for (UiConfEntry uiConfEntry : uiConfList){


			switch (uiConfEntry.getUiConfType()) {
			case PLAYER: 
				templateName = "resources/templates/playerTemplate.html";
				fileName = "player_uiconf_" + uiConfEntry.getUiConfId() + ".html";
				break;
			case KCW: 
				templateName = "resources/templates/kcwTemplate.html";
				fileName = "kcw_uiconf_" + uiConfEntry.getUiConfId() + ".html";
				break;
			default: 
				break;
			}

			if (!uiConfEntry.getUiConfType().equals(UiConfTypeEnum.UNKNOWN)){
				try {
					fileContent = createHtmlTag(templateName,
							uiConfEntry.getUiConfId(), MainWindow.onPremTestMe.getConfig().getPartnerId(), MainWindow.onPremTestMe.getRandomVideoEntry(), MainWindow.onPremTestMe.getSessionId());//TODO get entry id from API!!
//							uiConfEntry.getUiConfId(), MainWindow.onPremTestMe.getConfig().getPartnerId(), "0_azifke9z", MainWindow.onPremTestMe.getSessionId());//TODO get entry id from API!!
							//TODO DEBUG:
							//uiConfEntry.getUiConfId(), 959472, "1_3u4nvppb", MainWindow.onPremTestMe.getSessionId());//TODO get entry id from API!!		
					//Create the HTML page locally
					localFilePath = MainWindow.projectPath + "/resources/out/" + fileName;
					FileUtils.writeStringToFile(new File(localFilePath), fileContent);

					switch (uiConfEntry.getUiConfType()) {
					case PLAYER: 
						//Append all player tags to one HTML page
						fileContentAllPlayers = fileContentAllPlayers + 
								IFRAME_TEMPLATE_STRING.replace("&uiconf_details&", 
										uiConfEntry.toString()).replace("$uiconf_html_url$", fileName) + "\n\n";
						break;
					case KCW: 
						//Append all KCW tags to one HTML page
						fileContentAllKcw = fileContentAllKcw + 
								IFRAME_TEMPLATE_STRING.replace("&uiconf_details&", 
										uiConfEntry.toString()).replace("$uiconf_html_url$", fileName) + "\n\n";
						break;
					default: 
						break;
					}

					//Create (scp) the HTML file on apache machine (linux)
					try {
						new ScpTo(MainWindow.LINUX_PATH + fileName, localFilePath);
					} catch (Exception e) {
						logger.error("Failed to write to apache machine: "
								+ "Host = " + MainWindow.LINUX_HOSTNAME + "\n"
								+ "User = " + MainWindow.LINUX_USERNAME + "\n"
								+ "Password = " + MainWindow.LINUX_PASSWORD + "\n"
								+ "Path to write = " + MainWindow.LINUX_PATH);
						logger.debug(e.getMessage());
					}
					uiConfURL = MainWindow.LINUX_URL + fileName;
					uiConfEntry.setUiConfURL(uiConfURL);
					logger.info("[" + uiConfEntry.getInnerId() + "] Test page of UiConfID = " + uiConfEntry.getUiConfId() + 
							" was created at \"" + uiConfURL + "\"");
				} catch (IOException e) {
					logger.error("Filed to prepare HTML page with player info: \n" + uiConfEntry.toString());
					logger.debug("Filed to prepare HTML page with player info: \n" + uiConfEntry.toString() + "\n" + e.getMessage());
				}
			}
		}
		//Create HTML page with all palyers, kcw locally
		try {
			FileUtils.writeStringToFile(new File(UiConf.UICONF_HTML_PAGE_ALL_UICONFS_PATH + UiConf.HTML_PAGE_NAME_ALL_PLAYERS), fileContentAllPlayers);
			FileUtils.writeStringToFile(new File(UiConf.UICONF_HTML_PAGE_ALL_UICONFS_PATH + UiConf.HTML_PAGE_NAME_ALL_KCW), fileContentAllKcw);
		} catch (Exception e) {
			logger.error("Failed to write to apache machine: "
					+ "Host = " + MainWindow.LINUX_HOSTNAME + "\n"
					+ "User = " + MainWindow.LINUX_USERNAME + "\n"
					+ "Password = " + MainWindow.LINUX_PASSWORD + "\n"
					+ "Path to write = " + MainWindow.LINUX_PATH);
			logger.debug(e.getMessage());
		}

		try {
			new ScpTo(MainWindow.LINUX_PATH + UiConf.HTML_PAGE_NAME_ALL_PLAYERS, UiConf.UICONF_HTML_PAGE_ALL_UICONFS_PATH  + UiConf.HTML_PAGE_NAME_ALL_PLAYERS);
		} catch (Exception e) {
			logger.error("FAILED to prepare HTML page with all players: " + UiConf.UICONF_HTML_PAGE_ALL_UICONFS_PATH  + UiConf.HTML_PAGE_NAME_ALL_PLAYERS);
			logger.debug("FAILED to prepare HTML page with all players.\n Page source: \n" + fileContentAllPlayers + "\n EXCEPTION: " + e.getMessage());
		}
		

		logger.info("\nTest HTML page with all player tags was created: " +
				MainWindow.LINUX_URL + UiConf.HTML_PAGE_NAME_ALL_PLAYERS +
				"\"\nGo to \"Tools\" > \"Open all players in one HTML page\"\n");
		
		try {
			new ScpTo(MainWindow.LINUX_PATH + UiConf.HTML_PAGE_NAME_ALL_KCW, UiConf.UICONF_HTML_PAGE_ALL_UICONFS_PATH  + UiConf.HTML_PAGE_NAME_ALL_KCW);
		} catch (Exception e) {
			logger.error("FAILED to prepare HTML page with all KCWs: " + UiConf.UICONF_HTML_PAGE_ALL_UICONFS_PATH  + UiConf.HTML_PAGE_NAME_ALL_KCW);
			logger.debug("FAILED to prepare HTML page with all KCWs.\n Page source: \n" + fileContentAllKcw + "\n EXCEPTION: " + e.getMessage());
		}

		logger.info("Test HTML page with all KCW tags was created: " +
				MainWindow.LINUX_URL + UiConf.HTML_PAGE_NAME_ALL_KCW +
				"\"\nGo to \"Tools\" > \"Open all KCW types in one HTML page\"\n");

	}

	private String createHtmlTag(String htmlFileTemplatePath, int uiConfId, int partnerId, String entryId, String ks){
		BufferedReader br = null;
		String dataString = null;
		try {
			br = new BufferedReader(new FileReader(htmlFileTemplatePath));
		} catch (FileNotFoundException e) {
			logger.error("Failed to locate HTML player template file, verify file exists in /resources/templates/[htmlFileTemplate].html");
			logger.debug("Failed to locate HTML player template file:\n" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			dataString = sb.toString();
			br.close();
		} catch (IOException e) {
			logger.error("Failed to read file, file may be corrupted!");
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		if (dataString.contains("$uiConfId$")){
			dataString = dataString.replace("$uiConfId$", String.valueOf(uiConfId));
		}

		if (dataString.contains("$partnerId$")){
			//TODO debug override
			//partnerId = 1270801;
			dataString = dataString.replace("$partnerId$",String.valueOf(partnerId));
		}

		if (dataString.contains("$entryId$")){
			dataString = dataString.replace("$entryId$", entryId);
		}

		if (dataString.contains("$kalturaSession$")){
			//TODO debug override
			//ks = "djJ8MTI3MDgwMXwPAS4x8muk6mxL7Ao54v_W12dqtQi30hpQxLWm6B1Ed17AHME1sl01cNHyqmhUp0odtpjeuF49d2wDja2m0dY71qQK7diVw4r05b2GiUpnT0XxDEJ9KpCYy1ZdqajL6gxh4kFD_wzeP1pvOSZktcyC";
			dataString = dataString.replace("$kalturaSession$", ks);
		}

		return dataString;
	}

	/**
	 * @return the uiConfList
	 */
	protected static List<UiConfEntry> getUiConfList() {
		return uiConfList;
	}

	/**
	 * @param uiConfList the uiConfList to set
	 */
	protected static void setUiConfList(List<UiConfEntry> uiConfList) {
		UiConfContainer.uiConfList = uiConfList;
	}
}
