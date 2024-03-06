package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.ConfirmUpdatePage;
import uk.gov.justice.digital.hmpps.vsip.services.PrisonVisitsTestingHelperService;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

public class ConfirmUpdateSteps {

    @LazyAutowired
    private TestContextService testContextService;

    @LazyAutowired
    private ConfirmUpdatePage confirmUpdatePage;

    @Then("I select Yes to update booking")
    public void iSelectYesToUpdateBooking() {
        confirmUpdatePage.selectYesRadioButton();
    }
}
