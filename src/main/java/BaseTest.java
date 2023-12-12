package main.java;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {
public static WebDriver driver=null;
   
	@BeforeClass
	public void TestArry() {
		String projectpath=System.getProperty("user.dir");
		System.out.println("projectpath: "+projectpath);
		System.setProperty("webdriver.chome.driver", projectpath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		
	

}
	
	@BeforeMethod
	public void openMyBrowser() throws InterruptedException {
		   driver.navigate().to("https://www.facebook.com/login/");
		  Thread.sleep(3000);
	}
	@Parameters({"text"})
	@Test
	public void PassUSERPASSWORD() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("9704661656");
	    driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Subbu165689$");
	    System.out.println("user enter user and password");
	}
	@AfterClass
	public void ClickOnLoginButton() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@name='login']")).click();  
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
         System.out.println("user clickon login butttuon");
        
	
	}
	@AfterTest
	public void afterclass() {
		driver.quit();
	}
}