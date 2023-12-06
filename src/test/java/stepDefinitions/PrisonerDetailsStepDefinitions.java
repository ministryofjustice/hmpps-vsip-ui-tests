package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PrisonerDetailsPage;
import pages.CommonPage;

public class PrisonerDetailsStepDefinitions extends PrisonerDetailsPage {

    CommonPage commonPage = new CommonPage();

    @Then("I click on Book a visit button")
    public void i_click_on_book_a_visit_button() {
        commonPage.clickOnBookAVisitBtn();
    }

    @And("I click on Cancel a visit button")
    public void iClickOnCancelAVisitButton() {
        commonPage.clickOnCancelAVisitBtn();
    }

    @And("I select latest visit reference")
    public void iSelectLatestVisitReference() {
        selectLatestPrisonVisit();
    }

    @And("I select last booked visit reference")
    public void iSelectLastBookedVisitReference() {
        selectLastBookedVisitReference();
    }
}