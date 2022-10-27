package com.ages.joinfut.model;

import com.ages.joinfut.dto.SubgroupDTO;
import com.ages.joinfut.service.SubgroupService;
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

    public Subgroup(){}

    public Subgroup(SubgroupDTO subgroupDTO){
        SubgroupService subgroupService = new SubgroupService();
        Subgroup subgroup = subgroupService.EntityDataConverter(subgroupDTO);
        this.idSubgroup = subgroup.idSubgroup;
        this.subgroupName = subgroup.subgroupName;
        this.club = subgroup.club;
    }
    public Long getId(){
        return getIdSubgroup();
    }








}
