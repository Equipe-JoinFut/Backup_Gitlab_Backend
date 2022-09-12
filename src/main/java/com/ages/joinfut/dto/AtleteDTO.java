package com.ages.joinfut.dto;

import com.ages.joinfut.model.Atlete;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AtleteDTO {

       @ApiModelProperty(position = 1, notes = "Identificação única do Atleta")
        private Long idAtlete;

       @ApiModelProperty(position = 2, notes = "Nome do Alteta")
        private String atleteName;

       @ApiModelProperty(position = 3, notes = "Idade do Atleta")
        private Integer atleteAge;

       public AtleteDTO () {}

        public AtleteDTO (Atlete atlete) {
           this.idAtlete = atlete.getIdAtlete();
           this.atleteName = atlete.getAtleteName();
           this.atleteAge = atlete.getAtleteAge();
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
}
