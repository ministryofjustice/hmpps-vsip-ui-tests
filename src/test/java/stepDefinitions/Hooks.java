package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class Hooks implements WebDriverInstance {
    @Before
    public void initialise(){
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario result) {
        if (result.isFailed()) {
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot screenshot1 = (TakesScreenshot) driver;
                try {
                    byte[] screenshot = screenshot1.getScreenshotAs(OutputType.BYTES);
                    result.attach(screenshot, "image/png", "Screenshot");
                } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                    System.err.println(somePlatformsDontSupportScreenshots.getMessage());
                }
            }
        }
    }
}