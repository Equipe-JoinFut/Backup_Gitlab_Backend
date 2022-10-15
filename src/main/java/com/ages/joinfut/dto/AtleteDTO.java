package com.ages.joinfut.dto;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.Position;
import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.model.User;
import com.ages.joinfut.service.AtleteService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AtleteDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Atleta")
    private Long idAtlete;

    @ApiModelProperty(position = 2, notes = "Nome do Alteta")
    private String atleteName;

    @ApiModelProperty(position = 3, notes = "Data de nascimento")
    private Date dateBirth;

    @ApiModelProperty(position = 4, notes = "Altura do Atleta")
    @DecimalMin(value = "0.0", message = "Altura mínima inválida!")
    @DecimalMax(value = "3.0", message = "Altura máxima inválida!")
    private Double atleteHeight;

    @ApiModelProperty(position = 5, notes = "Peso do Atleta")
    @DecimalMin(value = "0.0", message = "Peso mínimo inválido!")
    @DecimalMax(value = "200.0", message = "Peso máximo inválido!")
    private Double atleteWeight;

    @ApiModelProperty(position = 6, notes = "IMC do Atlela")
    private Double atleteImc;

    @ApiModelProperty(position = 7, notes = "Código BID do Atleta")
    private String atleteBid;

    @ApiModelProperty(position = 8, notes = "Perna Dominante")
    private DominantLeg dominantLeg;

    @ApiModelProperty(position = 9, notes = "Posição")
    private Position position;

    @ApiModelProperty(position = 10, notes = "Endereço do jogador")
    private AdressDTO adress;

    @ApiModelProperty(position = 11, notes = "Contato do jogador")
    private ContactDTO contact;

    @ApiModelProperty(position = 12, notes = "Historico de Clubes do Atleta")
    private List<AtleteClubDTO> atleteClubs;

    @ApiModelProperty(position = 13, notes = "Doenças pre-existentes do Atleta")
    private String deceases;

    @ApiModelProperty(position = 14, notes = "Usuario vinculado ao atleta")
    private User user;

    public AtleteDTO () {}

    public AtleteDTO (Atlete atlete) {
        AtleteService atleteService = new AtleteService();
        AtleteDTO atleteDTO = atleteService.DTODataConverter(atlete);
        this.idAtlete = atleteDTO.idAtlete;
        this.atleteName = atleteDTO.atleteName;
        this.dateBirth = atleteDTO.dateBirth;
        this.atleteHeight = atleteDTO.atleteHeight;
        this.atleteWeight = atleteDTO.atleteWeight;
        this.atleteImc = atleteDTO.atleteImc;
        this.atleteBid = atleteDTO.atleteBid;
        this.dominantLeg = atleteDTO.dominantLeg;
        this.position = atleteDTO.position;
        this.adress = atleteDTO.adress;
        this.contact = atleteDTO.contact;
        this.atleteClubs = atleteDTO.atleteClubs;
        this.deceases = atleteDTO.deceases;
        this.user = atleteDTO.user;
    }

    public Long getId() {
        return getIdAtlete();
    }
}