package uk.gov.justice.digital.hmpps.vsip.services;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.util.Context;

import java.util.HashMap;
import java.util.Map;


/**
 * Avoid putting web driver instance in this as the instance may have been recreated when session expires.
 */
@Service
public class TestContextService {

    private static Map<Context,Object>  testContext = new HashMap<>();

    private static final Logger LOG = LoggerFactory.getLogger(TestContextService.class);

    @LazyAutowired
    private ApplicationContext ctx;

    public TestContextService() {
        LOG.debug("Entered TestService created");
    }

    private <T> T getFromContext(Context key) {
        Object object = testContext.get(key);
        LOG.debug("Entered getFromContext Key :" + key + " Value :" + object);
        return (T) object;
    }

    public <T> T setToContext(Context key, T object) {
        LOG.debug("Entered setToContext Key :" + key + " Value :" + object);
        testContext.put(key, object);
        return object;
    }

    public String getBookingReference() {
        return getFromContext(Context.BOOKING_REFERENCE);
    }

    public String getTimeSlotDay() {
        return getFromContext(Context.SLOT_DATE_TIME);
    }

    public void clearTestContext() {
        LOG.debug("Entered clearTestContext()");
        testContext.clear();
    }

    public byte[] getScreenshot() {
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
