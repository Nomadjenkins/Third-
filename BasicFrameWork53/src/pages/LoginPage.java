package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;

	public void Openbrowser() throws IOException {
		FileInputStream f = new FileInputStream("E:\\eclipse\\testng\\properties.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser=  prop.getProperty("browser"); // this value will be read from data file
		 
		
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\\\eclipse\\\\Selenium JAR\\\\geckodriver.exe");
			 driver= new FirefoxDriver();
			 
		}
		else if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\\\eclipse\\\\Selenium JAR\\\\chromedriver.exe");
			 driver= new ChromeDriver();
			
		}
		else 
		{
			System.setProperty("webdriver.ie.driver", "E:\\\\eclipse\\\\Selenium JAR\\\\iedriver.exe");
			 driver= new InternetExplorerDriver();
		}
		
		}
	public void OpenScotiabank()  {
		
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=ztYIxg_s0cQ&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJvYXV0aF9rZXkiOiJ6dFlJeGdfczBjUSIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNjI0MTE5NTI5LCJpYXQiOjE2MjQxMTgzMjksImp0aSI6IjNjOGFmZWU3LTJhNGQtNDI2OS04YTU3LTdjNjkzNGE3OWQ1MSIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.x1MMSXUrNFMdqT3mTG4q62nxtAG2b1sK7ULozJjgW6RQh-JuXfqnGS2HR-MkVgdrFtx73dpTLsJyGSNJtAFECTyeehKR49cp333dPKQ7-McYkKM3Ds9pvDxdB9ZXJjo9DDnSGSXEl5gRMAoJwecegPVwj26mYrUTy2bhtIo8RttL-UEGFi6TPDs7vZ3u1a_YN0nMcUrKR4HzA295RUIBT4K9Q7o9vo_0Bckgalb3FwdDJc0OxbvcDVargNUVDf-NwnA_44PsPjiNW0q98g97MlIFf2G1gOKJtPeqFe0wrmEmLdVDW0JEsFdAy3ZNHudOObeu05XeWd127bdR11Y3UQ&preferred_environment=");
		
			WebDriverWait wait = new WebDriverWait(driver, 20);
	}
	public void Closebrowser() {
		driver.close();
	}
	public String Globalerror() {
		String actualErr= driver.findElement(By.id("globalError")).getText();
		System.out.println(actualErr);
		return actualErr;
	}
	public String Error() {
		String actualErr= driver.findElement(By.className("Error__text")).getText();
		System.out.println(actualErr);
		return actualErr;
	}
	public void Login(String a, String b) throws InterruptedException {
		driver.findElement(By.id("usernameInput-input")).sendKeys(a);
		driver.findElement(By.name("password")).sendKeys(b);
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(2000);
	}
	
}
