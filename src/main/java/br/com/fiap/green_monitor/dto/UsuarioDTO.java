package br.com.fiap.green_monitor.dto;

import br.com.fiap.green_monitor.model.Usuario;
import br.com.fiap.green_monitor.model.UsuarioRole;

public record UsuarioDTO(
    int id,
    String nome,
    String email,
    UsuarioRole role) {

  public UsuarioDTO(Usuario usuario) {
    this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getRole());
  }

}
