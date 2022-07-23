package Calendar_select;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class calendar_with_string_defined
{
	WebDriver driver;
	
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
		
		//set month for selecting that month
		String month ="August 2022";
		
		//click on "calendar" field to open it
		driver.findElement(By.xpath("//input[@id='ffdate']")).click();
		
		Thread.sleep(3000);
		
		while(true)
		{
			//take date and year from calendar's header
			String msg = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/div[1]")).getText();
			
			
			//if obj month = "August 2022" matches above given calendar's header date and year, 
			//then nothing else do condition of if else do else's condition i.e click on next calendar button
			//do until msg's "August 2022" displays
			//and after selecting correct gievn date, then click on "1" day whose path is given after completion of loop.
			if(msg.equals(month))
			{
//				String date = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/div[1]")).getText();
//				System.out.println("Wrong date selected	:	"+date);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			}
		}
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]")).click();
		String day = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]")).getText();
		String msg = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/div[1]")).getText();
		System.out.println("Date selected	:	"+day+" "+msg);
	}	
		
	//after @Test, it runs
	@AfterMethod
	public void end()
	{
		System.out.println(+'\n'+"***** CALENDAR SELECTION FINISHED *****"+'\n');
	}
		
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}








