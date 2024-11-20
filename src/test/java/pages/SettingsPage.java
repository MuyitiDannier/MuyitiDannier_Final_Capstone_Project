package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    //Constructor for the page:
    public SettingsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Elements:
    @FindBy(xpath = "//h3[text()='Settings']")
    public WebElement settingsLabel;

    @FindBy(xpath = "//a[@href='/admin/items']")
    public WebElement itemsButton;

    @FindBy(xpath = "//a[@href='/admin/invoices']")
    public WebElement invoicesButton;
}
