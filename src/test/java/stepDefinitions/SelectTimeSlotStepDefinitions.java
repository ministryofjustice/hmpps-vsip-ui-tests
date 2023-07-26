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
}