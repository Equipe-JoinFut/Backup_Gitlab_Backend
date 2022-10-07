package com.ages.joinfut.service;

import com.ages.joinfut.dto.AdressDTO;
import com.ages.joinfut.model.Adress;
import com.ages.joinfut.repository.AdressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdressService {

    public AdressService() {}

    @Transactional
    public void save(Adress adress, AdressRepository adressRepository) {
        adressRepository.save(adress);
    }

    public List<AdressDTO> convertList(List<Adress> adresses) {
        return adresses.stream().map(AdressDTO::new).collect(Collectors.toList());
    }

    public AdressDTO convertObject(Adress adress) {return new AdressDTO(adress);}

    public List<Adress> desconvertList(List<AdressDTO> adressDTOS) {
        return adressDTOS.stream().map(Adress::new).collect(Collectors.toList());
    }

    public Adress desconvertObject(AdressDTO adressDTO){return new Adress(adressDTO);}

    public Adress update(Long id, Adress updated, AdressRepository adressRepository) {
        Adress saved = adressRepository.findByidAdress(id);
        if (updated.getStreetInfo() != null && !updated.getStreetInfo().equals(saved.getStreetInfo())) {
            saved.setStreetInfo(updated.getStreetInfo());
        }
        if (updated.getAthlete() != null && !updated.getAthlete().equals(saved.getAthlete())) {
            saved.setAthlete(updated.getAthlete());
        }
        if (updated.getCity() != null && !updated.getCity().equals(saved.getCity())) {
            saved.setCity(updated.getCity());
        }
        if (updated.getState() != null && !updated.getState().equals(saved.getState())) {
            saved.setState(updated.getState());
        }
        adressRepository.save(saved);
        return saved;
    }
}
