package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.HomePage;


public class HomeSteps {

    @LazyAutowired
    private HomePage homePage;

    @Then("I click on Book a visit option")
    public void i_click_on_book_a_visit_option() {
        homePage.clickOnBookAVisitOption();
    }

    @And("I click on Change a visit option")
    public void iClickOnChangeAVisitOption() {
        homePage.clickOnChangeAVisitOption();
    }

    @And("I click on View visits by date option")
    public void iClickOnViewVisitsByDateOption() {
        homePage.clickOnViewVisitsByDateOption();
    }

    @And("I click on Need a Review option with a review number flag")
    public void iClickOnNeedAReviewOptionWithReviewFlag() {
        homePage.hasNeedReviewCount();
        homePage.clickOnNeedAReviewOption();
    }

    @And("I see need a Review option with a review number flag")
    public void iSeeNeedAReviewOptionWithReviewFlag() {
        homePage.hasNeedReviewCount();
    }

    @And("I click on Need a Review option")
    public void iClickOnNeedAReviewOption() {
        homePage.clickOnNeedAReviewOption();
    }

    @And("I goto home page")
    public void iGoToHomePage() {
        homePage.gotoHomePage();
    }

    @Then("I click on option to search by booking reference")
    public void iClickOnOptionToSearchByBookingReference() {
        homePage.clickOptionSearchByRef();
    }

    @Then("I click on search by name or prison number option")
    public void iClickOnSearchByNameOrPrisonNumberOption() {
        homePage.clickOptionSearchByPrisonNo();
    }

    @And("the need to Review option is unset")
    public void theNeedToReviewOptionIsUnset() {
        homePage.hasNoNeedReviewCount();
    }

    @And("I click on Block visit dates option")
    public void iClickOnBlockVisitDatesOption() {
        homePage.clickOnBlockVisitDatesOption();
    }

}
