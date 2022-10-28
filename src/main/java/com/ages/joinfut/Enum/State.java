package com.ages.joinfut.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum State {

    AC("AC","Acre"),
    AL("AL", "Alagoas"),
    AP("AP", "Amapá"),
    AM("AM", "Amazonas"),
    BA("BA", "Bahia"),
    CE("CE", "Ceara"),
    DF("DF", "Distrito Federal"),
    ES("ES", "Espírito Santo"),
    GO("GO", "Goiás"),
    MA("MA", "Maranhão"),
    MT("MT", "Mato Grosso"),
    MS("MS", "Mato Grosso do Sul"),
    MG("MG", "Minas Gerais"),
    PA("PA", "Pará"),
    PB("PB", "Paraíba"),
    PR("PR", "Paraná"),
    PE("PE", "Pernambuco"),
    PI("PI", "Piauí"),
    RJ("RJ", "Rio de Janeiro"),
    RN("RN", "Rio Grande do Norte"),
    RS("RS", "Rio Grande do Sul"),
    RO("RO", "Rondônia"),
    RR("RR", "Roraima"),
    SC("SC", "Santa Catarina"),
    SP("SP", "São Paulo"),
    SE("SE", "Sergipe"),
    TO("TO", "Tocantins");

    private final String chave;
    private final String descricao;

    private static final Map<String, State> byDescription = new HashMap<>();

    static{
        for(State s : values()){
            byDescription.put(s.chave, s);
        }
    }

    State(String chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public String getChave(){return chave;}
    public String getDescricao(){return descricao;}

    @JsonValue
    public String getValor() {
        switch (this) {
            case AC:
            case RS:
            case AL:
            case AM:
            case AP:
            case BA:
            case CE:
            case DF:
            case ES:
            case GO:
            case MA:
            case MG:
            case MS:
            case MT:
            case PA:
            case PB:
            case PE:
            case PI:
            case PR:
            case RJ:
            case RN:
            case RO:
            case RR:
            case SC:
            case SE:
            case SP:
            case TO:
                return valueOfDescription(getChave()).getDescricao();
        }
        return "Valor Inválido";
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static State valueOfDescription(String key){
        return byDescription.get(key);
    }
}
