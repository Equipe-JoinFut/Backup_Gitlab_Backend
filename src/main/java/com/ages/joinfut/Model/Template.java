package com.ages.joinfut.Model;

import com.ages.joinfut.DTO.TemplateDTO;
import com.ages.joinfut.Enums.TemplateEnum;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "templates", schema = "examples")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_template")
    private Long iTemplate;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @NotNull(message = "O nome do Template não pode ser nulo!")
    @NotEmpty(message = "O nome do Template não pode ser vazio!")
    @Size(min = 5, max = 255, message = "O tamanho do nome deve ser maior que 5 e menor que 255 caracteres!")
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

    public void setiTemplate(Long iTemplate) {
        this.iTemplate = iTemplate;
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
