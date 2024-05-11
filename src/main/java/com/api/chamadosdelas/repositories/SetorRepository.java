package com.api.chamadosdelas.repositories;

import com.api.chamadosdelas.models.Pessoa;
import com.api.chamadosdelas.models.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SetorRepository extends JpaRepository<Setor, Integer> {
    Optional<Setor> findByNome(String nome);
}
