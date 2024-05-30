package br.com.fiap.green_monitor.dto;

import br.com.fiap.green_monitor.model.Usuario;

public record UsuarioDTO(
    int id,
    String nome,
    String email) {

  public UsuarioDTO(Usuario usuario) {
    this(usuario.getId(), usuario.getNome(), usuario.getEmail());
  }

}
