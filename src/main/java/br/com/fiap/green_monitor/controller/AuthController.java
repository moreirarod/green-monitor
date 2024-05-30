package br.com.fiap.green_monitor.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.green_monitor.config.security.TokenService;
import br.com.fiap.green_monitor.dto.LoginDTO;
import br.com.fiap.green_monitor.dto.TokenDTO;
import br.com.fiap.green_monitor.dto.UsuarioNovoDTO;
import br.com.fiap.green_monitor.model.Usuario;
import br.com.fiap.green_monitor.service.UsuarioService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UsuarioService service;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid LoginDTO loginDTO) {

    UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(loginDTO.email(),
        loginDTO.senha());

    Authentication auth = authenticationManager.authenticate(usernamePassword);

    String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

    return ResponseEntity.ok(new TokenDTO(token));
  }

}
