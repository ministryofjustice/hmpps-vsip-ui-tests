package uk.gov.justice.digital.hmpps.vsip.services.clients.dto;

import jakarta.validation.constraints.NotBlank;

public record NonAssociationEventDto(@NotBlank String prisonerCode, @NotBlank String nonAssociationPrisonerCode) {}
