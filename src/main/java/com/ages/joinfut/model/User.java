package com.ages.joinfut.model;
import com.ages.joinfut.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "personas")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    //Email
    //Senha
    //Data criação

    public User() {}
    
    public User(UserDTO userDTO) {
        this.idUser = userDTO.getIdUser();
        
        //Email
        //Senha
        //Data criação
    }

    public Long getId() {return getId();}

    public Long getIdUser() { return idUser; }

    public void setIdUser(Long idUser) { this.idUser = idUser; }

    // get/setEmail
    // get/setSenha
    // get/setDataCriação

    
}
