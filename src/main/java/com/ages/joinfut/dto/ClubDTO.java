package com.ages.joinfut.dto;

import com.ages.joinfut.model.Adress;
import com.ages.joinfut.model.NdaContract;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClubDTO {
    
    @ApiModelProperty(position = 1, notes = "Identificação única do Clube")
    private Long idClub;

    @ApiModelProperty(position = 2, notes = "Razão Social")
    private String corporateName;

    @ApiModelProperty(position = 3, notes = "Nome fantasia")
    private String fantasyName;

    @ApiModelProperty(position = 4, notes = "CNPJ")
    private String cnpj;

    @ApiModelProperty(position = 5, notes = "Endereço")
    private Adress adress;

    @ApiModelProperty(position = 6, notes = "Termo de confidencialidade")
    private NdaContract ndaContract;

    public ClubDTO() {}

    public Long getId() {
        return getIdClub();
    }
}
