package uk.gov.justice.digital.hmpps.vsip.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyConfiguration;
import uk.gov.justice.digital.hmpps.vsip.util.Configuration;
import uk.gov.justice.digital.hmpps.vsip.util.Environment;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

@LazyConfiguration
public class SpringBeansConfigs {

    @LazyAutowired
    private TestContextService testContextService;

    @Value("${environment:STAGING}")
    private Environment environment;

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