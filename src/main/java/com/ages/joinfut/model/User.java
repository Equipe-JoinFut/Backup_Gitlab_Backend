package com.ages.joinfut.model;
import com.ages.joinfut.Enum.UserType;
import com.ages.joinfut.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


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

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;


    public User() {}
    
    public User(UserDTO userDTO) {
        this.idUser = userDTO.getIdUser();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.creationDate = userDTO.getCreationDate();
        this.userType = userDTO.getUserType();
    }

    public Long getId() {
        return getIdUser();
    }

    
}
