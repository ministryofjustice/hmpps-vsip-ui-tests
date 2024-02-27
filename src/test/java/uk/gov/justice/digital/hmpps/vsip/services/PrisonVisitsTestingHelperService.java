package uk.gov.justice.digital.hmpps.vsip.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.justice.digital.hmpps.vsip.services.clients.PrisonVisitsTestingHelperClient;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.CreateNotificationEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.NonAssociationEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerRestrictionEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.VisitStatus;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.VisitorRestrictionEventDto;

import java.time.LocalDate;

@Service
public class PrisonVisitsTestingHelperService {

    private static final Logger LOG = LoggerFactory.getLogger(PrisonVisitsTestingHelperService.class);
    @Autowired
    protected PrisonVisitsTestingHelperClient client;
    @Autowired
    protected TestContextService context;

    public void startPrisonerReleased(String prisonCode, String prisonerCode) {
        PrisonerEventDto request = new PrisonerEventDto(prisonCode, prisonerCode);
        client.put("/test/prisoner/released", request, client.validateCreateStatusHandler, "Prisoner release not created");
    }

    public void startPrisonerReceived(String prisonCode, String prisonerCode) {
        PrisonerEventDto request = new PrisonerEventDto(prisonCode, prisonerCode);

        client.put("/test/prisoner/received", request, client.validateCreateStatusHandler, "Prisoner received not created");
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

    public void cleanUpBookings() {
        LOG.debug("Entered cleanUpLastBooking");
        var bookings = context.getBookingReferences();
        if (bookings != null) {
            LOG.debug(bookings.size() + " Bookings found, must tidy up!");
            // We use changing here because it is not counted as part of booking slot counts and is also removed after configured time.
            bookings.forEach(bookingReference -> client.changeStatus(bookingReference, VisitStatus.CHANGING));
        }
    }

    public void addVisitExcludeDateEvent(String visitReference) {
        CreateNotificationEventDto request = new CreateNotificationEventDto("PRISON_VISITS_BLOCKED_FOR_DATE");

        client.put("/test/visit/"+ visitReference + "/notifications", request, client.validateCreateStatusHandler, "");
    }
}
