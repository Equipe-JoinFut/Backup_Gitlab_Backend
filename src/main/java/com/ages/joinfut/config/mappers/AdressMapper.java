package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.AdressDTO;
import com.ages.joinfut.model.Adress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdressMapper {

    AdressMapper MAPPER = Mappers.getMapper(AdressMapper.class);

    AdressDTO AdressToAdressDTO(Adress adress);
    Adress AdressDTOToAdress(AdressDTO adressDTO);
}
