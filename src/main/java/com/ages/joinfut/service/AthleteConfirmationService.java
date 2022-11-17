package com.ages.joinfut.service;

import com.ages.joinfut.config.mappers.AthleteConfirmationMapper;
import com.ages.joinfut.dto.AthleteConfirmationDTO;
import com.ages.joinfut.model.AthleteConfirmation;
import com.ages.joinfut.repository.AthleteConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteConfirmationService {

    @Autowired
    private AthleteConfirmationRepository athleteConfirmationRepository;

    @Autowired
    public AthleteConfirmationService() {}
    @Transactional
    public AthleteConfirmation save(AthleteConfirmationDTO athleteConfirmationDTO) {
        AthleteConfirmation athleteConfirmation = AthleteConfirmationMapper.MAPPER.AthleteConfirmationDTOToAthleteConfirmation(athleteConfirmationDTO);
        athleteConfirmationRepository.save(athleteConfirmation);
        return athleteConfirmation;
    }

    public List<AthleteConfirmationDTO> convertList(List<AthleteConfirmation> athleteConfirmations) {
        return athleteConfirmations.stream().map(athleteConfirmation -> AthleteConfirmationMapper.MAPPER.AthleteConfirmationToAthleteConfirmationDTO(athleteConfirmation)).collect(Collectors.toList());
    }

    public AthleteConfirmation update(Long id, AthleteConfirmation update, AthleteConfirmationRepository athleteConfirmationRepository) {
        AthleteConfirmation saved = athleteConfirmationRepository.findByidAthleteConfirmation(id);
        if (update.getAthlete() != null && !update.getAthlete().equals(saved.getAthlete())) {
            saved.setAthlete(update.getAthlete());

        }
        // if (update.getSieve() != null && !update.getSieve().equals(saved.getSieve())) {
        //    saved.setSieve(update.getSieve());
        // }

        return saved;
    }

}
