package com.api.chamadosdelas.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.Locale;

public class PessoaDTO {
    private String nome;
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;
    @Length(min = 8, max = 100)
    private String senha;
    private String setor;
    private String tipo;

    public PessoaDTO(String nome, String email, String senha, String setor, String tipo){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.setor = setor;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
