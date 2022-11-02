package com.ages.joinfut.service;

import com.ages.joinfut.config.mappers.SubgroupMapper;
import com.ages.joinfut.dto.SubgroupDTO;
import com.ages.joinfut.model.AthleteSubgroup;
import com.ages.joinfut.model.Subgroup;
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

    private ClubService clubService = new ClubService();

    @Transactional
    public Subgroup save(SubgroupDTO subgroupDTO){
        Subgroup subgroup = SubgroupMapper.MAPPER.SubgroupDTOToSubgroup(subgroupDTO);
        subgroupRepository.save(subgroup);
        return subgroup;
    }

    @Transactional
    public Subgroup update(Long id, SubgroupDTO subgroupDTO, SubgroupRepository subgroupRepository) {
        Subgroup updated = SubgroupMapper.MAPPER.SubgroupDTOToSubgroup(subgroupDTO);
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

    public List<SubgroupDTO> convertList(List<Subgroup> subgroups) {
        return subgroups.stream().map(subgroup -> SubgroupMapper.MAPPER.SubgroupToSubgroupDTO(subgroup)).collect(Collectors.toList());
    }

    public void insertAthleteSubgroupToList(AthleteSubgroup athleteSubgroup) {
        Optional<Subgroup> subgroupGetter = subgroupRepository.findById(athleteSubgroup.getSubgroup().getId());
        Subgroup subgroup = subgroupGetter.get();
        subgroup.getAthleteSubgroups().add(athleteSubgroup);
    }
}
