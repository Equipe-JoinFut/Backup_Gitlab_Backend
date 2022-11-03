package com.ages.joinfut.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoSlimDTO {

    @ApiModelProperty(position = 1, notes = "Id do Video")
    private Long idVideo;

    public Long getId() {
        return getIdVideo();
    }
}
