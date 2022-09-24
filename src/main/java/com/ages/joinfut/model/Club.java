package com.ages.joinfut.model;

import com.ages.joinfut.dto.ClubDTO;
import com.ages.joinfut.service.ClubService;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "contacts", schema = "personas")
public class Club {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_club")
    private Long idClub;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_club")
    private Club club;

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

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "adress")
    private Adress adress;

    // ndaContract ainda nao foi criado
    // @Type(type = "org.hibernate.type.TextType")
    // @Column(name = "nda_contract")
    // private NdaContract ndaContract;

    public Club() {}
    
    public Club(ClubDTO clubDTO) {
        ClubService clubService = new ClubService();
        Club club = clubService.EntityDataConverter(clubDTO);

        this.idClub = club.idClub;
        this.club = club.club;
        this.corporateName = club.corporateName;
        this.fantasyName = club.fantasyName;
        this.cnpj = club.cnpj;
        this.adress = club.adress;
    }

    public Long getId() {return getIdClub();}
}