package insurance.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import insurance.qa.util.Test_util;
import insurance.qa.util.WebEventListener;

public class Testbase {

public static WebDriver driver;
public static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebEventListener eventlistener;


public Testbase() {
	try {
		prop = new Properties();
		FileInputStream ip= new FileInputStream ("C:\\Users\\Hammad\\eclipse-workspace\\insurance\\src\\main\\java\\insurance\\qa\\config\\config.properties");
				prop.load (ip);
				
} catch (FileNotFoundException e) {
	e.printStackTrace();
	System.out.println ("error");
} catch (IOException e) {
	e.printStackTrace ();
}
}

public static void initialization () throws InterruptedException {

String browserName = prop.getProperty("browser");
if (browserName.equals("chrome")){
//	System.setProperty("webdriver.gecko.driver","C:\\Users\\Hammad\\Desktop\\Selenium\\geckodriver.exe");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Hammad\\Downloads\\chromedriver.exe");
	driver=new ChromeDriver();	
}
 e_driver = new EventFiringWebDriver(driver);
 eventlistener= new WebEventListener();
 e_driver.register(eventlistener);
 driver= e_driver;
 

//"http://username:password@website.com"

    // Thread.sleep(5000);
     
                    
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));
Thread.sleep(3000);

}
}


