package PageFrame_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFrame.Login_GlobalHR_POM;


public class Login_Test_GlobalHR 
{
	WebDriver driver;
	
	@BeforeTest
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver","e:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.geecon.co.uk/dev/gap_v2/index.php/login/login");	
	}
	
	@Test
	public void test() throws InterruptedException
	{
	
		//  when in this "Login_Test" or in this "Test_POM" , when developer changes code then 
		// tester need not to do path changes in this or all related to this packge classes.
		// When developer changes in code and when we changed "xpath" in "Login.java" on "POM" , 
		// then its effect occurs on this package classes
		
		
		//calling created "Login.java" class from "POM" package
		Login_GlobalHR_POM loginpage = PageFactory.initElements(driver, Login_GlobalHR_POM.class);
		loginpage.Login_Credentials_Username();	//write in import as "import POM.Login;" , as we have called from POM package
		
		loginpage.Login_Credentials_Password();
		
		loginpage.Login_Click();
		
		loginpage.Employee_Hub();
		
	}
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);	//waits for 2 msec
		driver.quit();		
		
	}	
}

