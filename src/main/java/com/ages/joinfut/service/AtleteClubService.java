package com.ages.joinfut.service;

import com.ages.joinfut.dto.AtleteClubDTO;
import com.ages.joinfut.model.AtleteClub;
import com.ages.joinfut.repository.AtleteClubRepository;
import com.ages.joinfut.repository.AtleteRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AtleteClubService {
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
        return saved;
    }
}
