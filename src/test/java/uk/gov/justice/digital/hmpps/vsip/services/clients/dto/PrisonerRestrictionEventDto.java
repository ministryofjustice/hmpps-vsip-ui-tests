package uk.gov.justice.digital.hmpps.vsip.services.clients.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PrisonerRestrictionEventDto(@NotBlank String prisonerCode, @NotBlank LocalDate startDate,
                                          @NotBlank LocalDate endDate) {
}
