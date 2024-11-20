package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private static WebDriver driver;

    /**
     * This is a private constructor to force no object will be created.
     */
    private Driver(){

    }

    /**
     * This is the method to get the driver which will instantiate only once.
     * @return
     */
    public static WebDriver getDriver(){
        String browserType = ConfigurationReader.getPropertyValue("browserType");
        if(driver == null){
            switch (browserType.toLowerCase()){
                case "chrome" :
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "chrome-headless":
                    System.out.println("Running in headless mode in chrome");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    //chromeOptions.addArguments("--headless");// Regular way.
                    //chromeOptions.addArguments("--window-position=-2400,-2400");// Option1 to avoid white/blank screen pop up.
                    chromeOptions.addArguments("--headless=old");// Option2 to avoid white/blank screen pop up.
                    driver = new ChromeDriver(chromeOptions);//will create new instance of chromedriver in headless mode
                    break;
                case "firefox-headless":
                    System.out.println("Running in headless mode in firefox");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "sauce-labs":
                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setPlatformName("Windows 11");
                    browserOptions.setBrowserVersion("latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("username", "oauth-daniyarmuhid-27bd2");
                    sauceOptions.put("accessKey", "7b182443-5765-4ed9-b27a-062b0e43975e");
                    sauceOptions.put("build", "selenium-build-EHEMI");
                    sauceOptions.put("name", "PrimeTech Cucumber");
                    browserOptions.setCapability("sauce:options", sauceOptions);
                    //Start the session
                    URL url = null;
                    try{
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new RemoteWebDriver(url, browserOptions);
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
            }
        }
        return driver;
    }

    /**
     * This is the method to check if the driver is still alive, then quit and set driver to null value.
     */
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
