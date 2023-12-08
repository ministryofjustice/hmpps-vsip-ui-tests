package uk.gov.justice.digital.hmpps.vsip;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication()
public class SpringSeleniumApplication {
    public static void main(String[] args) {

        new SpringApplicationBuilder(SpringSeleniumApplication.class)
                .web(WebApplicationType.NONE)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}