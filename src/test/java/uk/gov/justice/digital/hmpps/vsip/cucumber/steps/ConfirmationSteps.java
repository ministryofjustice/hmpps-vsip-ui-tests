package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.ConfirmationPage;
import uk.gov.justice.digital.hmpps.vsip.util.Context;
import uk.gov.justice.digital.hmpps.vsip.services.TestService;

public class ConfirmationSteps {

    @LazyAutowired
    private ConfirmationPage confirmationPage;

    @LazyAutowired
    private TestService testService;

    @And("I see {string} message displayed")
    public void iSeeMessageDisplayed(String confirmationMsg) {
        confirmationPage.checkBookingHeading(confirmationMsg);
    }

    @And("I see a booking reference")
    public void iSeeABookingReferenceDisplayed() {
        String bookingReference = confirmationPage.getBookingReference();
        TestService.setToContext(Context.BOOKING_REFERENCE, bookingReference);
    }


}