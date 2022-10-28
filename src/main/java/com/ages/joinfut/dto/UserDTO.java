package com.ages.joinfut.dto;

import java.util.Date;

import com.ages.joinfut.Enum.UserType;
import com.ages.joinfut.model.AthleteSlim;
import com.ages.joinfut.model.Club;
import com.ages.joinfut.model.ClubSlim;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Usuário")
    private Long idUser;

    @ApiModelProperty(position = 2, notes = "Email do Usuário")
    private String email;

    @ApiModelProperty(position = 3, notes = "Senha do Usuário")
    private String password;

    @ApiModelProperty(position = 4, notes = "Usuário Atleta")
    private AthleteSlim athlete;

    @ApiModelProperty(position = 5, notes = "Usuário Clube")
    private ClubSlim club;

    @ApiModelProperty(position = 6, notes = "Tipo de Usuario")
    private UserType userType;

    @ApiModelProperty(position = 7, notes = "Data de criação do Usuário")
    private Date creationDate;

    public UserDTO () {}

    public Long getId() {
        return getIdUser();
    }
}
