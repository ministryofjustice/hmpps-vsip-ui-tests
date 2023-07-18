package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CancelAVisitPage;
import pages.commonPage;

public class CancelAVisitStepDefinitions extends CancelAVisitPage {

    pages.commonPage commonPage = new commonPage();

    @And("I select Visitor Cancelled option")
    public void iSelectVisitorCancelledOption() {
        selectCancelByVisitor();
    }
    @And("I enter cancellation {string} for the visit")
    public void iEnterCancellationForTheVisit(String reason) {
        enterReasonForCancellation(reason);
    }
    @And("click on cancel button")
    public void clickOnCancelButton() {
        commonPage.clickOnBtn();
    }
    @And("I select Establishment cancelled option")
    public void iSelectEstablishmentCancelledOption() {
        selectCancelByEstablishment();
    }

    @And("I select Prisoner cancelled option")
    public void iSelectPrisonerCancelledOption() {
        selectCancelByPrisoner();
    }

    @And("I select Administrative error option")
    public void iSelectAdministrativeErrorOption() {
        selectCancelByAdmin();
    }
}
