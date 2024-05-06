package com.api.chamadosdelas.exceptions;

public class AutenticacaoExcecao extends RuntimeException {
    public AutenticacaoExcecao(){
        super("E-mail ou senha inválidos!");
    }
}
