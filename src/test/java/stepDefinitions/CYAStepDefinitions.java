package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.CYAPage;
import pages.commonPage;

public class CYAStepDefinitions extends CYAPage{
    pages.commonPage commonPage = new commonPage();

    @And("click on submit booking button")
    public void clickOnSubmitBookingButton() {
        clickOnSubmitBookingBtn();

    }
}
