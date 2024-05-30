package br.com.fiap.green_monitor.config.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.fiap.green_monitor.model.Usuario;

@Service
public class TokenService {

  @Value("p4l4vr4$3333cr3t4")
  private String secret;

  public String gerarToken(Usuario usuario) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      String token = JWT.create()
          .withIssuer("green-monitor")
          .withSubject(usuario.getEmail())
          .withExpiresAt(gerarDataDeExpiracao())
          .sign(algorithm);

      return token;
    } catch (JWTCreationException e) {
      throw new RuntimeException("Erro ao gerar token");
    }
  }

  public String validarToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      return JWT.require(algorithm)
          .withIssuer("green-monitor")
          .build()
          .verify(token)
          .getSubject();

    } catch (JWTVerificationException e) {
      return "";
    }
  }

  private Instant gerarDataDeExpiracao() {
    return LocalDateTime
        .now()
        .plusHours(2)
        .toInstant(ZoneOffset.of("-03:00"));
  }

}
