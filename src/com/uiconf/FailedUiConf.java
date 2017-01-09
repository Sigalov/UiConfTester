package com.uiconf;

/**
 * @author oleg.sigalov
 *
 */
public class FailedUiConf {
	private String prodUiConfText;
	private String onPremUiConfText;
	
	public FailedUiConf(String prodUiConfText, String onPremUiConfText){
		this.prodUiConfText = prodUiConfText;
		this.onPremUiConfText = onPremUiConfText;
	}

	/**
	 * @return the prodUiConfText
	 */
	public String getProdUiConfText() {
		return prodUiConfText;
	}

	/**
	 * @param prodUiConfText the prodUiConfText to set
	 */
	public void setProdUiConfText(String prodUiConfText) {
		this.prodUiConfText = prodUiConfText;
	}

	/**
	 * @return the onPremUiConfText
	 */
	public String getOnPremUiConfText() {
		return onPremUiConfText;
	}

	/**
	 * @param onPremUiConfText the onPremUiConfText to set
	 */
	public void setOnPremUiConfText(String onPremUiConfText) {
		this.onPremUiConfText = onPremUiConfText;
	}
}
