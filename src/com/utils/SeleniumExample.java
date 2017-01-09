package com.utils;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumExample {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//	  System.setProperty("webdriver.chrome.driver", "C:\\Presonal\\chromedriver.exe");
		//    driver = new ChromeDriver();
		baseUrl = "http://www.diffchecker.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSeleniumExample() throws Exception {
		String text1 = "(com.kaltura.client.KalturaParams) {height=0, objType=1, useCdn=1, width=0, name=drupal kdp, swfUrlVersion=1.0.3, creationMode=2, confFile=<?xml version=\"1.0\" encoding=\"UTF-8\"?> <layouts> 	<layout layoutId=\"fullLarge\" skinPath=\"/content/uiconf/kaltura/drupal/styles_KDP_blue.swf\"> 		<VBox width=\"100%\" height=\"100%\" styleName=\"mlayout\" > 			<HBox width=\"100%\" height=\"30\" styleName=\"TopTitle\" > 				<Label id=\"movieName\" styleName=\"movieName\" height=\"22\" width=\"100%\" label=\"{myKplayer.kalturaShow.kshowName,myKplayer.kalturaEntry.entryName,''}\"/> 				<Button id=\"kalturaLogo\" widht=\"20\" height=\"20\" styleName=\"kalturaLogo\" /> 				<poweredBy id=\"poweredBy\" k_path=\"poweredby/PoweredBy.swf\" styleName=\"poweredBy\" width=\"120\" height=\"18\"/> 			</HBox>  			<HBox width=\"100%\" height=\"100%\" styleName=\"playerContainer\">  				<Canvas id=\"marginLeft\" width=\"5\" height=\"100%\" styleName=\"playerMarginLeft\" />  				<Canvas id=\"PlayerHolder\" styleName=\"PlayerBackground\" width=\"100%\" height=\"100%\" > 					<KplayerModule id=\"myKplayer\" styleName=\"centered\"  k_path=\"kplayer/KplayerModule.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 					<EndScreen id=\"endScreen\" styleName=\"centered\" k_share_click=\"popup:SharePop\"  k_path=\"endScreen/EndScreen.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 				</Canvas> 				<Canvas id=\"marginRight\" width=\"5\" height=\"100%\" styleName=\"playerMarginRight\" />  			</HBox> 			<HBox styleName=\"controllerBox\" height=\"34\" width=\"100%\"> 				<VBox> 					<Button id=\"play\" styleName=\"play\" width=\"15\" height=\"17\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<VBox width=\"100%\" height=\"100%\" styleName=\"scrubberContainer\"> 					<Scrubber id=\"scrubber\" styleName=\"scrubber\" width=\"100%\" /> 					<HBox styleName=\"timerHolder\"> 						<TimerCountdown id=\"timer\" styleName=\"timer\" width=\"30\" height=\"8\" k_path=\"timertext/SimpleTimer.swf\"/> 					</HBox> 				</VBox> 				<VBox> 					<VolumeModule width=\"20\" height=\"20\" k_path=\"VolumeBars/VolumeBarA.swf\" id=\"Volume\" styleName=\"pp\"/>  					<Spacer height=\"4\"/> 				</VBox> 				<VBox> 					<Button id=\"fullScreen\" width=\"20\" height=\"17\" styleName=\"fs\" label=\"\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<Button id=\"addToReel\" styleName=\"bottomButtons\" label=\"UPLOAD\" height=\"18\" width=\"55\" k_click=\"jsInject:gotoContribWizard,pauseMedia\" /> 				<Spacer width=\"4\"/> 				<Button id=\"editReel\" styleName=\"bottomButtons\" label=\"REMIX\" height=\"18\" width=\"45\" k_click=\"jsInject:gotoEditorWindow,pauseMedia\" /> 			</HBox> 		</VBox> 	    <popups> 	    		<SharePop id=\"SharePop\" k_path=\"popups/SharePopup.swf\" width=\"350\" height=\"350\"/>  		</popups> 		<javaScript> 			<jsBlock id=\"gotoContribWizard\" functionName=\"gotoContribWizard\" params=\"kshowId\" > 				<![CDATA[ 					function gotoContribWizard (kshowId) 					{ 						setTimeout(\"handleGotoContribWizard ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 			<jsBlock id=\"gotoEditorWindow\" functionName=\"gotoEditorWindow\" params=\"kshowId\" > 				<![CDATA[ 					function gotoEditorWindow (kshowId) 					{ 						setTimeout(\"handleGotoEditorWindow ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 		</javaScript> 	</layout> </layouts> , objectType=KalturaUiConf, swfUrl=/flash/kdp/v1.0.3/kdp.swf}";
		String text2 = "(com.kaltura.client.KalturaParams) {height=0, useCdn=1, confVars=, width=0, name=drupal kdp, swfUrlVersion=1.2.3CE, creationMode=3, confFile=<?xml version=\"1.0\" encoding=\"UTF-8\"?> <layouts> 	<layout layoutId=\"fullLarge\" skinPath=\"/content/uiconf/kaltura/drupal/styles_KDP_blue.swf\"> 		<VBox width=\"100%\" height=\"100%\" styleName=\"mlayout\" > 			<HBox width=\"100%\" height=\"30\" styleName=\"TopTitle\" > 				<Label id=\"movieName\" styleName=\"movieName\" height=\"22\" width=\"100%\" label=\"{myKplayer.kalturaShow.kshowName,myKplayer.kalturaEntry.entryName,''}\"/> 				<Button id=\"kalturaLogo\" widht=\"20\" height=\"20\" styleName=\"kalturaLogo\" /> 				<poweredBy id=\"poweredBy\" k_path=\"poweredby/PoweredBy.swf\" styleName=\"poweredBy\" width=\"120\" height=\"18\"/> 			</HBox>  			<HBox width=\"100%\" height=\"100%\" styleName=\"playerContainer\">  				<Canvas id=\"marginLeft\" width=\"5\" height=\"100%\" styleName=\"playerMarginLeft\" />  				<Canvas id=\"PlayerHolder\" styleName=\"PlayerBackground\" width=\"100%\" height=\"100%\" > 					<KplayerModule id=\"myKplayer\" styleName=\"centered\"  k_path=\"kplayer/KplayerModule.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 					<EndScreen id=\"endScreen\" styleName=\"centered\" k_share_click=\"popup:SharePop\"  k_path=\"endScreen/EndScreen.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 				</Canvas> 				<Canvas id=\"marginRight\" width=\"5\" height=\"100%\" styleName=\"playerMarginRight\" />  			</HBox> 			<HBox styleName=\"controllerBox\" height=\"34\" width=\"100%\"> 				<VBox> 					<Button id=\"play\" styleName=\"play\" width=\"15\" height=\"17\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<VBox width=\"100%\" height=\"100%\" styleName=\"scrubberContainer\"> 					<Scrubber id=\"scrubber\" styleName=\"scrubber\" width=\"100%\" /> 					<HBox styleName=\"timerHolder\"> 						<TimerCountdown id=\"timer\" styleName=\"timer\" width=\"30\" height=\"8\" k_path=\"timertext/SimpleTimer.swf\"/> 					</HBox> 				</VBox> 				<VBox> 					<VolumeModule width=\"20\" height=\"20\" k_path=\"VolumeBars/VolumeBarA.swf\" id=\"Volume\" styleName=\"pp\"/>  					<Spacer height=\"4\"/> 				</VBox> 				<VBox> 					<Button id=\"fullScreen\" width=\"20\" height=\"17\" styleName=\"fs\" label=\"\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<Button id=\"addToReel\" styleName=\"bottomButtons\" label=\"UPLOAD\" height=\"18\" width=\"55\" k_click=\"jsInject:gotoContribWizard,pauseMedia\" /> 				<Spacer width=\"4\"/> 				<Button id=\"editReel\" styleName=\"bottomButtons\" label=\"REMIX\" height=\"18\" width=\"45\" k_click=\"jsInject:gotoEditorWindow,pauseMedia\" /> 			</HBox> 		</VBox> 	    <popups> 	    		<SharePop id=\"SharePop\" k_path=\"popups/SharePopup.swf\" width=\"350\" height=\"350\"/>  		</popups> 		<javaScript> 			<jsBlock id=\"gotoContribWizard\" functionName=\"gotoContribWizard\" params=\"kshowId\" > 				<![CDATA[ 					function gotoContribWizard (kshowId) 					{ 						setTimeout(\"handleGotoContribWizard ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 			<jsBlock id=\"gotoEditorWindow\" functionName=\"gotoEditorWindow\" params=\"kshowId\" > 				<![CDATA[ 					function gotoEditorWindow (kshowId) 					{ 						setTimeout(\"handleGotoEditorWindow ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 		</javaScript> 	</layout> </layouts> , objectType=KalturaUiConf, swfUrl=/flash/kdp/v1.2.3CE/kdp.swf}";

		driver.get(baseUrl + "/");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//	  js.executeScript("document.getElementById('file1').removeAttr('display');");
		js.executeScript("document.getElementById('file2').style.display = 'inline';");
		js.executeScript("document.getElementById('file1').style.display = 'inline';");

		driver.findElement(By.name("file1")).sendKeys(text1);
		driver.findElement(By.name("file2")).sendKeys(text2);

		//    driver.findElement(By.name("id=file2")).sendKeys("TESTING");//id="file2"
		//    driver.findElement(By.name("file2")).sendKeys("(com.kaltura.client.KalturaParams) {height=0, objType=1, useCdn=1, width=0, name=drupal kdp, swfUrlVersion=1.0.3, creationMode=2, confFile=<?xml version=\"1.0\" encoding=\"UTF-8\"?> <layouts> 	<layout layoutId=\"fullLarge\" skinPath=\"/content/uiconf/kaltura/drupal/styles_KDP_blue.swf\"> 		<VBox width=\"100%\" height=\"100%\" styleName=\"mlayout\" > 			<HBox width=\"100%\" height=\"30\" styleName=\"TopTitle\" > 				<Label id=\"movieName\" styleName=\"movieName\" height=\"22\" width=\"100%\" label=\"{myKplayer.kalturaShow.kshowName,myKplayer.kalturaEntry.entryName,''}\"/> 				<Button id=\"kalturaLogo\" widht=\"20\" height=\"20\" styleName=\"kalturaLogo\" /> 				<poweredBy id=\"poweredBy\" k_path=\"poweredby/PoweredBy.swf\" styleName=\"poweredBy\" width=\"120\" height=\"18\"/> 			</HBox>  			<HBox width=\"100%\" height=\"100%\" styleName=\"playerContainer\">  				<Canvas id=\"marginLeft\" width=\"5\" height=\"100%\" styleName=\"playerMarginLeft\" />  				<Canvas id=\"PlayerHolder\" styleName=\"PlayerBackground\" width=\"100%\" height=\"100%\" > 					<KplayerModule id=\"myKplayer\" styleName=\"centered\"  k_path=\"kplayer/KplayerModule.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 					<EndScreen id=\"endScreen\" styleName=\"centered\" k_share_click=\"popup:SharePop\"  k_path=\"endScreen/EndScreen.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 				</Canvas> 				<Canvas id=\"marginRight\" width=\"5\" height=\"100%\" styleName=\"playerMarginRight\" />  			</HBox> 			<HBox styleName=\"controllerBox\" height=\"34\" width=\"100%\"> 				<VBox> 					<Button id=\"play\" styleName=\"play\" width=\"15\" height=\"17\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<VBox width=\"100%\" height=\"100%\" styleName=\"scrubberContainer\"> 					<Scrubber id=\"scrubber\" styleName=\"scrubber\" width=\"100%\" /> 					<HBox styleName=\"timerHolder\"> 						<TimerCountdown id=\"timer\" styleName=\"timer\" width=\"30\" height=\"8\" k_path=\"timertext/SimpleTimer.swf\"/> 					</HBox> 				</VBox> 				<VBox> 					<VolumeModule width=\"20\" height=\"20\" k_path=\"VolumeBars/VolumeBarA.swf\" id=\"Volume\" styleName=\"pp\"/>  					<Spacer height=\"4\"/> 				</VBox> 				<VBox> 					<Button id=\"fullScreen\" width=\"20\" height=\"17\" styleName=\"fs\" label=\"\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<Button id=\"addToReel\" styleName=\"bottomButtons\" label=\"UPLOAD\" height=\"18\" width=\"55\" k_click=\"jsInject:gotoContribWizard,pauseMedia\" /> 				<Spacer width=\"4\"/> 				<Button id=\"editReel\" styleName=\"bottomButtons\" label=\"REMIX\" height=\"18\" width=\"45\" k_click=\"jsInject:gotoEditorWindow,pauseMedia\" /> 			</HBox> 		</VBox> 	    <popups> 	    		<SharePop id=\"SharePop\" k_path=\"popups/SharePopup.swf\" width=\"350\" height=\"350\"/>  		</popups> 		<javaScript> 			<jsBlock id=\"gotoContribWizard\" functionName=\"gotoContribWizard\" params=\"kshowId\" > 				<![CDATA[ 					function gotoContribWizard (kshowId) 					{ 						setTimeout(\"handleGotoContribWizard ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 			<jsBlock id=\"gotoEditorWindow\" functionName=\"gotoEditorWindow\" params=\"kshowId\" > 				<![CDATA[ 					function gotoEditorWindow (kshowId) 					{ 						setTimeout(\"handleGotoEditorWindow ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 		</javaScript> 	</layout> </layouts> , objectType=KalturaUiConf, swfUrl=/flash/kdp/v1.0.3/kdp.swf}");
//		driver.findElement(By.xpath("//div[@id='form-content']/form/div[2]/div/div/textarea")).clear();
//		driver.findElement(By.xpath("//div[@id='form-content']/form/div[2]/div/div/textarea")).sendKeys("(com.kaltura.client.KalturaParams) {height=0, objType=1, useCdn=1, width=0, name=drupal kdp, swfUrlVersion=1.0.3, creationMode=2, confFile=<?xml version=\"1.0\" encoding=\"UTF-8\"?> <layouts> 	<layout layoutId=\"fullLarge\" skinPath=\"/content/uiconf/kaltura/drupal/styles_KDP_blue.swf\"> 		<VBox width=\"100%\" height=\"100%\" styleName=\"mlayout\" > 			<HBox width=\"100%\" height=\"30\" styleName=\"TopTitle\" > 				<Label id=\"movieName\" styleName=\"movieName\" height=\"22\" width=\"100%\" label=\"{myKplayer.kalturaShow.kshowName,myKplayer.kalturaEntry.entryName,''}\"/> 				<Button id=\"kalturaLogo\" widht=\"20\" height=\"20\" styleName=\"kalturaLogo\" /> 				<poweredBy id=\"poweredBy\" k_path=\"poweredby/PoweredBy.swf\" styleName=\"poweredBy\" width=\"120\" height=\"18\"/> 			</HBox>  			<HBox width=\"100%\" height=\"100%\" styleName=\"playerContainer\">  				<Canvas id=\"marginLeft\" width=\"5\" height=\"100%\" styleName=\"playerMarginLeft\" />  				<Canvas id=\"PlayerHolder\" styleName=\"PlayerBackground\" width=\"100%\" height=\"100%\" > 					<KplayerModule id=\"myKplayer\" styleName=\"centered\"  k_path=\"kplayer/KplayerModule.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 					<EndScreen id=\"endScreen\" styleName=\"centered\" k_share_click=\"popup:SharePop\"  k_path=\"endScreen/EndScreen.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 				</Canvas> 				<Canvas id=\"marginRight\" width=\"5\" height=\"100%\" styleName=\"playerMarginRight\" />  			</HBox> 			<HBox styleName=\"controllerBox\" height=\"34\" width=\"100%\"> 				<VBox> 					<Button id=\"play\" styleName=\"play\" width=\"15\" height=\"17\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<VBox width=\"100%\" height=\"100%\" styleName=\"scrubberContainer\"> 					<Scrubber id=\"scrubber\" styleName=\"scrubber\" width=\"100%\" /> 					<HBox styleName=\"timerHolder\"> 						<TimerCountdown id=\"timer\" styleName=\"timer\" width=\"30\" height=\"8\" k_path=\"timertext/SimpleTimer.swf\"/> 					</HBox> 				</VBox> 				<VBox> 					<VolumeModule width=\"20\" height=\"20\" k_path=\"VolumeBars/VolumeBarA.swf\" id=\"Volume\" styleName=\"pp\"/>  					<Spacer height=\"4\"/> 				</VBox> 				<VBox> 					<Button id=\"fullScreen\" width=\"20\" height=\"17\" styleName=\"fs\" label=\"\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<Button id=\"addToReel\" styleName=\"bottomButtons\" label=\"UPLOAD\" height=\"18\" width=\"55\" k_click=\"jsInject:gotoContribWizard,pauseMedia\" /> 				<Spacer width=\"4\"/> 				<Button id=\"editReel\" styleName=\"bottomButtons\" label=\"REMIX\" height=\"18\" width=\"45\" k_click=\"jsInject:gotoEditorWindow,pauseMedia\" /> 			</HBox> 		</VBox> 	    <popups> 	    		<SharePop id=\"SharePop\" k_path=\"popups/SharePopup.swf\" width=\"350\" height=\"350\"/>  		</popups> 		<javaScript> 			<jsBlock id=\"gotoContribWizard\" functionName=\"gotoContribWizard\" params=\"kshowId\" > 				<![CDATA[ 					function gotoContribWizard (kshowId) 					{ 						setTimeout(\"handleGotoContribWizard ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 			<jsBlock id=\"gotoEditorWindow\" functionName=\"gotoEditorWindow\" params=\"kshowId\" > 				<![CDATA[ 					function gotoEditorWindow (kshowId) 					{ 						setTimeout(\"handleGotoEditorWindow ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 		</javaScript> 	</layout> </layouts> , objectType=KalturaUiConf, swfUrl=/flash/kdp/v1.0.3/kdp.swf}");
//		driver.findElement(By.xpath("//div[@id='form-content']/form/div/div/div/textarea")).clear();
//		driver.findElement(By.xpath("//div[@id='form-content']/form/div/div/div/textarea")).sendKeys("(com.kaltura.client.KalturaParams) {height=0, useCdn=1, confVars=, width=0, name=drupal kdp, swfUrlVersion=1.2.3CE, creationMode=3, confFile=<?xml version=\"1.0\" encoding=\"UTF-8\"?> <layouts> 	<layout layoutId=\"fullLarge\" skinPath=\"/content/uiconf/kaltura/drupal/styles_KDP_blue.swf\"> 		<VBox width=\"100%\" height=\"100%\" styleName=\"mlayout\" > 			<HBox width=\"100%\" height=\"30\" styleName=\"TopTitle\" > 				<Label id=\"movieName\" styleName=\"movieName\" height=\"22\" width=\"100%\" label=\"{myKplayer.kalturaShow.kshowName,myKplayer.kalturaEntry.entryName,''}\"/> 				<Button id=\"kalturaLogo\" widht=\"20\" height=\"20\" styleName=\"kalturaLogo\" /> 				<poweredBy id=\"poweredBy\" k_path=\"poweredby/PoweredBy.swf\" styleName=\"poweredBy\" width=\"120\" height=\"18\"/> 			</HBox>  			<HBox width=\"100%\" height=\"100%\" styleName=\"playerContainer\">  				<Canvas id=\"marginLeft\" width=\"5\" height=\"100%\" styleName=\"playerMarginLeft\" />  				<Canvas id=\"PlayerHolder\" styleName=\"PlayerBackground\" width=\"100%\" height=\"100%\" > 					<KplayerModule id=\"myKplayer\" styleName=\"centered\"  k_path=\"kplayer/KplayerModule.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 					<EndScreen id=\"endScreen\" styleName=\"centered\" k_share_click=\"popup:SharePop\"  k_path=\"endScreen/EndScreen.swf\" width=\"100%\" height=\"100%\" maxWidth=\"640\" maxHeight=\"480\"/> 				</Canvas> 				<Canvas id=\"marginRight\" width=\"5\" height=\"100%\" styleName=\"playerMarginRight\" />  			</HBox> 			<HBox styleName=\"controllerBox\" height=\"34\" width=\"100%\"> 				<VBox> 					<Button id=\"play\" styleName=\"play\" width=\"15\" height=\"17\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<VBox width=\"100%\" height=\"100%\" styleName=\"scrubberContainer\"> 					<Scrubber id=\"scrubber\" styleName=\"scrubber\" width=\"100%\" /> 					<HBox styleName=\"timerHolder\"> 						<TimerCountdown id=\"timer\" styleName=\"timer\" width=\"30\" height=\"8\" k_path=\"timertext/SimpleTimer.swf\"/> 					</HBox> 				</VBox> 				<VBox> 					<VolumeModule width=\"20\" height=\"20\" k_path=\"VolumeBars/VolumeBarA.swf\" id=\"Volume\" styleName=\"pp\"/>  					<Spacer height=\"4\"/> 				</VBox> 				<VBox> 					<Button id=\"fullScreen\" width=\"20\" height=\"17\" styleName=\"fs\" label=\"\" /> 					<Spacer height=\"4\"/> 				</VBox> 				<Button id=\"addToReel\" styleName=\"bottomButtons\" label=\"UPLOAD\" height=\"18\" width=\"55\" k_click=\"jsInject:gotoContribWizard,pauseMedia\" /> 				<Spacer width=\"4\"/> 				<Button id=\"editReel\" styleName=\"bottomButtons\" label=\"REMIX\" height=\"18\" width=\"45\" k_click=\"jsInject:gotoEditorWindow,pauseMedia\" /> 			</HBox> 		</VBox> 	    <popups> 	    		<SharePop id=\"SharePop\" k_path=\"popups/SharePopup.swf\" width=\"350\" height=\"350\"/>  		</popups> 		<javaScript> 			<jsBlock id=\"gotoContribWizard\" functionName=\"gotoContribWizard\" params=\"kshowId\" > 				<![CDATA[ 					function gotoContribWizard (kshowId) 					{ 						setTimeout(\"handleGotoContribWizard ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 			<jsBlock id=\"gotoEditorWindow\" functionName=\"gotoEditorWindow\" params=\"kshowId\" > 				<![CDATA[ 					function gotoEditorWindow (kshowId) 					{ 						setTimeout(\"handleGotoEditorWindow ('\"+kshowId+\"');\", 0); 					}; 				]]> 			</jsBlock> 		</javaScript> 	</layout> </layouts> , objectType=KalturaUiConf, swfUrl=/flash/kdp/v1.2.3CE/kdp.swf}");
		driver.findElement(By.cssSelector("input.blue_button.find_difference")).click();



		//	  driver.findElement(By.name("file2")).sendKeys("asdasasdsad");
		////  List<WebElement> inputs = driver.findElements(By.tagName("file"));
		//  System.out.println(driver.getPageSource().toString());
		//  
		//  List<WebElement> inputs = driver.findElements(By.tagName("textarea"));
		//
		//  for (WebElement w : inputs){
		//  	System.out.println(w.getText());
		//  }
		//  



		System.out.println("DONE!");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
