package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import pages.BookingDetailsPage;

public class BookingDetailsStepDefinitions extends BookingDetailsPage {
    CommonPage commonPage = new CommonPage();

    @And("I see {string} message displayed on Booking details page")
    public void iSeeMessageDisplayedOnBookingDetailsPage(String cancelMsg) {
        checkCancelMessageDisplayed();

    }

    @And("I see {string} displayed on Booking details page")
    public void iSeeDisplayedOnBookingDetailsPage(String message) {
        checkMethodofBooking(message);

    }

    @Then("I choose Booking history tab")
    public void iChooseBookingHistoryTab() {
        clickOnBookingHistory();
    }

    @And("I see {string} method used to Book a visit")
    public void iSeeMethodUsedToBookAVisit(String method) {
        checkMethodofNewBooking(method);
    }
}
