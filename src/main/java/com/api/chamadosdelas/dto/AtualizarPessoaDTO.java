package com.api.chamadosdelas.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class AtualizarPessoaDTO {
    private String nome;
    private int setorId;
    private String senhaAtual;
    @Length(min = 8, max = 100)
    private String senhaNova;
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    public AtualizarPessoaDTO(String nome, String email, int setorId, String senhaAtual, String senhaNova) {
        this.nome = nome;
        this.email = email;
        this.setorId = setorId;
        this.senhaAtual = senhaAtual;
        this.senhaNova = senhaNova;
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

    public int getSetorId() { return setorId; }

    public void setSetor(int setorId) {
        this.setorId = setorId;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }
}



