package Console_Errors;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Console_Error_withDate
{
	WebDriver driver;
	@BeforeTest 
	public void Setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://mybusinessdirectorylocal.com/");		
	}
	
	@Test
	public void test()
	{
	LogEntries  logEntries = driver.manage().logs().get(LogType.BROWSER);
	for (LogEntry entry : logEntries)
	System.out.println(new Date(entry.getTimestamp()) + " " + entry.getMessage() + " " + entry.toString()+'\n');
 
	
	}

	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}










