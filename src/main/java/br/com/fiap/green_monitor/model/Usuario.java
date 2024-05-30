package br.com.fiap.green_monitor.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_GM_USUARIO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Usuario implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
  @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
  @Column(name = "id_usuario")
  private int id;

  @Column(name = "nm_usuario")
  private String nome;

  @Column(name = "nm_email")
  private String email;

  @Column(name = "nm_senha")
  private String senha;

  @Enumerated(EnumType.STRING)
  @Column(name = "st_tipo_usuario")
  private UsuarioRole role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (this.role == UsuarioRole.ADMIN) {
      return List.of(
          new SimpleGrantedAuthority("ROLE_ADMIN"),
          new SimpleGrantedAuthority("ROLE_USER"));
    } else {
      return List.of(
          new SimpleGrantedAuthority("ROLE_USER"));
    }

  }

  @Override
  public String getPassword() {
    return this.senha;
  }

  @Override
  public String getUsername() {
    return this.email;
  }
}
