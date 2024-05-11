package com.api.chamadosdelas.repositories;

import com.api.chamadosdelas.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository <Pessoa, Long> {
    Optional<Pessoa> findByEmail(String email);

    List<Pessoa> findByTipo(String tipo);
}
