package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.LazyComponent;

@LazyComponent
public class BookingDetailsPage extends BasePage {

    public void clickOnBookingHistory() {
        methodsService.clickOnButton("xpath", "//*[@id='tab_history']");
    }

    public void checkCancelMessageDisplayed() {
        methodsService.isElementDisplayed("xpath", "//p[text() = 'GOV.UK request']");
    }

    public void checkMethodofBooking(String msg) {
        methodsService.isElementDisplayed("xpath", "//p[text() = 'Email request']");
    }

    public void checkMethodofNewBooking(String msg) {
        methodsService.isElementDisplayed("xpath", "//p[text() = 'By the prisoner']");
    }

}