///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.uiconf;
//
///**
// *
// * @author oleg.sigalov
// * 
// */
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.net.URL;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import javax.xml.transform.stream.StreamSource;
//
//import org.custommonkey.xmlunit.DetailedDiff;
//import org.custommonkey.xmlunit.Diff;
//import org.custommonkey.xmlunit.Transform;
//import org.custommonkey.xmlunit.XMLUnit;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.CommandExecutor;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.w3c.dom.Document;
//
//import com.kaltura.client.KalturaApiException;
//
//public class test {
//	private static final String JQUERY_LOAD_SCRIPT = "resources/script/jQuerify.js";
////	private static org.apache.log4j.Logger log= Logger.getLogger(com.uiconf.test.class); 
//    public static void main(String[] args) throws Exception {
////    	test1();
////    	test2();
//    	 String everything;
//    	 URL seleniumServerUrl = new URL("http://localhost:4444");
//    	 URL serverUnderTest = new URL("http://www.google.com");
//    	 CommandExecutor executor = new SeleneseCommandExecutor(seleniumServerUrl, serverUnderTest, DesiredCapabilities.chrome());
//    	 WebDriver driver = new RemoteWebDriver(executor);
//    	 driver.get("http://www.google.com");
////         WebDriver driver = new FirefoxDriver();
//         driver.get("http://www.google.com");
//
//         String jQueryLoader = readFile(JQUERY_LOAD_SCRIPT);
//
//         // give jQuery time to load asynchronously
//         driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
//         JavascriptExecutor js = (JavascriptExecutor) driver;
//         js.executeAsyncScript(jQueryLoader /*, http://localhost:8080/jquery-1.7.2.js */);
//
//         // ready to rock
//         js.executeScript(
//             "jQuery(function($) { " +
//                 " $('input[name=\"q\"]').val('bada-bing').closest('form').submit(); " +
//             " }); "
//         );
//         
//         
////    	/UiConfTester/src/resources/playerTemplate.html
////    	try(BufferedReader br = new BufferedReader(new FileReader("C:\\work\\ws\\UiConfTester\\src\\resources\\playerTemplate.html"))) {
////    	 try(BufferedReader br = new BufferedReader(new FileReader("C:\\work\\ws\\UiConfTester\\src\\resources\\1.html"))) {
////            StringBuilder sb = new StringBuilder();
////            String line = br.readLine();
////
////            while (line != null) {
////                sb.append(line);
////                sb.append(System.lineSeparator());
////                line = br.readLine();
////            }
////            everything = sb.toString();
////            System.out.println(everything);
////        }
////    	
////    	ResponseLog rl = new ResponseLog();
////    	rl.setVisible(true);
////    	rl.log(everything);
////    	rl.responseLogHtml("");
//    	
////    	"/opt/lampp/htdocs/uiconf/"
////    	 LinuxOperations ssh = new LinuxOperations();
////    	 ssh.uploadFile("/opt/lampp/htdocs/uiconf/");
////    	 getClass().getResource("/resources/crmbo_big.jpg")
////    	ScpTo scp = new ScpTo("/opt/lampp/htdocs/uiconf/oleg111.html", MainWindow.class.getResource("/resources/oleg111.html").toString().replace("file:\"", ""));
////    	 ScpTo scp = new ScpTo("/opt/lampp/htdocs/uiconf/oleg111.html", "C:\\work\\ws\\UiConfTester\\src\\resources\\oleg111.html");
////    	 ScpTo scp = new ScpTo("/opt/lampp/htdocs/uiconf/oleg111.html", "resources/oleg111.html");
////    	 URL resource = ClassLoader.getSystemResource("gui/refresh.png"); 
////    	 ImageIcon tmp = new ImageIcon(resource);
////    	 File file = new File("resources/oleg111.html");
////    	 file.getPath();
//    	 
////    	 ScpFrom scp = new ScpFrom("/opt/lampp/htdocs/uiconf/123.123", "C:\\work\\ws\\UiConfTester\\src\\resources\\");
//    	
//        System.out.println("DONE!");
//    }
//
//    
//    
//    
//    
//    
//    
//    private static void test2() {
//        // The Firefox driver supports javascript 
//        WebDriver driver = new FirefoxDriver();
//        String baseUrl = "http://www.diffchecker.com";
//        
//        // Go to the Google Suggest home page
//        driver.get(baseUrl + "/");
//        
//        driver.findElement(By.xpath("//div[@id='form-content']/form/div[2]/div/div/textarea")).clear();
//        driver.findElement(By.xpath("//div[@id='form-content']/form/div[2]/div/div/textarea")).sendKeys("(com.kaltura.client.KalturaParams) {height=0, objType=1, useCdn=1, width=0, name=drupal kdp, swfUrlVersion=1.0.3, creationMode=2, confFile=<?xml version=\"1.0\" encoding=\"UTF-8\"?> <layouts> 	<layout layoutId=\"fullLarge\" skinPath=\"/content/uiconf/kaltura/drupal/styles_KDP_blue.swf\"> 		<VBox width=\"100%\" height=\"100%\" styleName=\"mlayout\" > 			<HBox width=\"100%\" height=\"30\" styleName=\"TopTitle\" > 				<Label id=\"movieName\" styleName=\"movieName\" height=\"22\" width=\"100%\" label=\"{myKplayer.kalturaShow.kshowName,myKplayer.kalturaEntry.entryName,''}\"/> 				<Button id=\"kalturaLogo\" widht=\"20\" height=\"20\" styleName=\"kalturaLogo\" /> 				<poweredBy id=\"poweredBy\" k_path=\"poweredby/PoweredBy.swf\" styleName=\"poweredBy\" width=\"120\" height=\"18\"/> 			</HBox>  			<HBox width=\"100%\" height=\"100%\" styleName=\"playerContainer\">  				<Canvas id=\"marginLeft\" width=\"5\" height=\"100%\" styleName=\"playerMarginLeft\" />  				<Canvas id=\"PlayerHolder\" styleName=\"PlayerBackground\" width=\"100%\" height=\"100%\" > 					<KplayerModule id=\"myKplayer\" styleName=\"centered\"  k_path=\"kplayer/KplayerModule.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 					<EndScreen id=\"endScreen\" styleName=\"centered\" k_share_click=\"popup:SharePop\"  k_path=\"endScreen/EndScreen.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 				</Canvas> 				<Canvas id=\"marginRight\" width=\"5\" height=\"100%\" styleName=\"playerMarginRight\" />  			</HBox> 			<HBox styleName=\"controllerBox\" height=\"34\" width=\"100%\"> 				<VBox> 					<Button id=\"play\" styleName=\"play\" width=\"15\" height=\"17\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<VBox width=\"100%\" height=\"100%\" styleName=\"scrubberContainer\"> 					<Scrubber id=\"scrubber\" styleName=\"scrubber\" width=\"100%\" /> 					<HBox styleName=\"timerHolder\"> 						<TimerCountdown id=\"timer\" styleName=\"timer\" width=\"30\" height=\"8\" k_path=\"timertext/SimpleTimer.swf\"/> 					</HBox> 				</VBox> 				<VBox> 					<VolumeModule width=\"20\" height=\"20\" k_path=\"VolumeBars/VolumeBarA.swf\" id=\"Volume\" styleName=\"pp\"/>  					<Spacer height=\"4\"/> 				</VBox> 				<VBox> 					<Button id=\"fullScreen\" width=\"20\" height=\"17\" styleName=\"fs\" label=\"\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<Button id=\"addToReel\" styleName=\"bottomButtons\" label=\"UPLOAD\" height=\"18\" width=\"55\" k_click=\"jsInject:gotoContribWizard,pauseMedia\" /> 				<Spacer width=\"4\"/> 				<Button id=\"editReel\" styleName=\"bottomButtons\" label=\"REMIX\" height=\"18\" width=\"45\" k_click=\"jsInject:gotoEditorWindow,pauseMedia\" /> 			</HBox> 		</VBox> 	    <popups> 	    		<SharePop id=\"SharePop\" k_path=\"popups/SharePopup.swf\" width=\"350\" height=\"350\"/>  		</popups> 		<javaScript> 			<jsBlock id=\"gotoContribWizard\" functionName=\"gotoContribWizard\" params=\"kshowId\" > 				<![CDATA[ 					function gotoContribWizard (kshowId) 					{ 						setTimeout(\"handleGotoContribWizard ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 			<jsBlock id=\"gotoEditorWindow\" functionName=\"gotoEditorWindow\" params=\"kshowId\" > 				<![CDATA[ 					function gotoEditorWindow (kshowId) 					{ 						setTimeout(\"handleGotoEditorWindow ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 		</javaScript> 	</layout> </layouts> , objectType=KalturaUiConf, swfUrl=/flash/kdp/v1.0.3/kdp.swf}");
//        driver.findElement(By.xpath("//div[@id='form-content']/form/div/div/div/textarea")).clear();
//        driver.findElement(By.xpath("//div[@id='form-content']/form/div/div/div/textarea")).sendKeys("(com.kaltura.client.KalturaParams) {height=0, useCdn=1, confVars=, width=0, name=drupal kdp, swfUrlVersion=1.2.3CE, creationMode=3, confFile=<?xml version=\"1.0\" encoding=\"UTF-8\"?> <layouts> 	<layout layoutId=\"fullLarge\" skinPath=\"/content/uiconf/kaltura/drupal/styles_KDP_blue.swf\"> 		<VBox width=\"100%\" height=\"100%\" styleName=\"mlayout\" > 			<HBox width=\"100%\" height=\"30\" styleName=\"TopTitle\" > 				<Label id=\"movieName\" styleName=\"movieName\" height=\"22\" width=\"100%\" label=\"{myKplayer.kalturaShow.kshowName,myKplayer.kalturaEntry.entryName,''}\"/> 				<Button id=\"kalturaLogo\" widht=\"20\" height=\"20\" styleName=\"kalturaLogo\" /> 				<poweredBy id=\"poweredBy\" k_path=\"poweredby/PoweredBy.swf\" styleName=\"poweredBy\" width=\"120\" height=\"18\"/> 			</HBox>  			<HBox width=\"100%\" height=\"100%\" styleName=\"playerContainer\">  				<Canvas id=\"marginLeft\" width=\"5\" height=\"100%\" styleName=\"playerMarginLeft\" />  				<Canvas id=\"PlayerHolder\" styleName=\"PlayerBackground\" width=\"100%\" height=\"100%\" > 					<KplayerModule id=\"myKplayer\" styleName=\"centered\"  k_path=\"kplayer/KplayerModule.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 					<EndScreen id=\"endScreen\" styleName=\"centered\" k_share_click=\"popup:SharePop\"  k_path=\"endScreen/EndScreen.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 				</Canvas> 				<Canvas id=\"marginRight\" width=\"5\" height=\"100%\" styleName=\"playerMarginRight\" />  			</HBox> 			<HBox styleName=\"controllerBox\" height=\"34\" width=\"100%\"> 				<VBox> 					<Button id=\"play\" styleName=\"play\" width=\"15\" height=\"17\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<VBox width=\"100%\" height=\"100%\" styleName=\"scrubberContainer\"> 					<Scrubber id=\"scrubber\" styleName=\"scrubber\" width=\"100%\" /> 					<HBox styleName=\"timerHolder\"> 						<TimerCountdown id=\"timer\" styleName=\"timer\" width=\"30\" height=\"8\" k_path=\"timertext/SimpleTimer.swf\"/> 					</HBox> 				</VBox> 				<VBox> 					<VolumeModule width=\"20\" height=\"20\" k_path=\"VolumeBars/VolumeBarA.swf\" id=\"Volume\" styleName=\"pp\"/>  					<Spacer height=\"4\"/> 				</VBox> 				<VBox> 					<Button id=\"fullScreen\" width=\"20\" height=\"17\" styleName=\"fs\" label=\"\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<Button id=\"addToReel\" styleName=\"bottomButtons\" label=\"UPLOAD\" height=\"18\" width=\"55\" k_click=\"jsInject:gotoContribWizard,pauseMedia\" /> 				<Spacer width=\"4\"/> 				<Button id=\"editReel\" styleName=\"bottomButtons\" label=\"REMIX\" height=\"18\" width=\"45\" k_click=\"jsInject:gotoEditorWindow,pauseMedia\" /> 			</HBox> 		</VBox> 	    <popups> 	    		<SharePop id=\"SharePop\" k_path=\"popups/SharePopup.swf\" width=\"350\" height=\"350\"/>  		</popups> 		<javaScript> 			<jsBlock id=\"gotoContribWizard\" functionName=\"gotoContribWizard\" params=\"kshowId\" > 				<![CDATA[ 					function gotoContribWizard (kshowId) 					{ 						setTimeout(\"handleGotoContribWizard ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 			<jsBlock id=\"gotoEditorWindow\" functionName=\"gotoEditorWindow\" params=\"kshowId\" > 				<![CDATA[ 					function gotoEditorWindow (kshowId) 					{ 						setTimeout(\"handleGotoEditorWindow ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 		</javaScript> 	</layout> </layouts> , objectType=KalturaUiConf, swfUrl=/flash/kdp/v1.2.3CE/kdp.swf}");
//        driver.findElement(By.cssSelector("input.blue_button.find_difference")).click();
//        
////        // Enter the query string "Cheese"
////        WebElement query = driver.findElement(By.name("q"));
////        query.sendKeys("Cheese");
////
////        // Sleep until the div we want is visible or 5 seconds is over
////        long end = System.currentTimeMillis() + 5000;
////        while (System.currentTimeMillis() < end) {
////            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));
////
////            // If results have been returned, the results are displayed in a drop down.
////            if (resultsDiv.isDisplayed()) {
////              break;
////            }
////        }
////
////        // And now list the suggestions
////        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
////        
////        for (WebElement suggestion : allSuggestions) {
////            System.out.println(suggestion.getText());
////        }
//
//        driver.quit();
//    }
//	
//
// // its nice to keep JavaScript snippets in separate files.
//    
//
//    // driver
//
//    // helper method
//    private static String readFile(String file) throws IOException {
//        Charset cs = Charset.forName("UTF-8");
//        FileInputStream stream = new FileInputStream(file);
//        try {
//            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
//            StringBuilder builder = new StringBuilder();
//            char[] buffer = new char[8192];
//            int read;
//            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
//                builder.append(buffer, 0, read);
//            }
//            return builder.toString();
//        }
//        finally {
//            stream.close();
//        }        
//    }
//
//
//
//
//
//	public static void test1() throws Exception{
////    	log.info("SDFDSFDS");
////    	File file = new File("1.xml");
////    	System.out.println(readFile("C:\\work\\ws\\UiConfTester\\bin\\1.xml", StandardCharsets.UTF_8));
////    	System.out.println(readFile("C:\\Users\\oleg.sigalov\\Desktop\\1.xml", StandardCharsets.UTF_8));
////        String result = "<abc             attr=\"value1\"                title=\"something\">            </abc>";
//        // will be ok
////        assertXMLEquals("<abc attr=\"value1\" title=\"something\"></abc>", result);
//       // assertXMLEquals(readFile("C:\\Users\\oleg.sigalov\\Desktop\\2.xml", StandardCharsets.UTF_8), readFile("C:\\Users\\oleg.sigalov\\Desktop\\1.xml", StandardCharsets.UTF_8));
////        testAnotherXSLTransformation();
//    	
//    	
//    	
//    	
//    	
//    	
//    	TestMeConnector prodTestMe = new TestMeConnector(1756201, "46d899681d7ca424e044df69cbac689d", "http://www.kaltura.com/");
//		String prodSessionId = prodTestMe.startAdminSession();
//		System.out.println(prodSessionId);
////		
////		TestMeConnector onPremTestMe = new TestMeConnector(1756201, "46d899681d7ca424e044df69cbac689d", "http://www.kaltura.com/");
////		String onPremSessionId = null;
//    	
//		TestMeConnector onPremTestMe = new TestMeConnector(106, "a3557902a2613d080bc88f7881613614", "https://op-ix920-api1.dev.kaltura.com/");
//		String onPremSessionId = null;
//		try {
//			onPremSessionId = onPremTestMe.startAdminSession();
//		} catch (KalturaApiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(onPremSessionId);
//    	
////    	TestMeConnector onPremTestMe = new TestMeConnector(106, "a3557902a2613d080bc88f7881613614", "https://op-ix920-api1.dev.kaltura.com/");
////    	String onPremSessionId = onPremTestMe.startAdminSession();
////		System.out.println(onPremSessionId);
//		
//	
//    	
//		List<Integer> uiConfIdList = new ArrayList<Integer>();
//		//wordpress
//		uiConfIdList.add(15333782);
////		uiConfIdList.add(15333792);
////		uiConfIdList.add(14969192);
////		uiConfIdList.add(11958362);
////		uiConfIdList.add(11958342);
//		
//		for (int uiConfId :  uiConfIdList){
//			UiConf uiConfProd = new UiConf(prodTestMe.getClient(), uiConfId, UiConfTypeEnum.UNKNOWN);
//			UiConf uiConfOnPrem = new UiConf(onPremTestMe.getClient(), uiConfId, UiConfTypeEnum.UNKNOWN);
//			
////			assertXMLEquals(uiConfOnPrem.getConfFile(), uiConfProd.getConfFile());
//			System.out.println(uiConfOnPrem.getAllParams());
//			
//			System.out.println("id**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().id);
//			System.out.println("**********************************\n");
//			
//			System.out.println("name**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().name);
//			assertXMLEquals(uiConfOnPrem.getKalturaUiConf().name, uiConfOnPrem.getKalturaUiConf().name);
//			System.out.println("**********************************\n");
//
//			System.out.println("description**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().description);
//			System.out.println("**********************************\n");
//
//			System.out.println("partnerId**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().partnerId);
//			System.out.println("**********************************\n");
//
//			System.out.println("objType**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().objType);
//			System.out.println("**********************************\n");
//
//			System.out.println("objTypeAsString**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().objTypeAsString);
//			System.out.println("**********************************\n");
//
//			System.out.println("width**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().width);
//			System.out.println("**********************************\n");
//
//			System.out.println("height**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().height);
//			System.out.println("**********************************\n");
//
//			System.out.println("htmlParams**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().htmlParams);
//			System.out.println("**********************************\n");
//
//			System.out.println("swfUrl**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().swfUrl);
//			System.out.println("**********************************\n");
//
//			System.out.println("confFilePath**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().confFilePath);
//			System.out.println("**********************************\n");
//
//			System.out.println("confFile**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().confFile);
//			System.out.println("**********************************\n");
//
//			System.out.println("confFileFeatures**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().confFileFeatures);
//			System.out.println("**********************************\n");
//
//			System.out.println("config**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().config);
//			System.out.println("**********************************\n");
//
//			System.out.println("confVars**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().confVars);
//			System.out.println("**********************************\n");
//
//			System.out.println("useCdn**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().useCdn);
//			System.out.println("**********************************\n");
//
//			System.out.println("tags**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().tags);
//			System.out.println("**********************************\n");
//
//			System.out.println("swfUrlVersion**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().swfUrlVersion);
//			System.out.println("**********************************\n");
//
//			System.out.println("createdAt**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().createdAt);
//			System.out.println("**********************************\n");
//
//			System.out.println("updatedAt**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().updatedAt);
//			System.out.println("**********************************\n");
//
//			System.out.println("creationMode**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().creationMode);
//			System.out.println("**********************************\n");
//
//			System.out.println("html5Url**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().html5Url);
//			System.out.println("**********************************\n");
//
//			System.out.println("version**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().version);
//			System.out.println("**********************************\n");
//
//			System.out.println("partnerTags**********************************\n");
//			System.out.println(uiConfOnPrem.getKalturaUiConf().partnerTags);
//			System.out.println("**********************************\n");
//
//		}
//    	
//    	
//    	
//    	
//    }
//    
//    
//    public static void assertXMLEquals(String expectedXML, String actualXML) throws Exception {
//        XMLUnit.setIgnoreWhitespace(true);
//        XMLUnit.setIgnoreAttributeOrder(true);
//
//        DetailedDiff diff = new DetailedDiff(XMLUnit.compareXML(expectedXML, actualXML));
//
//        List<?> allDifferences = diff.getAllDifferences();
//        Assert.assertEquals("Differences found: "+ diff.toString(), 0, allDifferences.size());
//    }
//    
//    public static void testAnotherXSLTransformation() throws Exception {
//        File myInputXMLFile = new File("C:\\Users\\oleg.sigalov\\Desktop\\2.xml");
//        File myStylesheetFile = new File("C:\\Users\\oleg.sigalov\\Desktop\\1.xml");
//        Transform myTransform = new Transform(
//            new StreamSource(myInputXMLFile),
//            new StreamSource(myStylesheetFile));
//        Document myExpectedOutputXML =
//           XMLUnit.buildDocument(XMLUnit.getControlParser(),
//                                 new FileReader("..."));
//        Diff myDiff = new Diff(myExpectedOutputXML,
//        myTransform.getResultDocument());
//        Assert.assertTrue("XSL transformation worked as expected", myDiff.similar());
//    }
//    static String readFile(String path, Charset encoding)  throws IOException 
//    		{
//    		  byte[] encoded = Files.readAllBytes(Paths.get(path));
//    		  return new String(encoded, encoding);
//    		}
//}