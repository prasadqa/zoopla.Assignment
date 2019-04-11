package com.zoopla.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	public TestBase(){
		try 
			{
				properties = new Properties();
				properties.load(new FileInputStream("D://NaveenAssignments//zoopla.Assignment//src//test//java//com//zoopla//config//config.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	public static void initialize()
	{
		String browser = properties.getProperty("Browser");
		
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\softwares\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		else
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.firefox.driver", "D:\\softwares\\chromedriver.exe");
				driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	
	}
	

}
