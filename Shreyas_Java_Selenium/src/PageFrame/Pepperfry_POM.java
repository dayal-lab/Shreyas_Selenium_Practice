package PageFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Pepperfry_POM 
{
	WebDriver driver ;
	
	public void Pepperfry (WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//path of hovering on "Light " module
	@FindBy (xpath = "//header/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[8]/a[1]")
	WebElement light;
	
	//path of "Wall light" submodule of "Light" module
	@FindBy (xpath = "//header/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[8]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	WebElement wall_light;
	
	
	//method to perform hovering action on "Light" module
	public void Light() throws InterruptedException
	{
		//created object of class "actions" of mouse hover
		Actions action = new Actions (driver);
		
		action.moveToElement(light).build().perform();
		Thread.sleep(1000);
	}
	
	
	//method to click on "Wall light" submodule
	public void WallLight()
	{
		wall_light.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
