package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class WorkflowHomePage {

	public WaitHelper waithelper;
	public WebDriver driver;
	public boolean flag=false;
	public WorkflowHomePage workflowhomep;
	public WorkflowHomePage(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waithelper=new WaitHelper(driver);
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle user']//span[@class='caret']") 
	WebElement toggle_User_Dropdown;
	@FindBy(xpath="//a[normalize-space()='Logout']") 
	WebElement btn_Logout;
	public void clickOnLogoutLink()
	{
		toggle_User_Dropdown.click();
		btn_Logout.click();
	}
	public boolean homePageTitle()
	{
		String actualhomePageTitle=driver.getTitle();
		String expectedhomePageTitle="AuditGenius";
		if (actualhomePageTitle==expectedhomePageTitle)
		{
			flag=true;
		}
		
		return flag;
	}
}
