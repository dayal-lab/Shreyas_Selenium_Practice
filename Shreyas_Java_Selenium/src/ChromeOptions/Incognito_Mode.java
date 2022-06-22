package ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Incognito_Mode 
{
	WebDriver driver;
	
	
	@BeforeTest 
	public void Setup()
	{
		
		
		//after "WebDriverManager" when write  dot (.), then will show multiple web browsers.
		// this will load automatically latest version, latest updated driver
		
		WebDriverManager.chromedriver().setup();
	
		
		//ChromeOptions class executes features of maximize window, opening in incognito mode and many more.
		//as normally we were writing "driver.manage().windows().maximize()", instead of this uses this class.
		
		ChromeOptions options = new ChromeOptions(); //created object "options" of "ChromeOptions" class
		
		options.addArguments("incognito");	//added "addArguments("")" after "options."
		
		driver = new ChromeDriver (options); //passed "options" object into "ChromeDriver" class
		
		
		driver.get("http://www.mydevsystems.com/dev/gap_v2/index.php/login/login"); //URL , url should be at last then and then it will run.
		
		
		
		
	}
	
	
	
	
	@Test
	public void test() throws InterruptedException
	{
	
	}
	
	
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.quit();		
	}	

	
}

