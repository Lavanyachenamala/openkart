package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver) {
	
	super(driver);
	}
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement Accountlnk;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement reglink;
	@FindBy(linkText="Login")
	WebElement login_lnk;
	
	public void Click_accLNk() {
		
		Accountlnk.click();
		
	}

	public void click_register() {
		
		reglink.click();
	}
	
	public void Click_login() {
		
		login_lnk.click();
		
		
	}
	 
}
	

	
	
	
	
	
	
	
	
