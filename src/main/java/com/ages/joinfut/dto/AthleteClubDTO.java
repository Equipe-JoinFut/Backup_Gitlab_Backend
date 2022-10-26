package com.ages.joinfut.dto;

import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.model.AthleteClub;
import com.ages.joinfut.model.AthleteSlim;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AthleteClubDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do clube que o atleta participou")
    private Long idAthleteClub;

    @ApiModelProperty(position = 2, notes = "Atleta que pertence esse registro")
    private Athlete athlete;

    @ApiModelProperty(position = 3, notes = "Nome do Clube")
    private String athleteClubName;

    @ApiModelProperty(position = 4, notes = "Data de inicio nesse clube (Opcional)")
    private Date beginDate;

    @ApiModelProperty(position = 5, notes = "Data de fim nesse clube (Opcional)")
    private Date endDate;

    @ApiModelProperty(position = 6, notes = "Atleta atualmente nesse clube? sim/não")
    private Boolean currentClub;

    public AthleteClubDTO() {}

    public AthleteClubDTO (AthleteClub athleteClub) {
        this.idAthleteClub = athleteClub.getIdAthleteClub();
        this.athlete = athleteClub.getAthlete();
        this.athleteClubName = athleteClub.getAthleteClubName();
        this.beginDate = athleteClub.getBeginDate();
        this.endDate = athleteClub.getEndDate();
        this.currentClub = athleteClub.getCurrentClub();
    }

    public Long getId() {
        return getIdAthleteClub();
    }
}
