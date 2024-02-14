package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.PrisonerDetailsPage;

public class PrisonerDetailsSteps {

    @LazyAutowired
    private PrisonerDetailsPage prisonerDetailsPage;

    @Then("I click on Book a visit button")
    public void i_click_on_book_a_visit_button() {
        prisonerDetailsPage.clickOnBookAVisitBtn();
    }

    @And("I click on Cancel a visit button")
    public void iClickOnCancelAVisitButton() {
        prisonerDetailsPage.clickOnCancelAVisitBtn();
    }

    @And("I select latest visit reference")
    public void iSelectLatestVisitReference() {
        prisonerDetailsPage.selectLatestPrisonVisit();
    }

    @And("I select last booked visit reference")
    public void iSelectLastBookedVisitReference() {
        prisonerDetailsPage.selectLastBookedVisitReference();
    }

    @And("I check {string} session is booked")
    public void iCheckSessionIsBooked(String sessionBookedStatus) {
        prisonerDetailsPage.checkSessionBookedStatus();
    }
    @And("I check incentive level for that prisoner")
    public void iCheckIncentiveLevelForThatPrisoner() {
        prisonerDetailsPage.checkIncentiveLevel();
        
    }
    @And("I check enhanced incentive level for that prisoner")
    public void iCheckEnhancedIncentiveLevelForThatPrisoner() {
        prisonerDetailsPage.checkEnhancedIncentiveLevel();
    }

    @And("I check category for that prisoner")
    public void iCheckCategoryForThatPrisoner() {
        prisonerDetailsPage.checkPrisonerCategory();

    }


    @And("I check Female category for that prisoner")
    public void iCheckFemaleCategoryForThatPrisoner() {
        prisonerDetailsPage.checkFemCategoryPrisoner();
    }

    @And("I check Prisoner location {string}")
    public void iCheckPrisonerLocation(String location) {
        prisonerDetailsPage.checkPrisonerLocation();
    }

    @And("I check Prisoner location {string} unable to proceed to book a visit")
    public void iCheckPrisonerLocationUnableToProceedToBookAVisit(String location) {
        prisonerDetailsPage.checkPrisonerLocationNotProceed();
    }

    @And("I see I cannot go further no time slots is available")
    public void iSeeICannotGoFurtherNoTimeSlotsIsAvailable() {
        prisonerDetailsPage.checkPrisonerCantGoFurther();
    }

    @And("I check {string} visit type is displayed")
    public void iCheckVisitTypeIsDisplayed(String visitType) {
        prisonerDetailsPage.checkPrisonerVisitType();

    }

    @And("I check Prisoner location {string} for drake hall")
    public void iCheckPrisonerLocationForDrakeHall(String location) {
        prisonerDetailsPage.checkPrisonerLocationDrakeHall();
    }
}