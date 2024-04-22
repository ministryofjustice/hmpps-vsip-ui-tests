package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import org.junit.Assert;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.ViewAVisitPage;


public class ViewAVisitSteps {

    @LazyAutowired
    private ViewAVisitPage cancelAVisitPage;


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

    @And("click on do not change button")
    public void clickOnDoNoChangeButton() {
        cancelAVisitPage.clickOnDoNoChangeButton();
    }


    @And("I do not see the do not change button")
    public void idoNotSeeTheDoNotChangeButton() {
        Assert.assertTrue("We should not see the do not change button", !cancelAVisitPage.canISeeDoNotChangeButton());
    }

    @And("I see the do not change button")
    public void idoSeeTheDoNotChangeButton() {
        Assert.assertTrue("We should see the do not change button", cancelAVisitPage.canISeeDoNotChangeButton());
    }

    @And("I select yes to the question i am sure the visit dose not need to be updated or cancelled")
    public void selectYesIAmSureTheVisitDoseNotNeedToBeUpdatedOrCancelled() {
        cancelAVisitPage.clickSelectYesIAmSureTheVisitDoseNotNeed();
    }
    @And("I select no to the question i am sure the visit dose not need to be updated or cancelled")
    public void iSelectNoIAmSureTheVisitDoseNotNeedToBeUpdatedOrCancelled() {
        cancelAVisitPage.clickSelectNoIAmSureTheVisitDoseNotNeed();
    }

    @And("I enter a {string} as a reason why the visit does not need to be updated or cancelled")
    public void iEnterAReasonWhyTheVisitDoseNotNeedToBeUpdatedOrCancelled(String reason) {
        cancelAVisitPage.entreReasonForDoNotChangeInput(reason);
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