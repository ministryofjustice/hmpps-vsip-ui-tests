package uk.gov.justice.digital.hmpps.vsip.pages;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class PrisonerDetailsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@data-test='visitors-max-total']")
    private WebElement numberOfAllowedVisitors;

    @FindBy(how = How.XPATH, using = "//*[@data-test='prison-name']")
    private WebElement prisonName;


    public void selectLatestPrisonVisit() {
        methodsService.click("xpath", "//*[@id='visits']/table[1]/tbody/tr/td[1]/a");
    }

    public void selectLastBookedVisitReference() {
        final String xPath = "//a[contains(text(),'" + testContextService.getBookingReference() + "')]";
        methodsService.click("xpath", xPath);
    }

    public void clickOnBookAVisitBtn() {
        methodsService.click("xpath", "//*[@id='main-content']/div[1]/div/form/button");
    }

    public void clickOnCancelAVisitBtn() {
        methodsService.click("xpath", "//a[contains(@data-test, 'cancel-visit')]");
    }

    public void checkSessionBookedStatus() {
        methodsService.isElementDisplayed("xpath", "//span[text()='Open']");
    }

    public void checkIncentiveLevel() {
        methodsService.isElementDisplayed("xpath", "//span[text()='Standard']");
    }

    public void checkEnhancedIncentiveLevel() {
        methodsService.isElementDisplayed("xpath", "//span[text()='Enhanced']");
    }

    public void checkPrisonerCategory() {
        methodsService.isElementDisplayed("xpath", "//span[text()='Cat C']");
    }

    public void checkFemCategoryPrisoner() {
        methodsService.isElementDisplayed("xpath", "//span[text()='Fem Closed']");
    }

    public void checkPrisonerLocation() {
        methodsService.isElementDisplayed("xpath", "//span[text()='I-1-003, Drake Hall (HMP & YOI)']");
    }

    public void checkPrisonerLocationNotProceed() {
        methodsService.isElementDisplayed("xpath", "//span[text()='RECP, Bristol (HMP)']");
    }

    public void checkPrisonerLocationDrakeHall() {
        methodsService.isElementDisplayed("xpath", "//span[text()='F-1-018, Drake Hall (HMP & YOI)']");
    }

    public void checkPrisonerCantGoFurther() {
        methodsService.isElementDisplayed("xpath", "//p[text()='There are no available time slots for this prisoner.']");
    }

    public void checkPrisonerVisitType() {
        methodsService.isElementDisplayed("xpath", "//span[text()='Closed']");
    }

    public void totalNumberOfVisitorsAllowed(String stg) {
        final String visitorsAllowedPerVisit = numberOfAllowedVisitors.getText();
        Assert.assertEquals("Visitors allowed at this prison", stg, visitorsAllowedPerVisit);
    }

    public void getPrisonName(String stg) {
        final String nameOfThePrison = prisonName.getText();
        Assert.assertEquals("Name of the prison", stg, nameOfThePrison);
    }

}