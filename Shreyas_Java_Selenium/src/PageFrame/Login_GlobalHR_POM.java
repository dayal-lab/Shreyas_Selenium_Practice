package PageFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Login_GlobalHR_POM 
{
	WebDriver driver;
	
	public Login_GlobalHR_POM(WebDriver driver)
	{
		this.driver = driver; 	//Constructor, as every page needs a Webdriver to find elements
	}
	

	//Now locating elements by "@FindBy"
	//Locate "username" path
	
	// where (id="username") is path of "username" of Global HR 
	//	as we take "driver.findElement(By.xpath())" from inspect chropath
		
	@FindBy (id = "username") 
	WebElement name ;
	
	//Locate "password" path
	@FindBy(id ="password")
	WebElement pass;
	
	//Locate "Login" button path
	@FindBy(className = "login_submit")
	WebElement login_button;
	
	//Locate "Emp Hub" module;s path
	@FindBy(xpath ="//span[contains(text(),'Employee Hub')]")
	WebElement emp_hub;
	
	
	
	//Method that performs login action using the web elements, i.e calls above @FindBy elements
	public void Login_Credentials_Username() throws InterruptedException
	{
		name.sendKeys("GSPLadmin");
		
	}
	
	public void Login_Credentials_Password()
	{
		pass.sendKeys("GSPLadmin");
	}
	
	public void Login_Click()
	{
		login_button.click();
	}
	
	
	//Hover on "Employee Hub" module
	
	// Write "Actions" method everytime, when write in a new method, because
	// in every method all data is related to only that method.
	// That is, it is call private variables/ local variables, 
	// where "driver" is a object defined in a method, which is of WebDriver which is globally defined 
	// so it is a global varible,it get use in any method.
	
	public void Employee_Hub() throws InterruptedException
	{
		Actions action = new Actions (driver);
		
		action.moveToElement(emp_hub).build().perform();
		Thread.sleep(2000);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
