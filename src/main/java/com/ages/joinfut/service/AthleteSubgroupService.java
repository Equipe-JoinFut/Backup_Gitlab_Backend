package com.ages.joinfut.service;

import com.ages.joinfut.config.mappers.AthleteSubgroupMapper;
import com.ages.joinfut.dto.AthleteSubgroupDTO;
import com.ages.joinfut.model.AthleteSubgroup;
import com.ages.joinfut.repository.AthleteSubgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteSubgroupService {

    @Autowired
    private AthleteSubgroupRepository athleteSubgroupRepository;

    @Autowired
    private SubgroupService subgroupService;

    public AthleteSubgroupService() {}

    @Transactional
    public AthleteSubgroup save(AthleteSubgroupDTO athleteSubgroupDTO) {
        AthleteSubgroup athleteSubgroup = AthleteSubgroupMapper.MAPPER.AthleteSubgroupDTOToAthleteSubgroup(athleteSubgroupDTO);
        athleteSubgroupRepository.save(athleteSubgroup);
        subgroupService.insertAthleteSubgroupToList(athleteSubgroup);
        return athleteSubgroup;
    }

    public List<AthleteSubgroupDTO> convertList(List<AthleteSubgroup> athleteSubgroups) {
        return athleteSubgroups.stream().map(athleteSubgroup -> AthleteSubgroupMapper.MAPPER.AthleteSubgroupToAthleteSubgroupDTO(athleteSubgroup)).collect(Collectors.toList());
    }
}
