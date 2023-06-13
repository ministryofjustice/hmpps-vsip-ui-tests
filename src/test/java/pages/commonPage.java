package pages;

import org.openqa.selenium.By;
import utils.Configuration;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class commonPage extends commonMethods {

//    By continueBtnOnAllPages = By.id("submit");

    public void loginVSIPService() {
        navigateToPage(Configuration.getConfiguration(Configuration.Environment.valueOf(System.getProperty("environment"))));
    }

    public void deleteBrowserCookies() {
        driver.manage().deleteAllCookies();
    }

    public void clickOnContinueBtn() throws InterruptedException {
        clickOnButton("xpath","//*[@id='submit']");
    }

}