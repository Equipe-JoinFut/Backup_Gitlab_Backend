package com.ages.joinfut.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubgroupDTO {

    @ApiModelProperty(position = 1, notes = "Identificacão Unica do Subgrupo")
    private Long idSubgroup;

    @ApiModelProperty(position = 2, notes = "Nome do Subgrupo")
    private String subgroupName;

    @ApiModelProperty(position = 3, notes = "Identificacao do Clube que criou o Subgrupo")
    private ClubDTO club;

    public SubgroupDTO(){}

    public Long getId(){
        return getIdSubgroup();
    }



}
