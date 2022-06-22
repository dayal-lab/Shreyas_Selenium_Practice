package PageFrame_Test;


import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFrame.Pepperfry_POM;

public class Pepperfry_Light_Test 
{
	WebDriver driver ;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","e:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException
	{
		//create object of calling call
		Pepperfry_POM call = PageFactory.initElements(driver, Pepperfry_POM.class);
		
		//now call methods from "Pepperfry_POM" class by "call_pepperfry" object
		call.Light();
		call.WallLight();
		
	}
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	

}
