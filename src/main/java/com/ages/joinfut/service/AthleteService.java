package com.ages.joinfut.service;

import com.ages.joinfut.config.mappers.AthleteMapper;
import com.ages.joinfut.dto.AthleteDTO;
import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.model.AthleteClub;
import com.ages.joinfut.repository.AdressRepository;
import com.ages.joinfut.repository.AthleteClubRepository;
import com.ages.joinfut.repository.AthleteRepository;
import com.ages.joinfut.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private AthleteClubRepository athleteClubRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private ContactRepository contactRepository;

    private AthleteMapper athleteMapper;

    private AdressService adressService = new AdressService();
    private ContactService contactService = new ContactService();
    private AthleteClubService athleteClubService = new AthleteClubService();

    public AthleteService(){
    }

    @Transactional
    public Athlete save(AthleteDTO athleteDTO) {

        Athlete athlete = athleteMapper.AthleteDTOToAthlete(athleteDTO);

        calculateImc(athlete);

        athleteRepository.save(athlete);

        if (athlete.getAthleteClubs() != null && !athlete.getAthleteClubs().isEmpty()) {
            for (AthleteClub athleteClub : athlete.getAthleteClubs()) {
                athleteClub.setAthlete(athlete);
                athleteClubService.save(athleteClub, athleteClubRepository);
            }
        }
        if (athlete.getAdress() != null) {
            athlete.getAdress().setAthlete(athlete);
            adressService.save(athlete.getAdress(), adressRepository);
        }
        if (athlete.getContact() != null) {
            athlete.getContact().setAthlete(athlete);
            contactService.save(athlete.getContact(), contactRepository);
        }

        return athlete;
    }

    @Transactional
    public void delete( @PathVariable Long id) {
        Optional<Athlete> athleteGetter = athleteRepository.findById(id);
        Athlete athlete = athleteGetter.get();
        if (athlete.getContact() != null && athlete.getContact().getId() != null) {
            contactService.delete(athlete.getContact());
        }
        if (athlete.getAdress() != null && athlete.getAdress().getId() != null) {
            adressRepository.delete(athlete.getAdress());
        }
        if (athlete.getAthleteClubs() != null && !athlete.getAthleteClubs().isEmpty()) {
            for (AthleteClub athleteClub : athlete.getAthleteClubs()) {
                if (athleteClub.getId() != null) {
                    athleteClubRepository.delete(athleteClub);
                }
            }
        }

        athleteRepository.delete(athlete);
    }

    @Transactional
    public Athlete update(Long id, Athlete updated, AthleteRepository athleteRepository) {
        Athlete saved = athleteRepository.findByidAthlete(id);
        if (updated.getAthleteName() != null && !updated.getAthleteName().equals(saved.getAthleteName())) {
            saved.setAthleteName(updated.getAthleteName());
        }
        if (updated.getDateBirth() != null && !updated.getDateBirth().equals(saved.getDateBirth())) {
            saved.setDateBirth(updated.getDateBirth());
        }
        if (updated.getAthleteHeight() != null && !updated.getAthleteHeight().equals(saved.getAthleteHeight())) {
            saved.setAthleteHeight(updated.getAthleteHeight());
        }
        if (updated.getAthleteWeight() != null && !updated.getAthleteWeight().equals(saved.getAthleteWeight())) {
            saved.setAthleteWeight(updated.getAthleteWeight());
        }
        if (updated.getAthleteImc() != null && !updated.getAthleteImc().equals(saved.getAthleteImc())) {
            saved.setAthleteImc(updated.getAthleteImc());
        }
        if (updated.getAthleteBid() != null && !updated.getAthleteBid().equals(saved.getAthleteBid())) {
            saved.setAthleteBid(updated.getAthleteBid());
        }
        if (updated.getDominantLeg() != null && !updated.getDominantLeg().equals(saved.getDominantLeg())) {
            saved.setDominantLeg(updated.getDominantLeg());
        }
        if (updated.getPosition() != null && !updated.getPosition().equals(saved.getPosition())) {
            saved.setPosition(updated.getPosition());
        }
        if (updated.getContact() != null && !updated.getContact().equals(saved.getContact())) {
            saved.setContact(contactService.update(updated.getContact().getId(), updated.getContact(), contactRepository));
        }
        if (updated.getAdress() != null && !updated.getAdress().equals(saved.getAdress())) {
            saved.setAdress(adressService.update(updated.getAdress().getId(), updated.getAdress(), adressRepository));
        }
        if (updated.getAthleteClubs() != null && !updated.getAthleteClubs().isEmpty()) {
            for (AthleteClub athleteClub : updated.getAthleteClubs()) {
                athleteClubService.update(athleteClub.getId(), athleteClub,athleteClubRepository);
            }
        }
        if (updated.getDeceases() != null && !updated.getDeceases().equals(saved.getDeceases())) {
            saved.setDeceases(updated.getDeceases());
        }

        if (updated.getUser() != null && !updated.getUser().equals(saved.getUser())) {
            saved.setUser(updated.getUser());
        }

        return saved;
    }

    public List<AthleteDTO> convertList(List<Athlete> athletes) {
        return athletes.stream().map(AthleteDTO::new).collect(Collectors.toList());
    }

    public AthleteDTO DTODataConverter(Athlete athlete) {
        AthleteDTO athleteDTO = new AthleteDTO();
        athleteDTO.setIdAthlete(athlete.getIdAthlete());
        athleteDTO.setAthleteName(athlete.getAthleteName());
        athleteDTO.setDateBirth(athlete.getDateBirth());
        athleteDTO.setAthleteHeight(athlete.getAthleteHeight());
        athleteDTO.setAthleteWeight(athlete.getAthleteWeight());
        athleteDTO.setAthleteImc(athlete.getAthleteImc());
        athleteDTO.setAthleteBid(athlete.getAthleteBid());
        athleteDTO.setDominantLeg(athlete.getDominantLeg());
        athleteDTO.setPosition(athlete.getPosition());
        athleteDTO.setDeceases(athlete.getDeceases());
        if (athlete.getAdress() != null) {
            athleteDTO.setAdress(adressService.convertObject(athlete.getAdress()));
        }
        if (athlete.getContact() != null) {
            athleteDTO.setContact(contactService.convertObject(athlete.getContact()));
        }
        if (athlete.getAthleteClubs() != null && !athlete.getAthleteClubs().isEmpty()) {
            athleteDTO.setAthleteClubs(athleteClubService.convertList(athlete.getAthleteClubs()));
        }
        return athleteDTO;
    }

    public Athlete EntityDataConverter(AthleteDTO athleteDTO) {
        Athlete athlete = new Athlete();
        athlete.setIdAthlete(athleteDTO.getIdAthlete());
        athlete.setAthleteName(athleteDTO.getAthleteName());
        athlete.setDateBirth(athleteDTO.getDateBirth());
        athlete.setAthleteHeight(athleteDTO.getAthleteHeight());
        athlete.setAthleteWeight(athleteDTO.getAthleteWeight());
        athlete.setAthleteImc(athleteDTO.getAthleteImc());
        athlete.setAthleteBid(athleteDTO.getAthleteBid());
        athlete.setDominantLeg(athleteDTO.getDominantLeg());
        athlete.setPosition(athleteDTO.getPosition());
        athlete.setDeceases(athleteDTO.getDeceases());
        if (athleteDTO.getAdress() != null) {
            athlete.setAdress(adressService.desconvertObject(athleteDTO.getAdress()));
        }
        if (athleteDTO.getContact() != null) {
            athlete.setContact(contactService.desconvertObject(athleteDTO.getContact()));
        }
        if (athleteDTO.getAthleteClubs() != null && !athleteDTO.getAthleteClubs().isEmpty()) {
            athlete.setAthleteClubs(athleteClubService.desconvertList(athleteDTO.getAthleteClubs()));
        }
        return athlete;
    }

    public AthleteDTO convertObject(Athlete athlete){
        return new AthleteDTO(athlete);
    }


    public List<Athlete> desconvertList(List<AthleteDTO> athleteDTOS) {
        return athleteDTOS.stream().map(Athlete::new).collect(Collectors.toList());
    }

    public Athlete desconvertObject(AthleteDTO athleteDTO) {
        return new Athlete(athleteDTO);
    }

    public void calculateImc(Athlete athlete){ athlete.setAthleteImc(athlete.getAthleteWeight() / (Math.pow(athlete.getAthleteWeight(), 2))); }

}
