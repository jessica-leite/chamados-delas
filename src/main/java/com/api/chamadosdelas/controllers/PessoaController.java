package com.api.chamadosdelas.controllers;

import com.api.chamadosdelas.dto.AuthDTO;
import com.api.chamadosdelas.dto.PessoaDTO;
import com.api.chamadosdelas.dto.LoginDTO;
import com.api.chamadosdelas.models.Pessoa;
import com.api.chamadosdelas.models.Setor;
import com.api.chamadosdelas.services.PessoaService;
import com.api.chamadosdelas.services.SetorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private SetorService setorService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody PessoaDTO dto) {
        // Tenta salvar pessoa com tipo usuario no banco, caso de ceto retorna um JSON com os dados cadastrados.
        // Caso contrario, retorna erro 400(badRequest)
        try {
//            pessoa.setTipo("usuario");

            Setor setor = this.setorService.findById(dto.getSetorId());

            Pessoa registro = this.pessoaService.cadastrarUsuario(
                dto.getNome(),
                dto.getEmail(),
                dto.getSenha(),
                setor,
                dto.getTipo()
            );

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> autenticarUsuario(@Valid @RequestBody AuthDTO authDTO) {
        // Tenta Logar pessoa, caso de ceto retorna um Token.
        // Caso contrario, retorna erro 401(UNAUTHORIZED)
        try {
            LoginDTO loginDto = this.pessoaService.autenticarUsuario(authDTO);
            return ResponseEntity.ok(loginDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/autorizartecnico")
    public ResponseEntity<Object> findAllUsuarios(){
        List<Pessoa> pessoas = this.pessoaService.findByTipo("aguardando autorizacao");
        return ResponseEntity.ok(pessoas);
    }

    @DeleteMapping("/excluirpessoa/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        this.pessoaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}



















