package com.ages.joinfut.config.mappers;

import com.ages.joinfut.controller.AthleteConfirmationController;
import com.ages.joinfut.dto.AthleteConfirmationDTO;
import com.ages.joinfut.dto.AthleteSlimDTO;
import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.model.AthleteConfirmation;
import com.ages.joinfut.model.AthleteSlim;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AthleteConfirmationMapper {

    AthleteConfirmationMapper MAPPER = Mappers.getMapper(AthleteConfirmationMapper.class);

    AthleteConfirmationDTO AthleteConfirmationToAthleteConfirmationDTO(AthleteConfirmation athleteConfirmation);
    AthleteSlimDTO AthleteConfirmationToAthleteSlimDTO(Athlete athlete);
    AthleteConfirmation AthleteConfirmationDTOToAthleteConfirmation(AthleteConfirmationDTO athleteConfirmationDTO);
    AthleteConfirmation AthleteSlimDTOToAthleteConfirmation(AthleteSlimDTO athleteSlimDTO);
    AthleteSlim AthleteConfirmationToAthleteSlim(AthleteConfirmation athleteConfirmation);

}
