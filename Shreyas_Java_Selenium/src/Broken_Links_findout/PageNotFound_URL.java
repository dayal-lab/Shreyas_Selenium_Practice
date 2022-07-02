package Broken_Links_findout;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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

public class PageNotFound_URL 
{
	WebDriver driver;

	@BeforeTest 
	public void Setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/gp/browse.html?node=6648217031&ref_=nav_cs_fashion");
	}
	
	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException
	{
		List <WebElement> list = driver.findElements(By.tagName("a"));					//take tagname "a" , bcz main URL's href stores into tag "a"
		
		for(int j=0; j<list.size(); j++) 												//for loop to continuously check all URL till List's size is less than "0"
		{
	         WebElement e = list.get(j); 												//get data captured by"j"
		
	    String url = e.getAttribute("href");											//take attribute "href" by creating object "url"
		
		if (url==null || url.isEmpty()  || url.isBlank())								//if URL is null or emoty or blank then following class or id or title or other take and print that
		{
			String tag = e.getTagName();
			String cls = e.getAttribute("class");
			String title = e.getAttribute("title");
			System.out.println("href : "+url+'\n'+"tag : "+tag+'n'+"Class : "+cls+'\n'+"title : "+title+'\n');
		}
		else
			
		try
		{
			URL link = new URL(url);
			HttpURLConnection http = (HttpURLConnection)link.openConnection();
			http.connect();
				
		if (http.getResponseCode()==400 )
		{
			System.out.println("************ BAD REQUEST ************** : " +url+'\n'+ "Status code:"+http.getResponseCode()+'\n'+"Response message:"  +http.getResponseMessage()+'\n');
		}
		if (http.getResponseCode()==404)
		{
			System.out.println("********** NOT FOUND LINK ************  :" +url+'\n'+ "Status code:"+http.getResponseCode()+'\n'+"Response message:"  +http.getResponseMessage()+'\n');
		}
		}

		catch(Exception ex)
		{
   		 System.out.println(ex.getMessage());
   		 ex.printStackTrace();
		}
	}
		System.out.println('\n'+'\n');
		System.out.println("----------> Total "+list.size()+ " CHECKING COMPLETED <-----------");
}
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.quit();		
	}	
}