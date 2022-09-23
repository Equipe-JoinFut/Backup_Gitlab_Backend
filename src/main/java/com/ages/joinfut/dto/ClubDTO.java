package com.ages.joinfut.dto;

import com.ages.joinfut.model.Adress;
import com.ages.joinfut.model.Club;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubDTO {
    
    @ApiModelProperty(position = 1, notes = "Identificação única do Clube")
    private Long idClub;

    @ApiModelProperty(position = 2, notes = "Clube")
    private Club club;

    @ApiModelProperty(position = 3, notes = "Razão Social")
    private String corporateName;

    @ApiModelProperty(position = 4, notes = "Nome fantasia")
    private String fantasyName;

    @ApiModelProperty(position = 5, notes = "CNPJ")
    private String cnpj;

    @ApiModelProperty(position = 6, notes = "Endereço")
    private Adress adress;

    // ndaContract ainda nao foi criado
    // @ApiModelProperty(position = 7, notes = "Termo de confidencialidade")
    // private NdaContract ndaContract;

    public ClubDTO() {}

    public ClubDTO(Club club) {
        this.idClub = club.getIdClub();
        this.club = club.getClub();
        this.corporateName = club.getCorporateName();
        this.fantasyName = club.getFantasyName();
        this.cnpj = club.getCnpj();
        this.adress = club.getAdress();
    }

    public Long getId() {
        return getIdClub();
    }
}
