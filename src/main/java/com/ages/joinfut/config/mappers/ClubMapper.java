package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.ClubDTO;
import com.ages.joinfut.dto.ClubSlimDTO;
import com.ages.joinfut.model.Club;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClubMapper {

    ClubMapper MAPPER = Mappers.getMapper(ClubMapper.class);

    ClubDTO ClubToClubDTO(Club club);
    ClubSlimDTO ClubToClubSlimDTO(Club club);
    Club ClubDTOToClub(ClubDTO clubDTO);
    Club ClubSlimDTOToClub(ClubSlimDTO clubSlimDTO);
    //ClubSlim ClubToClubSlim(Club club);
}
