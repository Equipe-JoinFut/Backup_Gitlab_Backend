package com.ages.joinfut.model;
import com.ages.joinfut.dto.AdressDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


@Entity
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
    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private Long houseNumber;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "city")
    private String city;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "state")
    private String state;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "country")
    private String country;

    public Adress() {}

    public Adress(AdressDTO adressDTO) {
        this.idAdress = adressDTO.getIdAdress();
        this.atlete = adressDTO.getAtlete();
        this.street = adressDTO.getStreet();
        this.houseNumber = adressDTO.getHouseNumber();
        this.city = adressDTO.getCity();
        this.state = adressDTO.getState();
        this.country = adressDTO.getCountry();
    }

    public Long getId() {return getIdAdress();}
    public Long getIdAdress() { return idAdress; }

    public void setIdAdress(Long idAdress) { this.idAdress = idAdress; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public Long getHouseNumber() { return houseNumber; }

    public void setHouseNumber(Long houseNumber) { this.houseNumber = houseNumber; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public Atlete getAtlete() {
        return atlete;
    }

    public void setAtlete(Atlete atlete) {
        this.atlete = atlete;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
