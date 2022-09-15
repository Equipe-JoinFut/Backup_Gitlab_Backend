package com.ages.joinfut.dto;

import java.util.List;

import com.ages.joinfut.model.Contact;
import io.swagger.annotations.ApiModelProperty;

public class ContactDTO {
    
    @ApiModelProperty(position = 1, notes = "Identificação única do Contato")
    private Long idContact;

    @ApiModelProperty(position = 2, notes = "Nome de Contato")
    private String contactName;

    @ApiModelProperty(position = 3, notes = "Email")
    private String email;

    @ApiModelProperty(position = 4, notes = "Telephone")
    private String telephone;

    @ApiModelProperty(position = 4, notes = "Responsáveis")
    private List<Contact> responsibles;
    
    public ContactDTO() {}

    public ContactDTO (Contact contact) {
        this.idContact = contact.getIdContact();
        this.contactName = contact.getContactName();
        this.email = contact.getEmail();
        this.telephone = contact.getTelephone();
        this.responsibles = contact.getResponsibles();
    }

    public Long getIdContact() {
        return idContact;
    }

    public String getContactName() {
        return contactName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public List<Contact> getResponsibles() {
        return responsibles;
    }
}
