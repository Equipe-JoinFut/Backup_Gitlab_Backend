package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.AthleteDTO;
import com.ages.joinfut.dto.AthleteSlimDTO;
import com.ages.joinfut.model.Athlete;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AthleteMapper {
    AthleteDTO AthleteToAthleteDTO(Athlete athlete);
    AthleteSlimDTO AthleteToAthleteSlimDTO(Athlete athlete);
    Athlete AthleteDTOToAthlete(AthleteDTO athleteDTO);
}
