package uk.gov.justice.digital.hmpps.vsip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyComponent;

@LazyComponent
public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@href='/search/prisoner']")
    private WebElement bookAVisitOption;

    @FindBy(how = How.XPATH, using = "//a[@href='/search/visit']")
    private WebElement findAVisitOption;

    @FindBy(how = How.XPATH, using = "//a[@href='/visits']")
    private WebElement viewVisitsOption;

    public void clickOnBookAVisitOption() {
        bookAVisitOption.click();
    }

    public void clickOnChangeAVisitOption() {
        findAVisitOption.click();
    }

    public void clickOnViewVisitsByDateOption() {
        viewVisitsOption.click();
    }

}
