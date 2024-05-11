package com.api.chamadosdelas.controllers;


import com.api.chamadosdelas.models.Setor;
import com.api.chamadosdelas.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SetorController {
    @Autowired
    private SetorService setorService;

    @RequestMapping(value = "/cadsetor", method = RequestMethod.POST)
    public Setor save(@RequestBody Setor c) {
        return this.setorService.save(c);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/mostrarsetores", method = RequestMethod.GET)
    public List<Setor> findAll() {
        return this.setorService.findAll();
    }

    @RequestMapping(value = "/mostrarsetor/{id}", method = RequestMethod.GET)
    public Setor findById(@PathVariable int id) {
        return this.setorService.findById(id);
    }

    @RequestMapping(value = "/excluirsetor/{id}", method = RequestMethod.DELETE)
    public String deleteSetor(@PathVariable("id") int id) {
        return this.setorService.deleteById(id);
    }

    @RequestMapping(value = "/alterarsetor/{id}", method = RequestMethod.PUT)
    public Setor updateById(@PathVariable int id, @RequestBody Setor c) {
        return this.setorService.updateById(id, c);
    }
}
