package GlobalHR_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage_POM extends BaseClass
{
	//set path of username and password by using "By" sytax
	private By username = By.id("username");
	private By password = By.id("password");
	private By submit 	= By.xpath("//div[3]/input[@class='login_submit']");
	
	public Loginpage_POM (WebDriver driver) 
	{
		this.driver = driver;
	}

	
	public void Credentials() throws InterruptedException
	{
		driver.findElement(username).sendKeys("GSPLadmin");
		Thread.sleep(1000);
		
		driver.findElement(password).sendKeys("GSPLadmin");
		Thread.sleep(1000);
		
		driver.findElement(submit).click();
	}

}
