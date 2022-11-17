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
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AthleteService{

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private AthleteClubRepository athleteClubRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private ContactRepository contactRepository;

    private AdressService adressService = new AdressService();
    private ContactService contactService = new ContactService();
    private AthleteClubService athleteClubService = new AthleteClubService();

    public AthleteService(){
    }

    @Transactional
    public Athlete save(AthleteDTO athleteDTO) {

        Athlete athlete = AthleteMapper.MAPPER.AthleteDTOToAthlete(athleteDTO);

        calculateImc(athlete);

        calculateAge(athlete);

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
    public void delete(@PathVariable Long id) {
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
    public Athlete update(Long id, AthleteDTO athleteDTO, AthleteRepository athleteRepository) {
        Athlete updated = AthleteMapper.MAPPER.AthleteDTOToAthlete(athleteDTO);
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
        return athletes.stream().map(athlete -> AthleteMapper.MAPPER.AthleteToAthleteDTO(athlete)).collect(Collectors.toList());
    }

    public void calculateImc(Athlete athlete){
        double imc = athlete.getAthleteWeight() / (Math.pow(athlete.getAthleteHeight(), 2));
        double formattedImc = Math.floor(imc * 100) / 100;
        athlete.setAthleteImc(formattedImc); 
    }

    public void calculateAge(Athlete athlete) {
        Date dateNow = new Date();
        Long timeBetween = dateNow.getTime() - athlete.getDateBirth().getTime();
        Double yearsBetween = timeBetween / 3.15576e+10;
        int age = (int) Math.floor(yearsBetween);
        athlete.setAge(age);
    }

}
