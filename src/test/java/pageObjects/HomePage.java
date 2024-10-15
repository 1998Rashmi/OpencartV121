package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath="//li//a[@title='My Account']") 
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//li//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login")//Login link added in step5
	WebElement linkLogin;
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}

	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
		
	}
}
