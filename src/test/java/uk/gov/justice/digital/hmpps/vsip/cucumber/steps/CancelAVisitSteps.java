package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.CancelAVisitPage;


public class CancelAVisitSteps {

    @LazyAutowired
    private CancelAVisitPage cancelAVisitPage;

    @And("I select Visitor Cancelled option")
    public void iSelectVisitorCancelledOption() {
        cancelAVisitPage.selectCancelByVisitor();
    }

    @And("I enter cancellation {string} for the visit")
    public void iEnterCancellationForTheVisit(String reason) {
        cancelAVisitPage.enterReasonForCancellation(reason);
    }

    @And("click on cancel button")
    public void clickOnCancelButton() {
        cancelAVisitPage.clickOnCancelBtn();
    }

    @And("I select Establishment cancelled option")
    public void iSelectEstablishmentCancelledOption() {
        cancelAVisitPage.selectCancelByEstablishment();
    }

    @And("I select Prisoner cancelled option")
    public void iSelectPrisonerCancelledOption() {
        cancelAVisitPage.selectCancelByPrisoner();
    }

    @And("I select Administrative error option")
    public void iSelectAdministrativeErrorOption() {
        cancelAVisitPage.selectCancelByAdmin();
    }

    //The below method can be written for multiple options Gov.uk,Email,In person
    @And("I select Phone call option")
    public void iSelectPhoneCallOption() {
        cancelAVisitPage.selectCancelByPhone();
    }
}