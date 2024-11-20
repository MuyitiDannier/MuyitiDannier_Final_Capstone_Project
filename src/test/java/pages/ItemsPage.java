package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ItemsPage {

    public ItemsPage(){
      PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h3[@class='text-2xl font-bold text-left text-black' and text()='Items']")
    public WebElement itemsPageLabel;

    @FindBy(xpath = "//button[@class='inline-flex whitespace-nowrap items-center border font-medium focus:outline-none focus:ring-2 focus:ring-offset-2 px-4 py-2 text-sm leading-5 rounded-md border-transparent shadow-sm text-white bg-primary-600 hover:bg-primary-700 focus:ring-primary-500']")
    public WebElement addItemsButton;

    @FindBy(xpath = "//table[@class='min-w-full divide-y divide-gray-200']//a[contains(@href, '/admin/items/')]")
    public List<WebElement> itemsList;
}
