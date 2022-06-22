package POM_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import POM.POM_Demo_GlobalHR;
import io.github.bonigarcia.wdm.WebDriverManager;

public class POM_Test_GlobalHR 
{


	WebDriver driver;
	
	@BeforeTest 
	public void Setup()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("incognito");
		
		driver = new ChromeDriver (options);
		
		
		driver.get("http://www.mydevsystems.com/dev/gap_v2/index.php/login/login");
	}
	
	@Test
	public void test() throws InterruptedException
	{
		
		//called "POM_Demo_GlobalHR" class for run "Credential()" method
		POM_Demo_GlobalHR hr = new POM_Demo_GlobalHR(driver); //created object "hr" of class "POM_Demo_GlobalHR"
		
		hr.Credentials(); //now it will run all set paths of this method here.
	}
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.quit();		
	}	
}




