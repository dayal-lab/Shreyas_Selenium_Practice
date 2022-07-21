package Checkboxes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mobile91
{
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.91mobiles.com/list-of-earphones/earphones-price-list-in-india");
	}
	
	@Test
	public void test() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,400)");			//scrolled down
		
//***1) Only one checkbox select -

		//click on Brand's "Ubon" checkbox
		driver.findElement(By.id("ubon3935")).click();
		Thread.sleep(1000);
		
		String msg = driver.findElement(By.xpath("//body/div[7]/form[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/label[1]/span[1]")).getText();
		System.out.println('\n'+"*** Only one selected checkbox name is : "+msg+'\n');
		Thread.sleep(2000);		

		
		
		
		

		
//2) All checkboxes select -
/*		
		driver.navigate().to("https://www.91mobiles.com/list-of-earphones/earphones-price-list-in-india");
		js.executeScript("scrollBy(0,400)");			//scrolled down
		
		
		//path of checkbox and unique element which is "brand[]" and combined both xpath by "and"
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@name,'brand[]')]"));
		System.out.println("Total cheboxes of brand is : "+checkbox.size());
		
		
		for(int i =0; i<checkbox.size(); i++)
		{
			checkbox.get(i).click();			//continues selects all checkboxes until checkbox size is less than i that is less than 0.
		}
		
	
	or
		for (WebElement chbox:checkbox)
		{
			chbox.click();
		}
	
*/		

		
//***3) Paticular checkboxes select -
	
		driver.navigate().to("https://www.91mobiles.com/list-of-earphones/earphones-price-list-in-india");	
		js.executeScript("scrollBy(0,400)");			//scrolled down
		
		
		//path of checkbox and unique element which is "brand[]" and combined both xpath by "and"
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@name,'brand[]')]"));
		
		for (WebElement brands : checkbox)							//created obj "brands" of already created obj "checkbox" by "for-each" loop
		{
		String checkbox_brand = brands.getAttribute("id");			//take attribute which we want to select of checkboxes
		
		
		//if checbox_brand (which is attribute i.e "id" of "boat" and "zebronics" checkboxes when equals to brands,
		//that is "brands" is obj. of "checkbox"obj.  which is created in "for-each" loop then clicks boat and zebronics checkboxes
		if (checkbox_brand.equals("boat2749") || checkbox_brand.equals("zebronics1056")) 		//after equals have taken id values from insoect	
		{
			brands.click();
		}
		}
		String msg1 = driver.findElement(By.xpath("//li[3]/label[1]/span[1]")).getText();	//gets text of "boat"
		String msg2=  driver.findElement(By.xpath("//li[5]/label[1]/span[1]")).getText();	//gets text of "zebronics"
		System.out.println("*** Selected checkboxes are : "+msg1+" and "+msg2);				//prints both texts
	
		
		
		
	
		
		
//*** 3) Click only first 2 checkboxes -
		
		driver.navigate().to("https://www.91mobiles.com/list-of-earphones/earphones-price-list-in-india");
		js.executeScript("scrollBy(0,400)");			//scrolled down
		
		
		//where "checkbox" is taken from obj. of "List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@name,'brand[]')]"));"
		//where obj "checkbox" path is unique path of checkbox and brands.
		int total = checkbox.size();
		
		//select all checkboxes
		for (int i=0;i<total;i++)		//if to select only last 2 then in place of "i=0", write " i=total-2"
		{
			if(i<3)
			{
				checkbox.get(i).click();
			}
		}
		
	}
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

}
