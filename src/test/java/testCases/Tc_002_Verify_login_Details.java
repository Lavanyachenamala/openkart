package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.My_account_page;
import testBase.BaseClass;

@Test(groups={"Master","Sanity","Regression"})
public class Tc_002_Verify_login_Details extends BaseClass 
{

public void Verify_Login() {
try {
	Homepage hp= new Homepage(driver);
	logger.info("clicking the account link ");
	hp.Click_accLNk();
	logger.info("clicking the login link ");
	hp.Click_login();
	logger.info("validing the user valid credentials ");
	
	LoginPage lp= new LoginPage(driver);
	
	lp.Enter_emaild(p.getProperty("email"));
	lp.Enter_password(p.getProperty("pwd"));
	lp.Click_login_btn();
	
	My_account_page ap= new My_account_page(driver);
	boolean check=ap.isaccountdisplayed();
	if(check) {
		
		Assert.assertTrue(true);
	}else {
		
		Assert.assertTrue(false);
	}
	
	
}catch (Exception e) {
	
	logger.info("testfailed");
	logger.debug("debug logs" );
	
	Assert.fail();
	
}
logger.info("finished validating the test case ");	
	
	
	
	
}

}
