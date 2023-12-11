package uk.gov.justice.digital.hmpps.vsip.pages;


import jakarta.annotation.PostConstruct;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;
import uk.gov.justice.digital.hmpps.vsip.services.CommonMethodService;
import uk.gov.justice.digital.hmpps.vsip.util.Configuration;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

@ComponentWithWebDriver
public class BasePage {

    @LazyAutowired
    protected WebDriver driver;

    @LazyAutowired
    protected WebDriverWait wait;

    @LazyAutowired
    protected JavascriptExecutor javascriptExecutor;

    @LazyAutowired
    protected CommonMethodService methodsService;

    @LazyAutowired
    protected Configuration configuration;

    @LazyAutowired
    protected TestContextService testContextService;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void isPageTitleDisplayed(String pageTitle) {
        String currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle, pageTitle);
    }

    public void verifyHeading(String text) {
        driver.findElement(By.cssSelector("h1")).getText().equals(text);
    }

}