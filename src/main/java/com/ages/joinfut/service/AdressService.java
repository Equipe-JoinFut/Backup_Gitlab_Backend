package com.ages.joinfut.service;

import com.ages.joinfut.dto.AdressDTO;
import com.ages.joinfut.model.Adress;
import com.ages.joinfut.repository.AdressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdressService {

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
        if (updated.getHouseNumber() != null && !updated.getHouseNumber().equals(saved.getHouseNumber())) {
            saved.setHouseNumber(updated.getHouseNumber());
        }
        if (updated.getCity() != null && !updated.getCity().equals(saved.getCity())) {
            saved.setCity(updated.getCity());
        }
        return saved;
    }
}
