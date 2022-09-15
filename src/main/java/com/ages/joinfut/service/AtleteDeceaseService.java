package com.ages.joinfut.service;

import com.ages.joinfut.dto.AtleteDeceaseDTO;
import com.ages.joinfut.model.AtleteDecease;
import com.ages.joinfut.repository.AtleteDeceaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtleteDeceaseService {

    @Autowired
    private AtleteDeceaseRepository atleteDeceaseRepository;

    public AtleteDeceaseService() {}

    @Transactional
    public void save(AtleteDecease atleteDecease, AtleteDeceaseRepository atleteDeceaseRepository) {
        this.atleteDeceaseRepository = atleteDeceaseRepository;
        atleteDeceaseRepository.save(atleteDecease);
    }

    public List<AtleteDeceaseDTO> convertList(List<AtleteDecease> atletes) {
        return atletes.stream().map(AtleteDeceaseDTO::new).collect(Collectors.toList());
    }

    public AtleteDeceaseDTO convertObject(AtleteDecease atleteDecease){
        return new AtleteDeceaseDTO(atleteDecease);
    }

    public List<AtleteDecease> desconvertList(List<AtleteDeceaseDTO> atleteDTOS) {
        return atleteDTOS.stream().map(AtleteDecease::new).collect(Collectors.toList());
    }

    public AtleteDecease desconvertObject(AtleteDeceaseDTO atleteDTO) {
        return new AtleteDecease(atleteDTO);
    }

    public AtleteDecease updateObject(Long id, AtleteDecease updated, AtleteDeceaseRepository atleteDeceaseRepository) {
        AtleteDecease saved = atleteDeceaseRepository.findByidAtleteDecease(id);
        if (updated.getAtlete() != null && !updated.getAtlete().equals(saved.getAtlete())) {
            saved.setAtlete(updated.getAtlete());
        }
        if (updated.getAtleteDeceaseName() != null && !updated.getAtleteDeceaseName().equals(saved.getAtleteDeceaseName())) {
            saved.setAtleteDeceaseName(updated.getAtleteDeceaseName());
        }
        return saved;
    }
}
