package com.api.chamadosdelas.repositories;

import com.api.chamadosdelas.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
