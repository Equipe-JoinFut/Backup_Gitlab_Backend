package com.ages.joinfut.dto;

import java.util.List;

import com.ages.joinfut.model.Atlete;
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
    private Atlete atlete;

    @ApiModelProperty(position = 3, notes = "Nome de Contato")
    private String contactName;

    @ApiModelProperty(position = 4, notes = "Email")
    private String email;

    @ApiModelProperty(position = 5, notes = "Telephone")
    private String telephone;

    @ApiModelProperty(position = 6, notes = "Responsáveis")
    private List<Contact> responsibles;
    
    public ContactDTO() {}

    public ContactDTO (Contact contact) {
        this.idContact = contact.getIdContact();
        this.atlete = contact.getAtlete();
        //this.contactName = contact.getContactName();
        //this.email = contact.getEmail();
        //this.telephone = contact.getTelephone();
        //this.responsibles = contact.getResponsibles();
    }

    public Long getId() {
        return getIdContact();
    }
}
