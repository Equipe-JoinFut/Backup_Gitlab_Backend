package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Position {
    G("G", "Goleiro"),
    V("V", "Volante"),
    Z("Z", "Zagueiro"),
    C("C", "Centroavante"),
    LD("LD", "Lateral Direita"),
    LE("LE", "Lateral Esquerda"),
    PD("PD", "Ponta Direita"),
    PE("PE", "Ponta Esquerda"),
    M("M", "Meia"),
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
            case G:
            case V:
            case Z:
            case C:
            case LD:
            case LE:
            case PD:
            case PE:
            case M:
            case A:
                return getChave();
        }
        return "Valor Inválido";
    }
}
