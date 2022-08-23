package com.ages.joinfut.Enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TemplateEnum {
    TA("TA", "Type A"),
    TB("TB", "Type B");

    private final String chave;
    private final String descricao;

    TemplateEnum(String chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public String getChave() {
        return chave;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonValue
    public String getValor() {
        switch (this) {
            case TA:
            case TB:
                return getChave();
        }
        return "Valor Inválido";
    }
}
