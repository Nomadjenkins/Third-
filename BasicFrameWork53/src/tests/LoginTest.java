package tests;

	

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import utilities.Xls_Reader;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	
	public static WebDriver driver;
	LoginPage lp=new LoginPage();
	DataFile df= new DataFile();
	
	
	
  @Test
  public void LoginTestWithWrongEMailPAssword() throws InterruptedException {
	  	lp.Login(df.incorrectemail, df.incorrectpassword);
		Assert.assertEquals(lp.Globalerror(), df.globalError);
		}
  @Test
  public void LoginwithInvalidEmailTest() throws InterruptedException {
  			lp.Login(df.invalidEmail, df.incorrectpassword);
  			Assert.assertEquals(lp.Error(), df.invalidEmailerr);
  			}
  		
  @Test
  public void LoginwithEmptyEmailTest() throws InterruptedException {
			lp.Login("", df.incorrectpassword);
  			Assert.assertEquals(lp.Error(),df.emptyemailerr);
  	}
  		
  @Test
  	public void LoginwithEmptypasswordTest() throws InterruptedException {
  		lp.Login(df.incorrectemail, "");
  			Assert.assertEquals(lp.Error(), df.emptypasswrderr);
  	}
  
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  	lp.Openbrowser();
		lp.OpenScotiabank();
  }

  @AfterMethod
  public void afterMethod() {
	  	lp.Closebrowser();
  }

}
