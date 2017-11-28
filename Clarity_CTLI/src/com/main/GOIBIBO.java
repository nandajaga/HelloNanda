package com.main;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GOIBIBO {

	                public static void main(String[] args) throws InterruptedException {
	                                // TODO Auto-generated method stub
	                                
	WebDriver driver;
	        
	        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.15.0-win64\\geckodriver.exe");
	        
	        driver =new FirefoxDriver();
	        
	        driver.get("https://www.goibibo.com/");
	        driver.findElement(By.id("get_sign_in")).click();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	       
//	        String myWindowHandle = driver.getWindowHandle();
//	        driver.switchTo().window(myWindowHandle);
//	        System.out.println("switched window");
//	        driver.switchTo().frame("authiframe");
//	        System.out.println("switched frame");
//	        
//	        driver.findElement(By.id("authMobile")).sendKeys("9999999");
//	        System.out.println("clicked");
	        Set<String>allWindows=driver.getWindowHandles();
			System.out.println(allWindows.size());
			Iterator<String>i=allWindows.iterator();
			
			String mainWindow=i.next();
			String secondWindow=i.next();
			String title1=driver.getTitle();
			System.out.println(title1);
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
	        
	        System.out.println("clicked log in");
	                }

	}

