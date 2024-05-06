package com.api.chamadosdelas.controllers;

import com.api.chamadosdelas.dto.AuthDTO;
import com.api.chamadosdelas.models.Pessoa;
import com.api.chamadosdelas.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody Pessoa pessoa) {
        // Tenta salvar pessoa com tipo usuario no banco, caso de ceto retorna um JSON com os dados cadastrados.
        // Caso contrario, retorna erro 400(badRequest)
        try {
            pessoa.setTipo("usuario");

            Pessoa registro = this.pessoaService.cadastrarUsuario(pessoa);

            return ResponseEntity.ok().body(registro);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> autenticarUsuario(@Valid @RequestBody AuthDTO authDTO) {
        // Tenta Logar pessoa, caso de ceto retorna um Token.
        // Caso contrario, retorna erro 401(UNAUTHORIZED)
        try {
            String token = this.pessoaService.autenticarUsuario(authDTO);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
