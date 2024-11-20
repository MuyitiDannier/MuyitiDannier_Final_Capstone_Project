package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//Telling Junit to run the TestRunner Class as a cucumber test.
@CucumberOptions(features = "src/test/resources/features",
                glue = "stepdefinitions",
                plugin = {"pretty", "html:target/final_capstone-report.html",
                "json:target/final_capstone-report.json"},
                tags = "@Crater",
                dryRun = true //dryRun=true Drive Run is used to generate steps without running actual tests.
)

public class DryTestRunner {
    //This class will allow us to execute and run our feature files/step definitions.

}