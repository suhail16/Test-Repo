package com.crm.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.TestUtils.TestUtil;
import com.crm.TestUtils.WebEventListener;

public class TestBase {
	
	
	public static Properties pro;
	public static FileInputStream fil;
	public static WebDriver driver;
	static EventFiringWebDriver e_driver;
	static WebEventListener listener;
	
	public TestBase()
	{
		pro = new Properties();
		
		try {
			fil = new FileInputStream("D:\\Auto self\\Seleniumworkspace\\TestCRM\\src\\main\\java\\com\\crm\\config\\config.properties");
			pro.load(fil);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize()
	{
		String browsername = pro.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Auto self\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		listener = new WebEventListener();
		
		e_driver.register(listener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
	}
	
	
   
   }

