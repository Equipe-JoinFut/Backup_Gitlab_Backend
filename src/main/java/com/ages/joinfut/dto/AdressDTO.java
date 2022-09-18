package com.ages.joinfut.dto;

import com.ages.joinfut.model.Adress;
import com.ages.joinfut.model.Atlete;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class AdressDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Endereço")
    private Long idAdress;

    @ApiModelProperty(position = 2, notes = "Atleta")
    private Atlete atlete;

    @ApiModelProperty(position = 3, notes = "Nome da rua")
    private String street;

    @ApiModelProperty(position = 4, notes = "Número da casa")
    private Long houseNumber;

    @ApiModelProperty(position = 5, notes = "Nome da cidade")
    private String city;

    @ApiModelProperty(position = 6, notes = "Estado")
    private String state;

    @ApiModelProperty(position = 7, notes = "País")
    private String country;

    public AdressDTO() {}

    public AdressDTO (Adress adress) {
        this.idAdress = adress.getIdAdress();
        this.atlete = adress.getAtlete();
        this.street = adress.getStreet();
        this.houseNumber = adress.getHouseNumber();
        this.city = adress.getCity();
        this.state = adress.getState();
        this.country = adress.getCountry();
    }

    public Long getIdAdress() { return idAdress; }

    public String getStreet() { return street; }

    public Long getHouseNumber() { return houseNumber; }

    public String getCity() { return city; }

    public Atlete getAtlete() {
        return atlete;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
