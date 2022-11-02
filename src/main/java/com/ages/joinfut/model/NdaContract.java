package com.ages.joinfut.model;
import com.ages.joinfut.Enum.StatusNda;
import com.ages.joinfut.dto.NdaContractDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id_club")
    private Club club;

    public NdaContract() {}

    public Long getId() { return getIdNdaContract(); }

}
