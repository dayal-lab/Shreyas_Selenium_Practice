package GlobalHR_LOGIN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bank_Single_Delete 
{
	WebDriver driver;
	
	
	@BeforeTest
	public void setup()
	{
		try
		{
		//after "WebDriverManager" when write  dot (.), then will show multiple web browsers.
		// this will load automatically latest version, latest updated driver
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("start-maximized"); //to open maximum size window		
		driver = new ChromeDriver (options);	//send ChromeOption's object "options" to ChromeDriver, if not added (options) then wont run start maxmimize and incognito
		driver.get("http://www.mydevsystems.com/dev/gap_v2/index.php/login/login");						//gets url from created object "url" above
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void test() throws InterruptedException
	{
		
		//enter data in "username" field
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("GSPLadmin");
		Thread.sleep(2000);
		
		//enter data in "password" field
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("GSPLadmin");
		Thread.sleep(2000);
		
		//click on "LOGIN" button
		driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]")).click();
		Thread.sleep(2000);
		
		//create class of mouse hover
		Actions action = new Actions (driver);
		
		//hovering on "Bank Manager" module
		WebElement wc = driver.findElement(By.xpath("//body/div[3]/div[1]/nav[1]/ul[1]/li[11]/a[1]"));
		action.moveToElement(wc).build().perform();
		Thread.sleep(2000);
		
		//click on "Bank Acc Detail" module
		driver.findElement(By.xpath("//a[contains(text(),'Bank Account Details')]")).click();
		Thread.sleep(30000);
		
		//click on first checkbox to select
		driver.findElement(By.xpath("//tbody/tr[@id='row_9']/td[1]")).click();
		Thread.sleep(2000);
		
		//click on red icon delete button button
		driver.findElement(By.xpath("//tbody/tr[@id='row_9']/td[2]/a[2]/span[1]")).click();
		Thread.sleep(2000);
		
		//click on "green tickmark" button
		driver.findElement(By.xpath("//body/div[11]/div[1]/div[10]/button[1]")).click();
		Thread.sleep(7000);
				
		
		//SEARCH DELETED RECORD DETAIL
		driver.findElement(By.xpath("//thead/tr[2]/th[4]/input[1]")).sendKeys("barclays");
		Thread.sleep(2000);
		
		//click on "Logout" button
		driver.findElement(By.xpath("//body/nav[1]/div[1]/ul[1]/li[7]/a[1]")).click();		
	}
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.quit();	
	}	
}



