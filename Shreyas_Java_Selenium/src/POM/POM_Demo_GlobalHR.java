package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_Demo_GlobalHR 
{
	
	public POM_Demo_GlobalHR (WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	
	WebDriver driver;
	
	
	//set path of username and password by using "By" sytax
	By username = By.id("username");
	By password = By.id("password");
	By submit 	= By.xpath("//div[3]/input[@class='login_submit']");
	
	//create method to perform actual actions of set path and call this method in "POM_Test_GlobalHR" package
	public void Credentials()
	{
		driver.findElement(username).sendKeys("GSPLadmin");
		driver.findElement(password).sendKeys("GSPLadmin");
		driver.findElement(submit).click();
	}

}
