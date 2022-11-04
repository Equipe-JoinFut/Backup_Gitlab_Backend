package com.ages.joinfut.dto;

import com.ages.joinfut.model.ClubSlim;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SieveDTO {
    @ApiModelProperty(position = 1, notes = "Identificação única da peneira")
    private Long idSieve;

    @ApiModelProperty(position = 2, notes = "Identificacao do Clube que criou a peneira")
    private ClubSlim club;

    @ApiModelProperty(position = 3, notes = "local da peneira")
    private String local;
}