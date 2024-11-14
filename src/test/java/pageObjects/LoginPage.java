package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class LoginPage {

public WebDriver driver;
public WaitHelper waithelper;
	
public boolean loginPageHints;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waithelper=new WaitHelper(driver);
	}
	
	@FindBy(xpath="//input[@id='UserName']") 
	WebElement txt_UserName;
	@FindBy(xpath="//input[@id='txtPwd']") 
	WebElement txt_Password;
	@FindBy(xpath="//input[@value='Log in']") 
	WebElement btn_Login;
	@FindBy(xpath="//p[text()='Use a local account to log in.']") 
	WebElement login_hint;
	
	
	public void enterDataInUserNameField(String userName)
	{
		txt_UserName.clear();
		txt_UserName.sendKeys(userName);
	}
	public void enterDataInPasswordField(String password)
	{
		txt_Password.sendKeys(password);
	}
	
	public void clickOnLoginBTN()
	{
		
		//waithelper.waitForElement(btn_Login,10);
		btn_Login.click();
	}
	
	
	public boolean login_page_hint()
	{
		loginPageHints=login_hint.isDisplayed();
		return loginPageHints;
	}
	
}
