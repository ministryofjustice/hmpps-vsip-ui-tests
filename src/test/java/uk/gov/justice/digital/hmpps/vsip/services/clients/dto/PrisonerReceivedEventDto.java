package uk.gov.justice.digital.hmpps.vsip.services.clients.dto;

import jakarta.validation.constraints.NotBlank;

public record PrisonerReceivedEventDto(@NotBlank String prisonerCode, @NotBlank String prisonCode, @NotBlank String reason) {

}
