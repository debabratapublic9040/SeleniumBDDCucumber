package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class LandingPage {

public WebDriver driver;
public boolean flag;
public boolean logoAvailable;
public WaitHelper waithelper;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waithelper=new WaitHelper(driver);
	}
	
	@FindBy(xpath="//a[@href='#loginModal']") 
	WebElement link_login;
	@FindBy(xpath="//img [@src='/AuditGenius_External_UAT/Assets/Img/Audit-Genius-Logo_whiteletters.png']") 
	WebElement logo;
	
	public void clickOnLoginLink()
	{
		link_login.click();
	}
	public boolean getLandingPageTitle()
	{
		 flag=false;
		String landingPageTitle=driver.getTitle();
		String actuallandingPageTitle="AuditGenius - Landing Page";
		
		if (landingPageTitle==actuallandingPageTitle)
		{
			flag=true;
		}
		return flag;
	}
	public boolean logoStatus()
	{
		logoAvailable=logo.isDisplayed();
		return logoAvailable;
	}
}
