package com.ages.joinfut.model;
import com.ages.joinfut.Enum.UserType;
import com.ages.joinfut.dto.UserDTO;
import com.ages.joinfut.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Type;

import javax.persistence.*;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Athlete")
    private Athlete athlete;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Club")
    private Club club;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "creation_date")
    private Date creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;


    public User() {}
    
    public User(UserDTO userDTO) {
        UserService userService = new UserService();
        User user = userService.EntityDataConverter(userDTO);
        this.idUser = user.idUser;
        this.email = user.email;
        this.password = user.password;
        this.athlete = user.athlete;
        this.club = user.club;
        this.creationDate = user.creationDate;
        this.userType = user.userType;
    }

    public Long getId() {
        return getIdUser();
    }

    
}
