package com.ages.joinfut.dto;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.Position;
import com.ages.joinfut.model.AthleteSubgroup;
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

public class AthleteSubgroupDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Atleta Subgrupo")
    private Long idAthelteSubgroup;

    @ApiModelProperty(position = 2, notes = "Identificação única do Atleta")
    private Long idAthlete;

    @ApiModelProperty(position = 3, notes = "Identificação única do Subgroup")
    private Long idSubgroup;

    public AthleteSubgroupDTO() {}

    public AthleteSubgroupDTO (AthleteSubgroup athleteSubgroup) {
        this.idAthelteSubgroup = athleteSubgroup.getIdAthleteSubgroup();
        this.idAthlete = athleteSubgroup.getIdAthlete();
        this.idSubgroup = athleteSubgroup.getIdSubgroup();
    }

    public Long getId() { return getIdAthelteSubgroup(); }

}
