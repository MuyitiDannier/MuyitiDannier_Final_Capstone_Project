package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//Telling Junit to run the TestRunner Class as a cucumber test.
@CucumberOptions(features = "src/test/resources/features",
                glue = {"stepdefinitions", "hooks"},//For Hooks, just need to provide the package name for the path.
                plugin = {"pretty" , "html:target/final_capstone-report.html",
                "json:target/final_capstone-report.json",//used by jenkins to generate report.
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"},
                tags ="@Crater and @Regression"//"@Crater and @smoke" will specify more to the test scenario.
                //monochrome = true
)

public class TestRunner {
    //This class will allow us to execute and run our feature files/step definitions.
}
