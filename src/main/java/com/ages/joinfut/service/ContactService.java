package com.ages.joinfut.service;

import com.ages.joinfut.dto.ContactDTO;
import com.ages.joinfut.model.Contact;
import com.ages.joinfut.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactService(){}

    @Transactional
    public void save(Contact contact, ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
        if (contact.getResponsibles() != null && !contact.getResponsibles().isEmpty()) {
            for(Contact responsible : contact.getResponsibles()) {
                responsible.setAthlete(contact.getAthlete());
                contactRepository.save(responsible);
            }
        }
        contactRepository.save(contact);
    }

    @Transactional
    public void delete(Contact contact) {
        List<Contact> contacts = contactRepository.findByAthlete(contact.getAthlete());
        for (Contact contact1 : contacts) {
            if (contact1.getId() != null) {
                contactRepository.delete(contact1);
            }
        }
    }

    public List<ContactDTO> convertList(List<Contact> adresses) {
        return adresses.stream().map(ContactDTO::new).collect(Collectors.toList());
    }

    public ContactDTO convertObject(Contact contact) {return new ContactDTO(contact);}

    public List<Contact> desconvertList(List<ContactDTO> adressDTOS) {
        return adressDTOS.stream().map(Contact::new).collect(Collectors.toList());
    }

    public Contact desconvertObject(ContactDTO adressDTO){return new Contact(adressDTO);}

    public Contact update(Long id, Contact updated, ContactRepository contactRepository) {
        Contact saved = contactRepository.findByidContact(id);
        if (updated.getContactName() != null && !updated.getContactName().equals(saved.getContactName())) {
            saved.setContactName(updated.getContactName());
        }
        if (updated.getAthlete() != null && !updated.getAthlete().equals(saved.getAthlete())) {
            saved.setAthlete(updated.getAthlete());
        }
        if (updated.getEmail() != null && !updated.getEmail().equals(saved.getEmail())) {
            saved.setEmail(updated.getEmail());
        }
        if (updated.getTelephone() != null && !updated.getTelephone().equals(saved.getTelephone())) {
            saved.setTelephone(updated.getTelephone());
        }
        if (updated.getResponsibles() != null && !updated.getResponsibles().isEmpty()) {
            for (Contact responsible : updated.getResponsibles()) {
                update(responsible.getId(), responsible, contactRepository);
            }
        }
        return saved;
    }
}
