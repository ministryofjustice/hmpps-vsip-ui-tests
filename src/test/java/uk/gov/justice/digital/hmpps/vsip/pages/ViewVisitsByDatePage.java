package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class ViewVisitsByDatePage extends BasePage {

    public void selectDatePicker() {
        methodsService.click("xpath", "//button[contains(@data-test, 'another-date-button')]");
    }

    public void enterDate(String date) {
        methodsService.enterValInTextField("xpath", date, "//*[@id='date']");
    }

    public void clickOnView() {
        methodsService.click("xpath", "//button[contains(@data-test, 'submit')]");
    }

    public void checkTabsDateChanged() {
        methodsService.isElementDisplayed("xpath", "//a[@href='/visits?selectedDate=2023-11-20&firstTabDate=2023-11-20']");
    }

    public void selectViewOption() {
//        methodsService.click("xpath", "//a[contains(text(), 'View')]");
        methodsService.click("xpath", "//a[contains(@data-test, 'view-visit-link')]");

    }

    public void checkTextOnVisit(String text) {
        methodsService.isElementDisplayed("xpath", "//h1[text()='Visit booking details']");
    }

    public void checkErrorMessage() {
        methodsService.isElementDisplayed("xpath", "//a[text() = 'Enter a valid date']");
    }

}
