/**
 * 
 */
package com.uiconf;

/**
 * @author oleg.sigalov
 *
 */
public class UiConfEntry {
	private int innerId;
	private String extension;
	private int uiConfId;
	private String description;
	private UiConfTypeEnum uiConfType;
	private String uiConfURL = "www.kaltura.com";
	
	public UiConfEntry(int innerId, String extension, int uiConfId, String description, UiConfTypeEnum uiConfType){
		this.innerId = innerId;
		this.extension = extension;
		this.uiConfId = uiConfId;
		this.description = description;
		this.uiConfType = uiConfType;
	}
	/**
	 * @return the innerId
	 */
	protected int getInnerId() {
		return innerId;
	}
	
	/**
	 * @return the extension
	 */
	protected String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	protected void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return the uiConfId
	 */
	protected int getUiConfId() {
		return uiConfId;
	}

	/**
	 * @param uiConfId the uiConfId to set
	 */
	protected void setUiConfId(int uiConfId) {
		this.uiConfId = uiConfId;
	}

	/**
	 * @return the description
	 */
	protected String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	protected void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the uiConfType
	 */
	protected UiConfTypeEnum getUiConfType() {
		return uiConfType;
	}

	/**
	 * @param uiConfType the uiConfType to set
	 */
	protected void setUiConfType(UiConfTypeEnum uiConfType) {
		this.uiConfType = uiConfType;
	}
	
	/**
	 * @return the playerURL
	 */
	protected String getUiConfURL() {
		return uiConfURL;
	}
	/**
	 * @param playerURL the playerURL to set
	 */
	protected void setUiConfURL(String playerURL) {
		this.uiConfURL = playerURL;
	}
	
	@Override
	public String toString(){
		return "UiConf ID = " + uiConfId + ";"
						+ " Description = " + description + ";"
								+ " UiConf Type = " + uiConfType.getUiConfType();
	}
}
