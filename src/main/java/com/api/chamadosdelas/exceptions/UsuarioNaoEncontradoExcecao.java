package com.api.chamadosdelas.exceptions;

public class UsuarioNaoEncontradoExcecao extends RuntimeException {
    public UsuarioNaoEncontradoExcecao(){
        super("Pessoa não está cadastrada!");
    }
}
