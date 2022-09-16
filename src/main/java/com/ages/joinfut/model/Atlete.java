package com.ages.joinfut.model;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.PlayStyle;
import com.ages.joinfut.Enum.Position;
import com.ages.joinfut.dto.AtleteDTO;
import com.ages.joinfut.service.AtleteService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_birth")
    private Date dateBirth;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "dominant_leg")
    private DominantLeg dominantLeg;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @Enumerated(EnumType.STRING)
    @Column(name = "play_style")
    private PlayStyle playStyle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact")
    private Contact contact;

    @JsonProperty("atleteClubs")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atlete", cascade = CascadeType.REMOVE)
    private List<AtleteClub> atleteClubs;

    @JsonProperty("atleteDeceases")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atlete", cascade = CascadeType.REMOVE)
    private List<AtleteDecease> atleteDeceases;

    public Atlete() {}

    public Atlete(AtleteDTO atleteDTO) {
        AtleteService atleteService = new AtleteService();
        Atlete atlete = atleteService.EntityDataConverter(atleteDTO);
        this.idAtlete = atlete.idAtlete;
        this.atleteName = atlete.atleteName;
        this.atleteAge = atlete.atleteAge;
        this.dateBirth = atlete.dateBirth;
        this.atleteHeight = atlete.atleteHeight;
        this.atleteWeight = atlete.atleteWeight;
        this.atleteImc = atlete.atleteImc;
        this.atleteBid = atlete.atleteBid;
        this.dominantLeg = atlete.dominantLeg;
        this.position = atlete.position;
        this.playStyle = atlete.playStyle;
        this.adress = atlete.adress;
        this.contact = atlete.contact;
        this.atleteClubs = atlete.atleteClubs;
        this.atleteDeceases = atlete.atleteDeceases;
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

    public List<AtleteClub> getAtleteClubs() { return atleteClubs; }

    public void setAtleteClubs(List<AtleteClub> atleteClubs){ this.atleteClubs = atleteClubs; }

    public List<AtleteDecease> getAtleteDeceases() {return atleteDeceases; }

    public void setAtleteDeceases(List<AtleteDecease> atleteDeceases) {
        this.atleteDeceases = atleteDeceases;
    }

    public void setAtleteWeight(Double atleteWeight) {
        this.atleteWeight = atleteWeight;
    }

    public void setAtleteImc(Double atleteImc) {
        this.atleteImc = atleteImc;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public DominantLeg getDominantLeg() {
        return dominantLeg;
    }

    public void setDominantLeg(DominantLeg dominantLeg) {
        this.dominantLeg = dominantLeg;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PlayStyle getPlayStyle() {
        return playStyle;
    }

    public void setPlayStyle(PlayStyle playStyle) {
        this.playStyle = playStyle;
    }
}