package com.ages.joinfut.model;

import com.ages.joinfut.dto.ContactDTO;
import com.ages.joinfut.Enum.TemplateEnum;
import org.hibernate.annotations.Type;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "contacts", schema = "users")
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Long idContact;

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
    @Column(name = "responses")
    private List<String> responses;

    public Contact() {}

    public Contact(ContactDTO contactDTO) {
        this.idContact = contactDTO.getIdContact();
        this.contactName = contactDTO.getContactName();
        this.email = contactDTO.getEmail();
        this.telephone = contactDTO.getTelephone();
        this.responses = contactDTO.getResponses();
    }

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

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }
}
