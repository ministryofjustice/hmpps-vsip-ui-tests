package uk.gov.justice.digital.hmpps.vsip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.justice.digital.hmpps.vsip.services.clients.PrisonVisitsTestingHelperClient;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.NonAssociationEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerRestrictionEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.VisitorRestrictionEventDto;

import java.time.LocalDate;

@Service
public class PrisonVisitsTestingHelperService {

    @Autowired
    protected PrisonVisitsTestingHelperClient client;

    public void  startPrisonerReleased(String prisonCode, String prisonerCode) {
        PrisonerEventDto request = new PrisonerEventDto(prisonCode,prisonerCode);
        client.put("/test/prisoner/released", request, client.validateCreateStatusHandler, "Prisoner release not created");
    }

    public void  startPrisonerReceived(String prisonCode, String prisonerCode) {
        PrisonerEventDto request = new PrisonerEventDto(prisonCode,prisonerCode);

        client.put("/test/prisoner/received", request, client.validateCreateStatusHandler, "Prisoner received not created");
    }

    public void  startPrisonerNonAssociation(String prisonerCode, String nonAssociationPrisonerCode) {
        NonAssociationEventDto request = new NonAssociationEventDto(prisonerCode,nonAssociationPrisonerCode);

        client.put("/test/prisoner/non-association", request, client.validateCreateStatusHandler, "");
    }

    /**
     *
     * @param visitorId
     * @param startDateStr
     * @param endDateStr can be null
     */
    public void  startVisitorRestriction(String visitorId,
                                       String startDateStr,
                                       String endDateStr) {

        LocalDate endDate = endDateStr!=null ? LocalDate.parse(endDateStr) : null;

        VisitorRestrictionEventDto request = new VisitorRestrictionEventDto(visitorId, LocalDate.parse(startDateStr) , endDate);
        client.put("/test/visitor/restriction", request, client.validateCreateStatusHandler, "Visitor restriction not created");
    }

    /**
     *
     * @param prisonerCode
     * @param startDateStr
     * @param endDateStr can be null
     */
    public void startPrisonerRestriction(String prisonerCode,
                                       String startDateStr,
                                       String endDateStr) {

        LocalDate endDate = endDateStr!=null ? LocalDate.parse(endDateStr) : null;

        PrisonerRestrictionEventDto request = new PrisonerRestrictionEventDto(prisonerCode,LocalDate.parse(startDateStr) , endDate);
        client.put("/test/prisoner/restriction", request, client.validateCreateStatusHandler, "Prisoner restriction not created");
    }

    public void startPrisonerRestriction(String prisonerCode) {

        PrisonerRestrictionEventDto request = new PrisonerRestrictionEventDto(prisonerCode,LocalDate.now() , null);
        client.put("/test/prisoner/restriction", request, client.validateCreateStatusHandler, "Prisoner restriction not created");
    }
}
