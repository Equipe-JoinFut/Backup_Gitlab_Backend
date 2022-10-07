package com.ages.joinfut.dto;

import java.util.Date;

import com.ages.joinfut.Enum.UserType;
import com.ages.joinfut.model.Atlete;
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

    @ApiModelProperty(position = 4, notes = "Iddentificado único do Atleta Vinculado")
    private Long idAtlete;

    @ApiModelProperty(position = 5, notes = "Idenficiador único do Clube Vinculado")
    private Long idClub;

    @ApiModelProperty(position = 6, notes = "Tipo de Usuario")
    private UserType userType;

    @ApiModelProperty(position = 7, notes = "Data de criação do Usuário")
    private Date creationDate;



    public UserDTO () {}

    public UserDTO (User user) {
        this.idUser = user.getIdUser();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.idAtlete = user.getIdAtlete();
        this.idClub = user.getIdClub();
        this.userType = user.getUserType();
        this.creationDate = user.getCreationDate();
    }

    public Long getIdUser() {
        return idUser;
    }

    

}