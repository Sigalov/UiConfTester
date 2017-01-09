/**
 * 
 */
package com.uiconf;

import com.kaltura.client.KalturaLogger;

/**
 * @author oleg.sigalov
 *
 */
public enum UiConfTypeEnum {
		PLAYER("player"), KCW("kcw"), UNKNOWN("unknown");

		private String uiConfType;
		
		private static KalturaLogger logger = KalturaLogger.getLogger(MainWindow.class);

		private UiConfTypeEnum(String uiConfType) {
			this.uiConfType = uiConfType;
		}

		/**
		 * @return the uiConfType
		 */
		public String getUiConfType() {
			return uiConfType;
		}

		/**
		 * @param uiConfType the uiConfType to set
		 */
		public void setUiConfType(String uiConfType) {
			this.uiConfType = uiConfType;
		}
		
		public static UiConfTypeEnum getUiConfTypeEnumFromString(String value){
			for (UiConfTypeEnum uiConfTypeEnum : UiConfTypeEnum.values()){
				if (uiConfTypeEnum.getUiConfType().equals(value)){
					logger.debug("ENUM = " + value);
					return uiConfTypeEnum;
				}
			}
			logger.debug("UNKNOWN enum detected: " + value);
			return UiConfTypeEnum.UNKNOWN;
		}
		
	}
