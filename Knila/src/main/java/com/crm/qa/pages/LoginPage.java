package com.crm.qa.pages;

import static org.testng.Assert.fail;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;
import javax.swing.plaf.basic.BasicTextUI.BasicHighlighter;
import javax.swing.text.Highlighter.Highlight;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.w3c.dom.html.HTMLIsIndexElement;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.JSExecutor;

public class LoginPage extends TestBase {

	JSExecutor js=new JSExecutor();
	
	
	
	@FindBy(xpath = "//button[text()=' Login ']")WebElement logInButton;
	@FindBy(name = "userName")WebElement username;
	@FindBy(name = "password")WebElement password;
	@FindBy(xpath = "//span[text()='Upload ']")WebElement UploadButton;
	@FindBy(xpath = "//a[text()=' Subscriber Import ']")WebElement Import;
	@FindBy(xpath = "//button[text()=' Download CSV ']")WebElement DownloadCSVbutton;
	@FindBy(xpath = "//input[@name='myFile']")WebElement CSVBrowse;
	@FindBy(xpath = "//span[@style='color: Red;']")WebElement DOBErrorMSG;
	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/div/div/div/div/app-bulk/div/div[2]/app-card/div/div[2]/div/div[3]/form/table/tbody/tr[1]/td[6]/div/input")WebElement DOB1 ;
	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/div/div/div/div/app-bulk/div/div[2]/app-card/div/div[2]/div/div[3]/form/table/tbody/tr[2]/td[6]/div/input")WebElement DOB2 ;
	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/div/div/div/div/app-bulk/div/div[2]/app-card/div/div[2]/div/div[3]/form/table/tbody/tr[3]/td[6]/div/input")WebElement DOB3 ;
	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/div/div/div/div/app-bulk/div/div[2]/app-card/div/div[2]/div/div[3]/form/table/tbody/tr[4]/td[6]/div/input")WebElement DOB4 ;
	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/div/div/div/div/app-bulk/div/div[2]/app-card/div/div[2]/div/div[3]/form/table/tbody/tr[5]/td[6]/div/input")WebElement DOB5 ;
	@FindBy(xpath = "//button[text()=' Save ']")WebElement Savebutton;
	@FindBy(xpath = "//span[text()='Subscriber ']")WebElement Subscriber;
	@FindBy(xpath = "//a[text()=' Subscriber List ']")WebElement SubscriberList;
	@FindBy(xpath = "//span[@class='input-group-text']")WebElement FromDate;
	@FindBy(xpath = "/html/body/app-root/app-admin/div/div/div/div/div/div/app-subscriberlist/div/div/app-card/div/div[2]/div/div/form/div/div[2]/div/div/div")WebElement Todate;
//	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]")WebElement CreatedDate;
//	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[4]")WebElement Fullname;
//	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[6]")WebElement Mobno;
	@FindBy(xpath = "//div[@class='dataTables_wrapper no-footer']")WebElement Webtable;
	@FindBy(xpath = "//td[text()=' Keer125 ']")WebElement Fullname;
	
	
	
	
	
		
	
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String gettitle(){
		return driver.getTitle();
	}
	public HomePage login(String un,String pwd) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		//logInButton.click();
		username.sendKeys(un);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		password.sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		js.clickElement(logInButton, driver);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		UploadButton.click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Import.click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		js.clickElement(DownloadCSVbutton, driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		CSVBrowse.sendKeys("C:\\Users\\FS-23\\Downloads\\Actio_Bulk.csv");

		
		  if(DOBErrorMSG.isDisplayed())
		  {
		      System.out.println("DOB format is DD/MM/YYYY should be entered");
		      driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		      DOB1.clear();
		      DOB1.sendKeys("23/07/1995");
		      driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		      DOB2.clear();
		      DOB2.sendKeys("12/10/1992");
		      driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		      DOB3.clear();
		      DOB3.sendKeys("10/05/1985");
		      driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		      DOB4.clear();
		      DOB4.sendKeys("08/08/1996");
		      driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		      DOB5.clear();
		      DOB5.sendKeys("09/11/1995");
		      Savebutton.click();
		      System.out.println("Bulk Subscriber Upload\n"
		      		+ "Success! CSV Uploaded..");
		      
		      
		      
		  }
		  else
		  {
			  Savebutton.click();
		      System.out.println("Save button is clicked");
		  } 
		  
		  
		  driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	      Subscriber.click();
	      driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	      SubscriberList.click();
	      
//	      Thread.sleep(200);
//	      SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
//	      SimpleDateFormat ft = new SimpleDateFormat("dd/mm/yyyy");
//	      Date date = new Date(0, 0, 0);
//	      System.out.println(formatter.format(date));
//	      System.out.println(ft.format(date));
//	      String CurrentDate = formatter.format(date);
//	      String Curdate = ft.format(date);
//	      String[]dates = CurrentDate.split("/");
//	      String day = dates[0];
//	      System.out.println(day);
//	      String month = dates[0];
//	      System.out.println(month);
//	      String year = dates[0];
//	      System.out.println(year);
	      
	      DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
	      java.util.Date today = Calendar.getInstance().getTime();
	      String date = dateFormat.format(today);
	      System.out.println(date);
	      String[]dates = date.split("/");
	      String day = dates[0];
	      System.out.println(day);
	      String month = dates[1];
	      System.out.println(month);
	      String year = dates[2];
	      System.out.println(year);
	      driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
	      FromDate.click();
	      Select selectYear = new Select (driver.findElement(By.xpath("//select[@title='Select year']")));
	      Select selectMonth = new Select (driver.findElement(By.xpath("//select[@title='Select month']")));
	      selectYear.selectByValue(year);
//	      selectMonth.selectByVisibleText(month);
	      String dayXpath="//div[@tabindex='0']/div[text() ="+day+"]";
	      driver.findElement(By.xpath(dayXpath)).click();
	      driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	      Todate.click();
	      Select selectYear1 = new Select (driver.findElement(By.xpath("//select[@title='Select year']")));
	      Select selectMonth1 = new Select (driver.findElement(By.xpath("//select[@title='Select month']")));
	      selectYear1.selectByValue(year);
//	      selectMonth.selectByVisibleText(month);
	      String dayXpath1="//div[@tabindex='0']/div[text() ="+day+"]";
	      driver.findElement(By.xpath(dayXpath1)).click();
	      
	      
	      
	      if(Webtable.isDisplayed())   {
	    	  
	    	String Fname = Fullname.getText();
	    	 
	    	 Assert.assertEquals(Fname, "Keer125" );
	    	  
	    }
	      
	      else {
	    	  
	    	  System.out.println("Webtable is notdisplayed");
	    	  
	      }
		
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	    
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      return null;
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	
	     
	    
	      
	      
	     
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
		
		
		
	      
	      
	      
	      
			
		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}




	

	
}