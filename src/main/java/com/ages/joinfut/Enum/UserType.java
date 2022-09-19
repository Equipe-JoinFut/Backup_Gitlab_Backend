package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {
    AT("AT", "Atleta"),
    CL("CL", "Clube");

    private final String chave;
    private final String descricao;

    UserType(String chave, String descricao) {
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
            case AT:
            case CL:
                return getChave();
        }
        return "Valor Inválido";
    }
}
