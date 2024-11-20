package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils {

    /**
     * This method will allow mouse/cursor to move to an element.
     * @param driver
     * @param elementToMoveTo
     */
    public static void moveToElement(WebDriver driver, WebElement elementToMoveTo){
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToMoveTo);
    }

    /**
     * This method will perform double click.
     * @param driver
     * @param elementToDoubleClick
     */
    public static void doubleClickElement(WebDriver driver, WebElement elementToDoubleClick){
        Actions actions = new Actions(driver);
        actions.doubleClick(elementToDoubleClick);
    }

    /**
     * This method will select an element by value from a dropdown.
     * @param element
     * @param valueToSelect
     */
    public static void selectByValueFromDropdown(WebElement element, String valueToSelect){
        Select select = new Select(element);
        select.selectByValue(valueToSelect);
    }

    /**
     * This method will move one element(source) to another element(target).
     * @param driver
     * @param source
     * @param target
     */
    public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    /**
     * This method will refresh a page.
     * @param driver
     */
    public static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }

    /**
     * This method will send keys to an element using Actions class
     * @param element the element that we want to send the keys to
     * @param input the string that we want to send
     */
    public static void sendkeysWithActionsClass(WebElement element, String input) {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(element, input).build().perform();
    }

    /**
     * This method will verify if an item is available within a table
     * @param elementList
     * @param itemNameToSearchFor
     * @return
     */
    public static boolean isItemInTable(List<WebElement> elementList, String itemNameToSearchFor){
        for(WebElement item : elementList){
            if(item.getText().equals(itemNameToSearchFor)){
                return true;
            }
        }
        return false;
    }
}
