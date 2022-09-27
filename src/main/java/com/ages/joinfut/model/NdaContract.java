package com.ages.joinfut.model;
import com.ages.joinfut.Enum.StatusNda;
import com.ages.joinfut.dto.NdaContractDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ndacontracts", schema = "informations")
public class NdaContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nda_contracts")
    private Long idNdaContract;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "info_nda")
    private String infoNda;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusNda")
    private StatusNda statusNda;

    public NdaContract() {}

    public NdaContract(NdaContractDTO ndaContractDTO) {
        this.idNdaContract = ndaContractDTO.getIdNdaContract();
        this.infoNda = ndaContractDTO.getInfoNda();
        this.statusNda = ndaContractDTO.getStatusNda();
    }

    public Long getIdNdaContract() { return getIdNdaContract(); }

}
