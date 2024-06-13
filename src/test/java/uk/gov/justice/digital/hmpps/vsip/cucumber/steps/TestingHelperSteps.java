package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.ConfirmationPage;
import uk.gov.justice.digital.hmpps.vsip.services.PrisonVisitsTestingHelperService;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class TestingHelperSteps {
    @LazyAutowired
    private PrisonVisitsTestingHelperService testHelper;

    @LazyAutowired
    private TestContextService testContextService;

    @LazyAutowired
    private ConfirmationPage confirmationPage;

    @Given("A prisoner {string} is released from {string} for {string}")
    public void aPrisonerIsReleased(String prisonerCode, String prisonCode, String type) {
        testHelper.startPrisonerReleased(prisonCode, prisonerCode,type);
    }

    @Given("A prisoner {string} is received from {string} for {string}")
    public void aPrisonerIsReceived(String prisonerCode, String prisonCode, String reason) {
        testHelper.startPrisonerReceived(prisonCode, prisonerCode, reason);
    }

    @Given("A prisoner {string} has a restriction from {string} to {string}")
    public void aPrisonerHasARestriction(String prisonerCode, String startDate, String endDate) {
        testHelper.startPrisonerRestriction(prisonerCode, startDate, endDate);
    }

    @Given("A prisoner {string} has a restriction from {string}")
    public void aPrisonerHasARestriction(String prisonerCode, String startDate) {
        testHelper.startPrisonerRestriction(prisonerCode, startDate, null);
    }

    @Given("A prisoner {string} has a restriction from today")
    public void aPrisonerHasARestriction(String prisonerCode) {
        testHelper.startPrisonerRestriction(prisonerCode);
    }

    @Given("A visitor {string} has a restriction from {string}")
    public void aVisitorHasARestriction(String visitorId, String startDate) {
        testHelper.startVisitorRestriction(visitorId, startDate, null);
    }

    @Given("A visitor {string} has a restriction from {string} to {string}")
    public void aVisitorHasARestriction(String visitorId, String startDate, String endDate) {
        testHelper.startVisitorRestriction(visitorId, startDate, endDate);
    }

    @Given("A prisoner {string} has a non association with {string}")
    public void aPrisonerHasNonAssociation(String prisonerCode, String nonAssociationPrisonerCode) {
        testHelper.startPrisonerNonAssociation(prisonerCode, nonAssociationPrisonerCode);
    }

    @And("I want to clean up after the above test")
    public void iWantToCleanUpAfterTheAboveTest() {
        testHelper.cleanUp();
    }

    @And("I want to clean up after the exclude date test at {string}")
    public void iWantToCleanUpAfterTheExcludeDateTest(String prison) {
        testHelper.removeVisitExcludeDateEvent(prison,testContextService.getBookingDate());
    }

    @Given("A date is excluded for booking at {string}")
    public void aDateIsExcludedForBooking(String prison) {
        //capturing date from booking confirmation page
        LocalDate bookingDate = confirmationPage.getBookingDate();

        //send call to exclude visit to testing api
        testHelper.addVisitExcludeDateEvent(prison, bookingDate);

        testContextService.setBookingDate(bookingDate);
    }

    @Then("I update the last modified time in the database to be {string} minutes in the past")
    public void iUpdateTheLastModifiedTimeInTheDatabaseToBeInThePast(String time) {
        LocalDateTime updatedModifiedDate = LocalDateTime.now().minusMinutes(Integer.parseInt(time));
        testHelper.updateModifyTimestampOfApplication(testContextService.getApplicationReference(), updatedModifiedDate);
    }


    @Then("I change booked visit prison to {string}")
    public void iChangeBookedVisitPrisonTo(String prisonCode) {
        final String bookingReference = testContextService.getBookingReference();
        testHelper.changeVisitPrison(bookingReference, prisonCode );
    }
}
