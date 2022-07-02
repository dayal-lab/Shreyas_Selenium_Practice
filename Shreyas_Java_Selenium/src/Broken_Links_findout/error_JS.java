package Broken_Links_findout;

import java.util.Date;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class error_JS
{
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup()
	{
		DesiredCapabilities capabilities =  DesiredCapabilities.chrome();
		LoggingPreferences login = new LoggingPreferences();
		login.enable(LogType.BROWSER, Level.ALL);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, login);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(capabilities);
	}
	
	
	
	@SuppressWarnings("deprecation")
	public void test()
	{
		LogEntries  logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries)
		System.out.println(new Date(entry.getTimestamp()+" "+entry.getLevel()+" "+entry.getMessage()));
	}
	
	public void website()
	{
		driver.get("https://mybusinessdirectorylocal.com/");
		test();
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
