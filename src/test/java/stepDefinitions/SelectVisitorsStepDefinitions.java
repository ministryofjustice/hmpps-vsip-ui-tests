package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SelectVisitorsPage;
import pages.commonPage;

public class SelectVisitorsStepDefinitions extends SelectVisitorsPage {

    pages.commonPage commonPage = new commonPage();

    @Then("I select a visitor form the list")
    public void i_select_a_visitor_form_the_list() {
        commonPage.chooseAPrisoner();
    }

}