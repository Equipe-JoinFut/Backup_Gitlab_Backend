package com.ages.joinfut.service;

import com.ages.joinfut.dto.AtleteDTO;
import com.ages.joinfut.dto.TemplateDTO;
import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.model.Template;
import com.ages.joinfut.repository.AtleteRepository;
import com.ages.joinfut.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtleteService {

    public List<AtleteDTO> convertList(List<Atlete> atletes) {
        return atletes.stream().map(AtleteDTO::new).collect(Collectors.toList());
    }

    public AtleteDTO convertObject(Atlete atlete){
        return new AtleteDTO(atlete);
    }

    public List<Atlete> desconvertList(List<AtleteDTO> atleteDTOS) {
        return atleteDTOS.stream().map(Atlete::new).collect(Collectors.toList());
    }

    public Atlete desconvertObject(AtleteDTO atleteDTO) {
        return new Atlete(atleteDTO);
    }

    public Atlete updateObject(Long id, Atlete updated, AtleteRepository atleteRepository) {
        Atlete saved = atleteRepository.findByidAtlete(id);
        if (updated.getAtleteName() != null && !updated.getAtleteName().equals(saved.getAtleteName())) {
            saved.setAtleteName(updated.getAtleteName());
        }
        if (updated.getAtleteAge() != null && !updated.getAtleteAge().equals(saved.getAtleteAge())) {
            saved.setAtleteAge(updated.getAtleteAge());
        }
        return saved;
    }
}
