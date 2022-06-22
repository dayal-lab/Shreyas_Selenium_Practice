package PageFrame_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFrame.Login_Compassion_POM;

public class Login_Test_Compassion 

{

WebDriver driver ;
	
	@BeforeTest()
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "e:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cukdev.co.uk/loggedinpop/");
	}
	
	
	@Test()
	public void test() throws InterruptedException
	{
		Login_Compassion_POM loginpage = PageFactory.initElements(driver, Login_Compassion_POM.class);
		
		loginpage.Login_Username();
		loginpage.Login_Password();
		loginpage.Login_Click();
	}
	
	
	@AfterTest()
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}


