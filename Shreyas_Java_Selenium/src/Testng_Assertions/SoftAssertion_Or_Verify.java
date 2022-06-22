package Testng_Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion_Or_Verify 
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
		
//In "Soft Assertion" - if given below driver.getCurrentURL() doesnt match with URL given in .assertEquals, still next hovering "More" module's script runs.
//But in Hard asssertion, if path not matches with URL given in .assertEquals, then next script not runs and aborts all test and gives fail error.
		 
		 
		 
		 SoftAssert softAssert = new SoftAssert();	//created object "softAssert" of class "SoftAssert"			
		
		 String getActualURL = driver.getCurrentUrl(); //get actual url by driver.getCurrentUrl() method, it will take URL automatically
		 
		 softAssert.assertEquals(getActualURL, "https://www.91mobil"); //checked this defined URL with above defined driver.getCurrentUrl()
		 																//given URL of https is wrong, still next hovering script will run and give passed test.
		
		 
		 
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
	 

	


