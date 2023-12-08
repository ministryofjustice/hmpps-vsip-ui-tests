package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.BookingDetailsPage;

public class BookingDetailsStepDefinitions {

    @LazyAutowired
    private BookingDetailsPage bookingDetailsPage;

    @And("I see {string} message displayed on Booking details page")
    public void iSeeMessageDisplayedOnBookingDetailsPage(String cancelMsg) {
        bookingDetailsPage.checkCancelMessageDisplayed();
    }

    @And("I see {string} displayed on Booking details page")
    public void iSeeDisplayedOnBookingDetailsPage(String message) {
        bookingDetailsPage.checkMethodofBooking(message);
    }

    @Then("I choose Booking history tab")
    public void iChooseBookingHistoryTab() {
        bookingDetailsPage.clickOnBookingHistory();
    }

    @And("I see {string} method used to Book a visit")
    public void iSeeMethodUsedToBookAVisit(String method) {
        bookingDetailsPage.checkMethodofNewBooking(method);
    }
}