package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.accountRegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	
	
	@Test(groups={"Regression" , "Master"})
	public void verify_account_registration()
	{
		logger.info("*** Starting TC001_AccountRegistrationTest ***");
		try
		{
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link ");
		hp.clickRegister();
		
		logger.info("Clicked on Register Link ");
		accountRegistrationPage regpage = new accountRegistrationPage(driver);
		
		/*reppage.setFirstName("RASHMI");
		reppage.setLastName("SAHOO");
		reppage.setEmail("rashmi@gmail.com");
		reppage.setTelephone("7894561234");
		
		String password="Linkan123";
		
		reppage.setPassword(password);
		reppage.setConfirmPassword(password);*/
		
		logger.info("Providing customer details ");

		
		regpage.setFirstName(randomeString());
		regpage.setLastName(randomeString());
		regpage.setEmail(randomeString()+"@gmail.com");//randomly generated email
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password); 
		  
		
		regpage.clickPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message.. ");

		
		String confmsg =regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		
		else
			
		{
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
	}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("*** Finshed TC001_AccountRegistrationTest ***");
	
	}
	
}
