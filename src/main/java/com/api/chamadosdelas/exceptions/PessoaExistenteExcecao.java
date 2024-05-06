package com.api.chamadosdelas.exceptions;

public class PessoaExistenteExcecao extends RuntimeException {
    public PessoaExistenteExcecao(){
        super("Pessoa já está cadastrada!");
    }
}
