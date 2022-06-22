package PageFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Compassion_POM 
{
	WebDriver driver;
	
	public Login_Compassion_POM (WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	
	@FindBy (xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy (xpath="//input[@id='password']")
	WebElement pass;
	
	@FindBy (xpath="//button[@id='submit']")
	WebElement login_button;
	
	public void Login_Username()
	{
		username.sendKeys("Shreyas");
	}
	
	public void Login_Password()
	{
		pass.sendKeys("Compassion123");
	}
	
	public void Login_Click()
	{
		login_button.click();
	}
	
	
	
	
	
	
	
	
	
	
	

}
