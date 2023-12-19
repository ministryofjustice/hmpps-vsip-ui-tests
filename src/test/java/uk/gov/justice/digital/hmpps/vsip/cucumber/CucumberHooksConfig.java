package uk.gov.justice.digital.hmpps.vsip.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

/**
 * This hooks class must be in the same package as the CucumberSpringContextConfig
 */
public class CucumberHooksConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CucumberHooksConfig.class);

    @Value("${browser:chrome}")
    private String targetBrowser;

    @LazyAutowired
    private TestContextService testContextService;

    @LazyAutowired
    private WebDriver webDriver;

    /**
     * Called for every Scenario
     */
    @Before
    public void initialise() {
        LOG.debug("Entered initialise deleteAllCookies");
        webDriver.manage().deleteAllCookies();
        testContextService.clearTestContext();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {

    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            LOG.debug("Entered afterStep" + scenario.getName() + " Failed therefore take screen shot");
            scenario.attach(testContextService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario() {
        LOG.debug("Entered afterScenario, quit web driver :" + targetBrowser);
        webDriver.quit();
    }

}