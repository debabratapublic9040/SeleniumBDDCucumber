package TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features=".//Features/",//to run all feature files
		features=".//Features/landingpage.feature",//to run particular feature file
		//features=".//Features/loginDDT.feature",//to run particular feature file
		//features=".//Features/login.feature",
		//features={".//Features/login.feature",".//Features/landingpage.feature"},//to run multiple specific feature files
		glue="stepDefinations",
		dryRun=false,
		monochrome=true,
		//tags="@sanity and @smoke",
		plugin= {"pretty","html:test-ouput"}
		
		
		)
public class Run {
//This class should be empty
}
