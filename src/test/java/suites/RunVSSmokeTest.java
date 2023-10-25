package suites;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Created by Anusha Nagula on 09/10/23.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@smoke_tests_vs",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunVSSmokeTest extends AbstractTestNGCucumberTests {

}
