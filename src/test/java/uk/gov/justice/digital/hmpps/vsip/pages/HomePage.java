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

    public void clickOnBookAVisitOption() {
        bookAVisitOption.click();
    }

    public void clickOnChangeAVisitOption() {
        findAVisitOption.click();
    }
    public void clickOnNeedAReviewOption(){
        findNeedAReviewOption.click();
    }
    public void clickOnViewVisitsByDateOption() {
        viewVisitsOption.click();
    }

    public void gotoHomePage() {
       navigateToPage(this.testContextService.getVsipUrl());
    }

    public void hashNeedReviewCount() {
        String count = findNeedReviewCount.getText();
        Assert.assertTrue("Count should be greater than 0 value (" + count+")", Integer.parseInt(count.trim()) > 0);
    }
}