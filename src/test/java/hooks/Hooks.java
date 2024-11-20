package hooks;

import utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    @Before()//()Parameters can be changed according to different conditions. Ex: (order = 1), ("@smoke").
    public void beforeScenario(){
        Driver.getDriver().manage().window().maximize();
        System.out.println("Run before each scenario.");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After()
    public void afterScenario(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot , "image/png", scenario.getName());
        }
        Thread.sleep(3000);
        Driver.closeDriver();
    }

    @BeforeStep
    public void beforeStep(){

    }

    @AfterStep
    public void afterStep(){

    }

}
