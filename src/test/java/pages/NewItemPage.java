package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NewItemPage {

    public NewItemPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h3[@class = 'text-2xl font-bold text-left text-black' and text()='New Item']")
    public WebElement newItemsPageLabel;

    @FindBy(xpath = "//input[@class='font-base block w-full sm:text-sm border-gray-200 rounded-md text-black focus:ring-primary-400 focus:border-primary-400' and @type='text']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@type='tel' and @class='font-base block w-full sm:text-sm border-gray-200 rounded-md text-black focus:ring-primary-400 focus:border-primary-400 v-money3']")
    public WebElement priceInput;

    @FindBy(xpath = "//input[@type='text' and @class='w-full absolute inset-0 outline-none appearance-none box-border border-0 text-sm font-sans bg-white rounded-md pl-3.5']")
    public WebElement unitInput;

    @FindBy(xpath = "//textarea[@name='description' and @class='box-border w-full px-3 py-2 text-sm not-italic font-normal leading-snug text-left text-black placeholder-gray-400 bg-white border border-gray-200 border-solid rounded outline-none focus:ring-primary-400 focus:border-primary-400']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//button[@type='submit' and @class='inline-flex whitespace-nowrap items-center border font-medium focus:outline-none focus:ring-2 focus:ring-offset-2 px-4 py-2 text-sm leading-5 rounded-md border-transparent shadow-sm text-white bg-primary-600 hover:bg-primary-700 focus:ring-primary-500']")
    public WebElement saveItemButton;

    @FindBy(xpath = "//div[@class='p-4']")
    public WebElement flashMessage;
}
