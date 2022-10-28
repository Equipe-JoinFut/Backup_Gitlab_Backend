package com.ages.joinfut.model;

import com.ages.joinfut.dto.AthleteSubgroupDTO;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "athlete_subgroup", schema = "informations")

public class AthleteSubgroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_athlete_subgroup")
    private Long idAthleteSubgroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_athlete")
    private Athlete athlete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subgroup")
    private Subgroup subgroup;

    public AthleteSubgroup() {}

    public Long getId() { return getIdAthleteSubgroup(); }

}
