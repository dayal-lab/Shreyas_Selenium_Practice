package Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Validation 
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
	public void log_in_button() throws InterruptedException, IOException
	{
		try {
		  	File file=new File("e:\\login.xlsx"); 
		
		  	FileInputStream inputstream=new FileInputStream(file);
		  
		    @SuppressWarnings("resource")
		   	XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		  
			XSSFSheet sheet=wb.getSheet("Test");
			
			XSSFRow row				=	null;
			String username 		= 	null;					
			String password 		= 	null;
			
			for (int i=1; i<=sheet.getLastRowNum();i++)
			{
			  row=sheet.getRow(i);
			  username = row.getCell(0).getStringCellValue();
			  password = row.getCell(1).getStringCellValue();
			  
			  String validation_user 	= username.toString();
			  String validation_pass 	= password.toString();
				
			  driver.findElement(By.id("user_login")).sendKeys(validation_user);
			  driver.findElement(By.id("user_pass")).sendKeys(validation_pass);
			  driver.findElement(By.id("submit_login")).click();
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/button[1]")).click();
				  
			  String username_u 		= "shreyas";		//valid username 
			  String password_p 		= "!@#ABC1122";		//valid password
			  
			  if(username==null || username.isBlank() && password==null || password.isBlank())
			{
				System.out.println('\n'+"----------> NULL USERNAME AND PASSWORD. DO NOT LEAVE EMPTY FIELDS. <----------");  
				  
				String message = driver.findElement(By.xpath("//p[contains(text(),'The following field is required: Username')]")).getText();
				System.out.println(message);
				
				String message2 = driver.findElement(By.xpath("//p[contains(text(),'The following field is required: Password')]"+'\n'+'\n'+'\n')).getText();
				System.out.println(message2);
				Thread.sleep(2000);
			}
			else if (!username.contentEquals(username_u) && !password.contentEquals(password_p))
			{
				System.out.println('\n'+"----------> BOTH USERNAME AND PASSWORD INCORRECT. PLEASE TYPE AGAIN. <----------"+'\n');
				
				String message = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/p[2]"+'\n'+'\n'+'\n')).getText();
				System.out.println(message);
				Thread.sleep(2000);
			}
			else if (!username.contentEquals(username_u) && password.contentEquals(password_p) || username.contentEquals(username_u) && !password.contentEquals(password_p))
			{
				System.out.println('\n'+"----------> EIGHER USERNAME OR PASSWORD INCORRECT. PLEASE ENTER AGAIN. <----------"+'\n');
				
				String message = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/p[2]"+'\n'+'\n'+'\n')).getText();
				System.out.println(message);
				Thread.sleep(2000);
			}
			else if (username.contentEquals(username_u) && password.contentEquals(password_p))
			{
				System.out.println('\n'+" *** SUCCESSFULLY LOGGED IN ***"+'\n');
/*			
			
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")).click();											//Logout
			Thread.sleep(2000);
					
			String message = driver.findElement(By.xpath("//p[contains(text(),'You have successfully logged out!')]"+'\n'+'\n'+'\n')).getText();	//logout message
			System.out.println(message);
			}
*/			}
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
}			  
				
	@AfterTest
	public void aftertest() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}