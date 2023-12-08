package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.LazyComponent;
import uk.gov.justice.digital.hmpps.vsip.services.TestService;

@LazyComponent
public class PrisonerDetailsPage extends BasePage {

    public void selectLatestPrisonVisit() {
        methodsService.click("xpath", "//*[@id='visits']/table[1]/tbody/tr/td[1]/a");
    }

    public void selectLastBookedVisitReference() {
        final String xPath = "//a[contains(text(),'" + TestService.getBookingReference() + "')]";
        methodsService.click("xpath", xPath);
    }

    public void clickOnBookAVisitBtn() {
        methodsService.click("xpath", "//*[@id='main-content']/div[1]/div/form/button");
    }

    public void clickOnCancelAVisitBtn() {
        methodsService.click("xpath", "//a[contains(@data-test, 'cancel-visit')]");
    }
}