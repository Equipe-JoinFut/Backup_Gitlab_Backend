package com.ages.joinfut.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "sieves", schema = "personas")
public class Sieve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sieve")
    private Long idSieve;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "sieve_name")
    private String sieveName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subgroup")
    private Subgroup subgroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_club")
    private Club club;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "sieve_local")
    private String local;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "date")
    private String date;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "time")
    private String time;

    public Sieve(){}

    public Long getId(){ return getIdSieve(); }
}