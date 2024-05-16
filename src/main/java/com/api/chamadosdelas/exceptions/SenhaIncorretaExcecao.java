package com.api.chamadosdelas.exceptions;

public class SenhaIncorretaExcecao extends RuntimeException {
    public SenhaIncorretaExcecao(){
        super("Senha incorreta!");
    }
}
