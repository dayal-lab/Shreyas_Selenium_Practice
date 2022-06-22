package Broken_Links_findout;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Acer 
{
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://mybusinessdirectorylocal.com/");
		

		
	}
	
	@Test
	public void test() throws InterruptedException
	{

		try
		{
				//click on All Category dropdown list
				driver.findElement(By.xpath("//body/div[4]/div[2]/form[1]/div[2]/div[1]/button[1]")).click();
				Thread.sleep(2000);
			
				//set path of all list table
		     	List<WebElement> list = driver.findElements(By.xpath("//body/div[4]/div[2]/form[1]/div[2]/div[1]/div[1]"));	    
		      
		      
		      for(int i=0; i<list.size(); i++) 
		      {
		    	//click on selected index value
		    	 list.get(i).click();
		       
		    	 
		    	 
		    	 //print selected value from dropdown
		    	 System.out.println(i);
		    	 
		    	 //click on "Search" button
		    	 driver.findElement(By.xpath("//body/div[4]/div[2]/form[1]/button[1]")).click();
		    	 Thread.sleep(2000);
		    	 
		    	 //navigate again on back page
		    	 driver.navigate().back();
		    	 Thread.sleep(2000);
		    	 
		    	 //click again on "All Category" dropdown list to select next data
		    	 driver.findElement(By.xpath("//body/div[4]/div[2]/form[1]/div[2]/div[1]/button[1]")).click();
		    	 Thread.sleep(2000);
		      }
		}   
		      catch (Exception e) 
				{
				   e.printStackTrace();
				   System.out.println("error: " + e.getMessage());
				}			
		}
		
		

	
	@AfterTest()
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	
	
	
	

}
