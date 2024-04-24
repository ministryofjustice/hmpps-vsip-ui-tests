package uk.gov.justice.digital.hmpps.vsip.services;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Avoid putting web driver instance in this as the instance may have been recreated when session expires.
 */
@Component
public class DateUtilService {

    private static final Logger LOG = LoggerFactory.getLogger(DateUtilService.class);

    private final DateTimeFormatter jsonDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final DateTimeFormatter bookingDateFormatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy");

    private final DateTimeFormatter calendarDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LocalDate getBookingDate(String bookingDate)
    {
        return LocalDate.parse(bookingDate, bookingDateFormatter);
    }

    public String getJsonDateStr(LocalDate bookingDate)
    {
        return jsonDateFormatter.format(bookingDate);
    }

    public String getBookingDateStr(LocalDate bookingDate)
    {
        return bookingDateFormatter.format(bookingDate);
    }

    public String getCalendarDateStr(LocalDate bookingDate)
    {
        return calendarDateFormatter.format(bookingDate);
    }

}
