package uk.gov.justice.digital.hmpps.vsip.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static uk.gov.justice.digital.hmpps.vsip.config.WebDriverScope.WEB_DRIVER_SCOPE;

@Bean
@Scope(WEB_DRIVER_SCOPE)
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WebdriverScopeBean {
}