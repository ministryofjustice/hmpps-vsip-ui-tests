package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SelectTimeSlotPage;
import pages.CommonPage;

public class SelectTimeSlotStepDefinitions extends SelectTimeSlotPage {

    CommonPage commonPage = new CommonPage();

    @Then("I see {string} on select timeslot page")
    public void iSeeOnSelectTimeslotPage(String errMsg) {
        selectTimeslotErrorDisplayed();
    }

    @And("I shouldn't be able to select a timeslot")
    public void iShouldNotBeAbleToSelectATimeslot() {
        noTimeslotAvailable();
    }

    @And("I shouldn't be able to select a timeslot that was booked last")
    public void iShouldNotBeAbleToSelectATimeslotThatWasBookedLast() {
        lastBookedTimeSlotNotAvailable();
    }

    @And("I select a time slot for a non-association prisoner")
    public void iSelectATimeSlotForANonAssociationPrisoner() {
        selectNonAssTimeSlot();
    }

    @And("I can select the last booked time slot")
    public void iCanSelectTheLastBookedTimeSlot() {
        selectLastBookedSlot();
    }

    @And("I select time slot")
    public void iSelectTimeSlot() {
        commonPage.clickNextEnabledElement();
    }
}