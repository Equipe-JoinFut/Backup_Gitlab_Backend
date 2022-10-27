package com.ages.joinfut.dto;

import com.ages.joinfut.Enum.State;
import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.model.Club;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdressDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Endereço")
    private Long idAdress;

    @ApiModelProperty(position = 2, notes = "Atleta")
    private Athlete athlete;

    @ApiModelProperty(position = 3, notes = "Clube")
    private Club club;

    @ApiModelProperty(position = 3, notes = "Informações do endereço")
    private String streetInfo;

    @ApiModelProperty(position = 4, notes = "Nome da cidade")
    private String city;

    @ApiModelProperty(position = 5, notes = "Estado")
    private State state;

    public AdressDTO() {}

    public Long getId() {
        return getIdAdress();
    }
}
