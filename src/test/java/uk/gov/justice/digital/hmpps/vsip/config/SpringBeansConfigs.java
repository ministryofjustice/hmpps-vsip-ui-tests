package uk.gov.justice.digital.hmpps.vsip.config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyConfiguration;
import uk.gov.justice.digital.hmpps.vsip.util.Configuration;
import uk.gov.justice.digital.hmpps.vsip.util.Environment;
import uk.gov.justice.digital.hmpps.vsip.services.TestService;

@LazyConfiguration
public class SpringBeansConfigs {

    @LazyAutowired
    private TestService testService;


    @Value("${environment:STAGING}")
    private Environment environment;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JavascriptExecutor javascriptExecutor(WebDriver driver) {
        return (JavascriptExecutor) driver;
    }


    @Bean
    public Configuration getConfiguration() {
        switch (environment) {
            case DEV:
                return new Configuration(
                        "https://manage-prison-visits-dev.prison.service.justice.gov.uk/",
                        10
                );
            case LOCAL:
                return new Configuration(
                        "http://localhost:3000/",
                        10
                );
            case STAGING:
                return new Configuration(
                        "https://manage-prison-visits-staging.prison.service.justice.gov.uk/",
                        10
                );
            default:
                throw new IllegalArgumentException("Environment '" + environment + "' not known");
        }
    }
}