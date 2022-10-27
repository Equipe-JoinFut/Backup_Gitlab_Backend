package com.ages.joinfut.dto;

import com.ages.joinfut.Enum.StatusNda;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NdaContractDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Termo de confidencialidade")
    private Long idNdaContract;

    @ApiModelProperty(position = 2, notes = "Texto completo do termo de confidencialidade")
    private String infoNda;

    @ApiModelProperty(position = 3, notes = "Tipo de aprovação")
    private StatusNda statusNda;

    @ApiModelProperty(position = 4, notes = "Club")
    private ClubDTO club;

    public NdaContractDTO() {}

    public Long getId() { return getIdNdaContract(); }

}
