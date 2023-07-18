package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ConfirmationPage;
import pages.commonPage;

public class ConfirmationStepDefinitions extends ConfirmationPage {

    pages.commonPage commonPage = new commonPage();

    @And("I see {string} message displayed")
    public void iSeeMessageDisplayed(String confirmationMsg) {
        checkBookingCancelHeading(confirmationMsg);
    }

}
