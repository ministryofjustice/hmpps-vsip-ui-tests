package pages;

import org.openqa.selenium.By;
import utils.Configuration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

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

    public void clickOnSubmitBtn() {
        clickOnButton("xpath","//*[@id='submit']");
    }

    public void clickOnBookAVisitOption() {
        click("xpath","//*[@id='main-content']/div/div/ul/li[1]/div/h2/a");
    }

    public void clickOnChangeAVisitOption() {
        click("xpath","//*[@id='main-content']/div/div/ul/li[2]/div/h2/a");
    }

    public void selectPrisoner() {
        click("xpath","//*[@id='search-results-true']/tbody/tr/td[1]/a");
    }

    public void clickOnBtn() {
        click("xpath", "//button[contains(@data-test, 'search')]");
    }

    public void clickOnContinueBtn() {
        click("xpath", "//button[contains(@data-test, 'submit')]");
    }

    public void clickOnCancelBtn() {
        click("xpath","//button[contains(@data-test, 'cancel-booking')]");
    }

    public void clickOnBookAVisitBtn() {
        click("xpath","//*[@id='main-content']/div[1]/div/form/button");
    }

    public void clickOnCancelAVisitBtn(){
        click("xpath","//a[contains(@data-test, 'cancel-visit')]");
    }

    public void clickOnManagePrisonOptn() {
        click("xpath","//a[contains(@class, 'hmpps-header__link hmpps-header__title__service-name')]");
    }

    public void chooseAPrisoner() {
        click("xpath","//input[@id='visitor-220914']");
    }
    public void chooseAnotherPrisoner() {
        click("xpath","//input[@id='visitor-3719071']");
    }
    public void clickOnSignOut() {
        click("xpath","/html/body/header/div/nav/ul/li[2]/a");
    }
    public void errorMsgDisplayed(String errorMsg) {
        isElementDisplayed("xpath","//*[@id='error-detail']");
    }

}