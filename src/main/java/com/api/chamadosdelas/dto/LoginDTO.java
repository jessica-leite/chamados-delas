package com.api.chamadosdelas.dto;

public class LoginDTO {
    private String token;
    private String tipo;
    private long id;

    public LoginDTO(String token, String tipo, long id) {
        this.token = token;
        this.tipo = tipo;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() { return tipo; }

    public void setToken(String token) { this.token = token; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
