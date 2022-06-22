package Save_as_image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dell 

{
WebDriver driver;

@BeforeTest
public void setup()
{
	System.setProperty("webdriver.chrome.driver","e:\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	//checking webisite's Home page loading time
	long start = System.currentTimeMillis();
	driver.get("https://www.dell.com/en-in");
	long finish = System.currentTimeMillis();
	long total = finish - start ;
	System.out.println("Total load time of Home page is (in millisecond) : " +total);
	
	
}


@Test
public void test() throws IOException
{
	
	//get xpath
	WebElement image = driver.findElement(By.xpath("//body/main[1]/div[2]/div[1]/div[2]/div[4]/div[1]/a[1]/figure[1]/img[1]"));
	
	//get source value of image ("src")
	String link = image.getAttribute("src");
	
	//creating URL
	URL url = new URL (link);
	
	//created object of Buffered Image with ImageIO class
	BufferedImage buffer = ImageIO.read(url);
	
	//saving selected image in given path
	ImageIO.write(buffer ,"png" ,new File ("e:\\Shreyas.png"));
	
	driver.close();
	
	//after successfully passed test, check image in "test-output" file on left side
	
	
	
	
	
}






@AfterTest
public void quit() throws InterruptedException
{
	Thread.sleep(2000);
	driver.quit();
}
}




