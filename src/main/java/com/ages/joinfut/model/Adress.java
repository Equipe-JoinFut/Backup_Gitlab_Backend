package com.ages.joinfut.model;
import com.ages.joinfut.Enum.State;
import com.ages.joinfut.dto.AdressDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

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
import javax.persistence.Table;


@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "adresses", schema = "informations")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adress")
    private Long idAdress;

    @JoinColumn(name = "id_atlete")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Atlete atlete;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "street_info")
    private String streetInfo;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "city")
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    public Adress() {}

    public Adress(AdressDTO adressDTO) {
        this.idAdress = adressDTO.getIdAdress();
        this.atlete = adressDTO.getAtlete();
        this.streetInfo = adressDTO.getStreetInfo();
        this.city = adressDTO.getCity();
        this.state = adressDTO.getState();
    }

    public Long getId() {
        return getIdAdress();
    }
}
