package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.AthleteSubgroupDTO;
import com.ages.joinfut.model.AthleteSubgroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AthleteSubgroupMapper {

    AthleteSubgroupMapper MAPPER = Mappers.getMapper(AthleteSubgroupMapper.class);

    AthleteSubgroupDTO AthleteSubgroupToAthleteSubgroupDTO(AthleteSubgroup athleteSubgroup);
    AthleteSubgroup AthleteSubgroupDTOToAthleteSubgroup(AthleteSubgroupDTO athleteSubgroupDTO);
}
