package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.AthleteDTO;
import com.ages.joinfut.dto.AthleteSlimDTO;
import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.model.AthleteSlim;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AthleteMapper {

    AthleteMapper MAPPER = Mappers.getMapper(AthleteMapper.class);

    AthleteDTO AthleteToAthleteDTO(Athlete athlete);
    AthleteSlimDTO AthleteToAthleteSlimDTO(Athlete athlete);
    Athlete AthleteDTOToAthlete(AthleteDTO athleteDTO);
    Athlete AthleteSlimDTOToAthlete(AthleteSlimDTO athleteSlimDTO);
    AthleteSlim AthleteToAthleteSlim(Athlete athlete);
}
