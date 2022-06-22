package Zoom_In_Out;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Jiomart_By_ROBOT_Class 
{
	WebDriver driver;
	
	@BeforeTest
	public void setuup()
	{
		System.setProperty("webdriver.chrome.driver", "e:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	
		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	
	}
	
	
	@Test
	public void test() throws InterruptedException, AWTException
	{
		//created object of Robot class
		//"Robot" class uses to enter shortcuts of keyboard like "Ctrl+Copy" and other
		Robot robot = new Robot();
		
		//zoomed one time
		robot.keyPress(KeyEvent.VK_CONTROL); //press on Keyboard's "Ctrl" button
		robot.keyPress(KeyEvent.VK_ADD);	 //press on keyboard's "+" button
		
	}
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		
	}
	

}
