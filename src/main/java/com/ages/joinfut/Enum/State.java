package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum State {

    RS("RS", "Rio Grande do Sul");

    private final String chave;
    private final String descricao;

    State(String chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public String getChave(){return chave;}
    public String getDescricao(){return descricao;}

    @JsonValue
    public String getValor() {
        switch (this) {
            case RS:
                return getChave();
        }
        return "Valor Inválido";
    }
}
