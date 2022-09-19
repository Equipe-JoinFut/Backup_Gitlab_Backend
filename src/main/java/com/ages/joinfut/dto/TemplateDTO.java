package com.ages.joinfut.dto;

import com.ages.joinfut.Enum.TemplateEnum;
import com.ages.joinfut.model.Template;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TemplateDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do Template")
    private Long idTemplate;

    @ApiModelProperty(position = 2, notes = "Nome do template")
    @NotNull(message = "O nome do Template não pode ser nulo!")
    @NotEmpty(message = "O nome do Template não pode ser vazio!")
    @Size(min = 5, max = 255, message = "O tamanho do nome deve ser maior que 5 e menor que 255 caracteres!")
    private String nome;

    @ApiModelProperty(position = 3, notes = "Enum do template")
    private TemplateEnum templateEnum;

    @ApiModelProperty(position = 4, notes = "Flag de ativo do template")
    private Boolean flagAtivo;

    public TemplateDTO() {}

    public TemplateDTO(Template template) {
        this.idTemplate = template.getIdTemplate();
        this.nome = template.getNome();
        this.templateEnum = template.getTemplateEnum();
        this.flagAtivo = template.getFlagAtivo();
    }

    public Long getId() {
        return getIdTemplate();
    }

}
