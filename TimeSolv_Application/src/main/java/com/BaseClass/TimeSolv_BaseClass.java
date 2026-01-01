package com.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeSolv_BaseClass {
	
	public static WebDriver driver;
	public static Properties property;
	
	
	@BeforeSuite
	public void load() throws IOException {
		property = new Properties();
		{
			FileInputStream f2 = new FileInputStream("C:\\Users\\admin\\Desktop\\Automation\\NewBatch\\TimeSolv_Application\\src\\main\\resources\\Config.Properties");
			property.load(f2);
		}

	}

	@BeforeMethod

	public void setup() {
		System.out.println("Setting up webDriver for : " + this.getClass().getSimpleName());
		OpenBrowser();
		configBrowsers();

	}

	public void OpenBrowser() {

		String browser = property.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else {
			throw new IllegalArgumentException("Browser Not supported :" + browser);

		}

	}

	public void configBrowsers() {
		{
			int implicitWait = Integer.parseInt(property.getProperty("implicitWait"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
			driver.manage().window().maximize();
			try {
				driver.get(property.getProperty("URL"));
			} catch (Exception e) {
				System.out.println("Failer to navigaet to Url:" + e.getMessage());
			}
		}
	}


	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			try {
				driver.quit();
			} catch (Exception e) {
				System.out.println("unable to quit the driver :" + e.getMessage());
			}
		}

	}

}
