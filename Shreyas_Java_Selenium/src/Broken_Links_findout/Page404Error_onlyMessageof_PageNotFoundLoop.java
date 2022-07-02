package Broken_Links_findout;

import java.net.HttpURLConnection;
import java.net.URL;
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

public class Page404Error_onlyMessageof_PageNotFoundLoop 
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
	public void pagenotfound()
	{
		System.out.println('\n'+"*** WEBPAGE CHECKING STARTED......"+'\n');
	try
	{
	List <WebElement> list2 = driver.findElements(By.tagName("a"));					
	
	for(int j=0; j<list2.size(); j++) 												
	{
         WebElement e2 = list2.get(j); 												
	
    String url2 = e2.getAttribute("href");											
	
	if (url2==null || url2.isEmpty()  || url2.isBlank())								
	{	
   	}
	else
	{
		URL link = new URL(url2);
		HttpURLConnection http = (HttpURLConnection)link.openConnection();
		http.connect();
			
	if (http.getResponseCode()==400 )
	{
		System.out.println("************ BAD REQUEST ************** : " +url2+'\n'+ "*Status code:"+http.getResponseCode()+'\n'+"*Response message:"  +http.getResponseMessage()+'\n');
		
	}
	if (http.getResponseCode()==404)
	{
		System.out.println("********** NOT FOUND LINK ************  :" +url2+'\n'+ "*Status code:"+http.getResponseCode()+'\n'+"*Response message:"  +http.getResponseMessage()+'\n');
	}
	}
	}
	}
	catch (Exception ex)
	{
		ex.printStackTrace();
		System.out.println(ex.getMessage());
		System.out.println(ex.getStackTrace());
	}
	System.out.println("----------------------------------------");
	System.out.println("******** URL CHECKING COMPLETED ********");
	System.out.println("----------------------------------------"+'\n'+'\n');
	}

		
	@AfterTest
	public void quit() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.quit();
	}	
}