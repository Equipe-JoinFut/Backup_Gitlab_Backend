package com.ages.joinfut.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubSlimDTO {

    @ApiModelProperty(position = 1, notes = "Id do Clube")
    private Long idClub;

    public Long getId() {
        return getIdClub();
    }
}
