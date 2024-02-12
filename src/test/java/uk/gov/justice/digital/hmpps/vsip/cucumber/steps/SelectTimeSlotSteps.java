package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.SelectTimeSlotPage;

public class SelectTimeSlotSteps {

    @LazyAutowired
    private SelectTimeSlotPage selectTimeSlotPage;


    @Then("I see {string} on select timeslot page")
    public void iSeeOnSelectTimeslotPage(String errMsg) {
        selectTimeSlotPage.selectTimeslotErrorDisplayed();
    }

    @And("I shouldn't be able to select a timeslot")
    public void iShouldNotBeAbleToSelectATimeslot() {
        selectTimeSlotPage.noTimeslotAvailable();
    }

    @And("I shouldn't be able to select a timeslot that was booked last")
    public void iShouldNotBeAbleToSelectATimeslotThatWasBookedLast() {
        selectTimeSlotPage.lastBookedTimeSlotNotAvailable();
    }

    @And("I select a time slot for a non-association prisoner")
    public void iSelectATimeSlotForANonAssociationPrisoner() {
        selectTimeSlotPage.selectNonAssTimeSlot();
    }

    @And("I can select the last booked time slot")
    public void iCanSelectTheLastBookedTimeSlot() {
        selectTimeSlotPage.selectLastBookedSlot();
    }

    @And("I select time slot")
    public void iSelectTimeSlot() {
        selectTimeSlotPage.clickNextEnabledElement();
    }

}