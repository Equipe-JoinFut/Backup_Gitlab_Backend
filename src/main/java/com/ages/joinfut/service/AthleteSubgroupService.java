package com.ages.joinfut.service;

import com.ages.joinfut.dto.AthleteSubgroupDTO;
import com.ages.joinfut.model.AthleteSubgroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteSubgroupService {

    @Autowired

    public AthleteSubgroupService() {}

    @Transactional
    public void save(AthleteSubgroup athleteSubgroup) {
        athleteSubgroupRepository.save(athleteSubgroup);
    }

    public List<AthleteSubgroupDTO> convertList(List<AthleteSubgroup> athleteSubgroups) {
        return athleteSubgroups.stream().map(AthleteSubgroupDTO::new).collect(Collectors.toList());
    }

    public AthleteSubgroupDTO convertObject(AthleteSubgroup athleteSubgroup) { return new AthleteSubgroupDTO(athleteSubgroup);
    }

    public List<AthleteSubgroup> desconvertList(List<AthleteSubgroupDTO> athleteSubgroupDTOS) {
        return athleteSubgroupDTOS.stream().map(AthleteSubgroup::new).collect(Collectors.toList());
    }

    public AthleteSubgroup desconvertObject(AthleteSubgroupDTO athleteSubgroupDTO) { return new AthleteSubgroup(athleteSubgroupDTO); }

}
