package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusNda {

    A("A", "Aprovado"),

    R("R", "Reprovado"),

    P("P", "Pendente");

    private final String chave;

    private final String descricao;

    StatusNda(String chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public String getChave() { return chave; }

    public String getDescricao() { return descricao; }

    @JsonValue
    public String getValor() {
        switch (this) {
            case A:
            case P:
            case R:
                return getChave();
        }
        return "Valor Inválido";
    }
}
