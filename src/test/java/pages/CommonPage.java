package pages;

import utils.Configuration;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class CommonPage extends CommonMethods {

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
        click("xpath","//a[@href='/search/prisoner']");
    }

    public void clickOnChangeAVisitOption() {
        click("xpath","//a[@href='/search/visit']");
    }

    public void clickOnViewVisitsByDateOption(){
        click("xpath","//a[@href='/visits']");
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
//        click("xpath","//*[@id='visitor-4729775']");
        click("xpath","(//input[@name='visitors'])[1]");
    }

    public void choosePrisoners() {
        click("xpath","//*[@id='visitor-4729778']");
    }
    public void chooseAnotherPrisoner() {
        click("xpath","//*[@id='visitor-4729773']");
    }

    public void chooseVisitorFromBristol(){
        click("xpath","//*[@id='visitor-4729777']");
    }

    public void choosePrisonerB() {
        click("xpath","//*[@id='visitor-4729791']");

    }
    public void clickOnSignOut() {
        click("xpath","/html/body/header/div/nav/ul/li[2]/a");
    }
    public void errorMsgDisplayed(String errorMsg) {
        isElementDisplayed("xpath","//*[@id='error-detail']");
    }

    public void chooseBristol(){
        selectRadioButton("xpath","//*[@id='BLI']");
    }
    public void chooseNoBristol() {
        isElementNotVisible("xpath","//*[@id='BLI']");
    }

    public void changeEstablishment() {
        click("xpath","//a[contains(@data-test, 'change-establishment')]");
    }
}