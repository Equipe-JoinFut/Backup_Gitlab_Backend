package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashMap;
import java.util.Map;

public enum DominantLeg {

    L("L","Esquerda"),
    R("R","Direita"),
    B("B", "Ambas");

    private final String chave;
    private final String descricao;

    private static final Map<String, DominantLeg> byDescription = new HashMap<>();

    static{
        for(DominantLeg d : values()){
            byDescription.put(d.chave, d);
        }
    }

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
            case B:
                return valueOfDescription(getChave()).getDescricao();
        }
        return "Valor Inválido";
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DominantLeg valueOfDescription(String key){
        return byDescription.get(key);
    }
}
