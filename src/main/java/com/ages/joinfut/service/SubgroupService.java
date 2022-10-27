package com.ages.joinfut.service;

import com.ages.joinfut.dto.SubgroupDTO;
import com.ages.joinfut.model.Subgroup;
import com.ages.joinfut.repository.ClubRepository;
import com.ages.joinfut.repository.SubgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubgroupService {

    @Autowired
    private SubgroupRepository subgroupRepository;

    @Autowired
    private ClubRepository clubRepository;

    private ClubService clubService = new ClubService();

    @Transactional
    public void save(Subgroup subgroup){
        subgroupRepository.save(subgroup);
    }

    @Transactional
    public Subgroup update(Long id, Subgroup updated, SubgroupRepository subgroupRepository) {
        Subgroup saved = subgroupRepository.findByidSubgroup(id);
        if (saved.getSubgroupName() != null && !updated.getSubgroupName().equals(saved.getSubgroupName())) {
            saved.setSubgroupName(updated.getSubgroupName());
        }
        return saved;
    }

    @Transactional
    public void delete(@PathVariable Long id) {
        Optional<Subgroup> subgroupGetter = subgroupRepository.findById(id);
        Subgroup subgroup = subgroupGetter.get();
        subgroupRepository.delete(subgroup);
    }

    public SubgroupDTO DTODataConverter(Subgroup subgroup){
        SubgroupDTO subgroupDTO = new SubgroupDTO();
        subgroupDTO.setIdSubgroup(subgroup.getIdSubgroup());
        subgroupDTO.setSubgroupName(subgroup.getSubgroupName());
        if (subgroup.getClub() != null) {
            subgroupDTO.setClub(clubService.convertObject(subgroup.getClub()));
        }
        return subgroupDTO;
    }

    public Subgroup desconvertObject(SubgroupDTO subgroupDTO) {
        return new Subgroup(subgroupDTO);
    }

    public Subgroup EntityDataConverter(SubgroupDTO subgroupDTO) {
        Subgroup subgroup = new Subgroup();
        subgroup.setIdSubgroup(subgroupDTO.getIdSubgroup());
        subgroup.setSubgroupName(subgroupDTO.getSubgroupName());
        if (subgroupDTO.getClub() != null) {
            subgroup.setClub(clubService.desconvertObject(subgroupDTO.getClub()));
        }
        return subgroup;
    }

    public SubgroupDTO convertObject(Subgroup subgroup) {return new SubgroupDTO(subgroup);}

    public List<SubgroupDTO> convertList(List<Subgroup> subgroups) {
        return subgroups.stream().map(SubgroupDTO::new).collect(Collectors.toList());
    }

    public List<Subgroup> desconvertList(List<SubgroupDTO> subgroupDTOS) {
        return subgroupDTOS.stream().map(Subgroup::new).collect(Collectors.toList());
    }
}
