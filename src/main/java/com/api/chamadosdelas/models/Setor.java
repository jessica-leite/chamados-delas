package com.api.chamadosdelas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "setor")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;
}
