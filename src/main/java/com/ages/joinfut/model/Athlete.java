package com.ages.joinfut.model;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.Position;
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
@Table(name = "athletes", schema = "personas")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_athlete")
    private Long idAthlete;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "athlete_name")
    private String athleteName;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_birth")
    private Date dateBirth;

    @Column(name = "athlete_height")
    private Double athleteHeight;

    @Column(name = "age")
    private Integer age;

    @Column(name = "athlete_weight")
    private Double athleteWeight;

    @Column(name = "athlete_imc")
    private Double athleteImc;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "athlete_bid")
    private String athleteBid;

    @Enumerated(EnumType.STRING)
    @Column(name = "dominant_leg")
    private DominantLeg dominantLeg;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("athlete")
    @JoinColumn(name = "id_contact")
    private Contact contact;

    @JsonProperty("athleteClubs")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "athlete", cascade = CascadeType.REMOVE)
    private List<AthleteClub> athleteClubs;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "athlete_deceases")
    private String deceases;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;


    public Athlete() {}

    public Long getId() {
        return getIdAthlete();
    }
}
