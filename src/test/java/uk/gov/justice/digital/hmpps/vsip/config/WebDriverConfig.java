package uk.gov.justice.digital.hmpps.vsip.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyConfiguration;
import uk.gov.justice.digital.hmpps.vsip.annotation.WebdriverScopeBean;
import uk.gov.justice.digital.hmpps.vsip.services.WebDriverService;

import java.time.Duration;

@LazyConfiguration
public class WebDriverConfig {

    @Value("${default.timeout:20}")
    private int timeout;
    @LazyAutowired
    private WebDriverService webDriverService;

    /**
     * Method as static to allow the bean to be created without first creating an instance of your @Configuration
     **/
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new WebdriverScopePostProcessor();
    }

    @WebdriverScopeBean
    @Primary
    public WebDriver createDriverBean() {
        return webDriverService.getWebDriver();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait webdriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofMillis(this.timeout));
    }
}