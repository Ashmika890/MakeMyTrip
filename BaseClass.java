package com.makemytrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass {
 public	static WebDriver driver;
 public	static Properties prop;
	public BaseClass()
	{
		try {
			prop =new Properties();
		
		FileInputStream  fis= new FileInputStream("C:\\Users\\ashmi\\eclipse-workspace\\makemytrip\\src\\main\\java\\com\\makemytrip\\configuration\\config.properties");
			prop.load(fis);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		String Browsername=prop.getProperty("Browser");
		if(Browsername.equalsIgnoreCase("chrome"))
	
			{ 
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashmi\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			//WebDriverManager.chromedriver().setup();
								 driver = new ChromeDriver();
			}
			else if(Browsername.equalsIgnoreCase("firefox"))
			{ 
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\GECKODRIVER.geckodriver.exe");
				driver=new FirefoxDriver();
		}
		
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
