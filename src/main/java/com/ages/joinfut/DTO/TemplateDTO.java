package com.ages.joinfut.DTO;

import com.ages.joinfut.Enums.TemplateEnum;
import com.ages.joinfut.Model.Template;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.stream.Collectors;

public class TemplateDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Template")
    private Long iTemplate;

    @ApiModelProperty(position = 2, notes = "Nome do template")
    private String nome;

    @ApiModelProperty(position = 3, notes = "Enum do template")
    private TemplateEnum templateEnum;

    @ApiModelProperty(position = 4, notes = "Flag de ativo do template")
    private Boolean flagAtivo;

    public TemplateDTO() {}

    public TemplateDTO(Template template) {
        this.iTemplate = template.getiTemplate();
        this.nome = template.getNome();
        this.templateEnum = template.getTemplateEnum();
        this.flagAtivo = template.getFlagAtivo();
    }

    public static List<TemplateDTO> convertList(List<Template> templates) {
        return templates.stream().map(TemplateDTO::new).collect(Collectors.toList());
    }

    public static TemplateDTO convertId(Template template) {
        return new TemplateDTO(template);
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
