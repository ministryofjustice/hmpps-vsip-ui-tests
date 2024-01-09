package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;


@ComponentWithWebDriver
public class SelectVisitorsPage extends BasePage {

    public void selectVisitorErrorDisplayed() {
        methodsService.isElementDisplayed("xpath", "//a[text() = 'No visitors selected']");
    }


    public void chooseAPrisoner() {
        methodsService.click("xpath", "(//input[@name='visitors'])[1]");
    }

    public void choosePrisoners() {
        methodsService.click("xpath", "//*[@id='visitor-4729778']");
    }

    public void chooseAnotherPrisoner() {
        methodsService.click("xpath", "//*[@id='visitor-4729692']");
    }

    public void chooseVisitorFromBristol() {
        methodsService.click("xpath", "//*[@id='visitor-4729777']");
    }

    public void choosePrisonerB() {
        methodsService.click("xpath", "//*[@id='visitor-4729791']");
    }

}