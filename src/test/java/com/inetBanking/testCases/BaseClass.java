package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseUrl = readconfig.getApplicationUrl();
	public String userName = readconfig.getuserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger log;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readconfig.getfirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);

		log = LogManager.getLogger("ebanking");
		// getLogger("ebanking");
		// getLogger(BaseClass.class.getName());
	}

	//@AfterClass
	//public void tearDown() {
	//	driver.quit();
	//}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/test-output/" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		System.out.println("ScreenShot Taken");
		return destinationFile;

	}

//public void getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
//{
//	TakesScreenshot ts=(TakesScreenshot) driver;
//	File source =ts.getScreenshotAs(OutputType.FILE);
//	File destinationFile = new File(System.getProperty("user.dir")+"/test-output/"+testCaseName+".png");
//	FileUtils.copyFile(source,destinationFile);
//	System.out.println("ScreenShot Taken");
//	//return destinationFile;
//	
//
//
//}
//	

}
