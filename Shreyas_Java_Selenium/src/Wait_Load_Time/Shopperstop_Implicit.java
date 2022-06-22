package Wait_Load_Time;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shopperstop_Implicit 

{
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","e:\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		//checking webisite's Home page loading time
				long start = System.currentTimeMillis();
				driver.get("https://www.shoppersstop.com/");
				long finish = System.currentTimeMillis();
				long total = finish - start ;
				System.out.println("Total load time of Home page is (in millisecond) : " +total);
				
		//implicit method will check xpath of given in Webelement, if xpath not loads within given period of time given in implicit
		//then next process of @Test not runs, and screen remains till infinite time.
		//So first check website loading time and after that check by giving xpath
		
				
		//If given path below not find within 5 sec. then next method which is in
		//@Test not runs, and screen remains on infinite time.
		//If got path, then and only then next process occurs
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 

		
		//given path is at last of webpage
		Actions men = new Actions (driver);
		
		WebElement wc = driver.findElement(By.xpath("//body/main[1]/div[17]/section[12]/div[2]/div[1]/a[1]/img[1]"));
		men.moveToElement(wc).build().perform();
		
	}
	
	@Test
	public void test() throws InterruptedException
	{
		//Hovering on "Signin" module
				Actions men = new Actions (driver);
				
				WebElement wc = driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[2]/ul[1]/li[4]/a[1]/img[1]")); //retrieved xpath
				men.moveToElement(wc).build().perform();							//hovering mouse pointer on "Signin"
				Thread.sleep(1000);
	}
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
}
