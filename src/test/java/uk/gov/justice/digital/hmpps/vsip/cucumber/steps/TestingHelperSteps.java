package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.services.PrisonVisitsTestingHelperService;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class TestingHelperSteps {
    @LazyAutowired
    private PrisonVisitsTestingHelperService testHelper;

    @LazyAutowired
    private TestContextService testContextService;

    @Given("A prisoner {string} is released from {string}")
    public void aPrisonerIsReleased(String prisonerCode, String prisonCode) {
        testHelper.startPrisonerReleased(prisonCode, prisonerCode);
    }

    @Given("A prisoner {string} is received from {string}")
    public void aPrisonerIsReceived(String prisonerCode, String prisonCode) {
        testHelper.startPrisonerReceived(prisonCode, prisonerCode);
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
        testHelper.cleanUpBookings();
    }

    @And("I want to clean up after the exclude date test")
    public void iWantToCleanUpAfterTheExcludeDateTest() {
        System.out.println("Original Date Booking Reference: " + testContextService.getDateBookingReference());
        testHelper.removeVisitExcludeDateEvent("HEI",testContextService.getDateBookingReference());

    }
}
