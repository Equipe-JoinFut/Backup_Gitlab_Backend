package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum StatusNda {

    A("A", "Aprovado"),

    R("R", "Reprovado"),

    P("P", "Pendente");

    private final String chave;

    private final String descricao;

    private static final Map<String, StatusNda> byDescription = new HashMap<>();

    static{
        for(StatusNda s : values()){
            byDescription.put(s.chave, s);
        }
    }

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
                return valueOfDescription(getChave()).getDescricao();
        }
        return "Valor Inválido";
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static StatusNda valueOfDescription(String key){
        return byDescription.get(key);
    }
}