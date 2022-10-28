package com.ages.joinfut.dto;

import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.model.Subgroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AthleteSubgroupDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Atleta Subgrupo")
    private Long idAthelteSubgroup;

    @ApiModelProperty(position = 2, notes = "Identificação única do Atleta")
    private Athlete idAthlete;

    @ApiModelProperty(position = 3, notes = "Identificação única do Subgroup")
    private Subgroup idSubgroup;

    public AthleteSubgroupDTO() {}

    public Long getId() { return getIdAthelteSubgroup(); }

}
