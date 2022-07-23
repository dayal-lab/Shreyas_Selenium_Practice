package GlobalHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GlobalHR_Logo_Assertion 
{
	WebDriver driver;
	 
	 @BeforeTest
	 public void setup()
	 {
		 System.setProperty("webdriver.chrome.driver", "e:\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://www.mydevsystems.com/dev/gap_v2/index.php/login/login");
	 }
	 
	 @Test
	 public void image_test() throws InterruptedException
	 	{
		 
		 driver.findElement(By.id("username")).sendKeys("GSPLadmin");						//entered Username
		 driver.findElement(By.id("password")).sendKeys("GSPLadmin");						//entered password
		 driver.findElement(By.className("login_submit")).click();							//clicked on "Login" button
		 Thread.sleep(5000); 																//wait for 5 sec
			
		
		 WebElement wc = driver.findElement(By.xpath("//body/div[3]/div[1]/nav[1]/div[1]/img[1]"));
		 String actualimage = wc.getAttribute("src");
		 String expectedimage = "http://www.mydevsystems.com/dev/gap_v2/img/global-hr-logo.png";
		 Assert.assertEquals(actualimage ,  expectedimage);
		
		 driver.findElement(By.xpath("//body/nav[1]/div[1]/ul[1]/li[7]/a[1]")).click();		//click on "Logout" button
		}
	 
	 @AfterTest
	 public void quit() throws InterruptedException
	 {
		 Thread.sleep(5000);
		 driver.quit();
		 
	 }
}
	 
