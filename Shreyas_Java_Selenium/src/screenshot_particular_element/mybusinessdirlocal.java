package screenshot_particular_element;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mybusinessdirlocal 
{
	WebDriver driver;
	
	@BeforeTest
	public void beforetest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://mybusinessdirectorylocal.com/members/index.php");
	}

	@Test
	public void test() throws IOException
	{
		WebElement franchise = driver.findElement (By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[5]/a[1]"));

		File shot = franchise.getScreenshotAs (OutputType.FILE);
		FileUtils.copyFile(shot, new File ("e:\\mybusinessdir.jpg"));
		
	}
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}

	
