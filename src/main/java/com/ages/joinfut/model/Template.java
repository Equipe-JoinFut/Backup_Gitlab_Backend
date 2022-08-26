package com.ages.joinfut.model;

import com.ages.joinfut.dto.TemplateDTO;
import com.ages.joinfut.Enum.TemplateEnum;
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


@Entity
@Table(name = "templates", schema = "examples")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_template")
    private Long iTemplate;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "template_enum")
    private TemplateEnum templateEnum;

    @Column(name = "flag_ativo", columnDefinition = "boolean default true")
    private Boolean flagAtivo;

    public Template() {}

    public Template(TemplateDTO templateDTO) {
        this.iTemplate = templateDTO.getiTemplate();
        this.nome = templateDTO.getNome();
        this.templateEnum = templateDTO.getTemplateEnum();
        this.flagAtivo = templateDTO.getFlagAtivo();
    }

    public Long getId() {
        return getiTemplate();
    }

    public Long getiTemplate() {
        return iTemplate;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TemplateEnum getTemplateEnum() {
        return templateEnum;
    }

    public void setTemplateEnum(TemplateEnum templateEnum) {
        this.templateEnum = templateEnum;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }
}
