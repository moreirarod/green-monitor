package br.com.fiap.green_monitor.dto;

import br.com.fiap.green_monitor.model.Usuario;
import br.com.fiap.green_monitor.model.UsuarioRole;

public record UsuarioNovoDTO(
    int id,
    String nome,
    String email,
    String senha,
    UsuarioRole role) {

  public UsuarioNovoDTO(Usuario usuario) {
    this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getRole());
  }

}
