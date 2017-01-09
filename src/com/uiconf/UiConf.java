package com.uiconf;

import com.kaltura.client.KalturaApiException;
import com.kaltura.client.KalturaClient;
import com.kaltura.client.types.KalturaUiConf;

/**
 * @author oleg.sigalov
 *
 */
public class UiConf {
	private KalturaUiConf kalturaUiConf;
	private UiConfTypeEnum uiConfType;
	public static final String HTML_PAGE_NAME_ALL_PLAYERS = "all_players_uiconf.html";
	public static final String HTML_PAGE_NAME_ALL_KCW = "all_kcw_uiconf.html";
	public static final String UICONF_HTML_PAGE_ALL_UICONFS_PATH = MainWindow.projectPath + "/resources/out/";

	private final String errorMsg = "KalturaUiConf OBJECT IS NULL";

	public UiConf(KalturaClient client, int uiConfId, UiConfTypeEnum uiConfType) throws KalturaApiException{
			kalturaUiConf = client.getUiConfService().get(uiConfId);
			this.uiConfType = uiConfType;
	}
	/**
	 * @return the kalturaUiConf
	 */
	public KalturaUiConf getKalturaUiConf() {
		return kalturaUiConf;
	}

	public String getConfFile() throws KalturaApiException{
		if (kalturaUiConf != null){
			return kalturaUiConf.confFile;
		}else{
			throw new KalturaApiException(errorMsg);
		}
	}

	public String getAllParams() throws KalturaApiException{
		if (kalturaUiConf != null){
			return kalturaUiConf.toParams().toString();
		}else{
			throw new KalturaApiException(errorMsg);
		}
	}
	/**
	 * @return the uiConfType
	 */
	public UiConfTypeEnum getUiConfType() {
		return uiConfType;
	}
}
