package SEF_Compassion;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class new_user 

{	WebDriver driver;
	
	By globalpool 		= By.xpath("//body/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/input[@name='child-pool']");
//	By search_button 	= By.id("global-search");
	By appl_code 		= By.xpath("//div[1]/div[1]/div[3]/div[1]/input[@id='barcode']");
	By sponsor_source	= By.xpath("//body/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]");
	By supporter_type	= By.xpath("//body/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[@class='ui dropdown selection']");
	By title			= By.xpath("//body/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[3]/div[1]//div[@class='ui dropdown selection title']");
	By firstname		= By.xpath("//body/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[3]/div[2]/div[1]//input[@type='text']");
	By lastname			= By.xpath("//body/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[3]/div[3]/div[1]//input[@id='surname0']");
	By email			= By.xpath("//body/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[8]/div[1]/div[1]//input[@id='emailid0']");
	By supporter_group  = By.xpath("//div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[@class='ui dropdown selection']");
	By DDI_source 		= By.xpath("//div[7]/div[2]/div[2]/div[2]/div[1]/div[@class='ui dropdown selection']");
	By acc_name			= By.xpath("//div[7]/div[2]/div[3]/div[1]/div[1]/input[@id='accountname']");
	By acc_no			= By.xpath("//div[7]/div[2]/div[3]/div[2]/div[1]/input[@id='accountnumber']");
	By sort_code 		= By.xpath("//div[7]/div[2]/div[3]/div[3]/div[1]/input[@id='sortcode']");
	By validate_acc		= By.xpath("//div[5]/div[1]/button[@id='validateBankAccount']");
	By validate_msg		= By.className("ui positive message");
	
	
	@Test
	public void test() throws InterruptedException
	{
		driver.findElement(globalpool).click();
		Thread.sleep(1000);
		
//		driver.findElement(search_button).click();
//		Thread.sleep(2000);
		
		driver.findElement(appl_code).sendKeys("1150");
		
	
		driver.findElement(sponsor_source).click();
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements (By.xpath("//div[@class='menu transition visible']//div"));
		System.out.println(list.size());
		list.get(1).click();
		String value = list.get(1).getText();
		System.out.println(value);
		Thread.sleep(2000);
		
	
		driver.findElement(supporter_type).click();
		Thread.sleep(1000);
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='menu transition visible']//div"));
		System.out.println(list1.size());
		list1.get(0).click();
		String value1 = list1.get(0).getText();
		System.out.println(value1);
		Thread.sleep(2000);
		
		
		driver.findElement(title).click();
		Thread.sleep(1000);
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='menu transition visible']//div"));
		System.out.println(list2.size());
		list2.get(1).click();
		String value2 = list2.get(1).getText();
		System.out.println(value2);
		Thread.sleep(2000);
		
		driver.findElement(firstname).sendKeys("Peter");
		driver.findElement(lastname).sendKeys("Jenkins");
		Thread.sleep(1000);
		driver.findElement(email).sendKeys("peterjenkins123@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(supporter_group).click();
		Thread.sleep(1000);
		List<WebElement> list3 = driver.findElements(By.xpath("//div[@class='menu transition visible']//div"));
		System.out.println(list3.size());
		list3.get(0).click();
		String value3 = list3.get(0).getText();
		System.out.println(value3);
		Thread.sleep(2000);
		
		driver.findElement(DDI_source).click();
		Thread.sleep(1000);
		List<WebElement> list4 = driver.findElements(By.xpath("//div[@class='menu transition visible']//div"));
		System.out.println(list4.size());
		list4.get(0).click();
		String value4 = list4.get(0).getText();
		System.out.println(value4);
		Thread.sleep(2000);
		
		driver.findElement(acc_name).sendKeys("David");
		driver.findElement(acc_no).sendKeys("34661743");
		driver.findElement(sort_code).sendKeys("602003");
		driver.findElement(validate_acc).click();
		Thread.sleep(5000);
	
		WebElement wc = driver.findElement(validate_msg);
		String actual_msg 	= wc.getAttribute("class");
		String expected_msg	= "Bank Account Validated Successfully. ";
		Assert.assertEquals(actual_msg, expected_msg);
		
		if(!expected_msg.equals(actual_msg))
	 	{
 			System.out.println("Not matched msg");
	 	}
		else
	 	{
 			System.out.println("Matched msg");
	 	 }
	}
}




