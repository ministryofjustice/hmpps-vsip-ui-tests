package stepDefinitions;

import io.cucumber.java.en.And;
import pages.commonPage;
import pages.BookingDetailsPage;

public class BookingDetailsStepDefinitions extends BookingDetailsPage {
    pages.commonPage commonPage = new commonPage();

    @And("I see {string} message displayed on Booking details page")
    public void iSeeMessageDisplayedOnBookingDetailsPage(String cancelMsg) {
        checkCancelMessageDisplayed();

    }

    @And("I see {string} displayed on Booking details page")
    public void iSeeDisplayedOnBookingDetailsPage(String message) {
        checkMethodofBooking(message);

    }
}
