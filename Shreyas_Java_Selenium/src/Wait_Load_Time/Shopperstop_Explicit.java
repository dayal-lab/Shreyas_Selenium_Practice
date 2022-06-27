package Wait_Load_Time;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shopperstop_Explicit 

{
	WebDriver driver;
	WebDriverWait expl_wait;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","e:\\chromedriver93\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//checking webisite's Home page loading time
				long start = System.currentTimeMillis();
				driver.get("https://www.shoppersstop.com/");
				long finish = System.currentTimeMillis();
				long total = finish - start ;
				System.out.println("Total load time of Home page is (in millisecond) : " +total);
	}
		
	@Test
	public void test() throws InterruptedException

	{

	//In Explicit, if not got given xpath, then runs last @AfterTest method and gives output pass/fails.
	//But in Implicit, if not got xpath, then last @AfterTest method not runs , and not give output pass/fails.
	//In implicit, system remains as it is in stable mode forever but not gives output, but in explicit even failed still gives output of fail.
	
	//path of "Shopperstop" logo image
	expl_wait = new WebDriverWait (driver,3);  
	expl_wait.until (ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/a[1]/img[1]")));
	
	
	//hovering on "Sigin"
	Actions men = new Actions (driver);
	
	WebElement wc = driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[2]/ul[1]/li[4]/a[1]/img[1]")); //retrieved xpath
	men.moveToElement(wc).build().perform();							//hovering mouse pointer on "Men"
	Thread.sleep(1000);
}
		
		
		@AfterTest
		public void quit() throws InterruptedException
	{
			
	Thread.sleep(2000);
	driver.quit();
	


		
	}
	
	
}

