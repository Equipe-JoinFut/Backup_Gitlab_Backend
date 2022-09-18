package com.ages.joinfut.model;

import com.ages.joinfut.dto.AtleteClubDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "atlete_clubs", schema = "informations")
public class AtleteClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atlete_club")
    private Long idAtleteClub;

    @JoinColumn(name = "id_atlete")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Atlete atlete;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "atlete_club_name")
    private String atleteClubName;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "begin_date")
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "flag_current_club")
    private Boolean currentClub;

    public AtleteClub() {
        super();
    }

    public AtleteClub(AtleteClubDTO atleteClubDTO) {
        this.idAtleteClub = atleteClubDTO.getIdAtleteClub();
        this.atlete = atleteClubDTO.getAtlete();
        this.atleteClubName = atleteClubDTO.getAtleteClubName();
        this.beginDate = atleteClubDTO.getBeginDate();
        this.endDate = atleteClubDTO.getEndDate();
        this.currentClub = atleteClubDTO.getCurrentClub();
    }

    public Long getId() {
        return getIdAtleteClub();
    }

    public Long getIdAtleteClub() {
        return idAtleteClub;
    }

    public void setIdAtleteClub(Long idAtleteClub) {
        this.idAtleteClub = idAtleteClub;
    }

    public Atlete getAtlete() {
        return atlete;
    }

    public void setAtlete(Atlete atlete) {
        this.atlete = atlete;
    }

    public String getAtleteClubName() {
        return atleteClubName;
    }

    public void setAtleteClubName(String atleteClubName) {
        this.atleteClubName = atleteClubName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(Boolean currentClub) {
        this.currentClub = currentClub;
    }
}
