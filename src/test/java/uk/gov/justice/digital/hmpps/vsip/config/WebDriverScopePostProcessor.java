package uk.gov.justice.digital.hmpps.vsip.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import static uk.gov.justice.digital.hmpps.vsip.config.WebDriverScope.WEB_DRIVER_SCOPE;

public class WebDriverScopePostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(WEB_DRIVER_SCOPE, new WebDriverScope());
    }
}