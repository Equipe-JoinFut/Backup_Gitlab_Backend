package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.AthleteClubDTO;
import com.ages.joinfut.model.AthleteClub;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AthleteClubMapper {

    AthleteClubMapper MAPPER = Mappers.getMapper(AthleteClubMapper.class);

    AthleteClubDTO AthleteClubToAthleteClubDTO(AthleteClub athleteClub);
    AthleteClub AthleteClubDTOToAthleteClub(AthleteClubDTO athleteClubDTO);
}
