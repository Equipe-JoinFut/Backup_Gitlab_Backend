package com.ages.joinfut.dto;

import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.model.AthleteConfirmation;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AthleteConfirmationDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do status (accept/reject) do atleta")
    private Long idAthleteConfirmation;

    @ApiModelProperty(position = 2, notes = "Atleta a qual pertence esse status")
    private Athlete athlete;

    @ApiModelProperty(position = 3, notes = "Atleta vai comparecer na pré-seleção? (Sim/Não)")
    private Boolean athlete_confirmed_reject;

    // @ApiModelProperty(position = 4, notes = "Pré seleção que engloba esse atleta")
    // private Sieve sieve;

    public AthleteConfirmationDTO() {}

    public Long getId() { return getIdAthleteConfirmation(); }
}
