package Delete_One_Word;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Jiomart 
{
	WebDriver driver;
	
	@BeforeTest
	public void setuup()
	{
		System.setProperty("webdriver.chrome.driver", "e:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//checking loadtime of home webpage
		long start = System.currentTimeMillis();
		
		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		long finish = System.currentTimeMillis();
		long total = finish - start ;
		System.out.println("Total loadtime of home webpage (msec) : "+total);
	}
	
	
	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException
	{
		
		//creating class of mouse hover 
		Actions men = new Actions (driver);
		
		//hover on "Men" module
		WebElement wc = driver.findElement(By.id("nav_link_496"));
		men.moveToElement(wc).build().perform();
		Thread.sleep(2000);
		
		//click on "Footwear" submodule
		driver.findElement(By.xpath("//a[@href='https://www.jiomart.com/c/fashion/men/footwear/1480']")).click();
		Thread.sleep(2000);
		
		//scrolling webpage up-down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,900)");	//scrolled page down
		Thread.sleep(2000);
		
		//handling price scrollbar
		WebElement scroll_bar = driver.findElement(By.xpath("//body/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[14]/div[1]/div[1]/div[1]"));
		men.dragAndDropBy(scroll_bar, 60, 80).build().perform();
		Thread.sleep(2000);
		
		//scrolling full page down till last
		js.executeScript("scrollBy(0,10000)");	//full scrolled page down
		Thread.sleep(2000);
		
		//click on "Google Play" 
		driver.findElement(By.xpath("//body/div[1]/footer[1]/div[1]/div[1]/a[1]/img[1]")).click();
		Thread.sleep(2000);
		
		//handling popup windows
		Set<String> s = driver.getWindowHandles();
		
		Iterator<String> it = s.iterator();
		
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		System.out.println("Child window's title name : "+driver.getTitle());
		
		//taking screenshot
		File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(shot, new File ("e:\\selenium screenshots\\Jiomart GPlay.jpg"));

		Thread.sleep(2000);
		driver.close();
		
		driver.switchTo().window(parent);
		System.out.println("Parent window's title name : "+driver.getTitle());
		Thread.sleep(2000);
		
		
		//navigate on home screen
		driver.navigate().to("https://www.jiomart.com/");
		Thread.sleep(2000);
		
		//save_as home page image
		WebElement save_as  = driver.findElement(By.xpath("//body/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]"));
	
		String source = save_as.getAttribute("src");
		
		URL url = new URL (source);
		
		BufferedImage buffer = ImageIO.read(url);
		
		ImageIO.write(buffer, "png", new File ("e:\\selenium download\\Jiomart.png"));
		
		
		//enetering values in "Search" field
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("footwearf");
		Thread.sleep(2000);
		
		//now erasing footwearf's "f" word by backspace
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		
		
		//now erasing footwearf's "f" word by backspace
		//WebElement wc2 = driver.findElement(By.xpath("//input[@id='search']"));
		//men.moveToElement(wc2).doubleClick(wc2).click(wc2).sendKeys(Keys.BACK_SPACE);
		
	}
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
	
	

}
