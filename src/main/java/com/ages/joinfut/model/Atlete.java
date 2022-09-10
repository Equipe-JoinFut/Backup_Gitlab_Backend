package com.ages.joinfut.model;

import com.ages.joinfut.dto.AtleteDTO;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "atletes", schema = "users")
public class Atlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atlete")
    private Long idAtlete;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "atlete_name")
    private String atleteName;

    @Column(name = "atlete_age")
    private Integer atleteAge;

    public Atlete() {}

    public Atlete(AtleteDTO atleteDTO) {
        this.idAtlete = atleteDTO.getIdAtlete();
        this.atleteName = atleteDTO.getAtleteName();
        this.atleteAge = atleteDTO.getAtleteAge();
    }

    public Long getIdAtlete() {
        return idAtlete;
    }

    public void setIdAtlete(Long idAtlete) {
        this.idAtlete = idAtlete;
    }

    public String getAtleteName() {
        return atleteName;
    }

    public void setAtleteName(String atleteName) {
        this.atleteName = atleteName;
    }

    public Integer getAtleteAge() {
        return atleteAge;
    }

    public void setAtleteAge(Integer atleteAge) {
        this.atleteAge = atleteAge;
    }
}
