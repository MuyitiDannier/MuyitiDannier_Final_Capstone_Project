package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

public LoginPage(){//This is the Constructor of the class
    PageFactory.initElements(Driver.getDriver(), this);
}
    //Elements:
    @FindBy(xpath = "//input[@name='email' and @class='font-base block w-full sm:text-sm border-gray-200 rounded-md text-black focus:ring-primary-400 focus:border-primary-400']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login' and @type='submit']")
    public WebElement loginButton;
}
