package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ViewVisitsByDatePage;
import pages.commonPage;

public class ViewVisitsByDateStepDefinitions extends ViewVisitsByDatePage {

    pages.commonPage commonPage = new commonPage();

    @When("I select Date picker option")
    public void iSelectDatePickerOption() {
        selectDatePicker();
    }

    @Then("I enter {string} to view the visits")
    public void iEnterToViewTheVisits(String date) {
        enterDate(date);
    }

    @Then("I click on view button")
    public void iClickOnViewButton() {
        clickOnView();

    }

    @Then("I see tabs changed to the date")
    public void iSeeTabsChangedToTheDate() {
        checkTabsDateChanged();
    }

    @Then("I see a visit and click on view option")
    public void iSeeAVisitAndClickOnViewOption() {
        selectViewOption();
    }

    @Then("I see {string} of the visit of that date")
    public void iSeeOfTheVisitOfThatDate(String text) {
        checkTextOnVisit(text);
    }

    @Then("I see {string} on view visits by date page")
    public void iSeeOnViewVisitsByDatePage(String errMsg) {
        checkErrorMessage();
    }
}
