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

    @And("I select other prisoner visitor form the list")
    public void iSelectOtherPrisonerVisitorFormTheList() {
        selectVisitorsPage.chooseOtherPrisonersVisitor();
    }

    @And("I select a visitor form the list from Bristol establishment")
    public void iSelectAVisitorFormTheListFromBristolEstablishment() {
        selectVisitorsPage.chooseVisitorFromBristol();
    }

    @And("I select a visitor form the list for a prisoner")
    public void iSelectAVisitorFormTheListForAPrisoner() {
        selectVisitorsPage.choosePrisonerB();
    }

    @And("I select a new visitor form the list from Bristol establishment")
    public void iSelectANewVisitorFormTheListFromBristolEstablishment() {
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

    @And("I select next visitor form the list from Bristol establishment")
    public void iSelectNextVisitorFormTheListFromBristolEstablishment() {
        selectVisitorsPage.chooseAVisitorFromBristol();
    }

    @And("I select a visitor the list from the Drake hall establishment")
    public void iSelectAVisitorTheListFromTheDrakeHallEstablishment() {
        selectVisitorsPage.chooseAVisitorFromDrakeHall();
    }

    @And("I check if the message is displayed no booking can be booked for this prisoner")
    public void iCheckIfTheMessageIsDisplayedNoBookingCanBeBookedForThisPrisoner() {
        selectVisitorsPage.checkMessage();
    }

    @And("I check Banned status for the visitor")
    public void iCheckBannedStatusForTheVisitor() {
        selectVisitorsPage.checkBannedStatus();
    }

    @And("I check the Banned visitor is not selectable")
    public void iCheckTheBannedVisitorIsNotSelectable() {
        selectVisitorsPage.checkVisitorUnselectable();
    }

    @And("I select visitor from the list")
    public void iSelectVisitorFromTheList() {
        selectVisitorsPage.chooseVisitorForPrisoner10();
    }
}