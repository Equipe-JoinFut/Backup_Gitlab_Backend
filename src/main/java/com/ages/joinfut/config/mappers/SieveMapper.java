package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.SieveDTO;
import com.ages.joinfut.dto.SieveSlimDTO;
import com.ages.joinfut.model.Sieve;
import com.ages.joinfut.model.SieveSlim;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SieveMapper {
    SieveMapper MAPPER = Mappers.getMapper(SieveMapper.class);
    SieveDTO SieveToSieveDTO(Sieve sieve);
    SieveSlimDTO SieveToSieveSlimDTO(Sieve sieve);
    Sieve SieveDTOToSieve(SieveDTO sieveDTO);
    Sieve SieveSlimDTOToSieve(SieveDTO sieveDTO);
    SieveSlim SieveToSieveSlim(Sieve sieve);
}
