package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<String, UserType> byDescription = new HashMap<>();

    static{
        for(UserType ut : values()){
            byDescription.put(ut.chave, ut);
        }
    }

    @JsonValue
    public String getValor() {
        switch (this) {
            case AT:
            case CL:
                return valueOfDescription(getChave()).getDescricao();
        }
        return "Valor Inválido";
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static UserType valueOfDescription(String key){
        return byDescription.get(key);
    }
}
