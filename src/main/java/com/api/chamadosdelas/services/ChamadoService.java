package com.api.chamadosdelas.services;

import com.api.chamadosdelas.models.Chamado;
import com.api.chamadosdelas.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public Chamado save(Chamado c){
        c = this.chamadoRepository.save(c);
        return c;
    }

    public List<Chamado> findAll(){
        List<Chamado> chamados = this.chamadoRepository.findAll();
        return chamados;
    }

    public Chamado findById(int id){
        Optional<Chamado> resultado = this.chamadoRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Chamado não encontrado!");
        } else {
            return resultado.get();
        }
    }

    public  String deleteById(int id){
        chamadoRepository.deleteById(id);
        return "Chamado com ID " + id + " excluído com sucesso!";
    }

    public Chamado updateById(int id, Chamado c){
        this.findById(id);
        c.setId(id);
        c =this.chamadoRepository.save(c);
        return c;
    }
}
