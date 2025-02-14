package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.dataProvider;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.My_account_page;
import testBase.BaseClass;

public class Tc_003_data_driven_verify_login extends BaseClass{
	
	@Test(dataProvider="Logindata",dataProviderClass=dataProvider.class,groups="datadriven")
	public void verify_login_DDT(String email,String pwd,String exp) {
		
		try {
			logger.info("tc_003 started excuting ");
		Homepage hp= new Homepage(driver);
		logger.info("clicking the account link ");
		hp.Click_accLNk();
		logger.info("clicking the login link ");
		hp.Click_login();
		logger.info("validing the user valid credentials ");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.Enter_emaild(email);
		lp.Enter_password(pwd);
		lp.Click_login_btn();
		
		My_account_page ap= new My_account_page(driver);
		boolean check_accpage=ap.isaccountdisplayed();
		
		
		//data is valid--- login success--testpass
		                  // login failed---testfail
		//data is invalid--login success--testfail	
		                // --login failed--testpass 
		
		if(exp.equalsIgnoreCase("Valid")) {
			
		if(check_accpage==true) {
			
			
			Assert.assertTrue(true);
			
			ap.click_logout();
			
		}else {
				
			Assert.assertTrue(false);
			
		}		
		}
		
		if(exp.equalsIgnoreCase("InValid")) 
		{
			
			if(check_accpage==true) {
		    ap.click_logout();
			Assert.assertTrue(false);	
			}
			else {
		    Assert.assertTrue(true);
				
			}	
			
	        }
		
	    }catch (Exception e) {
	     Assert.fail();
		}
		logger.info("tc_003 succesfully finished");
}}
