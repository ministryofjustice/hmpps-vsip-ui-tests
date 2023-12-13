package uk.gov.justice.digital.hmpps.vsip.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod;
import uk.gov.justice.digital.hmpps.vsip.SpringSeleniumApplication;

/**
 * This spring boot test must be in the same package as the CucumberHooksConfig
 */
@SpringBootTest(classes = SpringSeleniumApplication.class, useMainMethod = UseMainMethod.ALWAYS)
@CucumberContextConfiguration()
public class CucumberSpringContextConfig {

}
