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

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "email")
    private String email;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "password")
    private String password;

    //Data criação

    public User() {}
    
    public User(UserDTO userDTO) {
        this.idUser = userDTO.getIdUser();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        
        //Data criação
    }

    public Long getId() {
        return getId();
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // get/setDataCriação

    
}
