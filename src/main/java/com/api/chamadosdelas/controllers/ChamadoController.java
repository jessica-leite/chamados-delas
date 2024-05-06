package com.api.chamadosdelas.controllers;

import com.api.chamadosdelas.models.Chamado;

import com.api.chamadosdelas.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
public class ChamadoController {


    @Autowired
    private ChamadoService chamadoService;

    @RequestMapping(value = "/cadchamado", method = RequestMethod.POST)
    public Chamado save(@RequestBody Chamado c) {
        c.setDataInicio(LocalDateTime.now());
        return this.chamadoService.save(c);
    }

    @RequestMapping(value = "/mostrarchamados", method = RequestMethod.GET)
    public List<Chamado> findAll() {
        return this.chamadoService.findAll();
    }

    @RequestMapping(value = "/mostrarchamado/{id}", method = RequestMethod.GET)
    public Chamado findById(@PathVariable int id) {
        return this.chamadoService.findById(id);
    }

    @RequestMapping(value = "/excluirchamado/{id}", method = RequestMethod.DELETE)
    public String deleteChamado(@PathVariable("id") int id) {
        return this.chamadoService.deleteById(id);
    }

    @RequestMapping(value = "/alterarchamado/{id}", method = RequestMethod.PUT)
    public Chamado updateById(@PathVariable int id, @RequestBody Chamado c) {
        return this.chamadoService.updateById(id, c);
    }
}
