package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SelectTimeSlotPage;
import pages.commonPage;
import pages.util.TestRunContext;

public class SelectTimeSlotStepDefinitions extends SelectTimeSlotPage {

    pages.commonPage commonPage = new commonPage();

    @Then("I see {string} on select timeslot page")
    public void iSeeOnSelectTimeslotPage(String errMsg) {
        selectTimeslotErrorDisplayed();
    }

    @And("I shouldn't be able to select a timeslot")
    public void iShouldnTBeAbleToSelectATimeslot() {
        noTimeslotAvailable();
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