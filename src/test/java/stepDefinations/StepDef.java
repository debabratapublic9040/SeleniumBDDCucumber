package stepDefinations;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.WorkflowHomePage;


public class StepDef extends BaseClass{

	public WebDriver driver;
	public LandingPage landingp;
	public LoginPage loginp;
	public WorkflowHomePage WorkflowHP;
	
	
	
	public Properties p;
	     
	    @Before
		public void setUp() throws IOException 
		{
	    
	    	FileReader file=new FileReader(".//config.properties");
		    p=new Properties();
		    p.load(file);
		    
		    logger=LogManager.getLogger(this.getClass());
		    
		    logger.info("****Open Browser****");
		   
		    String br=p.getProperty("browser");
		    
	    		switch(br.toLowerCase())
				{
				case "chrome" : driver=new ChromeDriver();break;
				case "edge" : driver=new EdgeDriver();break;
				case "firefox" : driver=new FirefoxDriver();break;
				default: System.out.println("Invalid Browser");return;
				}

	    		driver.manage().deleteAllCookies();
	    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    		driver.manage().window().maximize();
	
	
		}

	@Given("user lunch chrome browser")
	public void user_lunch_chrome_browser() {
		//WebDriverManager.chromedriver().setup();
		
		landingp=new LandingPage(driver);
	}

	@When("user lunch url {string}")
	public void user_lunch_url(String url) {
		logger.info("*****Open URL*****");
		 driver.get(url);
	}

	@Then("validate landing page logo")
	public void validate_landing_page_logo() {
	
		try {
			logger.info("*****Validate logo*****");
			Assert.assertEquals(true, landingp.logoStatus());
		}
		catch(Exception e)
		{
			logger.info("*****Logo Validation Failed*****");
			Assert.fail();
		}
	}
	@When("click on login link")
	public void click_on_login_link() {
		logger.info("*****Click on login Link*****");
		landingp.clickOnLoginLink();
	}
	
	
	@Then("login page should be displayed")
	public void login_page_should_be_displayed() {
		loginp=new LoginPage(driver);
     try {
    	 logger.info("*****Login Page Displayed*****");
			Assert.assertEquals(true, loginp.login_page_hint());
		}
		catch(Exception e)
		{
			logger.info("*****Login Page Not Displayed*****");
			Assert.fail();
		}
	}

	@When("user enter username as {string}")
	public void user_enter_username_as(String username) {
		logger.info("*****Enter UserName*****");
		loginp.enterDataInUserNameField(username);
	}

	@When("user enter password as {string}")
	public void user_enter_password_as(String password) {
		logger.info("*****Enter Password*****");
		loginp.enterDataInPasswordField(password);
	}

	@When("user click on login button")
	
	public void user_click_on_login_button() {
		logger.info("*****Clicked on Login Button*****");
		try {
		loginp.clickOnLoginBTN();
		Thread.sleep(2000);
	    }
	
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	@And("logged out from application")
	public void logged_out_from_application() {
		WorkflowHP= new WorkflowHomePage(driver);
		logger.info("*****Clicked on logout Button*****");
		WorkflowHP.clickOnLogoutLink();
	}
	
	@And("close the browser")
	public void close_the_browser() {
		logger.info("*****Close Browser*****");
		driver.quit();
	}


}
