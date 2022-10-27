package com.ages.joinfut.model;

import com.ages.joinfut.dto.ClubDTO;
import com.ages.joinfut.service.ClubService;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "clubs", schema = "personas")
public class Club {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_club")
    private Long idClub;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "corporate_name")
    private String corporateName;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "fantasy_name")
    private String fantasyName;

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "cnpj")
    private String cnpj;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nda_contract")
    private NdaContract ndaContract;

    public Club() {}

    public Long getId() {return getIdClub();}
}
