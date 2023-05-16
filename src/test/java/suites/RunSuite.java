package suites;

import io.cucumber.testng.CucumberOptions;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
@CucumberOptions(
		plugin = {"html:target/cucumberHtmlReport"},
//		pretty:target/cucumber-json-report.json **Cucumber-Reports**
		features = "classpath:features",
		glue = {"info.seleniumcucumber.stepdefinitions"}
)

public class RunSuite {
}
