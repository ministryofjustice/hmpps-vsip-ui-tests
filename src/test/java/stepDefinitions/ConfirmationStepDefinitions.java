package stepDefinitions;

import io.cucumber.java.en.And;
import pages.ConfirmationPage;
import pages.CommonPage;
import pages.util.Context;
import pages.util.TestRunContext;

public class ConfirmationStepDefinitions extends ConfirmationPage {

    CommonPage commonPage = new CommonPage();

    @And("I see {string} message displayed")
    public void iSeeMessageDisplayed(String confirmationMsg) {
        checkBookingHeading(confirmationMsg);
    }

    @And("I see a booking reference")
    public void iSeeABookingReferenceDisplayed() {
        String bookingReference = getBookingReference();
        TestRunContext.set(Context.BOOKING_REFERENCE,bookingReference);
    }




}