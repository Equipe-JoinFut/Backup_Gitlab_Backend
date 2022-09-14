package com.ages.joinfut.model;

import com.ages.joinfut.dto.AtleteDeceaseDTO;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atlete_decesases", schema = "informations")
public class AtleteDecease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atlete_decease")
    private Long idAtleteDecease;

    @JoinColumn(name = "id_atlete")
    @ManyToOne(fetch = FetchType.LAZY)
    private Atlete atlete;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "atlete_decease_name")
    private String atleteDeceaseName;

    public AtleteDecease() {}

    public AtleteDecease(AtleteDeceaseDTO atleteDeceaseDTO) {
        this.idAtleteDecease = atleteDeceaseDTO.getIdAtleteDecease();
        this.atlete = atleteDeceaseDTO.getAtlete();
        this.atleteDeceaseName = atleteDeceaseDTO.getAtleteDeceaseName();
    }

    public Long getId() {
        return getIdAtleteDecease();
    }

    public Long getIdAtleteDecease() {
        return idAtleteDecease;
    }

    public void setIdAtleteDecease(Long idAtleteDecease) {
        this.idAtleteDecease = idAtleteDecease;
    }

    public Atlete getAtlete() {
        return atlete;
    }

    public void setAtlete(Atlete atlete) {
        this.atlete = atlete;
    }

    public String getAtleteDeceaseName() {
        return atleteDeceaseName;
    }

    public void setAtleteDeceaseName(String atleteDeceaseName) {
        this.atleteDeceaseName = atleteDeceaseName;
    }
}
