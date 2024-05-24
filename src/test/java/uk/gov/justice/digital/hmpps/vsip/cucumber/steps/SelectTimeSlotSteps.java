package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.SelectTimeSlotPage;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

public class SelectTimeSlotSteps {

    @LazyAutowired
    private SelectTimeSlotPage selectTimeSlotPage;

    @LazyAutowired
    private TestContextService testContextService;

    @Then("I see {string} on select timeslot page")
    public void iSeeOnSelectTimeslotPage(String errMsg) {
        selectTimeSlotPage.selectTimeslotErrorDisplayed();
    }

    @And("I shouldn't be able to select a timeslot")
    public void iShouldNotBeAbleToSelectATimeslot() {
        selectTimeSlotPage.noTimeslotAvailable();
    }

    @And("I shouldn't be able to select a timeslot that was booked last")
    public void iShouldNotBeAbleToSelectATimeslotThatWasBookedLast() {
        selectTimeSlotPage.lastBookedTimeSlotNotAvailable();
    }

    @And("I select a time slot for a non-association prisoner")
    public void iSelectATimeSlotForANonAssociationPrisoner() {
        selectTimeSlotPage.selectNonAssTimeSlot();
    }

    @And("I can select the last booked time slot")
    public void iCanSelectTheLastBookedTimeSlot() {
        selectTimeSlotPage.selectLastBookedSlot();
    }

    @And("I select time slot")
    public void iSelectTimeSlot() {
        selectTimeSlotPage.clickNextEnabledElement();
    }

    @And("I check only Open time slots is available")
    public void iCheckOnlyOpenTimeSlotsIsAvailable() {
        selectTimeSlotPage.checkOnlyOpenTimeSlots();
    }

    @And("I check no Closed time slots is available")
    public void iCheckNoClosedTimeSlotsIsAvailable() {
        selectTimeSlotPage.checkNoClosedTimeSlotsAvailable();
    }

    @And("I check only enhanced incentive timeslots available")
    public void iCheckOnlyEnhancedIncentiveTimeslotsAvailable() {
        selectTimeSlotPage.checkOnlyEnhancedTimeSlotsAvailable();
    }

    @And("I check standard timeslots not available")
    public void iCheckStandardTimeslotsNotAvailable() {
        selectTimeSlotPage.checkNoStandardTimeslotsAvailable();
    }

    @And("I check only standard incentive timeslots available")
    public void iCheckOnlyStandardIncentiveTimeslotsAvailable() {
        selectTimeSlotPage.checkOnlyStandardTimeslotsAvailable();
    }

    @And("I check enhanced timeslots not available")
    public void iCheckEnhancedTimeslotsNotAvailable() {
        selectTimeSlotPage.checkNoEnhancedTimeslotsAvailable();
    }

    @And("I check only this location time slots is available")
    public void iCheckOnlyThisLocationTimeSlotsIsAvailable() {
        selectTimeSlotPage.checkOnlyThisLocationTimeslotsAvailable();
    }

    @And("I check other location within this establishment timeslots not available")
    public void iCheckOtherLocationWithinThisEstablishmentTimeslotsNotAvailable() {
        selectTimeSlotPage.checkOtherLocationTimeSlotsNotAvailble();
    }

    @And("I check this location time slots is available")
    public void iCheckThisLocationTimeSlotsIsAvailable() {
        selectTimeSlotPage.checkTimeSlotsAvailableForThisLocation();
    }

    @And("I check no other location time slots is available")
    public void iCheckNoOtherLocationTimeSlotsIsAvailable() {
        selectTimeSlotPage.checkNoOtherLocationTimeslotsAvailable();
    }

    @And("I check only closed time slots is available")
    public void iCheckOnlyClosedTimeSlotsIsAvailable() {
        selectTimeSlotPage.checkOnlyClosedTimeslotsAvailable();
    }


    @And("I check open timeslots not available")
    public void iCheckOpenTimeslotsNotAvailable() {
        selectTimeSlotPage.checkNoOpenTimeSlotsAvailabe();
    }

    @And("I check only Cat C time slots is available for this prisoner")
    public void iCheckOnlyCatCTimeSlotsIsAvailableForThisPrisoner() {
        selectTimeSlotPage.checkOnlyCatCTimeslotsAvailable();
    }

    @And("I check other category time slots is not available")
    public void iCheckOtherCategoryTimeSlotsIsNotAvailable() {
        selectTimeSlotPage.checkNoOtherCategoryTimeSlotsAvailable();
    }

    @And("I check only Cat B timeslots is available")
    public void iCheckOnlyCatBTimeslotsIsAvailable() {
        selectTimeSlotPage.checkOnlyCatBTimeslotsAvailable();
    }

    @And("I check no other category timeslots is available")
    public void iCheckNoOtherCategoryTimeslotsIsAvailable() {
        selectTimeSlotPage.checkNoOthrCategoryTimeslotsAvailable();
    }

    @Then("I see {string} message is displayed")
    public void iSeeMessageIsDisplayed(String message) {
        selectTimeSlotPage.checkAMessageDisplayed();
    }

    @And("I capture the initial booking capacity size")
    public void iCaptureTheInitialBookingCapacitySize() {
        String initialCapacity = selectTimeSlotPage.getBookingCapacity();
        testContextService.setBookingCapacity(initialCapacity);
    }

    @And("The available capacity is back to the initial capacity")
    public void theAvailableCapacityIsBackToTheInitialCapacity() {
        String capacity = selectTimeSlotPage.getBookingCapacity();
        Assert.assertEquals(capacity, testContextService.getBookingCapacity());
    }
}