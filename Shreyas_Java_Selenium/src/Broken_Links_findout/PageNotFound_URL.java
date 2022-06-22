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
		driver.get("https://findusonweb.co.uk/members/index.php?from=aHR0cHM6Ly9maW5kdXNvbndlYi5jby51ay9tZW1iZXJzL21hbmFnZV9yZXF1ZXN0cy5waHA%252FYWN0aW9uPWFkZA%253D%253D");
	
	}
	
	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException
	{
	
		//take tagname "a" , bcz main URL's href stores into tag "a"
		List <WebElement> list = driver.findElements(By.tagName("a"));
		
		//for loop to continuously check all URL till List's size is less than "0"
		for(int j=0; j<list.size(); j++) 
		{
	         WebElement e = list.get(j); //get data captured by"j"
		
	    //take attribute "href" by creating object "url"
		String url = e.getAttribute("href");
		
		
		//if URL is null or emoty or blank than following class or id or title or other take and print that
		if (url==null || url.isEmpty()  || url.isBlank())
		{
			String cls = e.getAttribute("class");
       	 	String id = e.getAttribute("id");
       	 	String title = e.getAttribute("title");
       	 	String datatype = e.getAttribute("data-toggle");
       	 	System.out.println("href is null: "+" className:"+cls+" title:"+title+" Id:"+id+" value:"+datatype);
			
		}
		else
			try{
				
				System.out.println(" *** URL is active ***");
				
				URL link = new URL(url);
				
				HttpURLConnection http = (HttpURLConnection)link.openConnection();
				
				http.connect();
		
		int response_code = http.getResponseCode();
		
		if (response_code >= 400)
		{
			// where '\n' writes data on new line
			System.out.println(+'\n'+'\n'+"************************************* This link is broken *************************************************************************** :" 
			+url+'\n'+ "Status code:"+http.getResponseCode()+'\n'+"Response message:"  +http.getResponseMessage()+'\n');
		}
		else
		{
			System.out.println(" This link is active	:" +url+ '\n'+'\n');	
		}
		
		}
		catch(Exception ex)
		{
			
			//if errors captured, then print it messages
   		 System.out.println(ex.getMessage());
   		 ex.printStackTrace();
   		 System.out.println(ex.getLocalizedMessage());
   		 System.out.println(ex.getClass());
		}
		
		
	}
		System.out.println('\n'+'\n');
		System.out.println("URL CHECKING COMPLETED");
}
	
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.quit();		
	}	
}
