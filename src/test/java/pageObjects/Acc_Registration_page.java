package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Acc_Registration_page extends Basepage {

	
	public Acc_Registration_page(WebDriver driver) {
		
		super(driver);
	}
	
	
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailid;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement phonenum;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confmpassword;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement policy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement reg_btn;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confrmation_msg;
	
	
	public void enter_firstname(String fname) {
		
		firstname.sendKeys(fname);
		
	}
	public void enter_lastname(String lname) {
		
		lastname.sendKeys(lname);
	}
	public void enter_emaild(String email) {
		emailid.sendKeys(email);
	}
	public void enter_phonenum(String phnum) {
		phonenum.sendKeys(phnum);
	}
	
	public void enter_password(String pwd) {
		
		password.sendKeys(pwd);
	}
		public void reenter_password(String pwd) {
			
			confmpassword.sendKeys(pwd);	
			
	}
		public void chck_policy() {
			
			policy.click();
		}
	public void click_regbutton() {
		
		reg_btn.click();
	}
public String getConfirmationMsg() {
	try {
		
		return (confrmation_msg.getText());
		
	} catch (Exception e) {
		
		return(e.getMessage());
		
			}
	
	
		
}	
}
