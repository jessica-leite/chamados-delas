package com.api.chamadosdelas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;
}
