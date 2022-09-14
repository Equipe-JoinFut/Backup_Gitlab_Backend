package com.ages.joinfut.dto;

import com.ages.joinfut.model.Adress;
import io.swagger.annotations.ApiModelProperty;

public class AdressDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Endereço")
    private Long idAdress;

    @ApiModelProperty(position = 2, notes = "Nome da rua")
    private String street;

    @ApiModelProperty(position = 3, notes = "Número da casa")
    private Long houseNumber;

    @ApiModelProperty(position = 4, notes = "Nome da cidade")
    private String city;

    public AdressDTO() {}

    public AdressDTO (Adress adress) {
        this.idAdress = adress.getIdAdress();
        this.street = adress.getStreet();
        this.houseNumber = adress.getHouseNumber();
        this.city = adress.getCity();
    }

    public Long getIdAdress() { return idAdress; }

    public String getStreet() { return street; }

    public Long getHouseNumber() { return houseNumber; }

    public String getCity() { return city; }

}
