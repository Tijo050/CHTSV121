package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass {

	
	@Test(groups= {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("############starting Login ##########");
		try{
			
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickLogin();
		logger.info("Clicked on Login link");
		
		//Loginpage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage= macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true,"Login failed");
	}
	
	catch(Exception e)
	{
		Assert.fail();
		logger.info("############Finished TC002  Login ##########");
	}
}
}