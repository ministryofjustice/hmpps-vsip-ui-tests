package suites;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Created by Anusha Nagula on 15/05/23.
 */

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@suite",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunSuite extends AbstractTestNGCucumberTests {

}