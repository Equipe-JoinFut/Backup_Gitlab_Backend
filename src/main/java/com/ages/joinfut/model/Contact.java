package com.ages.joinfut.model;

import com.ages.joinfut.dto.ContactDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "contacts", schema = "informations")
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Long idContact;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_athlete")
    private Athlete athlete;

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

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "athlete", cascade = CascadeType.REMOVE)
    private List<Contact> responsibles;

    public Contact() {}

    public Contact(ContactDTO contactDTO) {
        this.idContact = contactDTO.getIdContact();
        this.athlete = contactDTO.getAthlete();
        this.contactName = contactDTO.getContactName();
        this.email = contactDTO.getEmail();
        this.telephone = contactDTO.getTelephone();
        this.responsibles = contactDTO.getResponsibles();
    }

    public Long getId() {return getIdContact();}

}
