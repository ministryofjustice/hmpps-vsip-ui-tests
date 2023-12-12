package uk.gov.justice.digital.hmpps.vsip.services.clients.dto;

import jakarta.validation.constraints.NotBlank;

public class NonAssociationEventDto {

    @NotBlank
    private String prisonerCode;

    @NotBlank
    private String nonAssociationPrisonerCode;

    public NonAssociationEventDto(String prisonerCode, String nonAssociationPrisonerCode) {
        this.prisonerCode = prisonerCode;
        this.nonAssociationPrisonerCode = nonAssociationPrisonerCode;
    }
}
