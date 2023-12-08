package uk.gov.justice.digital.hmpps.vsip.services;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyComponent;
import uk.gov.justice.digital.hmpps.vsip.util.Context;

import java.util.HashMap;
import java.util.Map;

import static java.lang.ThreadLocal.withInitial;

@LazyComponent
public class TestService {

    private static final ThreadLocal<Map<Context, Object>> testContexts = withInitial(HashMap::new);

    private static final Logger LOG = LoggerFactory.getLogger(TestService.class);

    @Autowired
    private ApplicationContext ctx;

    private static <T> T getFromContext(Context key) {
        Object object = testContexts.get().get(key);
        LOG.debug("Entered getFromContext Key :" + key + " Value :" + object);
        return (T) object;
    }

    public static <T> T setToContext(Context key, T object) {
        LOG.debug("Entered setToContext Key :" + key + " Value :" + object);
        testContexts.get().put(key, object);
        return object;
    }

    public static String getBookingReference() {
        return getFromContext(Context.BOOKING_REFERENCE);
    }

    public static String getTimeSlotDay() {
        return getFromContext(Context.SLOT_DATE_TIME);
    }

    public byte[] getScreenshot() {
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
