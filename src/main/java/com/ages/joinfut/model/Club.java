package com.ages.joinfut.model;

import com.ages.joinfut.dto.ClubDTO;
import com.ages.joinfut.service.ClubService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Type;


import javax.persistence.*;

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

    // ndaContract ainda nao foi criado
    // @Type(type = "org.hibernate.type.TextType")
    // @Column(name = "nda_contract")
    // private NdaContract ndaContract;

    public Club() {}
    
    public Club(ClubDTO clubDTO) {
        ClubService clubService = new ClubService();
        Club club = clubService.EntityDataConverter(clubDTO);

        this.idClub = club.idClub;
        this.corporateName = club.corporateName;
        this.fantasyName = club.fantasyName;
        this.cnpj = club.cnpj;
        this.adress = club.adress;
    }

    public Long getId() {return getIdClub();}
}