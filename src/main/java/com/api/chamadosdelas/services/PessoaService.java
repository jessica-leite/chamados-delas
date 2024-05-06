package com.api.chamadosdelas.services;

import com.api.chamadosdelas.dto.AuthDTO;
import com.api.chamadosdelas.exceptions.AutenticacaoExcecao;
import com.api.chamadosdelas.exceptions.PessoaExistenteExcecao;
import com.api.chamadosdelas.exceptions.UsuarioNaoEncontradoExcecao;
import com.api.chamadosdelas.models.Pessoa;
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

    public Pessoa cadastrarUsuario(Pessoa pessoa) {
        // busca pessoa no banco atraves do email, se encontrar lança excecão.
        Optional<Pessoa> registro = this.pessoaRepository.findByEmail(pessoa.getEmail());

        if (registro.isPresent()){
            throw new PessoaExistenteExcecao();
        }

        //faz hash da senha.
        String novaSenha = this.passwordEncoder.encode(pessoa.getSenha());
        pessoa.setSenha(novaSenha);

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
}