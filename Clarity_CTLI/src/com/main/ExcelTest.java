package com.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest {

	@DataProvider //Using TestNg instead of main()
	  public Object[][] DataWindChillInCelsius() throws Exception{
		  
		  Object[][] retObjArr= com.parameterization.Excel.getTableArray("src/dataprovider/DataTemp.xls", "Sheet1", "DataWindChillInCelsius");
	   
		  return(retObjArr); 
	      
	    
	  };
	@Test(dataProvider = "DataWindChillInCelsius") 
	 public void DataWindChillInCelsius(String temp, String wind){
		
		String exePath = "src\\com\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",exePath);
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://claritycloudprod:8443/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("ppm_login_username")).sendKeys(temp);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("ppm_login_password")).sendKeys(wind);
		driver.findElement(By.id("ppm_login_button")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Logged into Clarity successfully");
		
		//mouse hover on home
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ppm_nav_app']")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(".//*[@id='ppm_nav_app']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        System.out.println("mouse hover done");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //click on Projects
        //driver.findElement(By.linkText("Projects")).click();
        //action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//a[@title='Projects' and @href='#action:mainnav.work&classCode=project']"))).click();
        driver.findElement(By.xpath("//a[@title='Projects' and @href='#action:mainnav.work&classCode=project']")).click();
        //Thread.sleep(5000);
        System.out.println("Clicked on projects");
       // Thread.sleep(5000);
        
        //click on Build Power filter
        driver.findElement(By.xpath(".//*[@id='filter-content-projmgr.projectList_odf-powerFilterLabel']")).click();
       // Thread.sleep(3000);
        System.out.println("click on Build Power filter");
        
        //object = Project ->      
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("objSelect")));       
        Select oSelect = new Select(driver.findElement(By.name("objSelect")));        
        oSelect.selectByVisibleText("Project");
        
        //Field = Approved Status -> 
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("attrSelect")));
        Select oSelect1 = new Select(driver.findElement(By.name("attrSelect")));
        oSelect1.selectByVisibleText("Approved Status");
        System.out.println("selected Approved status");
        
        //Constant = Yes - > 
       // Thread.sleep(3000);
        Select oSelect2 = new Select(driver.findElement(By.name("constantNumValue")));
        oSelect2.selectByVisibleText("Yes");
        
        //Add ->
        //Thread.sleep(3000);
        driver.findElement(By.className("ppm_button")).click();
        System.out.println("successfully added");
        
        //And/Or = And - > 
        //Thread.sleep(3000);
        Select oSelect3 = new Select(driver.findElement(By.name("clause")));
        oSelect3.selectByVisibleText("and");
        
        //Field = Progress ->  
        //Thread.sleep(3000);
        Select oSelect4 = new Select(driver.findElement(By.name("attrSelect")));
        oSelect4.selectByVisibleText("Progress");
        System.out.println("Selected Progress");
        
       // Right = binocular icon - >
       // Thread.sleep(5000);
        driver.findElement(By.name("Browse")).click();
       // Thread.sleep(5000);
        
        //Started - >
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//td//input[@name='objectInstanceId' and @value='Started^=^1']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(5000);
        
        //Add 1 ->
        driver.findElement(By.xpath("//div//button//img[@title='Add']")).click();
        System.out.println("successfully added 1");
        //Thread.sleep(8000);
        
        //Add  2 ->
        driver.findElement(By.className("ppm_button")).click();
        System.out.println("successfully added 2");
       // Thread.sleep(9000);
        
        //Save and Return - > 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
        driver.findElement(By.xpath("//button[contains(text(),'Save And Return')]")).click();
        System.out.println("save and return : done");

        //click on little cog wheel setting icon in upper right corner ->
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//span//span//img[contains(@src,'ui/uitk/images/s.gif')]")).click();
        System.out.println("Clicked on settings");
        //Thread.sleep(5000);
        
       //Export to Excel (Data Only) link -> 
        
        driver.findElement(By.xpath("//span//span//a[contains(text(),'Export to Excel (Data Only)')]")).click();
        System.out.println("Clicked on Export to Excel (Data Only) "); 
       // driver.close();
		
	}
	}

