package Get_Dimension_Location;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dimention

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
	public void test()
	{
		

		//"Dimention" is a class to call to check height and width of a particular button/image.
		Dimension dimesion=driver.findElement(By.id("user_login")).getSize();	//getSize() emthod takes size of selectedbelement.
		System.out.println("Width of Username field 	: "	+dimesion.width);		//takes width	
		System.out.println("Height of Username field 	: "	+dimesion.height+'\n');	//takes height
		
		//whole window's height and width
		Dimension dimension2 = driver.manage().window().getSize();
		System.out.println("Whole window's Height	:	"+dimension2.height);
		System.out.println("Whole window's width	:	"+dimension2.width+'\n');
		
		//"Point" a class to take webelement's x and y location
		Point point=driver.findElement(By.id("user_login")).getLocation();
		System.out.println("X Position of Username field	: "	+point.x);
		System.out.println("Y Position of Username field	: "	+point.y+'\n');
		
		//wholw window's X and Y axis
		Point point2=  driver.manage().window().getPosition();	
		System.out.println("X position of whole window of upper left: "+point2.x);
		System.out.println("Y position of whole window : "+point2.y+'\n');
	
	}
		
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}