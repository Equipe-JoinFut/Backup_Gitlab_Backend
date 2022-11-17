package com.ages.joinfut.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer" , "handler"})
@Table(name = "subgroups", schema = "selections")
public class Subgroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subgroup")
    private Long idSubgroup;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "subgroup_name")
    private String subgroupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_club")
    private Club club;

    @JsonProperty("athleteSubgroups")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subgroup", cascade = CascadeType.REMOVE)
    private List<AthleteSubgroup> athleteSubgroups;

    public Subgroup(){}

    public Long getId(){
        return getIdSubgroup();
    }








}
