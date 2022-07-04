package Console_Errors;

import java.util.List;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JE_errors_with_messages_defined
{
	WebDriver driver;
	@BeforeTest 
	public void Setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		options.setCapability("goog:loggingPrefs", logPrefs);
		driver = new ChromeDriver(options);
		driver.get("https://mybusinessdirectorylocal.com/");
	}
	
	@Test
	public void test()
	{
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        // Retrieving all log 
        List<LogEntry> logs= entry.getAll();
        // Print one by one
        for(LogEntry e: logs)
        {
        	System.out.println(e);
        }
        
        // Printing details separately 
        for(LogEntry e: logs)
        {
        	System.out.println('\n'+"Message is: " +e.getMessage());
        	System.out.println("Level is: " +e.getLevel()+'\n');
        }
	}
	   
@AfterTest
public void quit()
{
	driver.quit();
}
}


