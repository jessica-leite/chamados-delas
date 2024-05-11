package com.api.chamadosdelas.dto;

public class PessoaTipoDTO {
    private String tipo;

    public PessoaTipoDTO(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
