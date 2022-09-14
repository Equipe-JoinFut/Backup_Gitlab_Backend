package com.ages.joinfut.dto;

import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.model.AtleteClub;
import com.ages.joinfut.model.AtleteDecease;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AtleteDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Atleta")
    private Long idAtlete;

    @ApiModelProperty(position = 2, notes = "Nome do Alteta")
    private String atleteName;

    @ApiModelProperty(position = 3, notes = "Idade do Atleta")
    private Integer atleteAge;

    @ApiModelProperty(position = 4, notes = "Peso do Atleta")
    private Double atleteHeight;

    @ApiModelProperty(position = 5, notes = "Altura do Atleta")
    private Double atleteWeight;

    @ApiModelProperty(position = 6, notes = "IMC do Atlela")
    private Double atleteImc;

    @ApiModelProperty(position = 7, notes = "Código BID do Atleta")
    private String atleteBid;

    @ApiModelProperty(position = 8, notes = "Histórico de Clubes do Atleta")
    private List<AtleteClub> atleteClubStory;

    @ApiModelProperty(position = 9, notes = "Doenças pŕe-existentes do Atleta")
    private List<AtleteDecease> atleteDeceases;

    public AtleteDTO () {}

    public AtleteDTO (Atlete atlete) {
        this.idAtlete = atlete.getIdAtlete();
        this.atleteName = atlete.getAtleteName();
        this.atleteAge = atlete.getAtleteAge();
        this.atleteHeight = atlete.getAtleteHeight();
        this.atleteWeight = atlete.getAtleteWeight();
        this.atleteImc = atlete.getAtleteImc();
        this.atleteBid = atlete.getAtleteBid();
        this.atleteClubStory = atlete.getAtleteClubStory();
        this.atleteDeceases = atlete.getAtleteDeaceases();
    }

    public Long getIdAtlete() {
        return idAtlete;
    }

    public String getAtleteName() {
        return atleteName;
    }

    public Integer getAtleteAge() {
        return atleteAge;
    }

    public Double getAtleteHeight() { return atleteHeight; }

    public Double getAtleteWeight() { return atleteWeight; }

    public Double getAtleteImc() { return atleteImc; }

    public String getAtleteBid() { return atleteBid; }

    public List<AtleteClub> getAtleteClubStory() { return atleteClubStory; }

    public List<AtleteDecease> getAtleteDeaceases() { return atleteDeceases; }
}