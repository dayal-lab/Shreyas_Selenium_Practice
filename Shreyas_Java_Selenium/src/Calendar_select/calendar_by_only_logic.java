package Calendar_select;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class calendar_by_only_logic 
{
	WebDriver driver;
	WebDriverWait wait;
	
	By byUsername 		= By.id("username");
    By byPassword 		= By.id("password");
    By byLoginButton 	= By.id("login");
	By globalpool 		= By.xpath("//div[2]/div[2]/div[2]/input[@name='child-pool']");
	By supporter_type	= By.xpath("//div[3]/div[2]/div[1]/div[@class='ui dropdown selection']");
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://services.compassionuk.org/sef/");
	}
	
	@Test
	public void test() throws InterruptedException
	{
		
		driver.findElement(byUsername).sendKeys("GC_2");
        driver.findElement(byPassword).sendKeys("G33con0404");
        driver.findElement(byLoginButton).click();
        Thread.sleep(1000);
        
		driver.findElement(globalpool).click();
		Thread.sleep(1000);
		
		driver.findElement(supporter_type).click();
		Thread.sleep(1000);
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='menu transition visible']//div"));
		System.out.println(list1.size());
		list1.get(0).click();
		String value1 = list1.get(0).getText();
		System.out.println(value1);
		Thread.sleep(2000);
		
	
		//click on "calendar" field to open it
		driver.findElement(By.xpath("//input[@id='ffdate']")).click();
		
		//list takes all dates from selected month (given path is whole month selected border)
		List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']"));
				
		//created variable "total_dates" to store all dates from list's "dates"
		int total_dates = dates.size();
		Thread.sleep(2000);
				
				
		//for loop checks all dates from calendar till all dates are less than 0
		for (int i =0; i<total_dates;i++)
		{
			//gets all dates from calendar and prints
			String date = dates.get(i).getText();
			System.out.println(date);
			Thread.sleep(2000);
					
					
		//in this loop , checks selected calendar's date with "1" by "date" obj wchich is got text from calendar
		if(date.equals("1"))
		{
			break;	//if calendar's date is equal to 1 then breaks here and clicks wc 
		}
		else
		{
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();	//else clicks on next calendar's button
		}
		}
				
		//below wc's path is 1 date's path from all calendar's month from Jan-Dec.
		// If checked 1 date's xpath from Jan-Dec then there are 3 common paths which written in or
		//and or means it will check all xpaths of 1 dates and will select and click among Jan-Dec.
		WebElement wc = driver.findElement(By.xpath("//a[@class='ui-state-default' or class=\"ui-state-default ui-state-hover\" or contains(text(),'1')]"));
		wc.click();
		Thread.sleep(4000);
				
		//get text which element that is 1 is selected
		String day = wc.getText();
		String month_year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText(); //get month and year text
		Thread.sleep(4000);
		System.out.println("Date selected : "+day+" "+month_year);
					
		System.out.println('\n'+"***** COMPLETED *****"+'\n');
		}	
	}