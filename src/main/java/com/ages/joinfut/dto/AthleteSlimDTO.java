package com.ages.joinfut.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AthleteSlimDTO {

    @ApiModelProperty(position = 1, notes = "Id do Atleta")
    private Long idAthlete;

    public Long getId() {
        return getIdAthlete();
    }
}
