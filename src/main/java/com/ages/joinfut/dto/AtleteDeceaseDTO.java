package com.ages.joinfut.dto;

import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.model.AtleteDecease;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class AtleteDeceaseDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única da doença do Atleta")
    private Long idAtleteDecease;

    @ApiModelProperty(position = 2, notes = "Atleta que pertence a doença")
    private Atlete atlete;

    @ApiModelProperty(position = 3, notes = "Nome da doença")
    private String atleteDeceaseName;

    public AtleteDeceaseDTO() {}

    public AtleteDeceaseDTO(AtleteDecease atleteDecease) {
        this.idAtleteDecease = atleteDecease.getIdAtleteDecease();
        this.atlete = atleteDecease.getAtlete();
        this.atleteDeceaseName = atleteDecease.getAtleteDeceaseName();
    }

    public Long getIdAtleteDecease() {
        return idAtleteDecease;
    }

    public Atlete getAtlete() {
        return atlete;
    }

    public String getAtleteDeceaseName() {
        return atleteDeceaseName;
    }
}
