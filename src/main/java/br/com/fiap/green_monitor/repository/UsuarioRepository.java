package br.com.fiap.green_monitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.fiap.green_monitor.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  UserDetails findByEmail(String email);

}
