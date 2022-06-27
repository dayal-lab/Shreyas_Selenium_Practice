package Login_Validations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Validation 
{
	WebDriver driver;
	
	@BeforeTest
	public void beforetest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://mybusinessdirectorylocal.com/members/index.php");
	}
	

	@Test
	public void log_in_button() throws InterruptedException
	{
		//created object of assertion
		SoftAssert softassert = new SoftAssert();
		
		//credentials
		String username 		= "12";	
		String password 		= "abc";
		
		//added sendkeys data into object "validation_user"
		String validation_user 	= username.toString();
		driver.findElement(By.id("user_login")).sendKeys(validation_user);
	
		//added sendkeys data into object "validation_pass"
		String validation_pass 	= password.toString();
		driver.findElement(By.id("user_pass")).sendKeys(validation_pass);
		
		//click on "LOGIN" button
		driver.findElement(By.id("submit_login")).click();
		
		//check user name and password's validation
		softassert.assertEquals(username, password);

		
//*** if username and password are NULL ***//
		
		if(username==null || username.isBlank() && password==null || password.isBlank())
		{
			//print error message of user name
			String message = driver.findElement(By.xpath("//p[contains(text(),'The following field is required: Username')]")).getText();
			System.out.println(message);
			
			//print error message of password
			String message2 = driver.findElement(By.xpath("//p[contains(text(),'The following field is required: Password')]"+'\n')).getText();
			System.out.println(message2);
			
		}

		

		
//*** if username and password are incorrect ***//
		
		else if (!username.contentEquals(username) && !password.contentEquals(password))
		{
			
			System.out.println("Incorrect data");
			
			//print error message
			String message = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/p[2]"+'\n')).getText();
			System.out.println(message);
		}
		

		
//*** if username and password, one of this is wrong and other is correct *** //
		
		else if (!username.contentEquals(username) && password.contentEquals(password) ||  username.contentEquals(username) && !password.contentEquals(password))
		{
			System.out.println('\n'+" *** Incorrect data *** "+'\n');
			
			//print error message
			String message = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/p[2]"+'\n')).getText();
			System.out.println(message);
		}
	
		
		
///*** if username and password are correct ***//
		else 
		{
			//print success message
			System.out.println(" *** SUCCESSFULLY LOGGED IN ***"+'\n');
		}
		
		//stops loading after 10 seconds
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		
		//click on "Logout" button
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")).click();
		Thread.sleep(2000);
				
		//print SUCCESS message
		String message = driver.findElement(By.xpath("//p[contains(text(),'You have successfully logged out!')]"+'\n')).getText();
		System.out.println(message);
	}		
		
	@AfterTest
	public void aftertest() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}