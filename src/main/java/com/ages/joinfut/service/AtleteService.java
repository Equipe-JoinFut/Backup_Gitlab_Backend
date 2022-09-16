package com.ages.joinfut.service;

import com.ages.joinfut.dto.AtleteDTO;
import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.model.AtleteClub;
import com.ages.joinfut.model.AtleteDecease;
import com.ages.joinfut.repository.AdressRepository;
import com.ages.joinfut.repository.AtleteClubRepository;
import com.ages.joinfut.repository.AtleteDeceaseRepository;
import com.ages.joinfut.repository.AtleteRepository;
import com.ages.joinfut.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtleteService {

    @Autowired
    private AtleteRepository atleteRepository;

    @Autowired
    private AtleteDeceaseRepository atleteDeceaseRepository;

    @Autowired
    private AtleteClubRepository atleteClubRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private ContactRepository contactRepository;

    private AdressService adressService = new AdressService();
    private ContactService contactService = new ContactService();
    private AtleteClubService atleteClubService = new AtleteClubService();
    private  AtleteDeceaseService atleteDeceaseService = new AtleteDeceaseService();

    public AtleteService(){
    }

    @Transactional
    public void save(Atlete atlete) {
        atleteRepository.save(atlete);

        if (atlete.getAtleteClubs() != null && !atlete.getAtleteClubs().isEmpty()) {
            for (AtleteClub atleteClub : atlete.getAtleteClubs()) {
                atleteClub.setAtlete(atlete);
                atleteClubService.save(atleteClub, atleteClubRepository);
            }
        }
        if (atlete.getAtleteDeceases() != null) {
            for (AtleteDecease atleteDecease : atlete.getAtleteDeceases()) {
                atleteDecease.setAtlete(atlete);
                atleteDeceaseService.save(atleteDecease, atleteDeceaseRepository);
            }
        }
        if (atlete.getAdress() != null) {
            atlete.getAdress().setAtlete(atlete);
            adressService.save(atlete.getAdress(), adressRepository);
        }
        if (atlete.getContact() != null) {
            atlete.getContact().setAtlete(atlete);
            contactService.save(atlete.getContact(), contactRepository);
        }
    }

    public List<AtleteDTO> convertList(List<Atlete> atletes) {
        return atletes.stream().map(AtleteDTO::new).collect(Collectors.toList());
    }

    public AtleteDTO DTODataConverter(Atlete atlete) {
        AtleteDTO atleteDTO = new AtleteDTO();
        atleteDTO.setIdAtlete(atlete.getIdAtlete());
        atleteDTO.setAtleteName(atlete.getAtleteName());
        atleteDTO.setAtleteAge(atlete.getAtleteAge());
        atleteDTO.setDateBirth(atlete.getDateBirth());
        atleteDTO.setAtleteHeight(atlete.getAtleteHeight());
        atleteDTO.setAtleteWeight(atlete.getAtleteWeight());
        atleteDTO.setAtleteImc(atlete.getAtleteImc());
        atleteDTO.setAtleteBid(atlete.getAtleteBid());
        atleteDTO.setDominantLeg(atlete.getDominantLeg());
        atleteDTO.setPosition(atlete.getPosition());
        atleteDTO.setPlayStyle(atlete.getPlayStyle());
        if (atlete.getAdress() != null) {
            atleteDTO.setAdress(adressService.convertObjet(atlete.getAdress()));
        }
        if (atlete.getContact() != null) {
            atleteDTO.setContact(contactService.convertObjet(atlete.getContact()));
        }
        if (atlete.getAtleteClubs() != null && !atlete.getAtleteDeceases().isEmpty()) {
            atleteDTO.setAtleteClubs(atleteClubService.convertList(atlete.getAtleteClubs()));
        }
        if (atlete.getAtleteDeceases() != null && !atlete.getAtleteDeceases().isEmpty()) {
            atleteDTO.setAtleteDeceases(atleteDeceaseService.convertList(atlete.getAtleteDeceases()));
        }
        return atleteDTO;
    }

    public Atlete EntityDataConverter(AtleteDTO atleteDTO) {
        Atlete atlete = new Atlete();
        atlete.setIdAtlete(atleteDTO.getIdAtlete());
        atlete.setAtleteName(atleteDTO.getAtleteName());
        atlete.setAtleteAge(atleteDTO.getAtleteAge());
        atlete.setDateBirth(atleteDTO.getDateBirth());
        atlete.setAtleteHeight(atleteDTO.getAtleteHeight());
        atlete.setAtleteWeight(atleteDTO.getAtleteWeight());
        atlete.setAtleteImc(atleteDTO.getAtleteImc());
        atlete.setAtleteBid(atleteDTO.getAtleteBid());
        atlete.setDominantLeg(atleteDTO.getDominantLeg());
        atlete.setPosition(atleteDTO.getPosition());
        atlete.setPlayStyle(atleteDTO.getPlayStyle());
        if (atleteDTO.getAdress() != null) {
            atlete.setAdress(adressService.desconvertObject(atleteDTO.getAdress()));
        }
        if (atleteDTO.getContact() != null) {
            atlete.setContact(contactService.desconvertObject(atleteDTO.getContact()));
        }
        if (atleteDTO.getAtleteClubs() != null && !atleteDTO.getAtleteClubs().isEmpty()) {
            atlete.setAtleteClubs(atleteClubService.desconvertList(atleteDTO.getAtleteClubs()));
        }
        if (atleteDTO.getAtleteDeceases() != null && !atleteDTO.getAtleteDeceases().isEmpty()) {
            atlete.setAtleteDeceases(atleteDeceaseService.desconvertList(atleteDTO.getAtleteDeceases()));
        }
        return atlete;
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
        if (updated.getDateBirth() != null && !updated.getDateBirth().equals(saved.getDateBirth())) {
            saved.setDateBirth(updated.getDateBirth());
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
        if (updated.getDominantLeg() != null && !updated.getDominantLeg().equals(saved.getDominantLeg())) {
            saved.setDominantLeg(updated.getDominantLeg());
        }
        if (updated.getPosition() != null && !updated.getPosition().equals(saved.getPosition())) {
            saved.setPosition(updated.getPosition());
        }
        if (updated.getPlayStyle() != null && !updated.getPlayStyle().equals(saved.getPlayStyle())) {
            saved.setPlayStyle(updated.getPlayStyle());
        }
        if (updated.getContact() != null && !updated.getContact().equals(saved.getContact())) {
            saved.setContact(updated.getContact());
        }
        if (updated.getAdress() != null && !updated.getAdress().equals(saved.getAdress())) {
            saved.setAdress(updated.getAdress());
        }
        if (updated.getAtleteClubs() != null && !updated.getAtleteClubs().isEmpty()) {
            for (AtleteClub atleteClub : updated.getAtleteClubs()) {
                atleteClubService.updateObject(atleteClub.getId(), atleteClub,atleteClubRepository);
            }
        }
        if (updated.getAtleteDeceases() != null && !updated.getAtleteDeceases().isEmpty()) {
            for (AtleteDecease atleteDecease : updated.getAtleteDeceases()) {
                atleteDeceaseService.updateObject(atleteDecease.getId(), atleteDecease, atleteDeceaseRepository);
            }
        }
        return saved;
    }
}
