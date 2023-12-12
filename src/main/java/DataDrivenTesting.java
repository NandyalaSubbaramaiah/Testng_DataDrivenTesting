package main.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataDrivenTesting {

	WebDriver driver;
	
		
	@BeforeClass
	public void setUpDriver() {
		String projectpath=System.getProperty("user.dir");
		System.out.println("projectpath: "+projectpath);
		System.setProperty("webdriver.chome.driver", projectpath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 
	}
	@Test(dataProvider ="LoginData")
	public void LoginTest(String username,String password) {
		 driver.navigate().to("https://www.facebook.com/login/");
		
		WebElement txt_username=driver.findElement(By.xpath("//input[@name='email']"));
		txt_username.sendKeys(username);
		WebElement txt_password=driver.findElement(By.xpath("//input[@name='pass']"));
		txt_username.sendKeys(password);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
	}
	@DataProvider(name="LoginData")
	public String[][] getData(){
		String[][] logindta= {{"9704661656","Subbu466165689$"},{"9704661656","Subbu466165689#"}};
		return logindta;
		
	}
	
	@AfterClass
	public void teardown() {
		//driver.close();
	}
}
