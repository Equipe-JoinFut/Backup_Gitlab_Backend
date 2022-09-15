package com.ages.joinfut.model;

import com.ages.joinfut.dto.ContactDTO;
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
import java.util.List;

@Entity
@Table(name = "contacts", schema = "informations")
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Long idContact;

    @JoinColumn(name = "id_atlete")
    @ManyToOne(fetch = FetchType.LAZY)
    private Atlete atlete;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "contact_name")
    private String contactName;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "email")
    private String email;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "telephone")
    private String telephone;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "responsibles")
    private List<Contact> responsibles;

    public Contact() {}

    public Contact(ContactDTO contactDTO) {
        this.idContact = contactDTO.getIdContact();
        this.atlete = contactDTO.getAtlete();
        this.contactName = contactDTO.getContactName();
        this.email = contactDTO.getEmail();
        this.telephone = contactDTO.getTelephone();
        this.responsibles = contactDTO.getResponsibles();
    }

    public Long getId() {return getIdContact();}
    public Long getIdContact() {
        return idContact; 
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Contact> getResponsibles() {
        return responsibles;
    }

    public void setResponsibles(List<Contact> responsibles) {
        this.responsibles = responsibles;
    }

    public Atlete getAtlete() {
        return atlete;
    }

    public void setAtlete(Atlete atlete) {
        this.atlete = atlete;
    }
}
