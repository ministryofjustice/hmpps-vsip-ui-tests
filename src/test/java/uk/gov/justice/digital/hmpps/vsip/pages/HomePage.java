package uk.gov.justice.digital.hmpps.vsip.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@href='/search/prisoner']")
    private WebElement bookAVisitOption;

    @FindBy(how = How.XPATH, using = "//a[@href='/search/visit']")
    private WebElement findAVisitOption;

    @FindBy(how = How.XPATH, using = "//a[@href='/visits']")
    private WebElement viewVisitsOption;

    @FindBy(how = How.XPATH, using = "//a[@href='/review']")
    private WebElement findNeedAReviewOption;

    @FindBy(how = How.XPATH, using = "//*[contains(@data-test, 'need-review-count')]")
    private WebElement findNeedReviewCount;

    @FindBy(how = How.XPATH, using = "//a[@href='/search/visit']")
    private WebElement clickSearchByRefOption;

    @FindBy(how = How.XPATH, using = "//a[@href='/search/prisoner']")
    private WebElement clickSearchByPrisonNo;

    public void clickOnBookAVisitOption() {
        bookAVisitOption.click();
    }

    public void clickOnChangeAVisitOption() {
        findAVisitOption.click();
    }

    public void clickOnNeedAReviewOption() {
        findNeedAReviewOption.click();
    }

    public void clickOnViewVisitsByDateOption() {
        viewVisitsOption.click();
    }

    public void gotoHomePage() {
        navigateToPage(this.testContextService.getVsipUrl());
    }

    public void hasNeedReviewCount() {
        findNeedReviewCount.isDisplayed();
        String count = findNeedReviewCount.getText();
        Assert.assertTrue("Count should be greater than 0 value (" + count + ")", isPositiveNumber(count));
    }

    public void hasNoNeedReviewCount() {
        Assert.assertFalse("Count should be zero",findNeedReviewCount.isDisplayed());
    }

    public static boolean isPositiveNumber(String strNum) {
        if (strNum != null)
            try {
                return Integer.parseInt(strNum)>0;
            } catch (NumberFormatException nfe) {}
        return false;
    }

    public void clickOptionSearchByRef() {
        clickSearchByRefOption.click();
    }

    public void clickOptionSearchByPrisonNo() {
        clickSearchByPrisonNo.click();
    }

}