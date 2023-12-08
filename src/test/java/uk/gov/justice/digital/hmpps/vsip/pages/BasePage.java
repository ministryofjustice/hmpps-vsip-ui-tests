package uk.gov.justice.digital.hmpps.vsip.pages;


import jakarta.annotation.PostConstruct;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyComponent;
import uk.gov.justice.digital.hmpps.vsip.services.CommonMethodService;
import uk.gov.justice.digital.hmpps.vsip.util.Configuration;
import uk.gov.justice.digital.hmpps.vsip.services.TestService;

@LazyComponent
public class BasePage {
    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected JavascriptExecutor javascriptExecutor;

    @LazyAutowired
    protected CommonMethodService methodsService;

    @LazyAutowired
    protected Configuration configuration;

    @LazyAutowired
    protected TestService testService;

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