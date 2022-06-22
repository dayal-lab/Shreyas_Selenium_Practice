package Testng_Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HardAssertion_Or_Validation 
{
	WebDriver driver;
	 
	 @BeforeTest
	 public void setup()
	 {
		 System.setProperty("webdriver.chrome.driver", "e:\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.91mobiles.com/");
	 }
	 
	 @Test
	 public void image_test() throws InterruptedException
	 	{
		
// in Hard assertion- if given actual path not matched with expected path, then next script not runs and aborts all test and gives fail error.
//But in "Soft Assertion" - if given path of driver.getCurrentUrl() doesnt match with URL given in .assertEquals, still next hovering "More" module's script runs.		 
		 
		 
		 WebElement wc = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/a[")); //this is wrong path of logo image
		 String actualimage = wc.getAttribute("src");
		 String expectedimage = "https://www.91-img.com/images/logo.gif"; //xpath will not match with this URL, bcz xpath is wrong
		 Assert.assertEquals(actualimage ,  expectedimage);
		 
		 if(!expectedimage.equals(actualimage))
		 {
	 		System.out.println("Not matched search message with actual path");
	 	 }
		 	else
 		{
	 		System.out.println("Matched search message with actual path");
 		}
 
 Thread.sleep(2000);
		
		
		 //so next script of mouse hover wont run and test will abort and will give error of failed.//
		 
		 
		 
		//hovering on "More" 
		 Actions action = new Actions (driver);
	 
		 WebElement wc1 = driver.findElement(By.xpath("//body/div[@id='body']/div[@id='floating-box']/div[1]/ul[1]/li[7]/span[1]"));
		 action.moveToElement(wc1).build().perform();
	 }
	 
	 
	 
	 @AfterTest
	 public void quit() throws InterruptedException
	 {
		 Thread.sleep(5000);
		 driver.quit();
		 
	 }
}
	 

	



