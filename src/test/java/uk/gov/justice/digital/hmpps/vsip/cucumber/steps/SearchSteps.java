package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.SearchPage;

public class SearchSteps {

    @LazyAutowired
    private SearchPage searchPage;

    @When("I enter {string} to search for a prison")
    public void i_enter_to_search_for_a_prison(String prisonNo) {
        searchPage.enterPrisonerDetails(prisonNo);
    }

    @And("click on search button")
    public void clickOnSearchButton() {
        searchPage.clickOnSearchBtn();
    }

    @Then("I choose prisoner from search results")
    public void i_choose_prisoner_from_search_results() {
        searchPage.selectPrisoner();
    }

    @And("I enter {string} in first block")
    public void iEnterInFirstBlock(String value1) {
    }

    @And("I enter {string} in second block")
    public void iEnterInSecondBlock(String value2) {
        searchPage.enterConfirmationInBlock2(value2);
    }

    @And("I enter {string} in third block")
    public void iEnterInThirdBlock(String value3) {
        searchPage.enterConfirmationInBlock3(value3);
    }

    @And("I enter {string} in fourth block")
    public void iEnterInFourthBlock(String value4) {
        searchPage.enterConfirmationInBlock4(value4);
    }

    @Then("I see {string} on search page")
    public void iSeeOnSearchPage(String errMsg) {
        searchPage.searchErrorDisplayed(errMsg);
    }

    @And("I check the visit status {string}")
    public void iCheckTheVisitStatus(String status) {
        searchPage.visitStatusDisplayed(status);
    }

    @Then("I see {string} on booking reference search page")
    public void iSeeOnBookingReferenceSearchPage(String errorMsg) {
        searchPage.bookingRefSearchErrMsg();
    }

    @And("I enter the booking reference")
    public void iEnterBookingReference() {
        searchPage.enterBookingReference();
    }
}