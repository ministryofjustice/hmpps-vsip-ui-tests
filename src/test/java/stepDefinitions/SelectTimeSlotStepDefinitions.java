package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SelectTimeSlotPage;
import pages.commonPage;

public class SelectTimeSlotStepDefinitions extends SelectTimeSlotPage {

    pages.commonPage commonPage = new commonPage();

    @Then("I select a time slot")
    public void i_select_a_time_slot() {
        selectTimeSlot();
    }
    @And("I select next time slot")
    public void iSelectNextTimeSlot() {
        selectNextTimeSlot();
    }

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
}