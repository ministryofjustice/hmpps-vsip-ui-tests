package uk.gov.justice.digital.hmpps.vsip.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.services.TestService;

/**
 * This hooks class must be in the same package as the CucumberSpringContextConfig
 */
public class CucumberHooksConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CucumberHooksConfig.class);

    @LazyAutowired
    private TestService testService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @LazyAutowired
    private WebDriver webDriver;

    @Before
    public void initialise(){
        LOG.debug("Entered initialise deleteAllCookies");
        webDriver.manage().deleteAllCookies();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            LOG.debug("Entered afterStep" + scenario.getName() + " Failed therefore take screen shot");
            scenario.attach(this.testService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario() {
        LOG.debug("Entered afterScenario : quit web driver");
        webDriver.quit();
    }

}