package pages;

import pages.util.TestRunContext;

public class PrisonerDetailsPage extends CommonMethods {

    public void selectLatestPrisonVisit() {
        click("xpath","//*[@id='visits']/table[1]/tbody/tr/td[1]/a");
    }

    public void selectLastBookedVisitReference() {
        final String xPath = "//a[contains(text(),'" + TestRunContext.getBookingReference() + "')]";
        click("xpath",xPath);
    }
}