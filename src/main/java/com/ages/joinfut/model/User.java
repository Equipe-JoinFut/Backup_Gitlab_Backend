package com.ages.joinfut.model;
import com.ages.joinfut.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Type;

import java.util.Date;

import javax.persistence.*;

@Getter
@Setter

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

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "creation_date")
    private Date creationDate;

    public User() {}
    
    public User(UserDTO userDTO) {
        this.idUser = userDTO.getIdUser();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.creationDate = userDTO.getCreationDate();
        
    }

    public Long getId() {
        return getIdUser();
    }

    
}
