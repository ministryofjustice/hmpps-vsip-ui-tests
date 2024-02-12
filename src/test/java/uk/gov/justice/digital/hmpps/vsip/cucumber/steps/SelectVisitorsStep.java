package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.SelectVisitorsPage;

public class SelectVisitorsStep {

    @LazyAutowired
    private SelectVisitorsPage selectVisitorsPage;

    @Then("I select a visitor form the list")
    public void i_select_a_visitor_form_the_list() {
        selectVisitorsPage.chooseAPrisoner();
    }

    @Then("I select a visitor form the lists")
    public void i_select_a_visitor_form_the_lists() {
        selectVisitorsPage.choosePrisoners();
    }

    @Then("I see {string} on select visitors page")
    public void iSeeOnSelectVisitorsPage(String errMsg) {
        selectVisitorsPage.selectVisitorErrorDisplayed();
    }

    @And("I select another visitor form the list")
    public void iSelectAnotherVisitorFormTheList() {
        selectVisitorsPage.chooseAnotherPrisoner();
    }

    @And("I select a visitor form the list from Bristol establishment")
    public void iSelectAVisitorFormTheListFromBristolEstablishment() {
        selectVisitorsPage.chooseVisitorFromBristol();
    }

    @And("I select a visitor form the list for a prisoner")
    public void iSelectAVisitorFormTheListForAPrisoner() {
        selectVisitorsPage.choosePrisonerB();
    }

    @And("I select a visitr form the list from Bristol establishment")
    public void iSelectAVisitrFormTheListFromBristolEstablishment() {
        selectVisitorsPage.choosePrisner();
    }

    @And("I select a visitor the list from Bristol establishment")
    public void iSelectAVisitorTheListFromBristolEstablishment() {
        selectVisitorsPage.chooseVistor();

    }

    @And("I select a visitor form the list from Drake hall establishment")
    public void iSelectAVisitorFormTheListFromDrakeHallEstablishment() {
        selectVisitorsPage.chooseVisitorFromDrakeHall();
    }
}