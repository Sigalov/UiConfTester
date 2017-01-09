package com.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kaltura.client.KalturaLogger;
import com.uiconf.MainWindow;

/**
 * @author oleg.sigalov
 *
 */
public class SeleniumUtils {
	private static KalturaLogger logger = KalturaLogger.getLogger(SeleniumUtils.class);
	//	private static final String JQUERY_LOAD_SCRIPT = "resources/script/jQuerify.js";

	private WebDriver driver;
	//	private final String BASE_URL = "http://text-compare.com";
	private final String BASE_URL = "http://www.quickdiff.com";

	public SeleniumUtils(){
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Presonal\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		//		driver.get(BASE_URL + "/");
		//		driver.manage().window().maximize();
	}
	public void openDiffInBrowser(int innerId){
		try {
			String text1 = MainWindow.failedUiConfMap.get(innerId).getProdUiConfText().replaceAll("\\s{3,}", "\n");
			String text2 = MainWindow.failedUiConfMap.get(innerId).getOnPremUiConfText().replaceAll("\\s{3,}", "\n");

			driver.get(BASE_URL + "/");
			driver.manage().window().maximize();
			Thread.sleep(1500);

			driver.findElement(By.id("een")).clear();
			driver.findElement(By.id("een")).sendKeys(text1);
			driver.findElement(By.id("twee")).clear();
			driver.findElement(By.id("twee")).sendKeys(text2);
			driver.findElement(By.cssSelector("input.awesome.white")).click();
			//			driver.findElement(By.id("inputText1")).clear();
			//			
			//			driver.findElement(By.id("inputText1")).sendKeys(text1);
			//			Thread.sleep(1500);
			//			driver.findElement(By.id("inputText2")).clear();
			//			
			//			driver.findElement(By.id("inputText2")).sendKeys("asd\nsdfsdfsdfsdf\nsdfsfsgggdfsd");
			//			Thread.sleep(1500);
			//			driver.findElement(By.id("compareButton")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ChromeDriver
	//		System.setProperty("webdriver.chrome.driver", "C:\\Presonal\\Tools\\chromedriver.exe");
	//		driver = new ChromeDriver();
	//
	////		driver = new FirefoxDriver();
	////		baseUrl = "http://www.diffchecker.com";
	//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	}
	//
	//	public void openDiffInBrowser(int innerId){
	//		if (MainWindow.failedUiConfMap.get(innerId) == null){
	//			logger.error("Invalid Inner ID: " + innerId);
	//			JOptionPane.showMessageDialog(null, "Invalid Inner ID: " + innerId);
	//			return;
	//		}
	////		String prodText = MainWindow.failedUiConfMap.get(innerId).getProdUiConfText().replaceAll("[\\t ]", "");
	////		String onPremText = MainWindow.failedUiConfMap.get(innerId).getOnPremUiConfText().replaceAll("[\\t ]", "");
	//		String prodText = "OELDDSfsdfsdfsf";
	//		String onPremText = "sdasdsadsdsad";
	//
	//		driver.get(BASE_URL + "/");
	//		driver.manage().window().maximize();
	//		 String jQueryLoader = null;
	////		try {
	////			jQueryLoader = readFile(JQUERY_LOAD_SCRIPT);
	////		} catch (IOException e) {
	////			// TODO Auto-generated catch block
	////			e.printStackTrace();
	////		}
	//
	//         // give jQuery time to load asynchronously
	////         driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	//         JavascriptExecutor js = (JavascriptExecutor) driver;
	////         js.executeAsyncScript(jQueryLoader /*, http://localhost:8080/jquery-1.7.2.js */);
	//
	//         // ready to rock
	////         js.executeScript("jQuery(function($) { $('input[name=\"q\"]').val('bada-bing').closest('form').submit(); }); ");
	//         
	//         
	////		try {
	////			Thread.sleep(3000);
	////		} catch (InterruptedException e) {
	////			e.printStackTrace();
	////		}
	////		JavascriptExecutor jss = (JavascriptExecutor) driver;
	//		//The textarea is not visible, in order to get element we need to make it visible (inline)
	////		js.executeScript("document.getElementById('file2').style.display = 'inline';");
	////		js.executeScript("document.getElementById('file1').style.display = 'inline';");
	//		
	//		
	////		if (waitForJQueryProcessing(driver, 60)){
	//			try {
	//				String jScript = "(function($) { $(\".CodeMirror-code\").getElementsByTagName(\"span\")[0].innerHTML = \"hellooooo\"});"; 
	////				String jScript = "document.getElementById(\".CodeMirror-code\").getElementsByTagName(\"span\")[0].innerHTML = \"hello\""; 
	//				js.executeScript(jScript);
	//			} catch (Exception e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//			js.executeScript("jQuery(function($) { $(\".CodeMirror-code\").getElementsByTagName(\"span\")[0].innerHTML = \"hello\" }); ");
	//			
	////		}
	//
	//		
	////		driver.findElement(By.className("CodeMirror cm-s-default CodeMirror-wrap")).sendKeys("TEST");
	////	    driver.findElement(By.xpath("//div[@id='form-content']/form/div/div/div/textarea")).clear();
	////	    driver.findElement(By.xpath("//div[@id='form-content']/form/div/div/div/textarea")).sendKeys(prodText);
	////	    driver.findElement(By.xpath("//div[@id='form-content']/form/div[2]/div/div/textarea")).clear();
	////	    driver.findElement(By.xpath("//div[@id='form-content']/form/div[2]/div/div/textarea")).sendKeys(onPremText);
	//	    
	////	    
	//		driver.findElement(By.name("file1")).sendKeys(prodText);
	//		driver.findElement(By.name("file2")).sendKeys(onPremText);
	//		
	////		js.executeScript("document.getElementById('file2').style.display = 'none;");
	////		js.executeScript("document.getElementById('file1').style.display = 'none';");
	//		
	//		driver.findElement(By.cssSelector("input.blue_button.find_difference")).click();
	//		System.out.println("done selenium");//TODO remove this, debug
	//		//Leave the windows open
	//		//driver.quit();




	//    driver.findElement(By.xpath("//div[@id='form-content']/form/div/div/div/textarea")).clear();
	//    driver.findElement(By.xpath("//div[@id='form-content']/form/div/div/div/textarea")).sendKeys("asd");
	//    driver.findElement(By.xpath("//div[@id='form-content']/form/div[2]/div/div/textarea")).clear();
	//    driver.findElement(By.xpath("//div[@id='form-content']/form/div[2]/div/div/textarea")).sendKeys("vbn");
	//    driver.findElement(By.cssSelector("input.blue_button.find_difference")).click();

	//
	//	public static boolean waitForJQueryProcessing(WebDriver driver, int timeOutInSeconds) {
	//		boolean jQcondition = false;
	//		try {
	//			new WebDriverWait(driver, timeOutInSeconds) {
	//			}.until(new ExpectedCondition<Boolean>() {
	//
	//				@Override
	//				public Boolean apply(WebDriver driverObject) {
	//					return (Boolean) ((JavascriptExecutor) driverObject)
	//							.executeScript("return jQuery.active == 0");
	//				}
	//			});
	//			jQcondition = (Boolean) ((JavascriptExecutor) driver)
	//					.executeScript("return window.jQuery != undefined && jQuery.active === 0");
	//			return jQcondition;
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//		return jQcondition;
	//	}
	//
	//	// helper method
	//	private static String readFile(String file) throws IOException {
	//		Charset cs = Charset.forName("UTF-8");
	//		FileInputStream stream = new FileInputStream(file);
	//		try {
	//			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
	//			StringBuilder builder = new StringBuilder();
	//			char[] buffer = new char[8192];
	//			int read;
	//			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
	//				builder.append(buffer, 0, read);
	//			}
	//			return builder.toString();
	//		}
	//		finally {
	//			stream.close();
	//		}        
	//	}
}
