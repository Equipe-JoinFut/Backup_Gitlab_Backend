package com.ages.joinfut.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    private AdressDTO adress;

    // ndaContract ainda nao foi criado
    // @ApiModelProperty(position = 7, notes = "Termo de confidencialidade")
    // private NdaContract ndaContract;

    public ClubDTO() {}

    public Long getId() {
        return getIdClub();
    }
}
