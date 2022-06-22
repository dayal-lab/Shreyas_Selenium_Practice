package New_Tab_Open;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Nykaa 
{

	WebDriver driver;
	
	@BeforeTest
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver","e:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/?root=logo");
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void test() throws AWTException, InterruptedException
	{
		Actions action = new Actions (driver);
		
		//Hovering on "Hair" module
		WebElement hair = driver.findElement(By.xpath("//header/div[@id='header_id']/div[3]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
		action.moveToElement(hair).build().perform();
		Thread.sleep(2000);
		
		//taking path of "Hair_brush" submodule and open in new window tab
		String hair_brush = Keys.chord(Keys.CONTROL,Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'Hair Brushes')]")).sendKeys(hair_brush);
		driver.switchTo().window(hair_brush);
		Thread.sleep(3000);
		
		
	}
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		
	}
}
