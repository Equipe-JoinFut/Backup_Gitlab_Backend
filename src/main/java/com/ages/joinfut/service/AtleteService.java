package com.ages.joinfut.service;

import com.ages.joinfut.dto.AtleteDTO;
import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.model.AtleteClub;
import com.ages.joinfut.model.AtleteDecease;
import com.ages.joinfut.repository.AtleteDeceaseRepository;
import com.ages.joinfut.repository.AtleteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtleteService {

    private final AtleteRepository atleteRepository;
    private final AtleteClubService atleteClubService;
    private final AtleteDeceaseRepository atleteDeceaseRepository;
    private final AdressService adressService;
    private final ContactService contactService;
    public AtleteService(AtleteRepository atleteRepository, AtleteClubService atleteClubService, AtleteDeceaseRepository atleteDeceaseRepository, AdressService adressService, ContactService contactService){
        this.atleteRepository = atleteRepository;
        this.atleteClubService = atleteClubService;
        this.atleteDeceaseRepository = atleteDeceaseRepository;
        this.adressService = adressService;
        this.contactService = contactService;
    }

    public void save(Atlete atlete) {

        if (atlete.getAtleteClubs() != null && !atlete.getAtleteClubs().isEmpty()) {
            for (AtleteClub atleteClub : atlete.getAtleteClubs()) {
                atleteClub.setAtlete(atlete);
                atleteClubService.save(atleteClub);
            }
        }
        if (atlete.getAtleteDeaceases() != null) {
            for (AtleteDecease atleteDecease : atlete.getAtleteDeaceases()) {
                atleteDecease.setAtlete(atlete);
                atleteDeceaseRepository.save(atleteDecease);
            }
        }
        if (atlete.getAdress() != null) {
            atlete.getAdress().setAtlete(atlete);
            adressService.save(atlete.getAdress());
        }
        if (atlete.getContact() != null) {
            atlete.getContact().setAtlete(atlete);
            contactService.save(atlete.getContact());
        }
        atleteRepository.save(atlete);
    }

    public List<AtleteDTO> convertList(List<Atlete> atletes) {
        return atletes.stream().map(AtleteDTO::new).collect(Collectors.toList());
    }

    public AtleteDTO convertObject(Atlete atlete){
        return new AtleteDTO(atlete);
    }

    public List<Atlete> desconvertList(List<AtleteDTO> atleteDTOS) {
        return atleteDTOS.stream().map(Atlete::new).collect(Collectors.toList());
    }

    public Atlete desconvertObject(AtleteDTO atleteDTO) {
        return new Atlete(atleteDTO);
    }

    public Atlete updateObject(Long id, Atlete updated, AtleteRepository atleteRepository) {
        Atlete saved = atleteRepository.findByidAtlete(id);
        if (updated.getAtleteName() != null && !updated.getAtleteName().equals(saved.getAtleteName())) {
            saved.setAtleteName(updated.getAtleteName());
        }
        if (updated.getAtleteAge() != null && !updated.getAtleteAge().equals(saved.getAtleteAge())) {
            saved.setAtleteAge(updated.getAtleteAge());
        }
        if (updated.getAtleteHeight() != null && !updated.getAtleteHeight().equals(saved.getAtleteHeight())) {
            saved.setAtleteHeight(updated.getAtleteHeight());
        }
        if (updated.getAtleteWeight() != null && !updated.getAtleteWeight().equals(saved.getAtleteWeight())) {
            saved.setAtleteWeight(updated.getAtleteWeight());
        }
        if (updated.getAtleteImc() != null && !updated.getAtleteImc().equals(saved.getAtleteImc())) {
            saved.setAtleteImc(updated.getAtleteImc());
        }
        if (updated.getAtleteBid() != null && !updated.getAtleteBid().equals(saved.getAtleteBid())) {
            saved.setAtleteBid(updated.getAtleteBid());
        }
        if (updated.getContact() != null && !updated.getContact().equals(saved.getContact())) {
            saved.setContact(updated.getContact());
        }
        if (updated.getAdress() != null && !updated.getAdress().equals(saved.getAdress())) {
            saved.setAdress(updated.getAdress());
        }
        return saved;
    }
}
