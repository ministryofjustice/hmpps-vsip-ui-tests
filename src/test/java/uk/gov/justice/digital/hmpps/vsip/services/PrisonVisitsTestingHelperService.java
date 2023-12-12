package uk.gov.justice.digital.hmpps.vsip.services;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.gov.justice.digital.hmpps.vsip.services.clients.PrisonVisitsTestingHelperClient;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.NonAssociationEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.PrisonerRestrictionEventDto;
import uk.gov.justice.digital.hmpps.vsip.services.clients.dto.VisitorRestrictionEventDto;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class PrisonVisitsTestingHelperService {

    @Autowired
    protected PrisonVisitsTestingHelperClient client;

    public void  startPrisonerReleased(String prisonCode, String prisonerCode) {
        PrisonerEventDto request = new PrisonerEventDto(prisonCode,prisonerCode);
        client.put("/test/visitor/restriction", request, client.statusCreatedHandler , "Prisoner release not created");
    }

    public void  startPrisonerReceived(String prisonCode, String prisonerCode) {
        PrisonerEventDto request = new PrisonerEventDto(prisonCode,prisonerCode);

        client.put("/test/prisoner/received", request, client.statusCreatedHandler , "Prisoner received not created");
    }

    public void  startPrisonerNonAssociation(String prisonerCode, String nonAssociationPrisonerCode) {
        NonAssociationEventDto request = new NonAssociationEventDto(prisonerCode,nonAssociationPrisonerCode);

        client.put("/test/prisoner/non-association", request, client.statusCreatedHandler , "");
    }

    /**
     *
     * @param visitorId
     * @param startDate format 2007-12-03
     * @param endDate format 2007-12-03
     */
    public void  startVisitorRestriction(String visitorId,
                                       String startDate,
                                       String endDate) {
        VisitorRestrictionEventDto request = new VisitorRestrictionEventDto(visitorId, LocalDate.parse(startDate) , LocalDate.parse(endDate));
        client.put("/test/visitor/restriction", request, client.statusCreatedHandler , "Visitor restriction not created");
    }

    /**
     *
     * @param prisonerCode
     * @param startDate format 2007-12-03
     * @param endDate format 2007-12-03
     */
    public void startPrisonerRestriction(String prisonerCode,
                                       String startDate,
                                       String endDate) {
        PrisonerRestrictionEventDto request = new PrisonerRestrictionEventDto(prisonerCode,LocalDate.parse(startDate) , LocalDate.parse(endDate));
        client.put("/test/prisoner/restriction", request, client.statusCreatedHandler , "Prisoner restriction not created");
    }

}
