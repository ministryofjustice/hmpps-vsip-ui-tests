package stepDefinitions;

import io.cucumber.java.en.And;
import pages.CheckYourAnswersPage;
import pages.CommonPage;

public class CheckYourAnswersStepDefinitions extends CheckYourAnswersPage {

    CommonPage commonPage = new CommonPage();

    @And("click on submit booking button")
    public void clickOnSubmitBookingButton() {
        clickOnSubmitBookingBtn();
    }
}