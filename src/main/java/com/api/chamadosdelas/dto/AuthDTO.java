package com.api.chamadosdelas.dto;

import jakarta.validation.constraints.Email;

public class AuthDTO {
    private String senha;
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    public AuthDTO(String senha, String email) {
        this.senha = senha;
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) { this.senha = senha; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
