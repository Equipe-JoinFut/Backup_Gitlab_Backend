package com.ages.joinfut.dto;

import com.ages.joinfut.model.ClubSlim;
import com.ages.joinfut.model.Subgroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SieveDTO {
    @ApiModelProperty(position = 1, notes = "Identificação única da peneira")
    private Long idSieve;

    @ApiModelProperty(position = 2, notes = "Nome da Peneira")
    private String sieveName;

    @ApiModelProperty(position = 3, notes = "Identificacao do Subgrupo em que a peneira foi criada")
    private Subgroup subgroup;

    @ApiModelProperty(position = 4, notes = "Identificacao do Clube que criou a peneira")
    private ClubSlim club;

    @ApiModelProperty(position = 5, notes = "local da peneira")
    private String local;

    @ApiModelProperty(position = 6, notes = "Data da peneira")
    private String date;

    @ApiModelProperty(position = 7, notes = "Data da peneira")
    private String time;

    public SieveDTO () {}

    public Long getId() {
        return getIdSieve();
    }
}
