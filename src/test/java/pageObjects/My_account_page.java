package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_account_page extends Basepage {

	
	public My_account_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath=("//h2[normalize-space()='My Account']"))
	WebElement account_txt;
	 @FindBy(xpath=("//a[@class='list-group-item'][normalize-space()='Logout']"))
	  WebElement logout;
	

		public void click_logout() {
			
			logout.click();
			
		}
	
	public boolean isaccountdisplayed() {
		
		try {
		return(account_txt.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
		
		
			
	}
	}
	
	
	
	
