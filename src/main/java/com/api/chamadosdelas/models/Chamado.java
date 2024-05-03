package com.api.chamadosdelas.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chamado")
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column
    private int prioridade;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Pessoa tecnico;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Pessoa usuario;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
