package com.ages.joinfut.dto;

import java.util.Date;

import com.ages.joinfut.Enum.UserType;
import com.ages.joinfut.model.User;
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

    @ApiModelProperty(position = 4, notes = "Data de criação do Usuário")
    private Date creationDate;

    @ApiModelProperty(position = 5, notes = "Tipo de Usuario")
    private UserType userType;

    public UserDTO () {}

    public UserDTO (User user) {
        this.idUser = user.getIdUser();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.creationDate = user.getCreationDate();
        this.userType = user.getUserType();
    }

    public Long getIdUser() {
        return idUser;
    }

    

}