package uk.gov.justice.digital.hmpps.vsip.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.justice.digital.hmpps.vsip.services.clients.PrisonVisitsTestingHelperClient;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.CreateNotificationEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.NonAssociationEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerReceivedEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerReleasedEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerAlertCreatedUpdatedEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerRestrictionEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.VisitorRestrictionEventDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



@Service
public class PrisonVisitsTestingHelperService {

    final static  String SQS_PRISONER_RECEIVED = "/test/prisoner/received";

    private static final Logger LOG = LoggerFactory.getLogger(PrisonVisitsTestingHelperService.class);
    @Autowired
    protected PrisonVisitsTestingHelperClient client;
    @Autowired
    protected TestContextService context;

    private final DateTimeFormatter jsonDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public void startPrisonerReleased(String prisonCode, String prisonerCode, String reason) {
        PrisonerReleasedEventDto request = new PrisonerReleasedEventDto(prisonCode, prisonerCode, reason);
        client.put("/test/prisoner/released", request, client.validateCreateStatusHandler, "Prisoner release not created");
    }

    public void startPrisonerReceived(String prisonerCode, String prisonCode, String reason) {
        PrisonerReceivedEventDto request = new PrisonerReceivedEventDto(prisonerCode, prisonCode, reason.toUpperCase());

        client.put(SQS_PRISONER_RECEIVED, request, client.validateCreateStatusHandler, "Prisoner received not created");
    }

    public void startPrisonerNonAssociation(String prisonerCode, String nonAssociationPrisonerCode) {
        NonAssociationEventDto request = new NonAssociationEventDto(prisonerCode, nonAssociationPrisonerCode);

        client.put("/test/prisoner/non-association", request, client.validateCreateStatusHandler, "");
    }

    /**
     * @param visitorId
     * @param startDateStr
     * @param endDateStr   can be null
     */
    public void startVisitorRestriction(String visitorId,
                                        String startDateStr,
                                        String endDateStr) {

        LocalDate endDate = endDateStr != null ? LocalDate.parse(endDateStr) : null;

        VisitorRestrictionEventDto request = new VisitorRestrictionEventDto(visitorId, LocalDate.parse(startDateStr), endDate);
        client.put("/test/visitor/restriction", request, client.validateCreateStatusHandler, "Visitor restriction not created");
    }

    /**
     * @param prisonerCode
     * @param startDateStr
     * @param endDateStr   can be null
     */
    public void startPrisonerRestriction(String prisonerCode,
                                         String startDateStr,
                                         String endDateStr) {

        LocalDate endDate = endDateStr != null ? LocalDate.parse(endDateStr) : null;

        PrisonerRestrictionEventDto request = new PrisonerRestrictionEventDto(prisonerCode, LocalDate.parse(startDateStr), endDate);
        client.put("/test/prisoner/restriction", request, client.validateCreateStatusHandler, "Prisoner restriction not created");
    }

    public void startPrisonerRestriction(String prisonerCode) {

        PrisonerRestrictionEventDto request = new PrisonerRestrictionEventDto(prisonerCode, LocalDate.now(), null);
        client.put("/test/prisoner/restriction", request, client.validateCreateStatusHandler, "Prisoner restriction not created");
    }


    public void addVisitExcludeDateEvent(String prisonCode, LocalDate date) {
        LOG.debug("Enter addVisitExcludeDateEvent: " + date);
        CreateNotificationEventDto request = new CreateNotificationEventDto("PRISON_VISITS_BLOCKED_FOR_DATE");
        var jsonDate = jsonDateFormatter.format(date);
        client.put("/test/prison/"+ prisonCode +"/add/exclude-date/"+ jsonDate, request, client.validateCreateStatusHandler, "");
    }

    public void removeVisitExcludeDateEvent(String prisonCode, LocalDate date) {
        LOG.debug("Enter removeVisitExcludeDateEvent: " + date);
        CreateNotificationEventDto request = new CreateNotificationEventDto("PRISON_VISITS_BLOCKED_FOR_DATE");
        var jsonDate = jsonDateFormatter.format(date);
        client.put("/test/prison/"+ prisonCode +"/remove/exclude-date/"+ jsonDate, request, client.validateCreateStatusHandler, "");
    }

    public void updateModifyTimestampOfApplication(String applicationReference,  LocalDateTime updatedModifyTimestamp) {
        LOG.debug("Enter updateModifyTimestampOfApplication");
        client.updateModifyTimestamp(applicationReference, updatedModifyTimestamp);
        LOG.debug("Exit updateModifyTimestampOfApplication");
    }

    public void changeVisitPrison(String bookingReference, String prisonCode) {
        LOG.debug("Enter changeVisitPrison {} {}", bookingReference, prisonCode);
        client.changeVisitPrison(bookingReference, prisonCode);
        LOG.debug("Exit changeVisitPrison");
    }

