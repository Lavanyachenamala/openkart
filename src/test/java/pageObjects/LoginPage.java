package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends Basepage {
	
	public LoginPage(WebDriver driver) 
	   {
		super(driver);
		}
  @FindBy(xpath = "//input[@id='input-email']")
  WebElement emailID;
  
  @FindBy(xpath = "//input[@id='input-password']")
  WebElement password;
  
  @FindBy(xpath = "//input[@type='submit']")
  WebElement login_btn;
  
  @FindBy(xpath="//span[normalize-space()='My Account']")
  WebElement myaccount;
 
  
  

  
	public void Enter_emaild(String email) 
	{
		emailID.sendKeys(email);
	}
	public void Enter_password(String pwd)
	{
		
		password.sendKeys(pwd);
	}
	
	public void Click_login_btn()
	{
	
		login_btn.click();
		
		}
	
	
	}	
		
		
		
	
	
	
	
