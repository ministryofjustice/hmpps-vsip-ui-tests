package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.BasePage;
import uk.gov.justice.digital.hmpps.vsip.services.CommonMethodService;
import uk.gov.justice.digital.hmpps.vsip.services.PrisonVisitsTestingHelperService;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class CommonSteps {

    @LazyAutowired
    private BasePage basePage;

    @LazyAutowired
    private CommonMethodService methodsService;

    @LazyAutowired
    private PrisonVisitsTestingHelperService testHelper;

    @LazyAutowired
    private TestContextService testContextService;



    @Given("click on submit button")
    public void i_click_on_submit_button() {
        methodsService.clickOnSubmitBtn();
    }

    @Then("I see {string} on the page")
    public void iSeeOnThePage(String error) {
        methodsService.isElementDisplayed("xpath","//a[text()='"+error+"']");
    }

    @Then("Im on {string} page")
    public void im_on_vsip_page(String pageTitle) {
        basePage.isPageTitleDisplayed(pageTitle);
    }

    @Then("I take note of the hidden application reference")
    public void then_i_take_note_of_the_hidden_application_reference() {
        String applicationReference = methodsService.getApplicationRef();
        Assert.assertTrue("We are expecting a application reference here", applicationReference!=null || !applicationReference.trim().isEmpty());
        testContextService.setApplicationReference(applicationReference);
    }

    @Then("Im on {string} visit view page")
    public void im_on_a_visit_view_page(String pageTitle) {
        basePage.isPageTitleDisplayed(pageTitle.replace("<booking_reference>",testContextService.getBookingReference()));
    }

    @Then("click on continue button")
    public void click_on_continue_button() {
        methodsService.clickOnContinueBtn();
    }

    @And("I click on Manage a Prison option")
    public void iClickOnManageAPrisonOption() {
        methodsService.clickOnManagePrisonOption();
    }

    @And("I sign out of the service")
    public void iSignOutOfTheService() {
        methodsService.clickOnSignOut();
    }

    @Then("I see {string} page")
    public void iSeePage(String errorMsg) {
        methodsService.errorMsgDisplayed(errorMsg);
    }

    @And("I change the establishment to Bristol")
    public void iChangeTheEstablishmentToBristol() {
        methodsService.chooseBristol();
    }

    @And("I change the establishmnet to Drake Hall")
    public void iChangeTheEstablishmnetToDrakeHall() {
        methodsService.chooseDrakeHall();
    }

    @And("I should not be able to select Bristol establishment")
    public void iShouldNotBeAbleToSelectBristolEstablishment() {
        methodsService.chooseNoBristol();
    }

    @And("I select change establishment")
    public void iSelectChangeEstablishment() {
        methodsService.changeEstablishment();
    }

    @And("then we wait {string} second for the system to update")
    public void thenWeWaitSecondForTheSystemToUpdate(String seconds) {
        basePage.waitAWhile(Integer.parseInt(seconds.trim()));
    }
}
