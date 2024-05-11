package com.api.chamadosdelas.services;

import com.api.chamadosdelas.dto.AuthDTO;
import com.api.chamadosdelas.exceptions.AutenticacaoExcecao;
import com.api.chamadosdelas.exceptions.PessoaExistenteExcecao;
import com.api.chamadosdelas.exceptions.UsuarioNaoEncontradoExcecao;
import com.api.chamadosdelas.models.Pessoa;
import com.api.chamadosdelas.models.Setor;
import com.api.chamadosdelas.repositories.PessoaRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PessoaService {

    //esse atributo é responsavel por validar a assinatura do token.
    @Value("${security.token.secret}")
    private String secretKey;
    @Autowired
    private PessoaRepository pessoaRepository;

    //É uma classe do pacote security responsavel por fazer hash da senha.
    @Autowired
    private PasswordEncoder passwordEncoder;

//    public Pessoa cadastrarUsuario(Pessoa pessoa) {
    public Pessoa cadastrarUsuario(String nome, String email, String senha, Setor setor, String tipo) {
        // busca pessoa no banco atraves do email, se encontrar lança excecão.
        Optional<Pessoa> registro = this.pessoaRepository.findByEmail(email);

        if (registro.isPresent()){
            throw new PessoaExistenteExcecao();
        }

        //faz hash da senha.
        String novaSenha = this.passwordEncoder.encode(senha);
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail(email);
        pessoa.setNome(nome);
        pessoa.setSenha(novaSenha);
        pessoa.setTipo(Objects.equals(tipo, "tecnico") ? "aguardando autorizacao" : "usuario");
        pessoa.setSetor(setor);

        return this.pessoaRepository.save(pessoa);
    }

    public String autenticarUsuario(AuthDTO authDTO) {

        // busca pessoa no banco atraves do email, senão achar lança excecão.
        Optional<Pessoa> registro = this.pessoaRepository.findByEmail(authDTO.getEmail());

        if (registro.isEmpty()){
            throw new UsuarioNaoEncontradoExcecao();
        }

        // Compara senha enviada com a senha salva no banco, caso seja diferente lança exceção.
        Pessoa pessoa = registro.get();
        boolean senhaCorreta = this.passwordEncoder.matches(authDTO.getSenha(), pessoa.getSenha());

        if (!senhaCorreta) {
            throw new AutenticacaoExcecao();
        }

        //Gera o Token.
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create().withIssuer("chamadosdelas")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(String.valueOf(pessoa.getId())).sign(algorithm);
    }

    public List<Pessoa> findByTipo(String tipo) {
        return pessoaRepository.findByTipo(tipo);
    }

    public void deleteById(Long id) {
        Optional<Pessoa> registro = this.pessoaRepository.findById(id);

        if (registro.isEmpty()) {
            throw new UsuarioNaoEncontradoExcecao();
        }

        this.pessoaRepository.delete(registro.get());
    }
}