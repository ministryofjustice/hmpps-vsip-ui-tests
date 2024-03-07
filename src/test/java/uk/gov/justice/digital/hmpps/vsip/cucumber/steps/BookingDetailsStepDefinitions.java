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

    @And("I see {string} reason used to Book a visit")
    public void iSeeReasonUsedToBookAVisit(String method) {
        bookingDetailsPage.checkMethodofNewBooking(method);
    }

    @And("I see {string} banner")
    public void iSeeBanner(String banner) {
        bookingDetailsPage.checkBannerDisplayed(banner);
    }

    @And("I see {string} used to cancel booking")
    public void iSeeUsedToCancelBooking(String requestMethod) {
        bookingDetailsPage.checkMethodofCancellation(requestMethod);
    }

    @And("I see {string} time slot removed reason")
    public void iSeeTimeSlotRemovedReason(String reason) {
        bookingDetailsPage.checkReasonFlagged(reason);
    }

    @Then("I click on update booking button")
    public void iClickOnUpdateBookingButton() {
        bookingDetailsPage.clickOnUpdateBooking();
    }

    @And("I choose Booking visitors tab")
    public void iChooseBookingVisitorsTab() {
        bookingDetailsPage.clickOnVisitorsTab();
    }

    @Then("I check additional support is displayed")
    public void iCheckAdditionalSupportIsDisplayed() {
        bookingDetailsPage.checkAddSupportDetails();
    }
}
