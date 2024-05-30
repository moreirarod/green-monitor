package br.com.fiap.green_monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.green_monitor.dto.UsuarioDTO;
import br.com.fiap.green_monitor.dto.UsuarioNovoDTO;
import br.com.fiap.green_monitor.model.Usuario;
import br.com.fiap.green_monitor.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")

public class UsuarioController {

  @Autowired
  private UsuarioService service;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<UsuarioDTO> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UsuarioNovoDTO save(@RequestBody UsuarioNovoDTO usuario) {
    return service.save(usuario);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Integer id) {
    service.deleteById(id);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAll() {
    service.deleteAll();
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public Usuario update(@RequestBody Usuario usuario) {
    return service.update(usuario);
  }

}
