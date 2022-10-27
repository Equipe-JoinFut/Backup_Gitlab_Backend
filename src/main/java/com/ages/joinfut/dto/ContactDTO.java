package com.ages.joinfut.dto;

import java.util.List;

import com.ages.joinfut.model.Contact;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
    
    @ApiModelProperty(position = 1, notes = "Identificação única do Contato")
    private Long idContact;

    @ApiModelProperty(position = 2, notes = "Atleta")
    private AthleteDTO athlete;

    @ApiModelProperty(position = 3, notes = "Clube")
    private ClubDTO club;

    @ApiModelProperty(position = 4, notes = "Nome de Contato")
    private String contactName;

    @ApiModelProperty(position = 5, notes = "Email")
    private String email;

    @ApiModelProperty(position = 6, notes = "Telephone")
    private String telephone;

    @ApiModelProperty(position = 7, notes = "Responsáveis")
    private List<Contact> responsibles;
    
    public ContactDTO() {}

    public Long getId() {
        return getIdContact();
    }
}
