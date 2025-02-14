package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Acc_Registration_page;
import pageObjects.Homepage;
import testBase.BaseClass;

public class Tc_001_Accout_registartion extends BaseClass{


@Test(groups={"Master","Regression"})
public void verify_account() 
{
	logger.info("***Starting the Tc_001_Accout_registartion***");
	try {
    Homepage hp= new Homepage(driver);

    logger.info("***clicked on the account link***");
    hp.Click_accLNk();

     logger.info("***clicked on  the register link***");
    hp.click_register();

    logger.info("***providing all necessary details***");
    Acc_Registration_page regpage= new Acc_Registration_page(driver);

 regpage.enter_firstname(randomestring());
 regpage.enter_lastname(randomestring());
 regpage.enter_emaild(randomestring()+"@gmail.com");
 regpage.enter_phonenum(randomeNum());
 
 String alphanumeric=randomealphaNum();
 regpage.enter_password(alphanumeric);
 regpage.reenter_password(alphanumeric);
 
 regpage.chck_policy();
 regpage.click_regbutton();
 
 
logger.info("***validating the account**");
String verify_msg=regpage.getConfirmationMsg();
if(verify_msg.equals("Your Account Has Been Created!")) {
	Assert.assertTrue(true);
}else {
	logger.info("Test failed");
	logger.debug("debug logs");
	Assert.assertTrue(false);
		
	}
	

//Assert.assertEquals(verify_msg, "Your Account Has Been Created!");
	}catch (Exception e) {
		
		Assert.fail();
		
	}
	logger.info("test case execution finished succesffully");
}

}
