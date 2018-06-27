package Selenium.Dimpu;

import org.testng.annotations.Test;

import pages.LoginPageObject;
import utility.Excelutility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class BookTicketTest {
  
	private WebDriver driver;
  @Test(priority=1, dataProvider="logindata")
  public void f(String username, String password) {
	  LoginPageObject.uname.sendKeys(username);
	  LoginPageObject.password.sendKeys(password);
	  LoginPageObject.Login_button.click();
	  //WebDriverWait wait=new WebDriverWait(driver, 50);
	  
	  //Assert.assertEquals(actual, expected);
	  driver.navigate().back();
	  
  }
  @DataProvider(name="logindata")
  public String[][] login_data()throws IOException{
	 Excelutility.setExcelPath("test","C:\\Users\\A06438_P5.Training\\Desktop\test.xlsx");
	 /* String username=Excelutility.getCellData(1, 1);
	  String password=Excelutility.getCellData(1, 2);*/
	  String[][] exceldata=Excelutility.getExcelTable();
	  return exceldata;
	  
	  /*retrun new String[][] {
		  new String[] {username,password}*/
	  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","C:\\DIMPU\\Selenium Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	 driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
	PageFactory.initElements(driver, LoginPageObject.class);
  }

  @AfterTest
  public void afterTest() {
  }

}
