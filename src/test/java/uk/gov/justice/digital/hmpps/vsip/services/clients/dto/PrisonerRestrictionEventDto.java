package uk.gov.justice.digital.hmpps.vsip.services.clients.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class PrisonerRestrictionEventDto {


    @NotBlank
    private String prisonerCode;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    public PrisonerRestrictionEventDto(String prisonerCode, LocalDate startDate, LocalDate endDate) {
        this.prisonerCode = prisonerCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
