package com.api.chamadosdelas.services;

import com.api.chamadosdelas.models.Setor;
import com.api.chamadosdelas.repositories.SetorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public Setor save(Setor c){
        c = this.setorRepository.save(c);
        return c;
    }

    public List<Setor> findAll(){
        List<Setor> setores = this.setorRepository.findAll();
        return setores;
    }

    public Setor findById(int id){
        Optional<Setor> resultado = this.setorRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Setor não encontrado!");
        } else {
            return resultado.get();
        }
    }

    public  void deleteById(int id){
        Optional<Setor> setor = this.setorRepository.findById(id);

        if (setor.isEmpty()) {
            throw new EntityNotFoundException();
        }

        this.setorRepository.delete(setor.get());
    }

    public Setor updateById(int id, Setor c){
        this.findById(id);
        c.setId(id);
        c =this.setorRepository.save(c);
        return c;
    }

    public Setor findByName(String nome){
        Optional<Setor> resultado = this.setorRepository.findByNome(nome);

        if (resultado.isEmpty()) {
            throw new RuntimeException("Setor não encontrado!");
        } else {
            return resultado.get();
        }
    }
}
