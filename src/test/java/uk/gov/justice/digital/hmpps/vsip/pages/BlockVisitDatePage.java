package uk.gov.justice.digital.hmpps.vsip.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class BlockVisitDatePage extends BasePage {
    @FindBy(how = How.ID, using = "date")
    private WebElement blockDate;

    @FindBy(how = How.ID, using = "confirmBlockDate")
    private WebElement confirmedBlockDate;

    @FindBy(how = How.CLASS_NAME, using = "moj-banner__message")
    private WebElement mojBannerMessage;

    @FindBy(how = How.CLASS_NAME, using = "govuk-error-summary__body")
    private WebElement alreadyBlockedError;

    public void enterDateToBlock(String dateToBlockVisit) {
        blockDate.sendKeys(dateToBlockVisit);
    }

    public void clickConfirmBlockDate() {
        confirmedBlockDate.click();
    }

    public void getConfirmationMessage(String stg) {
        final String blockVisitStatus = mojBannerMessage.getText();
        Assert.assertEquals("block visit date status", stg, blockVisitStatus);
    }

    public void clickOnUnblockBtn() {
        methodsService.click("xpath", "//button[contains(@data-test,'unblock-date-1')]");
    }

    public void alreadyBlockedErrorMessage(String stg) {
        final String blockVisitError = alreadyBlockedError.getText();
        Assert.assertEquals("error message is not displayed", stg, blockVisitError);
    }
}
