package com.ages.joinfut.dto;

import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.model.AtleteClub;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class AtleteClubDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do clube que o atleta participou")
    private Long idAtleteClub;

    @ApiModelProperty(position = 2, notes = "Atleta que pertence esse registro")
    private Atlete atlete;

    @ApiModelProperty(position = 3, notes = "Nome do Clube")
    private String atleteClubName;

    @ApiModelProperty(position = 4, notes = "Data de inicio nesse clube (Opcional)")
    private Date beginDate;

    @ApiModelProperty(position = 5, notes = "Data de fim nesse clube (Opcional)")
    private Date endDate;

    @ApiModelProperty(position = 6, notes = "Atleta atualmente nesse clube? sim/não")
    private Boolean currentClub;

    public AtleteClubDTO() {}

    public AtleteClubDTO (AtleteClub atleteClub) {
        this.idAtleteClub = atleteClub.getIdAtleteClub();
        this.atlete = atleteClub.getAtlete();
        this.atleteClubName = atleteClub.getAtleteClubName();
        this.beginDate = atleteClub.getBeginDate();
        this.endDate = atleteClub.getEndDate();
        this.currentClub = atleteClub.getCurrentClub();
    }

    public Long getIdAtleteClub() {
        return idAtleteClub;
    }

    public Atlete getAtlete() {
        return atlete;
    }

    public String getAtleteClubName() {
        return atleteClubName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Boolean getCurrentClub() {
        return currentClub;
    }
}
