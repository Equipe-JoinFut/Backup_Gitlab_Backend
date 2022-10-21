package com.ages.joinfut.model;

import com.ages.joinfut.dto.AthleteSubgroupDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "athlete_subgroup", schema = "informations")

public class AthleteSubgroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_athlete_subgroup")
    private Long idAthleteSubgroup;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_athlete")
    private Long idAthlete;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subgroup")
    private Long idSubgroup;

    public AthleteSubgroup() {}

    public AthleteSubgroup(AthleteSubgroupDTO athleteSubgroupDTO) {
        this.idAthleteSubgroup = athleteSubgroupDTO.getIdAthelteSubgroup();
        this.idAthlete = athleteSubgroupDTO.getIdAthlete();
        this.idSubgroup = athleteSubgroupDTO.getIdSubgroup();
    }

    public Long getId() { return getIdAthleteSubgroup(); }

}
