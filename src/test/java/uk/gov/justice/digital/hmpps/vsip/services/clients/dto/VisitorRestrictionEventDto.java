package uk.gov.justice.digital.hmpps.vsip.services.clients.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class VisitorRestrictionEventDto {
    @NotBlank
    private String visitorId;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    public VisitorRestrictionEventDto(String visitorId, LocalDate startDate, LocalDate endDate) {
        this.visitorId = visitorId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