    public void createSessionTemplate(String prisonCode,
                                      LocalDateTime sessionStartDateTime,
                                      Integer weeklyFrequency,
                                      Integer closedCapacity,
                                      Integer openCapacity,
                                      String locationLevels,
                                      String incentive,
                                      String category,
                                      Boolean disableAllOtherSessionsForSlotAndPrison) {
        LOG.debug("Enter changeVisitPrison {} {} {} {} {} {} {} {} {}", prisonCode, sessionStartDateTime,weeklyFrequency,closedCapacity, openCapacity,locationLevels,incentive,category,disableAllOtherSessionsForSlotAndPrison);
        var sessionReference = client.createSessionTemplate(prisonCode, sessionStartDateTime,weeklyFrequency,closedCapacity, openCapacity,locationLevels,incentive,category,disableAllOtherSessionsForSlotAndPrison);
        context.setSessionTemplateReference(sessionReference);
        LOG.debug("Exit changeVisitPrison");
    }


    public void changeClosedSessionSlotCapacityForApplication(String applicationReference, Integer capacity) {
         LOG.debug("Enter changeClosedSessionSlotCapacityForApplication {} {}", applicationReference, capacity);
         client.changeClosedSessionSlotCapacityForApplication(applicationReference, capacity);
         LOG.debug("Exit changeClosedSessionSlotCapacityForApplication");
    }

    public void changeOpenSessionSlotCapacityForApplication(String applicationReference, Integer capacity) {
        LOG.debug("Enter changeClosedSessionSlotCapacityForApplication {} {}", applicationReference, capacity);
        client.changeOpenSessionSlotCapacityForApplication(applicationReference, capacity);
        LOG.debug("Exit changeClosedSessionSlotCapacityForApplication");
    }

    public void startAlertsUpdated(String prisonCode, List<String> alertsAdded, List<String> alertsRemoved) {
        String description = alertsAdded.size() + " alert(s) added.";
        PrisonerAlertCreatedUpdatedEventDto request = new PrisonerAlertCreatedUpdatedEventDto(prisonCode, description, alertsAdded, alertsRemoved);
        client.put("/test/prisoner/alerts/updated", request, client.validateCreateStatusHandler, "Prisoner alerts updated");
    }


    public void cleanUp() {
        LOG.debug("Entered cleanUpLastBooking");
        if (context.getBookingReferences()!=null) {
            var bookings = new ArrayList<>(context.getBookingReferences());
            if (bookings != null) {
                    LOG.debug(bookings.size() + " Bookings found, must tidy up!");
                    bookings.forEach(bookingReference -> {
                    client.deleteVisits(bookingReference);
                    // Remove reference from context
                    context.getBookingReferences().remove(bookingReference);
                });
            }
        }

        if (context.getApplicationReferences()!=null) {
            var applicationReferences = new ArrayList<>(context.getApplicationReferences());
            if (applicationReferences != null) {
                    LOG.debug(applicationReferences.size() + " Application found, must tidy up!");
                    applicationReferences.forEach(applicationReference -> {
                    client.deleteApplication(applicationReference);
                   // Remove reference from context
                   context.getApplicationReferences().remove(applicationReference);
                });
            }
        }

        if (context.getBookingCapacity() != null) {
            context.setBookingCapacity(null);
        }

        if (context.getBookingDate()!=null) {
            // TODO need to add a booking object to context that holds booking ref, booking date extra
        }

        if (context.getSessionTemplateReferences()!=null) {
            // This must be done after visits have been deleted
            var sessionTemplateReferences = new ArrayList<>(context.getSessionTemplateReferences());
            if (sessionTemplateReferences != null) {
                LOG.debug(sessionTemplateReferences.size() + " Session template references, must tidy up!");
                sessionTemplateReferences.forEach(sessionTemplateReference -> {
                    client.deleteSessionTemplate(sessionTemplateReference);
                    // Remove reference from context
                    context.getSessionTemplateReferences().remove(sessionTemplateReference);
                });
            }
        }

    }


    public String getSlotDataTestValue(LocalDate localDate, int startSlot, int endSlot) {
        var startTime = LocalTime.of(startSlot,0);
        var endTime = LocalTime.of(endSlot,0);
        var formatter = DateTimeFormatter.ofPattern("ha");

        //Format as follows <2024-07-13 - 9am to 11am>
        final StringBuilder buffer = new StringBuilder();
        buffer.append(localDate.toString());
        buffer.append(" - ");
        buffer.append(startTime.format(formatter));
        buffer.append(" to ");
        buffer.append(endTime.format(formatter));

        //    2024-07-13 - 9am to 11am
        return buffer.toString();
    }
}
