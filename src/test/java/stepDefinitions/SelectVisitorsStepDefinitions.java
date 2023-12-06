package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SelectVisitorsPage;
import pages.CommonPage;

public class SelectVisitorsStepDefinitions extends SelectVisitorsPage {

    CommonPage commonPage = new CommonPage();

    @Then("I select a visitor form the list")
    public void i_select_a_visitor_form_the_list() {
        commonPage.chooseAPrisoner();
    }

    @Then("I select a visitor form the lists")
    public void i_select_a_visitor_form_the_lists() {
        commonPage.choosePrisoners();
    }
    @Then("I see {string} on select visitors page")
    public void iSeeOnSelectVisitorsPage(String errMsg) {
        selectVisitorErrorDisplayed();
    }

    @And("I select another visitor form the list")
    public void iSelectAnotherVisitorFormTheList() {
        commonPage.chooseAnotherPrisoner();
    }

    @And("I select a visitor form the list from Bristol establishment")
    public void iSelectAVisitorFormTheListFromBristolEstablishment() {
        commonPage.chooseVisitorFromBristol();
    }

    @And("I select a visitor form the list for a prisoner")
    public void iSelectAVisitorFormTheListForAPrisoner() {
        commonPage.choosePrisonerB();
    }
}