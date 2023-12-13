package uk.gov.justice.digital.hmpps.vsip;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication()
public class SpringSeleniumApplication {

    public static void main(String[] args) {

        // Web application Type cannot WebApplicationType.NONE as OAuth2 uses spring web
        new SpringApplicationBuilder(SpringSeleniumApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}