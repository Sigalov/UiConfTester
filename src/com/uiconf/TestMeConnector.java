package com.uiconf;


import com.kaltura.client.enums.*;
import com.kaltura.client.types.*;
import com.kaltura.client.services.*;
import com.kaltura.client.KalturaApiException;
import com.kaltura.client.KalturaClient;
import com.kaltura.client.KalturaConfiguration;
import com.kaltura.client.KalturaLogger;

/**
 * Creates new session
 * 
 * 
 * @author oleg.sigalov
 *
 */
class TestMeConnector {

    private KalturaConfiguration config;
    private KalturaClient client;

    private int partnerId;
    private String adminSecret;
    private String endPoint;
    private String sessionId = null;

	private static KalturaLogger logger = KalturaLogger.getLogger(TestMeConnector.class);

    /**
     * @param parthnerId
     * @param adminSecret
     * @param endPoint
     */
    public TestMeConnector(int parthnerId, String adminSecret, String endPoint) {
        config = new KalturaConfiguration();
        config.setPartnerId(parthnerId);
        config.setEndpoint(endPoint);
        config.setAdminSecret(adminSecret);
        
        client = new KalturaClient(config);
        
        try {
			this.sessionId = startAdminSession();
		} catch (KalturaApiException e) {
			logger.error("Couldn't start Admin Session");
			e.printStackTrace();
		}
    }

    public TestMeConnector() {
		// TODO Auto-generated constructor stub
	}

    public String getRandomVideoEntry(){
    	try {
			return listEntries(KalturaMediaType.VIDEO, 10).id;
		} catch (KalturaApiException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    
    /**
     * Get a list of entries on the kaltura server
     * 
     * @param mediaType  type of entries
     * @param howMany    maximum numer of entries
     *
     * @throws KalturaApiException
     */
    public KalturaMediaEntry listEntries(KalturaMediaType mediaType, int howMany) throws KalturaApiException//TODO change it more clever
    {
            // create a new mediaService object for our client
            KalturaMediaService mediaService = client.getMediaService();
            // create a new filter to filter entries - not mandatory
            KalturaMediaEntryFilter filter = new KalturaMediaEntryFilter();
            filter.mediaTypeEqual = mediaType;
            // create a new pager to choose how many and which entries should be recieved
            // out of the filtered entries - not mandatory
            KalturaFilterPager pager = new KalturaFilterPager();
            pager.pageSize  = howMany;
            // execute the list action of the mediaService object to recieve the list of entries
            KalturaMediaListResponse listResponse = mediaService.list(filter, pager);
            // loop through all entries in the reponse list and print their id.
            System.out.println("Entries list :");
            for (KalturaMediaEntry entry : listResponse.objects) {
                    System.out.println("id:" + entry.id);
            }
            return listResponse.objects.get(0);
    }
    
    
    
    public String startAdminSession() throws KalturaApiException {
        startSession(client, config, config.getAdminSecret(), KalturaSessionType.ADMIN);
        sessionId = client.getSessionId();
        return sessionId;
    }

    protected void startSession(KalturaClient client, KalturaConfiguration kalturaConfig, String secret,
            KalturaSessionType type) throws KalturaApiException {

        KalturaSessionService sessionService = client.getSessionService();

        String sessionId = sessionService.start(secret, "admin", type,
                kalturaConfig.getPartnerId(), 86400, "");
        if (logger.isEnabled()) {
            logger.debug("Session id:" + sessionId);
        }
        client.setSessionId(sessionId);
    }

    public void closeSession(KalturaClient client) throws KalturaApiException {
        client.getSessionService().end();
    }

    /**
     * @return the config
     */
    public KalturaConfiguration getConfig() {
        return config;
    }

    /**
     * @param config the config to set
     */
    public void setConfig(KalturaConfiguration config) {
        this.config = config;
    }

    /**
     * @return the client
     */
    public KalturaClient getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */

    /**
     * @return the parthnerId
     */
    public int getParthnerId() {
        return partnerId;
    }

    /**
     * @param parthnerId the parthnerId to set
     */
    public void setParthnerId(int parthnerId) {
        this.partnerId = parthnerId;
    }

    /**
     * @return the adminSecret
     */
    public String getAdminSecret() {
        return adminSecret;
    }

    /**
     * @param adminSecret the adminSecret to set
     */
    public void setAdminSecret(String adminSecret) {
        this.adminSecret = adminSecret;
    }

    /**
     * @return the endPoint
     */
    public String getEndPoint() {
        return endPoint;
    }

    /**
     * @param endPoint the endPoint to set
     */
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
    
    /**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

}
