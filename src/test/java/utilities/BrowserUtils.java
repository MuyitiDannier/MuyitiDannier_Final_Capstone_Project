package utilities;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {
    public static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }
}
