package com.api.chamadosdelas.models;

import java.util.ArrayList;
import java.util.List;

public enum StatusEnum {
    Aguardandotecnico ("Aguardando técnico"),
    EmAtendimento ("Em atendimento"),
    EscaladoParaOutroSetor ("Escalado para outro setor"),
    Finalizado ("Finalizado");

    private final String name;


    StatusEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

    public static List<String> getAllNames(){
        var values = new ArrayList<String>();
        for(StatusEnum c : StatusEnum.values()){
            values.add(c.toString());
        }
        return values;
    }
}
