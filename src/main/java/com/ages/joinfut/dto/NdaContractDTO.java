package com.ages.joinfut.dto;

import com.ages.joinfut.Enum.StatusNda;
import com.ages.joinfut.model.NdaContract;
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

    public NdaContractDTO() {}

    public NdaContractDTO (NdaContract ndaContract) {
        this.idNdaContract = ndaContract.getIdNdaContract();
        this.infoNda = ndaContract.getInfoNda();
        this.statusNda = ndaContract.getStatusNda();
    }

    public Long getId() { return getIdNdaContract(); }

}
