package com.ages.joinfut.model;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.Position;
import com.ages.joinfut.dto.AtleteDTO;
import com.ages.joinfut.service.AtleteService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
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

@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact")
    private Contact contact;

    @JsonProperty("atleteClubs")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atlete", cascade = CascadeType.REMOVE)
    private List<AtleteClub> atleteClubs;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "atlete_deceases")
    private String deceases;

    public Atlete() {}

    public Atlete(AtleteDTO atleteDTO) {
        AtleteService atleteService = new AtleteService();
        Atlete atlete = atleteService.EntityDataConverter(atleteDTO);
        this.idAtlete = atlete.idAtlete;
        this.atleteName = atlete.atleteName;
        this.dateBirth = atlete.dateBirth;
        this.atleteHeight < 0 || this.atleteHeight > 3 ? null : atlete.atleteHeight;
        this.atleteWeight < 0 || this.atleteWeight > 200 ? null : atlete.atleteWeight;
        this.atleteImc = this.atleteWeight / (this.atleteHeight * this.atleteHeight);
        this.atleteBid = atlete.atleteBid;
        this.dominantLeg = atlete.dominantLeg;
        this.position = atlete.position;
        this.adress = atlete.adress;
        this.contact = atlete.contact;
        this.atleteClubs = atlete.atleteClubs;
        this.deceases = atlete.deceases;
    }

    public Long getId() {
        return getIdAtlete();
    }
}