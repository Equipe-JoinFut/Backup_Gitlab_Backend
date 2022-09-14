package com.ages.joinfut.model;

import com.ages.joinfut.dto.AtleteDTO;
import org.hibernate.annotations.Type;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "atletes", schema = "personas")
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

    @Column(name = "atlete_height")
    private Double atleteHeight;

    @Column(name = "atlete_weight")
    private Double atleteWeight;

    @Column(name = "atlete_imc")
    private Double atleteImc;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "atlete_bid")
    private String atleteBid;

    @OneToMany(mappedBy = "id_atlete", cascade = CascadeType.REMOVE)
    private List<AtleteClub> atleteClubStory;

    @OneToMany(mappedBy = "id_atlete", cascade = CascadeType.REMOVE)
    private List<AtleteDecease> atleteDeaceases;

    public Atlete() {}

    public Atlete(AtleteDTO atleteDTO) {
        this.idAtlete = atleteDTO.getIdAtlete();
        this.atleteName = atleteDTO.getAtleteName();
        this.atleteAge = atleteDTO.getAtleteAge();
        this.atleteHeight = atleteDTO.getAtleteHeight();
        this.atleteWeight = atleteDTO.getAtleteWeight();
        this.atleteImc = atleteDTO.getAtleteImc();
        this.atleteBid = atleteDTO.getAtleteBid();
        this.atleteClubStory = atleteDTO.getAtleteClubStory();
        this.atleteDeaceases = atleteDTO.getAtleteDeaceases();
    }

    public Long getId() {
        return getIdAtlete();
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
    public Double getAtleteHeight() { return atleteHeight; }

    public void setAtleteHeight(Double atleteHeight){ this.atleteHeight = atleteHeight; }
    public Double getAtleteWeight() { return atleteWeight; }

    public void setAtleteWeight(double atleteWeight){ this.atleteWeight = atleteWeight; }
    public Double getAtleteImc() { return atleteImc; }

    public void setAtleteImc(double atleteImc){ this.atleteImc = atleteImc; }
    public String getAtleteBid() { return atleteBid; }

    public void setAtleteBid(String atleteBid){ this.atleteBid = atleteBid; }

    public List<AtleteClub> getAtleteClubStory() { return atleteClubStory; }

    public void setAtleteClubStory(List<AtleteClub> atleteClubstory){ this.atleteClubStory = atleteClubStory; }

    public List<AtleteDecease> getAtleteDeaceases() {return atleteDeaceases; }

    public void setAtleteDeaceases() {this.atleteDeaceases = atleteDeaceases; }
}