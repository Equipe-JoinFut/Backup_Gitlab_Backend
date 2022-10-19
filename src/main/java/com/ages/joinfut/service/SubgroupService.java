package com.ages.joinfut.service;

import com.ages.joinfut.dto.SubgroupDTO;
import com.ages.joinfut.model.Subgroup;
import com.ages.joinfut.repository.ClubRepository;
import com.ages.joinfut.repository.SubgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SubgroupService {

    @Autowired
    private SubgroupRepository subgroupRepository;

    @Autowired
    private ClubRepository subgroupClubRepository;

    private ClubService clubService = new ClubService();

    @Transactional
    public void save(Subgroup subgroup){

        subgroupRepository.save(subgroup);
    }

    public SubgroupDTO DTODataConverter(Subgroup subgroup){
        SubgroupDTO subgroupDTO = new SubgroupDTO();
        subgroupDTO.setIdSubgroup(subgroup.getIdSubgroup());
        subgroupDTO.setClub(subgroup.getClub());
        subgroupDTO.setSubGroupname(subgroup.getSubgroupName());
        return subgroupDTO;
    }

    public Subgroup desconvertObject(SubgroupDTO subgroupDTO) {
        return new Subgroup(subgroupDTO);
    }
}
