package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Position {
    G("G", "Goleiro"),
    V("V", "Volante"),
    Z("Z", "Zagueiro"),
    C("C", "Centroavante"),
    L("L", "Lateral"),
    A("A", "Atacante");

    private final String chave;
    private final String descricao;

    private static final Map<String, Position> byDescription = new HashMap<>();

    static{
        for(Position p : values()){
            byDescription.put(p.chave, p);
        }
    }

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
                return valueOfDescription(getChave()).getDescricao();
        }
        return "Valor Inválido";
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Position valueOfDescription(String key){
        return byDescription.get(key);
    }
}
