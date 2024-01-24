package uk.gov.justice.digital.hmpps.vsip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class NeedAReviewPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'govuk-details__summary-text')]")
    private WebElement summaryList;

    public void isSummaryListOptionDisplayed(String summaryList) {
        methodsService.isElementDisplayed("xpath", "//span[contains(@class, 'govuk-details__summary-text')]");
    }

    public void clickOnView()
    {
        methodsService.click("xpath","//a[text()='View']");
    }
    public void checkReviewMsg(String reviewMsg) {
        methodsService.isElementDisplayed("xpath","//h2[text()='Needs review']");
    }
}
