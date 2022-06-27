package Read_from_Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
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

public class Validation_Read_from_Excel_oneloop 

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
			//takes excel file's path.
		  	File file=new File("e:\\shreyas.xlsx"); 
		  	
		  	//adds taken path into obj. "inputstream" in "FileInoutStream" method.
		  	FileInputStream inputstream=new FileInputStream(file);
		  
		    @SuppressWarnings("resource")
		   	XSSFWorkbook wb = new XSSFWorkbook(inputstream);		//stores into excel's method "XSSFWorkbook".
		  
			XSSFSheet sheet=wb.getSheet("Test");					//takes sheet name from excel file and stores into obj. "sheet".
			
			XSSFRow row				=	null;						//takes row which horizontally from location 0, i.e from 1st horizontally.
			String username 		= 	null;						//takes from "sendkeys()" which is defined below for loop.
			String password 		= 	null;
			
			for (int i=1; i<=sheet.getLastRowNum();i++)				//takes all values of excel until last row horizontally
			{
			  row=sheet.getRow(i);									//gets value "i" which is from row 0 excel, i. e in "shreyas" excel at row 0 is "123" and "!@#ABC". 
			  username = row.getCell(0).getStringCellValue();		//gets 1st row's data which at row0 horizontally 
			  password = row.getCell(1).getStringCellValue();
			  
			  
			  //converted excel's data which is in integer is numbers, converted into String-
			  //If not wrote this method then numbers not accept in String and gives error.
			  String validation_user 	= username.toString();						//if username will be in numbers i.e in string, then converts into string and passes to "String username = null".
			  driver.findElement(By.id("user_login")).sendKeys(validation_user);
			
			  //converted excel's data which is in integer is numbers, converted into String-
				String validation_pass 	= password.toString();
				driver.findElement(By.id("user_pass")).sendKeys(validation_pass);
			
			  
			  

			  driver.findElement(By.id("submit_login")).click();	
			  driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/button[1]")).click();
			  Thread.sleep(2000);
				  
			  
			  String username_u 		= "shreyas";		//valid username 
			  String password_p 		= "!@#ABC1122";		//valid password


			if(username==null || username.isBlank() && password==null || password.isBlank())
			{
				String message = driver.findElement(By.xpath("//p[contains(text(),'The following field is required: Username')]")).getText();
				System.out.println(message);
				
				String message2 = driver.findElement(By.xpath("//p[contains(text(),'The following field is required: Password')]"+'\n'+'\n'+'\n')).getText();
				System.out.println(message2);
			}
			else if (!username.contentEquals(username_u) && !password.contentEquals(password_p))
			{
				System.out.println('\n'+"Both username and password incorrect"+'\n');
				
				String message = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/p[2]"+'\n'+'\n'+'\n')).getText();
				System.out.println(message);
			}
			else if (!username.contentEquals(username_u) && password.contentEquals(password_p) || username.contentEquals(username_u) && !password.contentEquals(password_p))
			{
				System.out.println('\n'+" *** Either username or password is wrong *** "+'\n');
				
				String message = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/p[2]"+'\n'+'\n'+'\n')).getText();
				System.out.println(message);
			}
			else 
			{
				System.out.println(" *** SUCCESSFULLY LOGGED IN ***"+'\n');
			
			
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")).click();											//Logout
			Thread.sleep(2000);
					
			String message = driver.findElement(By.xpath("//p[contains(text(),'You have successfully logged out!')]"+'\n'+'\n'+'\n')).getText();	//logout message
			System.out.println(message);
			}
			}
}			  
				
	@AfterTest
	public void aftertest() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}