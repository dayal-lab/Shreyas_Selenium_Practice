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



public class Nationality_Add_Form 
{
	WebDriver driver;
	
	
	@BeforeTest
	public void setup()
	{
		try
		{
		//after "WebDriverManager" when write  dot (.), then will show multiple web browsers.
		// this will load automatically latest version, latest updated driver	
		
		System.setProperty("webdriver.chrome.driver", "path of chromdriver");
			
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
		
		//hovering on "Employee Hub" module
		WebElement wc = driver.findElement(By.xpath("//body/div[3]/div[1]/nav[1]/ul[1]/li[5]/a[1]/img[1]"));
		action.moveToElement(wc).build().perform();
		Thread.sleep(2000);
		
		//click on "Nationality" module
		driver.findElement(By.xpath("//a[contains(text(),'Nationality')]")).click();
		Thread.sleep(2000);
		
		//click on "Add" button
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[5]/div[2]/div[1]/div[2]/a[1]/i[1]")).click();
		Thread.sleep(20000);
		
		//select "Requested By" dropdown button
		driver.findElement(By.xpath("//div[@id='user_chosen']")).click();
		Thread.sleep(4000);
		
		//select data "Poonam" from dropdown
		driver.findElement(By.xpath("//li[contains(text(),'Poonam')]")).click();
		Thread.sleep(4000);
				
		//select "Employee Full Name" dropdown button
		driver.findElement(By.xpath("//div[@id='empId_chosen']")).click();
		Thread.sleep(2000);
		
		//select data from dropdown
		driver.findElement(By.xpath("//li[contains(text(),'Devdas Devendra Shula')]")).click();
		Thread.sleep(4000); 
		
		//select "Contact Nationality" dropdown button
		driver.findElement(By.xpath("//div[@id='CNTCT_NATIONALITY_ID_chosen']")).click();
		Thread.sleep(2000);
		
		//select "Contact Nationality" dropdown button
		driver.findElement(By.xpath("//li[contains(text(),'American Samoa')]")).click();
		Thread.sleep(2000);
		
		//select "Save" dropdown button
		driver.findElement(By.xpath("//button[@id='main']")).click();
		Thread.sleep(20000);
		
		//search created data by netering data in seach field
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[5]/div[2]/form[1]/fieldset[1]/div[2]/div[1]/div[2]/div[1]/label[1]/input[1]")).sendKeys("devdas");
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
