package com.api.chamadosdelas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderizaSite() {
        return "index";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String renderizaCadastro() {
        return "cadastro";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderizaLogin() {
        return "login";
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public String renderizaUsuario() {
        return "usuario";
    }

    @RequestMapping(value = "/cadastro-chamado", method = RequestMethod.GET)
    public String renderizaCriarChamado() {
        return "cadastro-chamado";
    }

    @RequestMapping(value = "/atualizar-chamado", method = RequestMethod.GET)
    public String renderizaAtualizarChamado() {
        return "atualizar-chamado";
    }

    @RequestMapping(value = "/atualizar-usuario", method = RequestMethod.GET)
    public String renderizaAtualizarUsuario() {
        return "atualizar-usuario";
    }

    @RequestMapping(value = "/tela-usuario", method = RequestMethod.GET)
    public String renderizaTelaUsuario() {
        return "usuario";
    }

    @RequestMapping(value = "/tela-tecnico", method = RequestMethod.GET)
    public String renderizaTelaTecnico() {
        return "tela-tecnico";
    }

    @RequestMapping(value = "/atualizar-tecnico", method = RequestMethod.GET)
    public String renderizaAtualizarTecnico() {
        return "atualizar-tecnico";
    }

    @RequestMapping(value = "/administrador", method = RequestMethod.GET)
    public String renderizaAdministrador() {
        return "administrador";
    }

    @RequestMapping(value = "/cadastro-setor", method = RequestMethod.GET)
    public String renderizaCadastroSetor() {return "cadastro-setor";}
}
