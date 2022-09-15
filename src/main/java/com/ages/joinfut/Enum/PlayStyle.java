package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PlayStyle {
    D("D", "Defensivo"),
    O("O", "Ofensivo");

    private final String chave;
    private final String descricao;

    PlayStyle(String chave, String descricao) {
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
            case D:
            case O:
                return getChave();
        }
        return "Valor Inválido";
    }
}
