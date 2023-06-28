package stepDefinitions;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anusha Nagula on 15/05/23.
 */

public interface WebDriverInstance {
    WebDriver driver = Driver.GetWebDriver();
    WebDriverWait waitFor = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

}