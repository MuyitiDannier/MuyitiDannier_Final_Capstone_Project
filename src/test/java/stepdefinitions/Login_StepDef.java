package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SettingsPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

public class Login_StepDef {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    SettingsPage settingsPage = new SettingsPage();

    @Given("user is navigated to Crater login page")
    public void user_is_navigated_to_crater_login_page() {
        driver.get(ConfigurationReader.getPropertyValue("craterUrl"));
    }
    @When("user enters {string} in the username field")
    public void user_enters_in_the_username_field(String email) {
        SeleniumUtils.sendkeysWithActionsClass(loginPage.emailInput,email);
    }
    @And("user enters {string} in the password field")
    public void user_enters_in_the_password_field(String password) {
        SeleniumUtils.sendkeysWithActionsClass(loginPage.passwordInput,password);
    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String loginUrl = "http://crater.primetech-apps.com/login";
        String afterLoginUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login in is : " + afterLoginUrl);
        Assert.assertNotEquals(loginUrl , afterLoginUrl);
    }
    @And("user should be able to see {string} page title is being displayed")
    public void user_should_be_able_to_see_page_title_is_being_displayed(String labelOfSettingsPage) {
        Assert.assertTrue(settingsPage.settingsLabel.isDisplayed());
        System.out.println("Settings Page Url is : " + driver.getCurrentUrl());
    }
}
