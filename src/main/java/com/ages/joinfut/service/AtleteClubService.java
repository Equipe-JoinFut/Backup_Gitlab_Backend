package com.ages.joinfut.service;

import com.ages.joinfut.dto.AtleteClubDTO;
import com.ages.joinfut.model.AtleteClub;
import com.ages.joinfut.repository.AtleteClubRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtleteClubService {

    private final AtleteClubRepository atleteClubRepository;
    public AtleteClubService(AtleteClubRepository atleteClubRepository) {
        this.atleteClubRepository = atleteClubRepository;
    }

    public void save(AtleteClub atleteClub) {
        atleteClubRepository.save(atleteClub);
    }

    public List<AtleteClubDTO> convertList(List<AtleteClub> atleteClubs) {
        return atleteClubs.stream().map(AtleteClubDTO::new).collect(Collectors.toList());
    }

    public AtleteClubDTO convertObject(AtleteClub atleteClub){
        return new AtleteClubDTO(atleteClub);
    }

    public List<AtleteClub> desconvertList(List<AtleteClubDTO> atleteClubDTOS) {
        return atleteClubDTOS.stream().map(AtleteClub::new).collect(Collectors.toList());
    }

    public AtleteClub desconvertObject(AtleteClubDTO atleteClubDTO) {
        return new AtleteClub(atleteClubDTO);
    }

    public AtleteClub updateObject(Long id, AtleteClub updated, AtleteClubRepository atleteClubRepository) {
        AtleteClub saved = atleteClubRepository.findByidAtleteClub(id);
        if (updated.getAtlete() != null && !updated.getAtlete().equals(saved.getAtlete())) {
            saved.setAtlete(updated.getAtlete());
        }
        if (updated.getAtleteClubName() != null && !updated.getAtleteClubName().equals(saved.getAtleteClubName())) {
            saved.setAtleteClubName(updated.getAtleteClubName());
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
