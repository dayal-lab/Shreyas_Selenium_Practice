package PageFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Puma_POM
{
	WebDriver driver;
	
	public Puma_POM (WebDriver driver)
	{
		this.driver = driver ;
	}
	

	//Path of hovering on "Men" module
	@FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]/span[1]")
	WebElement men;
	
	//Path to click on "Running shoes" from "Men" module
	@FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/div[1]/ul[1]/li[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")
	WebElement shoes;
	
	//Path to click on "Facebook" icon logo
	@FindBy(xpath = "//body/div[@id='page']/footer[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]")
	WebElement fb;
	
	
	public void Men_module() throws InterruptedException
	{
		Actions action = new Actions (driver);
		action.moveToElement(men).build().perform();
		Thread.sleep(1000);
		
	}
	
	public void Running_shoes()
	{
		shoes.click();
	}
	
	public void Facebook()
	{
		fb.click();
	}
	
	
	
	
	
	
	
	

}
