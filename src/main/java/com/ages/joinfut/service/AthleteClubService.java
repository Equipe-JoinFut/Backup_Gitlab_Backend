package com.ages.joinfut.service;

import com.ages.joinfut.dto.AthleteClubDTO;
import com.ages.joinfut.model.AthleteClub;
import com.ages.joinfut.repository.AthleteClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteClubService {

    @Autowired

    public AthleteClubService() {}

    @Transactional
    public void save(AthleteClub athleteClub, AthleteClubRepository athleteClubRepository) {
        athleteClubRepository.save(athleteClub);
    }

    public List<AthleteClubDTO> convertList(List<AthleteClub> athleteClubs) {
        return athleteClubs.stream().map(AthleteClubDTO::new).collect(Collectors.toList());
    }

    public AthleteClubDTO convertObject(AthleteClub athleteClub){
        return new AthleteClubDTO(athleteClub);
    }

    public List<AthleteClub> desconvertList(List<AthleteClubDTO> athleteClubDTOS) {
        return athleteClubDTOS.stream().map(AthleteClub::new).collect(Collectors.toList());
    }

    public AthleteClub desconvertObject(AthleteClubDTO athleteClubDTO) {
        return new AthleteClub(athleteClubDTO);
    }

    public AthleteClub update(Long id, AthleteClub updated, AthleteClubRepository athleteClubRepository) {
        AthleteClub saved = athleteClubRepository.findByidAthleteClub(id);
        if (updated.getAthlete() != null && !updated.getAthlete().equals(saved.getAthlete())) {
            saved.setAthlete(updated.getAthlete());
        }
        if (updated.getAthleteClubName() != null && !updated.getAthleteClubName().equals(saved.getAthleteClubName())) {
            saved.setAthleteClubName(updated.getAthleteClubName());
        }
        if (updated.getBeginDate() != null && !updated.getBeginDate().equals(saved.getBeginDate())) {
            saved.setBeginDate(updated.getBeginDate());
        }
        if (updated.getEndDate() != null && !updated.getEndDate().equals(saved.getEndDate())) {
            saved.setEndDate(updated.getEndDate());
        }
        return saved;
    }
}