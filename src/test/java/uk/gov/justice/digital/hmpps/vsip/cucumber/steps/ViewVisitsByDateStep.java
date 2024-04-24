package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.ConfirmationPage;
import uk.gov.justice.digital.hmpps.vsip.pages.ViewVisitsByDatePage;
import uk.gov.justice.digital.hmpps.vsip.services.DateUtilService;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

import java.time.LocalDate;

public class ViewVisitsByDateStep {

    private static final Logger LOG = LoggerFactory.getLogger(ViewVisitsByDateStep.class);

    @LazyAutowired
    ViewVisitsByDatePage viewVisitsByDatePage;

    @LazyAutowired
    private ConfirmationPage confirmationPage;

    @LazyAutowired
    private TestContextService testContextService;

    @LazyAutowired
    private DateUtilService dateUtilService;

    @When("I select Date picker option")
    public void iSelectDatePickerOption() {
        viewVisitsByDatePage.selectDatePicker();
    }

    @Then("I click on view button")
    public void iClickOnViewButton() {
        viewVisitsByDatePage.clickOnView();
    }

    @Then("I see tabs changed to the date")
    public void iSeeTabsChangedToTheDate() {
        viewVisitsByDatePage.checkTabsDateChanged();
    }

    @And("I enter {string} to view the visits")
    public void iEnterToViewTheVisits(String date) {
        viewVisitsByDatePage.enterDate(date);
    }

    @Then("I see a visit and click on view option")
    public void iSeeAVisitAndClickOnViewOption() {
        viewVisitsByDatePage.selectViewOption();
    }

    @Then("I see {string} of the visit of that date")
    public void iSeeOfTheVisitOfThatDate(String text) {
        viewVisitsByDatePage.checkTextOnVisit(text);
    }

    @Then("I see {string} on view visits by date page")
    public void iSeeOnViewVisitsByDatePage(String errMsg) {
        viewVisitsByDatePage.checkErrorMessage();
    }

    @And("I capture date the Booking is booked")
    public void iCaptureDateTheBookingIsBooked() {
        LocalDate bookDate = confirmationPage.getBookingDate();
        testContextService.setBookingDate(bookDate);
    }
    @Then("I enter date to view the visits")
    public void iEnterToViewTheVisits() {
        viewVisitsByDatePage.enterDate(dateUtilService.getCalendarDateStr(testContextService.getBookingDate()));
    }

}
