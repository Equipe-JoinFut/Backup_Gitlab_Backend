package com.ages.joinfut.model;

import com.ages.joinfut.dto.TemplateDTO;
import com.ages.joinfut.Enum.TemplateEnum;
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

@Getter
@Setter
@Entity
@Table(name = "templates", schema = "examples")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_template")
    private Long idTemplate;

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
        this.idTemplate = templateDTO.getIdTemplate();
        this.nome = templateDTO.getNome();
        this.templateEnum = templateDTO.getTemplateEnum();
        this.flagAtivo = templateDTO.getFlagAtivo();
    }

    public Long getId() {
        return getIdTemplate();
    }
}
