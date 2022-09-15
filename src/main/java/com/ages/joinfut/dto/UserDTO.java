package com.ages.joinfut.dto;

import com.ages.joinfut.model.User;
import io.swagger.annotations.ApiModelProperty;

public class UserDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do User")
    private Long idUser;

    // Email
    // Senha
    // Data criação

    public UserDTO (User user) {
        this.idUser = user.getIdUser();
        // Email
        //Senha
        // Data criação
    }

    public Long getIdUser() { return idUser; }

    // getEmail
    // getSenha
    // getData criação

}