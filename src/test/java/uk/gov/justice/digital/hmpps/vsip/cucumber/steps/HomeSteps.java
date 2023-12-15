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
        homePage.hashNeedReviewCount();
        homePage.clickOnNeedAReviewOption();
    }

    @And("I click on Need a Review option")
    public void iClickOnNeedAReviewOption() {
        homePage.clickOnNeedAReviewOption();
    }

    @And("I goto home page")
    public void iGoToHomePage() {
        homePage.gotoHomePage();
    }

}