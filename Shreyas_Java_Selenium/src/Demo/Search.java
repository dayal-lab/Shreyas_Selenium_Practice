package Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Search 
{
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
	try
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://mybusinessdirectorylocal.com/members/index.php");
	}
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println(e.getStackTrace());
	}
}
		

	@Test
	public void all_category() throws InterruptedException
	{
		//enter blank credentials
		driver.findElement(By.id("user_login")).sendKeys("shreyas");
		driver.findElement(By.id("user_pass")).sendKeys("!@#ABC1122");
		driver.findElement(By.id("submit_login")).click();
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//body/div[4]/div[2]/form[1]/div[1]/input[1]")).sendKeys("Galaxy Store");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body/div[4]/div[2]/form[1]/button[1]")).click();
		Thread.sleep(2000);
		
		String message = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]")).getText();
		System.out.println(message);
		
		 SoftAssert softassert = new SoftAssert ();
		
		 WebElement wc = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]"));
		String actualText = wc.getAttribute("class");
		String expectedText = "showing-results";
		softassert.assertEquals(actualText, expectedText);
	
		 if(!expectedText.equals(actualText))
		 	{
	 			System.out.println("*** Not matched text with its actual path ***" +'\n');
		 	}
		 else  
		 	{
			 System.out.println("*** Matched text with its actual path" +'\n');
		 	}
		 
		 driver.navigate().back();
		
		//clear data in search field-
		driver.findElement(By.xpath("//body/div[4]/div[2]/form[1]/div[1]/input[1]")).clear();
		Thread.sleep(4000);
		
		//path of dropdown
		driver.findElement(By.xpath("//body/div[4]/div[2]/form[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(2000);
				
				//adding dropdown's all list into "List"
				List<WebElement> list = driver.findElements(By.tagName("option"));
				
				//loop to select one by one all data from dropdown list of "All Category"
				for (int i = 2030; i<list.size() ; i++)
				{
					list = driver.findElements(By.tagName("option"));
					
					list.get(i).click();	//click on got data from list's index
					Thread.sleep(2000);
					
					//select list index data which is at index = 2030 
//					driver.findElement(By.xpath("//body/div[4]/div[2]/form[1]/div[2]/div[1]/button[1]")).click();		
//					Thread.sleep(2000);
					
					//click on "Search" button
					driver.findElement(By.xpath("//body/div[4]/div[2]/form[1]/button[1]")).click();
					Thread.sleep(2000);
					
					//get search result's message
					String message2 = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]")).getText();
					System.out.println(message2);
					
					 SoftAssert softassert2 = new SoftAssert ();
						
					WebElement wc2 = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]"));
					String actualText2 = wc2.getAttribute("class");
					String expectedText2 = "showing_results";
					softassert2.assertEquals(actualText2, expectedText2);
				
					 if(!expectedText2.equals(actualText2))
					 	{
				 			System.out.println("*** Not matched text with its actual path ***" +'\n');
					 	}
					 else  
					 	{
						 System.out.println("*** Matched text with its actual path" +'\n');
					 	}
					 driver.navigate().back();
					}
		}

	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
