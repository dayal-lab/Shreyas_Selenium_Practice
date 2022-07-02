package Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

public class Registration_Validation
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
		driver.get("https://mybusinessdirectorylocal.com/members/user_accounts_add.php");
	}
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println(e.getStackTrace());
	}
}
		
	@Test
	public void new_data() throws InterruptedException, IOException
	{
		try
		{
		File file=new File("e:\\dir.xlsx"); 
		
	  	FileInputStream inputstream=new FileInputStream(file);
	  
	    @SuppressWarnings("resource")
	   	XSSFWorkbook wb = new XSSFWorkbook(inputstream);
	  
		XSSFSheet sheet=wb.getSheet("Test");
		
		XSSFRow row				=	null;
		String businessname 	= 	null;
		String firstname		= 	null;
		String lastname 		= 	null;
		String email 	 		= 	null;
		String email_confirm	= 	null;
		String mobile 	 		= 	null;
		String position			=	null;
		String password 		= 	null;
		String confirm_pass		= 	null;
		  				  
		  {
		  for (int i=1; i<=sheet.getLastRowNum();i++)
		  {
			  Thread.sleep(3000);
			  
			driver.findElement(By.xpath("//body/div[4]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[@placeholder='Business Name']")).clear();	//businessname field cleared
			driver.findElement(By.xpath("//body/div[4]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/input[1]")).clear();	//trading
			driver.findElement(By.id("user_first_name")).clear();																		//firstname
			driver.findElement(By.id("user_last_name")).clear();																		//lastname
			driver.findElement(By.id("user_email")).clear();																			//email
			driver.findElement(By.id("user_email2")).clear();																			//confirm email
			driver.findElement(By.id("user_phone")).clear();																			//mobile
			driver.findElement(By.id("position")).clear();																				//position
			driver.findElement(By.id("login")).clear();																					//unique username
			driver.findElement(By.id("pass")).clear();																					//password
			driver.findElement(By.id("pass2")).clear();																					//confirm pass
				  
			  
		  row=sheet.getRow(i);
		 
		  businessname 	= row.getCell(0).getStringCellValue();
		  firstname 	= row.getCell(1).getStringCellValue();
		  lastname 		= row.getCell(2).getStringCellValue();
		  email 		= row.getCell(3).getStringCellValue();
		  email_confirm = row.getCell(4).getStringCellValue();
		  mobile	    = row.getCell(5).getStringCellValue();
		  position		= row.getCell(6).getStringCellValue();
		  password		= row.getCell(7).getStringCellValue();
		  confirm_pass 	= row.getCell(8).getStringCellValue();
		  
		  String str1 	= businessname.toString();
		  String str2 	= firstname.toString();
		  String str3 	= lastname.toString();
		  String str4	= email.toString();
		  String str5 	= email_confirm.toString();
		  String str6 	= mobile.toString();
		  String str7	= position.toString();
		  String str8 	= password.toString();
		  String str9 	= confirm_pass.toString();
		 		  
		  
		  String regex  = "^[a-zA-Z0-9]*[0-9]*$";			//businessname	 (only capital, small letters, 0-9 numbers allowed) , "*" multiple times allowed.
//		  String regex2 = "^[a-zA-Z0-9]*[0-9]*$";			//tradingname
		  String regex3 = "^[a-zA-Z]*$";					//firstname
		  String regex4 = "^[a-zA-Z]*$";					//lastnamename
		  String regex5 = "[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+"[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";	//email
		  String regex6 = "[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+"[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";	//confirm email
		  String regex7 = "^[0-9]{10}$";					//mobile no.only 10 digits from 0-9 allowed upto 10 times
		  String regex8 = "^[a-zA-Z]*$";					//position
//		  String regex9 = "^[a-zA-Z]*$";					//usersname	 
		  String regex10 = "^[a-zA-Z0-9!@#$%^&]+$";			//password	 
		  String regex11 ="^[a-zA-Z0-9!@#$%^&]+$";			//confirm password	 
	
		
		
		
//*** Businessname validation-
		driver.findElement(By.xpath("//body/div[4]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(str1);	//Business Name
		Thread.sleep(1000);
		
		Pattern pattern = Pattern.compile(regex);   				
		Matcher matcher = pattern.matcher(str1); 	 	
		
		boolean matchFound = matcher.find();					
		 
		 if(businessname==null || businessname.isBlank() || businessname.isEmpty())
		 {	
			 System.out.println("-----> NULL DATA IN BUSINESSNAME. PLEASE ENTER DATA <-----"+'\n');
		 }	 
		 else if (matchFound) 
		 { 
		 System.out.println("*** SUCCESSFULLY ENTERED BUSINESSNAME ***"+'\n');
		 } 
		 else if (!matchFound)
		 {
		     System.out.println(businessname+"-----> Please Enter Only Letters/ Numbers in Businessname field <-----"+'\n');
		 }
		 
		 
		
		 
					
				
//Firtsname validation	
		driver.findElement(By.id("user_first_name")).sendKeys(str2);		
		Thread.sleep(1000);	
		
		
		Pattern pattern3 = Pattern.compile(regex3);   		
		Matcher matcher3 = pattern3.matcher(firstname);  
		
		boolean matchFound3 = matcher3.find();		
		 
		 if(firstname==null || firstname.isBlank() || firstname.isEmpty())
		 {	
			 System.out.println("-----> NULL DATA IN FIRSTNAME. PLEASE ENTER DATA <-----"+'\n');
		 }	 
		
		else if(matchFound3) 
		 {
		    System.out.println("*** SUCCESSFULLY ENTERED FIRSTNAME ***");
		 } 
		 else if(!matchFound3)
		 {
		    System.out.println(firstname+"-----> Please Enter Only Letters in Firtsname field <-----");
		 }
		
		
				
//Lastname validation-
		driver.findElement(By.id("user_last_name")).sendKeys(str3);		//last name
		Thread.sleep(1000);
		
		Pattern pattern4 = Pattern.compile(regex4);   		
		Matcher matcher4 = pattern4.matcher(lastname);  
		
		boolean matchFound4 = matcher4.find();		
		 
		if(lastname==null || lastname.isBlank() || lastname.isEmpty())
		 {	
			 System.out.println("-----> NULL DATA IN LASTNAME. PLEASE ENTER DATA <-----"+'\n');
		 }	  
		
		 else if(matchFound4) 
		 {
		    System.out.println("*** SUCCESSFULLY ENTERED LASTNAME ***"+'\n');
		 } 
		 else if (!matchFound4)
		 {
			 System.out.println(lastname+"-----> Please Enter Only Letters in Lastname field <-----");
		 }
		
		
				
// User email validation-
		driver.findElement(By.id("user_email")).sendKeys(str4);		
		Thread.sleep(1000);
		
		Pattern pattern5 = Pattern.compile(regex5);   
		Matcher matcher5 = pattern5.matcher(email);  
		
		boolean matchFound5 = matcher5.find();		
		 
		if(email==null || email.isBlank() || email.isEmpty())
		 {	
			 System.out.println("-----> NULL DATA IN EMAIL. PLEASE ENTER DATA <-----"+'\n');
		 }	 
		else if(matchFound5) 
		 {
		    System.out.println("*** SUCCESSFULLY ENTERED EMAIL ***");
		 } 
		 else if (!matchFound5)
		 {
		    System.out.println(email+"-----> Please Enter Correct Email Format <----- ***");
		 }
		

		
//Confirm email validation-
		driver.findElement(By.id("user_email2")).sendKeys(str5);		
		Thread.sleep(1000);
		
		Pattern pattern6 = Pattern.compile(regex6);   	
		Matcher matcher6 = pattern6.matcher(email_confirm);  
		
		boolean matchFound6 = matcher6.find();		
		 
		if(email_confirm==null || email_confirm.isBlank() || email_confirm.isEmpty())
		 {	
			 System.out.println("-----> NULL DATA IN CONFIRM EMAIL. PLEASE ENTER DATA <-----"+'\n');
		 }	 
		 else if(matchFound6) 
		 {
		    System.out.println("*** SUCCESSFULLY ENTERED EMAIL CONFIRM ***"+'\n');
		 } 
		 else if (!matchFound6)
		 {
			 System.out.println(email_confirm+"-----> Please Enter Correct Confirm_Email Format <----- ***");
		 }
	
		 
		 
		 if (!email.contentEquals(email_confirm))   //compare "email" and "confirm email"
		 {
			 System.out.println("----->NOT EQUAL EMAIL & CONFIRMED EMAIL. PLEASE TYPE AGAIN <----- "+'\n');
		 }
		 else
		 {
			 System.out.println("----->SUCCESS. EMAIL & CONFIRMED EMAIL ARE EQUAL <-----"+'\n');
		 }
		 
		 
		 		
//*** Mobile no. validation -
		driver.findElement(By.id("user_phone")).sendKeys(str6);		
		Thread.sleep(1000);
		
		Pattern pattern7 = Pattern.compile(regex7);   
		Matcher matcher7 = pattern7.matcher(mobile); 
		
		boolean matchFound7 = matcher7.find();		
		 
		if(mobile==null || mobile.isBlank() || mobile.isEmpty())
		 {	
			 System.out.println("-----> NULL DATA IN MOBILE NO. PLEASE ENTER DATA <-----"+'\n');
		 }	 
		else if(matchFound7) 
		 {
		    System.out.println("*** SUCCESSFULLY ENTERED MOBILE NO. ***"+'\n');
		 } 
		 else if (!matchFound7) 
		 {
		    System.out.println(mobile+"-----> Please Enter 10 digit no. only in Mobile Number field <-----"+'\n');
		 }
	
	
		 
//Position field-		 
		driver.findElement(By.id("position")).sendKeys(str7);		
		Thread.sleep(1000);
		
		Pattern pattern8 = Pattern.compile(regex8);   
		Matcher matcher8 = pattern8.matcher(position); 
		
		boolean matchFound8 = matcher8.find();		
		 
		if(position==null || position.isBlank() || position.isEmpty())
		 {	
			 System.out.println("-----> NULL DATA IN POSITION. PLEASE ENTER DATA <-----"+'\n');
		 }	  
		if(matchFound8) 
		 {
		    System.out.println("*** SUCCESSFULLY ENTERED POSITION ***"+'\n');
		 } 
		 else if (!matchFound) 
		 {
		    System.out.println(position+"-----> Please Enter Lettrers Only in Position field<-----"+'\n');
		 }
		
		
		
		 
//Password validation-
		 driver.findElement(By.id("pass")).sendKeys(str8);
		 Thread.sleep(1000);
		 
		 Pattern pattern10 = Pattern.compile(regex10);   
		 Matcher matcher10 = pattern10.matcher(password);  
			
		 boolean matchFound10 = matcher10.find();		
			
		 if(password==null || password.isBlank() || password.isEmpty())
		 {	
			 System.out.println("-----> NULL DATA IN PASSWORD. PLEASE ENTER DATA <-----"+'\n');
		 }	 
		 else if(matchFound10) 
		 {
			 System.out.println("*** SUCCESSFULLY ENTERED PASSWORD ***");
		 } 
		 else if (!matchFound10)
		 {
			 System.out.println(password+"-----> Please Enter Password With Atleast 1 Capital Letter and 1 Symbol <-----");
		 }
			
	
			 
//Confirm Password validation-
		driver.findElement(By.id("pass2")).sendKeys(str9);		
		Thread.sleep(1000);
			 
		Pattern pattern11 = Pattern.compile(regex11);   	
		Matcher matcher11 = pattern11.matcher(confirm_pass); 
				
		boolean matchFound11 = matcher11.find();		
				 
		if(confirm_pass==null || confirm_pass.isBlank() || confirm_pass.isEmpty())
		 {	
			 System.out.println("-----> NULL DATA IN CONFIRM PASSWORD. PLEASE ENTER DATA <-----"+'\n');
		 }	 
		else if(matchFound11) 
		{
			System.out.println("*** SUCCESSFULLY ENTERED CONFIRM PASSWORD ***"+'\n');
		} 
		else if (!matchFound)
		{
			 System.out.println(confirm_pass+"-----> Please Enter Confirm_Password With Atleast 1 Capital Letter and 1 Symbol <-----");
		 }
		}
		

			
		 if (!password.contentEquals(confirm_pass))																					//compare "password" and "confirm password"
		 {
			 System.out.println("-----> NOT EQUAL PASSWORD & CONFIRMED PASSWORD. PLEASE TYPE AGAIN <-----"+'\n');
		 }
		 else
		 {
			 System.out.println("-----> SUCCESS. PASSWORD & CONFIRMED PASSWORD ARE EQUAL <------"+'\n');
		 }
		 
		 Thread.sleep(5000);
		 
		driver.findElement(By.xpath("//body[1]/div[4]/div[1]/form[1]/div[1]/div[1]/div[6]/div[4]/div[1]/div[2]/div[1]/label[1]/input[1]")).click();		//terms accepted
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[4]/div[1]/form[1]/div[1]/div[3]/div[1]/button[1]")).click();						//create acc. button
		Thread.sleep(2000);
		
		System.out.println('\n'+"----------------------------------------------------------------------------------------------------");
		System.out.println("*******************************    FORM FILLING COMPLETED ********************************************");
		System.out.println("----------------------------------------------------------------------------------------------------"+'\n'+'\n');
		}
	}
		catch(Exception e)
		{
		 e.printStackTrace();
		 System.out.println(e.getMessage());
		}
		
		
	}
		
	@AfterTest
	public void quit() throws InterruptedException
	{	
	Thread.sleep(2000);
	driver.quit();
	}
}