package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DominantLeg {

    L("L","Esquerda"),
    R("R","Direita");

    private final String chave;
    private final String descricao;

    DominantLeg(String chave, String descricao) {
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
            case R:
                return getChave();
        }
        return "Valor Inválido";
    }
}
