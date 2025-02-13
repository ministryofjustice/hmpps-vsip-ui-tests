package uk.gov.justice.digital.hmpps.vsip.pages;

import org.junit.Assert;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class BookingDetailsPage extends BasePage {

    public void clickOnBookingHistory() {
        methodsService.clickOnButton("xpath", "//*[@id='tab_history']");
    }

    public void checkCancelMessageDisplayed(String cancelMsg) {
        methodsService.isElementDisplayed("xpath", "//span[text() = '" + cancelMsg + "']");
    }


    public void checkHistoryTabCancelRequestMethod(String text) {
        methodsService.isElementDisplayed("xpath", "//p[starts-with(@data-test,'visit-cancelled-request-method') and contains(.,'" + text + "')]");
    }

    public void checkHistoryTabCancelReasonMethod(String text) {
        methodsService.isElementDisplayed("xpath", "//p[starts-with(@data-test,'visit-cancelled-reason') and contains(.,'" + text + "')]");
    }

    public void checkHistoryTabBookRequestMethod(String text) {
        methodsService.isElementDisplayed("xpath", "//div[@class='moj-timeline__description' and text() = '" + text + "']");
    }


    public void checkMethodofBooking(String msg) {
        methodsService.isElementDisplayed("xpath", "//p[text() = 'Method: Phone booking']");
    }

    public void checkMethodofNewBooking(String msg) {
        methodsService.isElementDisplayed("xpath", "//p[text() = 'Reason: Health issues']");
    }

    public void checkReasonFlagged(String reason) {
        methodsService.isElementDisplayed("xpath", "//div[@class='moj-timeline__description' and text() = '" + reason + "']");
    }

    public void clickOnUpdateBooking() {
        methodsService.click("xpath", "//button[contains(@data-test,'update-visit')]");
    }

    public void checkMethodofCancellation(String msg) {
        methodsService.isElementDisplayed("xpath", "//p[text() = '" + msg + "']");
    }

    public void checkBannerDisplayed(String banner) {
        methodsService.isElementDisplayed("xpath", "//span[text()='" + banner + "']");
    }

    public void clickOnVisitorsTab() {
        methodsService.click("xpath", "//*[@id='tab_visitors']");
    }

    public void checkAddSupportDetails() {
        methodsService.isElementDisplayed("xpath", "//span[text()='wheel chair']");
    }

    public  void checkUpdateDetailsOptions(){
        Assert.assertFalse(methodsService.isElementPresent("xpath", "//button[contains(@data-test,'update-visit')]"));}
}