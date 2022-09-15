package com.ages.joinfut.service;

import com.ages.joinfut.dto.AdressDTO;
import com.ages.joinfut.model.Adress;
import com.ages.joinfut.repository.AdressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdressService {

    private final AdressRepository adressRepository;
    public AdressService(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    public void save(Adress adress) {
        adressRepository.save(adress);
    }
    public List<AdressDTO> convertList(List<Adress> adresses) {
        return adresses.stream().map(AdressDTO::new).collect(Collectors.toList());
    }

    public AdressDTO convertObjet(Adress adress) {return new AdressDTO(adress);}

    public List<Adress> desconvertList(List<AdressDTO> adressDTOS) {
        return adressDTOS.stream().map(Adress::new).collect(Collectors.toList());
    }

    public Adress desconvertObject(AdressDTO adressDTO){return new Adress(adressDTO);}

    public Adress updateObject(Long id, Adress updated, AdressRepository adressRepository) {
        Adress saved = adressRepository.findByidAdress(id);
        if (updated.getStreet() != null && !updated.getStreet().equals(saved.getStreet())) {
            saved.setStreet(updated.getStreet());
        }
        if (updated.getAtlete() != null && !updated.getAtlete().equals(saved.getAtlete())) {
            saved.setAtlete(updated.getAtlete());
        }
        if (updated.getHouseNumber() != null && !updated.getHouseNumber().equals(saved.getHouseNumber())) {
            saved.setHouseNumber(updated.getHouseNumber());
        }
        if (updated.getCity() != null && !updated.getCity().equals(saved.getCity())) {
            saved.setCity(updated.getCity());
        }
        if (updated.getState() != null && !updated.getState().equals(saved.getState())) {
            saved.setState(updated.getState());
        }
        if (updated.getCountry() != null && !updated.getCountry().equals(saved.getCountry())) {
            saved.setCountry(updated.getCountry());
        }
        return saved;
    }
}
