package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.CheckYourAnswersPage;
import pages.commonPage;

public class CheckYourAnswersStepDefinitions extends CheckYourAnswersPage {

    pages.commonPage commonPage = new commonPage();

    @And("click on submit booking button")
    public void clickOnSubmitBookingButton() {
        clickOnSubmitBookingBtn();
    }
}