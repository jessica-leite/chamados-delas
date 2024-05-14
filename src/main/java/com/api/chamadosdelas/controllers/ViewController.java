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
    @RequestMapping(value = "/tela-usuario", method = RequestMethod.GET)
    public String renderizaTelaUsuario() {
        return "usuario";
    }

    @RequestMapping(value = "/tela-tecnico", method = RequestMethod.GET)
    public String renderizaTelaTecnico() {
        return "tela-tecnico";
    }




}