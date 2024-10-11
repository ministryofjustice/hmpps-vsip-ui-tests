package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.OverBookingsPage;

public class OverBookingSteps {

    @LazyAutowired
    private OverBookingsPage overBookingsPage;

    @And("I select yes to over book a slot")
    public void iSelectYesToOverBookASlot() {
        overBookingsPage.clickConfirmOverbooking();
    }

}
