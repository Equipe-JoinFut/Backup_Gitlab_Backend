package com.ages.joinfut.dto;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.PlayStyle;
import com.ages.joinfut.Enum.Position;
import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.service.AtleteService;
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
    private AdressDTO adress;

    @ApiModelProperty(position = 13, notes = "Contato do jogador")
    private ContactDTO contact;

    @ApiModelProperty(position = 14, notes = "Historico de Clubes do Atleta")
    private List<AtleteClubDTO> atleteClubs;

    @ApiModelProperty(position = 15, notes = "Doenças pre-existentes do Atleta")
    private List<AtleteDeceaseDTO> atleteDeceases;

    public AtleteDTO () {}

    public AtleteDTO (Atlete atlete) {
        AtleteService atleteService = new AtleteService();
        AtleteDTO atleteDTO = atleteService.DTODataConverter(atlete);
        this.idAtlete = atleteDTO.idAtlete;
        this.atleteName = atleteDTO.atleteName;
        this.atleteAge = atleteDTO.atleteAge;
        this.dateBirth = atleteDTO.dateBirth;
        this.atleteHeight = atleteDTO.atleteHeight;
        this.atleteWeight = atleteDTO.atleteWeight;
        this.atleteImc = atleteDTO.atleteImc;
        this.atleteBid = atleteDTO.atleteBid;
        this.dominantLeg = atleteDTO.dominantLeg;
        this.position = atleteDTO.position;
        this.playStyle = atleteDTO.playStyle;
        this.adress = atleteDTO.adress;
        this.contact = atleteDTO.contact;
        this.atleteClubs = atleteDTO.atleteClubs;
        this.atleteDeceases = atleteDTO.atleteDeceases;
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

    public List<AtleteClubDTO> getAtleteClubs() { return atleteClubs; }

    public List<AtleteDeceaseDTO> getAtleteDeceases() { return atleteDeceases; }

    public AdressDTO getAdress() {
        return adress;
    }

    public ContactDTO getContact() {
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


    public void setIdAtlete(Long idAtlete) {
        this.idAtlete = idAtlete;
    }

    public void setAtleteName(String atleteName) {
        this.atleteName = atleteName;
    }

    public void setAtleteAge(Integer atleteAge) {
        this.atleteAge = atleteAge;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setAtleteHeight(Double atleteHeight) {
        this.atleteHeight = atleteHeight;
    }

    public void setAtleteWeight(Double atleteWeight) {
        this.atleteWeight = atleteWeight;
    }

    public void setAtleteImc(Double atleteImc) {
        this.atleteImc = atleteImc;
    }

    public void setAtleteBid(String atleteBid) {
        this.atleteBid = atleteBid;
    }

    public void setDominantLeg(DominantLeg dominantLeg) {
        this.dominantLeg = dominantLeg;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPlayStyle(PlayStyle playStyle) {
        this.playStyle = playStyle;
    }

    public void setAdress(AdressDTO adress) {
        this.adress = adress;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }

    public void setAtleteClubs(List<AtleteClubDTO> atleteClubs) {
        this.atleteClubs = atleteClubs;
    }

    public void setAtleteDeceases(List<AtleteDeceaseDTO> atleteDeceases) {
        this.atleteDeceases = atleteDeceases;
    }
}