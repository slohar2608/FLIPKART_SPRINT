package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"./scr/test/java/features/"},
		glue= {"stepDefinations"},
		dryRun=false,
		monochrome=true
		)
public class CucumberRunner extends AbstractTestNGCucumberTests{
	
}
