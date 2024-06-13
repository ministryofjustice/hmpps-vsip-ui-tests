package uk.gov.justice.digital.hmpps.vsip.services.clients.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PrisonerAlertCreatedUpdatedEventDto(
  @NotBlank
  String prisonerCode,

  @NotNull
  String description,

  @NotNull
  List<String> alertsAdded,

  @NotNull
  List<String> alertsRemoved
) {

}
