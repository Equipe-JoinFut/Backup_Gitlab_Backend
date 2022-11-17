package com.ages.joinfut.dto;

import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.model.AthleteSlim;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoDTO {
    
    @ApiModelProperty(position = 1, notes = "Identificação única do Vídeo")
    private Long idVideo;

    @ApiModelProperty(position = 2, notes = "Atleta")
    private AthleteSlim athlete;

    @ApiModelProperty(position = 3, notes = "Descrição do Vídeo")
    private String description;


    public VideoDTO () {}

    public Long getId() {
        return getIdVideo();
    }
}
