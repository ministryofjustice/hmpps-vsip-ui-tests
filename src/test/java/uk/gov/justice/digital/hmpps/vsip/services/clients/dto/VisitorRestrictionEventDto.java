package uk.gov.justice.digital.hmpps.vsip.services.clients.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record VisitorRestrictionEventDto(
        @NotBlank
        String visitorId,
        @NotBlank
        LocalDate startDate,
        @NotBlank
        LocalDate endDate
) {
}
