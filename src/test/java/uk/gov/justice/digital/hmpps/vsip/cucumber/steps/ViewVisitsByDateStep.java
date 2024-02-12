package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.ViewVisitsByDatePage;

public class ViewVisitsByDateStep {

    @LazyAutowired
    ViewVisitsByDatePage viewVisitsByDatePage;


    @When("I select Date picker option")
    public void iSelectDatePickerOption() {
        viewVisitsByDatePage.selectDatePicker();
    }

    @Then("I enter {string} to view the visits")
    public void iEnterToViewTheVisits(String date) {
        viewVisitsByDatePage.enterDate(date);
    }

    @Then("I click on view button")
    public void iClickOnViewButton() {
        viewVisitsByDatePage.clickOnView();
    }

    @Then("I see tabs changed to the date")
    public void iSeeTabsChangedToTheDate() {
        viewVisitsByDatePage.checkTabsDateChanged();
    }

    @Then("I see a visit and click on view option")
    public void iSeeAVisitAndClickOnViewOption() {
        viewVisitsByDatePage.selectViewOption();
    }

    @Then("I see {string} of the visit of that date")
    public void iSeeOfTheVisitOfThatDate(String text) {
        viewVisitsByDatePage.checkTextOnVisit(text);
    }

    @Then("I see {string} on view visits by date page")
    public void iSeeOnViewVisitsByDatePage(String errMsg) {
        viewVisitsByDatePage.checkErrorMessage();
    }

}
