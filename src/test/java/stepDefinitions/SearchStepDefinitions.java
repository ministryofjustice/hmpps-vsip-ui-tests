package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import pages.CommonPage;

public class SearchStepDefinitions extends SearchPage {

    CommonPage commonPage = new CommonPage();

    @When("I enter {string} to search for a prison")
    public void i_enter_to_search_for_a_prison(String prisonNo) {
        enterPrisonDetails(prisonNo);
    }
    @And("click on search button")
    public void clickOnSearchButton() {
        commonPage.clickOnBtn();
    }
    @Then("I choose prison from search results")
    public void i_choose_prison_from_search_results() {
        commonPage.selectPrisoner();
    }
    @And("I enter {string} in first block")
    public void iEnterInFirstBlock(String value1) {
        enterConfimationInBlock1(value1);
    }

    @And("I enter {string} in second block")
    public void iEnterInSecondBlock(String value2) {
        enterConfimationInBlock2(value2);
    }

    @And("I enter {string} in third block")
    public void iEnterInThirdBlock(String value3) {
        enterConfimationInBlock3(value3);
    }

    @And("I enter {string} in fourth block")
    public void iEnterInFourthBlock(String value4) {
        enterConfimationInBlock4(value4);
    }

    @Then("I see {string} on search page")
    public void iSeeOnSearchPage(String errMsg) {
        searchErrorDisplayed(errMsg);
    }
    @And("I check the visit status {string}")
    public void iCheckTheVisitStatus(String status) {
        visitStatusDisplayed(status);
    }
}