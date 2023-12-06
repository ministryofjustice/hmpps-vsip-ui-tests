package stepDefinitions;

import io.cucumber.java.en.And;
import pages.CancelAVisitPage;
import pages.CommonPage;

public class CancelAVisitStepDefinitions extends CancelAVisitPage {

    CommonPage commonPage = new CommonPage();

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
        commonPage.clickOnCancelBtn();
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

//The below method can be written for multiple options Gov.uk,Email,In person
    @And("I select Phone call option")
    public void iSelectPhoneCallOption() {
        selectCancelByPhone();
    }
}