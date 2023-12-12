package uk.gov.justice.digital.hmpps.vsip.services.clients.dto;

import jakarta.validation.constraints.NotBlank;

public class PrisonerEventDto {

    @NotBlank
    private String prisonCode;

    @NotBlank
    private String prisonerCode;

    public PrisonerEventDto(String prisonCode, String prisonerCode) {
        this.prisonCode = prisonCode;
        this.prisonerCode = prisonerCode;
    }
}

