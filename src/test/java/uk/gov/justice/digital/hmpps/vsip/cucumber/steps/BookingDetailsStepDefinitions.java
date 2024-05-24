package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.AdditionalSupportPage;
import uk.gov.justice.digital.hmpps.vsip.pages.BookingDetailsPage;
import uk.gov.justice.digital.hmpps.vsip.pages.ConfirmationPage;
import uk.gov.justice.digital.hmpps.vsip.pages.HomePage;
import uk.gov.justice.digital.hmpps.vsip.pages.MainContactPage;
import uk.gov.justice.digital.hmpps.vsip.pages.PrisonerDetailsPage;
import uk.gov.justice.digital.hmpps.vsip.pages.SearchPage;
import uk.gov.justice.digital.hmpps.vsip.pages.SelectTimeSlotPage;
import uk.gov.justice.digital.hmpps.vsip.pages.SelectVisitorsPage;
import uk.gov.justice.digital.hmpps.vsip.pages.WhatMethodPage;
import uk.gov.justice.digital.hmpps.vsip.services.CommonMethodService;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

public class BookingDetailsStepDefinitions {

    @LazyAutowired
    private BookingDetailsPage bookingDetailsPage;

    @LazyAutowired
    private HomePage homePage;

    @LazyAutowired
    private SearchPage searchPage;

    @LazyAutowired
    private PrisonerDetailsPage prisonerDetailsPage;

    @LazyAutowired
    private SelectVisitorsPage selectVisitorsPage;

    @LazyAutowired
    private CommonMethodService methodsService;

    @LazyAutowired
    private SelectTimeSlotPage selectTimeSlotPage;

    @LazyAutowired
    private AdditionalSupportPage additionalSupportPage;

    @LazyAutowired
    private MainContactPage mainContactPage;

    @LazyAutowired
    private WhatMethodPage whatMethodPage;

    @LazyAutowired
    private ConfirmationPage confirmationPage;

    @LazyAutowired
    private TestContextService testContextService;

    @And("I see {string} reason message displayed on booking history tab")
    public void iSeeReasonMessageDisplayedOnBookingHistoryTab(String message) {
        bookingDetailsPage.checkHistoryTabCancelReasonMethod(message);
    }

    @And("I see {string} cancel request method displayed on booking history tab")
    public void iSeeCancelRequestMethodReasonDisplayedOnBookingHistoryTab(String message) {
        bookingDetailsPage.checkHistoryTabCancelRequestMethod(message);
    }

    @And("I see {string} book request method displayed on booking history tab")
    public void iSeeBookRequestMethodReasonDisplayedOnBookingHistoryTab(String message) {
        bookingDetailsPage.checkHistoryTabBookRequestMethod(message);
    }


    @And("I dont see {string} message displayed on booking history tab")
    public void iDontSeeMessageDisplayedOnBookingHistoryTab(String arg0) {
        // todo
    }


    @And("I see {string} message displayed on Booking details page")
    public void iSeeMessageDisplayedOnBookingDetailsPage(String cancelMsg) {
        bookingDetailsPage.checkCancelMessageDisplayed(cancelMsg);
    }

    @Then("I choose Booking history tab")
    public void iChooseBookingHistoryTab() {
        bookingDetailsPage.clickOnBookingHistory();
    }

    @And("I see {string} reason used to Book a visit")
    public void iSeeReasonUsedToBookAVisit(String method) {
        bookingDetailsPage.checkMethodofNewBooking(method);
    }

    @And("I see {string} banner")
    public void iSeeBanner(String banner) {
        bookingDetailsPage.checkBannerDisplayed(banner);
    }

    @And("I see {string} used to cancel booking")
    public void iSeeUsedToCancelBooking(String requestMethod) {
        bookingDetailsPage.checkMethodofCancellation(requestMethod);
    }

    @And("I see {string} time slot removed reason")
    public void iSeeTimeSlotRemovedReason(String reason) {
        bookingDetailsPage.checkReasonFlagged(reason);
    }

    @Then("I click on update booking button")
    public void iClickOnUpdateBookingButton() {
        bookingDetailsPage.clickOnUpdateBooking();
    }

    @And("I choose Booking visitors tab")
    public void iChooseBookingVisitorsTab() {
        bookingDetailsPage.clickOnVisitorsTab();
    }

    @Then("I check additional support is displayed")
    public void iCheckAdditionalSupportIsDisplayed() {
        bookingDetailsPage.checkAddSupportDetails();
    }

    @Then("I book a visit for {string}")
    public void iBookAVisitFor(String prisonerNo) {
        iBookAVisitForAndStayOnPage(prisonerNo);
        methodsService.clickOnManagePrisonOption();
    }

    @Then("I book a visit for {string} and stay on confirmation page")
    public void iBookAVisitForAndStayOnPage(String prisonerNo) {
        homePage.clickOnBookAVisitOption();
        bookingDetailsPage.isPageTitleDisplayed("Manage prison visits - Search for a prisoner");
        searchPage.enterPrisonerDetails(prisonerNo);
        searchPage.clickOnSearchBtn();
        searchPage.selectPrisoner();
        bookingDetailsPage.isPageTitleDisplayed("Manage prison visits - "+prisonerNo+", Do Not Use");
        prisonerDetailsPage.clickOnBookAVisitBtn();
        bookingDetailsPage.isPageTitleDisplayed("Manage prison visits - Select visitors from the prisoner’s approved visitor list");
        selectVisitorsPage.choosePrisoners();
        methodsService.clickOnContinueBtn();
        bookingDetailsPage.isPageTitleDisplayed("Manage prison visits - Select date and time of visit");
        selectTimeSlotPage.clickNextEnabledElement();
        methodsService.clickOnContinueBtn();
        bookingDetailsPage.isPageTitleDisplayed("Manage prison visits - Is additional support needed for any of the visitors?");
        additionalSupportPage.selectNoForAddAssistance();
        methodsService.clickOnContinueBtn();
        bookingDetailsPage.isPageTitleDisplayed("Manage prison visits - Who is the main contact for this booking?");
        mainContactPage.selectMainContact();
        mainContactPage.chooseUKPhoneNoOption();
        mainContactPage.enterPhoneNo("07805123900");
        methodsService.clickOnContinueBtn();
        bookingDetailsPage.isPageTitleDisplayed("Manage prison visits - How was this booking requested?");
        whatMethodPage.selectPhoneCall();
        methodsService.clickOnContinueBtn();
        bookingDetailsPage.isPageTitleDisplayed("Manage prison visits - Check the visit details before booking");
        methodsService.clickOnContinueBtn();
        bookingDetailsPage.isPageTitleDisplayed("Manage prison visits - Booking confirmed");
        confirmationPage.checkBookingHeading("Booking confirmed");
        String bookingReference = confirmationPage.getBookingReference();
        testContextService.setBookingReference(bookingReference);
    }
}
