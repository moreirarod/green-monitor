package br.com.fiap.green_monitor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.green_monitor.dto.UsuarioDTO;
import br.com.fiap.green_monitor.dto.UsuarioNovoDTO;
import br.com.fiap.green_monitor.exceptions.ItemNaoEncontradoException;
import br.com.fiap.green_monitor.model.Usuario;
import br.com.fiap.green_monitor.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository repository;

  public List<UsuarioDTO> findAll() {
    return repository
        .findAll()
        .stream()
        .map(UsuarioDTO::new)
        .toList();
  }

  public UsuarioDTO findById(Integer id) {
    Optional<Usuario> usuarioOptional = repository.findById(id);
    if (usuarioOptional.isPresent()) {
      return new UsuarioDTO(usuarioOptional.get());
    } else {
      throw new ItemNaoEncontradoException("Alerta não encontrado no banco de dados");
    }
  }

  public UsuarioNovoDTO save(UsuarioNovoDTO usuarioNovoDTO) {
    String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioNovoDTO.senha());

    Usuario usuario = new Usuario();
    BeanUtils.copyProperties(usuarioNovoDTO, usuario);
    usuario.setSenha(senhaCriptografada);

    Usuario usuarioSalvo = repository.save(usuario);
    return new UsuarioNovoDTO(usuarioSalvo);
  }

  public void deleteById(Integer id) {
    Optional<Usuario> usuario = repository.findById(id);
    if (usuario.isPresent()) {
      repository.deleteById(id);
    } else {
      throw new ItemNaoEncontradoException("Alerta não encontrado no banco de dados");
    }
  }

  public void deleteAll() {
    repository.deleteAll();
  }

}
