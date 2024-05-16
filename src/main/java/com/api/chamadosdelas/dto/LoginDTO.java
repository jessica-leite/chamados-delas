package com.api.chamadosdelas.dto;

public class LoginDTO {
    private String nome;
    private String token;
    private String tipo;
    private int id;

    public LoginDTO(String token, String tipo, int id, String nome) {
        this.token = token;
        this.tipo = tipo;
        this.id = id;
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getToken() {
        return token;
    }

    public String getTipo() { return tipo; }

    public void setToken(String token) { this.token = token; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
