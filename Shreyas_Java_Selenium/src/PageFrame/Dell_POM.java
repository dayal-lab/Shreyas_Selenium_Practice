package PageFrame;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Dell_POM 
{
	WebDriver driver;
	
	public Dell_POM(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//Adding path 
	
	//Path of hovering on "Deals" module
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement deals;
	
	//Hovering on "Desktop Deals" from "Deals" module
	@FindBy( xpath ="//a[contains(text(),'Desktop Deals')]")
	WebElement desktop_deal;
	
	
	
	//Hovering on "Deal" model by actions class
	
	public void Deal() throws InterruptedException
	{
		Actions action = new Actions (driver);
		
		action.moveToElement(deals).build().perform();
		Thread.sleep(2000);
	}
	
	
	//Hovering on "Desktop_Deal" model by actions class
	public void Desktop_Deal() throws InterruptedException
	{
		Actions action = new Actions (driver);
		
		action.moveToElement(desktop_deal).build().perform();
		Thread.sleep(1000);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
