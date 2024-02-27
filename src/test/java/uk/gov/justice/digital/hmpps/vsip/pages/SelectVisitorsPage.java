package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;


@ComponentWithWebDriver
public class SelectVisitorsPage extends BasePage {

    public void selectVisitorErrorDisplayed() {
        methodsService.isElementDisplayed("xpath", "//a[text() = 'No visitors selected']");
    }

    public void chooseAPrisoner() { methodsService.click("xpath", "//*[@id='visitor-4729775']"); }

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

    public void choosePrisner() {
        methodsService.click("xpath","//*[@id='visitor-4729510']");
    }

    public void chooseVistor() { methodsService.click("xpath","//*[@id='visitor-4729699']");}

    public void chooseVisitorFromDrakeHall() { methodsService.click("xpath","//*[@id='visitor-4729692']");
    }
    public void chooseAVisitorFromBristol() { methodsService.click("xpath","//*[@id='visitor-4729699']");}

    public void chooseAVisitorFromDrakeHall() { methodsService.click("xpath","//*[@id='visitor-4729692']"); }

    public void checkMessage() { methodsService.isElementDisplayed("xpath","//span[text()='There are no          approved\n" +
            "visitors over 18 for this prisoner. A booking cannot be made at this time.']");}

    public void checkBannedStatus() {
        methodsService.isElementDisplayed("xpath","//span[text()='Banned']");
    }

    public void checkVisitorUnselectable() { methodsService.isElementDisabled("xpath","//*[@id='visitor-4729711']"); }

}