package com.ages.joinfut.dto;

import com.ages.joinfut.model.Club;
import com.ages.joinfut.model.Subgroup;
import com.ages.joinfut.service.SubgroupService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubgroupDTO {

    @ApiModelProperty(position = 1, notes = "Identificacão Unica do Subgrupo")
    private Long idSubgroup;

    @ApiModelProperty(position = 2, notes = "Nome do Subgrupo")
    private String subGroupName;

    @ApiModelProperty(position = 3, notes = "Identificacao do Clube que criou o Subgrupo")
    private Club club;

    public SubgroupDTO(){}
    public SubgroupDTO(Subgroup subgroup){
        SubgroupService subgroupService = new SubgroupService();
        SubgroupDTO subgroupDTO = subgroupService.DTODataConverter(subgroup);
    }
    public Long getId(){
        return getIdSubgroup();
    }



}
