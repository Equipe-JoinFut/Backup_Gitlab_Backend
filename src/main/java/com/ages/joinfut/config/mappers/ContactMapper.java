package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.ContactDTO;
import com.ages.joinfut.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    ContactMapper MAPPER = Mappers.getMapper(ContactMapper.class);

    ContactDTO ContactToContactDTO(Contact contact);
    Contact ContactDTOToContact(ContactDTO contactDTO);
}
