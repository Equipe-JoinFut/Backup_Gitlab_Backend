package com.ages.joinfut.dto;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.PlayStyle;
import com.ages.joinfut.Enum.Position;
import com.ages.joinfut.model.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class AtleteDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Atleta")
    private Long idAtlete;

    @ApiModelProperty(position = 2, notes = "Nome do Alteta")
    private String atleteName;

    @ApiModelProperty(position = 3, notes = "Idade do Atleta")
    private Integer atleteAge;

    @ApiModelProperty(position = 4, notes = "Data de nascimento")
    private Date dateBirth;

    @ApiModelProperty(position = 5, notes = "Peso do Atleta")
    private Double atleteHeight;

    @ApiModelProperty(position = 6, notes = "Altura do Atleta")
    private Double atleteWeight;

    @ApiModelProperty(position = 7, notes = "IMC do Atlela")
    private Double atleteImc;

    @ApiModelProperty(position = 8, notes = "Código BID do Atleta")
    private String atleteBid;

    @ApiModelProperty(position = 9, notes = "Perna Dominante")
    private DominantLeg dominantLeg;

    @ApiModelProperty(position = 10, notes = "Posição")
    private Position position;

    @ApiModelProperty(position = 11, notes = "Estilo de jogo")
    private PlayStyle playStyle;

    @ApiModelProperty(position = 12, notes = "Endereço do jogador")
    private Adress adress;

    @ApiModelProperty(position = 13, notes = "Contato do jogador")
    private Contact contact;

    @ApiModelProperty(position = 14, notes = "Histórico de Clubes do Atleta")
    private List<AtleteClub> atleteClubs;

    @ApiModelProperty(position = 15, notes = "Doenças pŕe-existentes do Atleta")
    private List<AtleteDecease> atleteDeceases;

    public AtleteDTO () {}

    public AtleteDTO (Atlete atlete) {
        this.idAtlete = atlete.getIdAtlete();
        this.atleteName = atlete.getAtleteName();
        this.atleteAge = atlete.getAtleteAge();
        this.dateBirth = atlete.getDateBirth();
        this.atleteHeight = atlete.getAtleteHeight();
        this.atleteWeight = atlete.getAtleteWeight();
        this.atleteImc = atlete.getAtleteImc();
        this.atleteBid = atlete.getAtleteBid();
        this.dominantLeg = atlete.getDominantLeg();
        this.position = atlete.getPosition();
        this.playStyle = atlete.getPlayStyle();
        this.adress = atlete.getAdress();
        this.contact = atlete.getContact();
        this.atleteClubs = atlete.getAtleteClubs();
        this.atleteDeceases = atlete.getAtleteDeceases();
    }

    public Long getIdAtlete() {
        return idAtlete;
    }

    public String getAtleteName() {
        return atleteName;
    }

    public Integer getAtleteAge() {
        return atleteAge;
    }

    public Double getAtleteHeight() { return atleteHeight; }

    public Double getAtleteWeight() { return atleteWeight; }

    public Double getAtleteImc() { return atleteImc; }

    public String getAtleteBid() { return atleteBid; }

    public List<AtleteClub> getAtleteClubs() { return atleteClubs; }

    public List<AtleteDecease> getAtleteDeceases() { return atleteDeceases; }

    public Adress getAdress() {
        return adress;
    }

    public Contact getContact() {
        return contact;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public DominantLeg getDominantLeg() {
        return dominantLeg;
    }

    public Position getPosition() {
        return position;
    }

    public PlayStyle getPlayStyle() {
        return playStyle;
    }
}