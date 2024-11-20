package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ItemsPage;
import pages.NewItemPage;
import pages.SettingsPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Items_StepDef {

    WebDriver driver = Driver.getDriver();
    SettingsPage settingsPage = new SettingsPage();
    ItemsPage itemsPage = new ItemsPage();
    NewItemPage newItemPage = new NewItemPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("user clicks on Items menu link")
    public void user_clicks_on_items_menu_link() {
        settingsPage.itemsButton.click();
    }
    @Then("user should be navigated to the Items page")
    public void user_should_be_navigated_to_the_items_page() {
        wait.until(ExpectedConditions.visibilityOf(itemsPage.itemsPageLabel));
        String itemsPageUrl = "http://crater.primetech-apps.com/admin/items";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(itemsPageUrl, currentUrl);
        Assert.assertTrue(itemsPage.itemsPageLabel.isDisplayed());
    }
    @When("user clicks on + Add Item")
    public void user_clicks_on_add_item() {
        wait.until(ExpectedConditions.elementToBeClickable(itemsPage.addItemsButton));
        itemsPage.addItemsButton.click();
    }
    @Then("user should be navigated to New Item page")
    public void user_should_be_navigated_to_new_item_page() {
        wait.until(ExpectedConditions.visibilityOf(newItemPage.newItemsPageLabel));
        Assert.assertTrue(newItemPage.newItemsPageLabel.isDisplayed());
    }
    @When("user enters {string} into the Name field")
    public void user_enters_into_the_name_field(String name) {
        SeleniumUtils.sendkeysWithActionsClass(newItemPage.nameInput, name);
    }
    @And("user enters {string} into the Price field")
    public void user_enters_into_the_price_field(String price) {
        SeleniumUtils.sendkeysWithActionsClass(newItemPage.priceInput, price);
    }
    @And("user selects {string} within the Unit field")
    public void user_selects_within_the_unit_field(String unit) {
        SeleniumUtils.sendkeysWithActionsClass(newItemPage.unitInput, unit);
        newItemPage.unitInput.sendKeys(Keys.ENTER);
    }
    @And("user enters {string} into the Description field")
    public void user_enters_into_the_description_field(String description) {
        newItemPage.descriptionInput.sendKeys(description);
    }
    @When("user clicks on the Save Item button")
    public void user_clicks_on_the_save_item_button() {
        newItemPage.saveItemButton.click();
    }
    @Then("user should be able to see a flash message {string} with a close button to the right being displayed")
    public void user_should_be_able_to_see_a_flash_message_with_a_close_button_to_the_right_being_displayed(String string) {
        wait.until(ExpectedConditions.visibilityOf(newItemPage.flashMessage));
        System.out.println("The Message is: " +newItemPage.flashMessage.getText());
        Assert.assertTrue(newItemPage.flashMessage.isDisplayed());
    }
    @And("user should be able to verify the flash message disappears within {int} seconds or less")
    public void user_should_be_able_to_verify_the_flash_message_disappears_within_seconds_or_less(Integer int1) {
        boolean flashMessageIsDisappeared = wait.until(ExpectedConditions.invisibilityOf(newItemPage.flashMessage));
        Assert.assertTrue(flashMessageIsDisappeared);
    }
    @And("user should be navigated back to the Items page")
    public void user_should_be_navigated_back_to_the_items_page() {
        wait.until(ExpectedConditions.visibilityOf(itemsPage.itemsPageLabel));
        String itemsPageUrl = "http://crater.primetech-apps.com/admin/items";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(itemsPageUrl, currentUrl);
        Assert.assertTrue(itemsPage.itemsPageLabel.isDisplayed());
    }
    @And("user should be able to view new item being displayed within the Items table")
    public void user_should_be_able_to_view_new_item_being_displayed_within_the_items_table() {
        String itemName = "Dan's New Backpack";
        for(WebElement item : itemsPage.itemsList){
            System.out.println(item.getText());
        }
        Assert.assertTrue(SeleniumUtils.isItemInTable(itemsPage.itemsList, itemName));
    }
    @And("user should be able to see entered information within the Name, Unit, Price and Description application database")
    public void user_should_be_able_to_see_entered_information_within_the_name_unit_price_and_description_application_database() {
        String query = "SELECT i.name, i.description, i.price, u.name AS 'unit'\n" +
                "FROM items i\n" +
                "INNER JOIN units u \n" +
                "ON i.unit_id = u.id\n" +
                "WHERE i.name = \"Dan's New Backpack\" AND i.description =\"This backpack is from Dan's collections.\" AND i.price = \"4500\" AND u.name = \"Dollars\";";
        String dbUrl = "jdbc:mysql://stack-overflow.cfse9bqqndon.us-east-1.rds.amazonaws.com/CraterDBS";
        String userName = "craterdbuser";
        String password = "ptschool2023";

        String expectedName = "Dan's New Backpack";
        String expectedPrice = "4500";
        String expectedUnit = "Dollars";
        String expectedDescription = "This backpack is from Dan's collections.";

        //Creating a connection
        try (Connection connection = DriverManager.getConnection(dbUrl, userName, password);
             //Creating a statement
             Statement statement = connection.createStatement();
             //Executing the query
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                String actualName = resultSet.getString("name");
                String actualUnit = resultSet.getString("unit");
                String actualPrice = resultSet.getString("price");
                String actualDescription = resultSet.getString("description");

                Assert.assertEquals("Name mismatch", expectedName, actualName);
                Assert.assertEquals("Unit mismatch", expectedUnit, actualUnit);
                Assert.assertEquals("Price mismatch", expectedPrice, actualPrice);
                Assert.assertEquals("Description mismatch", expectedDescription, actualDescription);

            } else {
                Assert.fail("No matching record found in the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Database verification failed: " + e.getMessage());
        }
    }

}

