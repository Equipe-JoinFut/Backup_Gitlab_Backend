package com.ages.joinfut.dto;

import com.ages.joinfut.model.User;
import io.swagger.annotations.ApiModelProperty;

public class UserDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Usuário")
    private Long idUser;

    @ApiModelProperty(position = 4, notes = "Email do Usuário")
    private String email;

    @ApiModelProperty(position = 4, notes = "Senha do Usuário")
    private String password;


    public UserDTO (User user) {
        this.idUser = user.getIdUser();
        this.email = user.getEmail();
        this.password = user.getPassword();
        // Data criação
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // getData criação

}