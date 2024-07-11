package uk.gov.justice.digital.hmpps.vsip.services;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Avoid putting web driver instance in this as the instance may have been recreated when session expires.
 */
@Service
public class TestContextService {

    private static final Logger LOG = LoggerFactory.getLogger(TestContextService.class);
    private static final Map<Context, Object> testContext = new HashMap<>();
    @Value("${vsip.ui-to-test.url}")
    private String vsipUiUrl;

    @LazyAutowired
    private ApplicationContext ctx;

    @LazyAutowired
    private PrisonVisitsTestingHelperService prisonVisitsTestingHelperService;

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
        List<String> bookings = getFromContext(Context.BOOKING_REFERENCE);
        if (bookings != null && !bookings.isEmpty()) {
            return bookings.getLast();
        }
        return null;
    }

    public void setBookingReference(String bookingReference) {
        List<String> bookings = getFromContext(Context.BOOKING_REFERENCE);
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        bookings.add(bookingReference);
        this.setToContext(Context.BOOKING_REFERENCE, bookings);
    }

    public void setSessionTemplateReference(String sessionTemplateReference) {
        List<String> bookings = getFromContext(Context.SESSION_TEMPLATE_REFERENCE);
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        bookings.add(sessionTemplateReference);
        this.setToContext(Context.SESSION_TEMPLATE_REFERENCE, bookings);
    }

    public String getSessionTemplateReference() {
        List<String> applications = getFromContext(Context.SESSION_TEMPLATE_REFERENCE);
        if (applications != null && !applications.isEmpty()) {
            return applications.getLast();
        }
        return null;
    }

    public String getApplicationReference() {
        List<String> applications = getFromContext(Context.APPLICATION_REFERENCE);
        if (applications != null && !applications.isEmpty()) {
            return applications.getLast();
        }
        return null;
    }

    public void setApplicationReference(String bookingReference) {
        List<String> applications = getFromContext(Context.APPLICATION_REFERENCE);
        if (applications == null) {
            applications = new ArrayList<>();
        }
        applications.add(bookingReference);
        this.setToContext(Context.APPLICATION_REFERENCE, applications);
    }

    public LocalDate getBookingDate() {
        return getFromContext(Context.BOOKING_DATE);
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.setToContext(Context.BOOKING_DATE, bookingDate);
    }

    public String getBookingCapacity() {
        return getFromContext(Context.BOOKING_CAPACITY);
    }

    public void setBookingCapacity(String bookingCapacity) {
        this.setToContext(Context.BOOKING_CAPACITY, bookingCapacity);
    }

    public List<String> getBookingReferences() {
        return getFromContext(Context.BOOKING_REFERENCE);
    }

    public List<String> getApplicationReferences() {
        return getFromContext(Context.APPLICATION_REFERENCE);
    }

    public List<String> getSessionTemplateReferences() {
        return getFromContext(Context.SESSION_TEMPLATE_REFERENCE);
    }

    public String getTimeSlotDay() {
        return getFromContext(Context.SLOT_DATE_TIME);
    }

    public void clearTestContext() {
        LOG.debug("Entered clearTestContext()");
        prisonVisitsTestingHelperService.cleanUp();
    }

    public byte[] getScreenshot() {
        return ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

    public String getVsipUrl() {
        return this.vsipUiUrl;
    }
}
