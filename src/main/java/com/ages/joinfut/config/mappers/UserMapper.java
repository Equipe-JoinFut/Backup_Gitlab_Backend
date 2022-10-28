package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.UserDTO;
import com.ages.joinfut.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserDTO UserToUserDTO(User user);
    User UserDTOToUser(UserDTO userDTO);
}
