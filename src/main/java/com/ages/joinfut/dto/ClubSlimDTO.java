package com.ages.joinfut.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClubSlimDTO {

    @ApiModelProperty(position = 1, notes = "Id do Clube")
    private Long idClub;

    public Long getId() {
        return getIdClub();
    }
}
