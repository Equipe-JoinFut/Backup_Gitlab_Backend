package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Position {
    G("G", "Goleiro"),
    V("V", "Volante"),
    Z("Z", "Zagueiro"),
    C("C", "Centroavante"),
    L("L", "Lateral"),
    A("A", "Atacante");

    private final String chave;
    private final String descricao;

    Position(String chave, String descricao) {
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
            case L:
            case A:
            case C:
            case G:
            case V:
            case Z:
                return getChave();
        }
        return "Valor Inválido";
    }
}
