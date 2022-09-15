package com.ages.joinfut.service;

import com.ages.joinfut.dto.ContactDTO;
import com.ages.joinfut.model.Contact;
import com.ages.joinfut.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    public void save(Contact contact) {
        if (contact.getResponsibles() != null && !contact.getResponsibles().isEmpty()) {
            for(Contact responsible : contact.getResponsibles()) {
                responsible.setAtlete(contact.getAtlete());
                contactRepository.save(responsible);
            }
        }
    }

    public List<ContactDTO> convertList(List<Contact> adresses) {
        return adresses.stream().map(ContactDTO::new).collect(Collectors.toList());
    }

    public ContactDTO convertObjet(Contact contact) {return new ContactDTO(contact);}

    public List<Contact> desconvertList(List<ContactDTO> adressDTOS) {
        return adressDTOS.stream().map(Contact::new).collect(Collectors.toList());
    }

    public Contact desconvertObject(ContactDTO adressDTO){return new Contact(adressDTO);}

    public Contact updateObject(Long id, Contact updated, ContactRepository contactRepository) {
        Contact saved = contactRepository.findByidContact(id);
        if (updated.getContactName() != null && !updated.getContactName().equals(saved.getContactName())) {
            saved.setContactName(updated.getContactName());
        }
        if (updated.getEmail() != null && !updated.getEmail().equals(saved.getEmail())) {
            saved.setEmail(updated.getEmail());
        }
        if (updated.getTelephone() != null && !updated.getTelephone().equals(saved.getTelephone())) {
            saved.setTelephone(updated.getTelephone());
        }
        return saved;
    }
}
