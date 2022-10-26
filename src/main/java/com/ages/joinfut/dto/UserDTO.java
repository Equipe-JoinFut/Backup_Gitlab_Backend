package com.ages.joinfut.dto;

import java.util.Date;

import com.ages.joinfut.Enum.UserType;
import com.ages.joinfut.model.User;
import com.ages.joinfut.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Usuário")
    private Long idUser;

    @ApiModelProperty(position = 2, notes = "Email do Usuário")
    private String email;

    @ApiModelProperty(position = 3, notes = "Senha do Usuário")
    private String password;

    @ApiModelProperty(position = 4, notes = "Usuário Atleta")
    private AthleteDTO athlete;

    @ApiModelProperty(position = 5, notes = "Usuário Clube")
    private ClubDTO club;

    @ApiModelProperty(position = 6, notes = "Tipo de Usuario")
    private UserType userType;

    @ApiModelProperty(position = 7, notes = "Data de criação do Usuário")
    private Date creationDate;



    public UserDTO () {}

    public UserDTO (User user) {
        UserService userService = new UserService();
        UserDTO userDTO = userService.DTODataConverter(user);
        this.idUser = userDTO.idUser;
        this.email = userDTO.email;
        this.password = userDTO.password;
        this.athlete = userDTO.athlete;
        this.club = userDTO.club;
        this.userType = userDTO.userType;
        this.creationDate = userDTO.creationDate;
    }

    public Long getId() {
        return getIdUser();
    }
}
