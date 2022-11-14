package com.ages.joinfut.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "athlete_confirmation", schema = "informations")
public class AthleteConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_athlete_confirmation")
    private Long idAthleteConfirmation;

    @JoinColumn(name = "id_athlete")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Athlete athlete;

    @Column(name = "athlete_confirmed_reject")
    private Boolean athlete_confirmed_reject;

    // @JoinColumn(name = "id_sieve")
    // @JsonIgnore
    // @ManyToOne(fetch = FetchType.LAZY)
    // private Sieve sieve;

    public AthleteConfirmation() {}

    public Long getId() { return getIdAthleteConfirmation(); }

}
