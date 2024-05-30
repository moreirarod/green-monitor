package br.com.fiap.green_monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.green_monitor.dto.ControleIrrigacaoDTO;
import br.com.fiap.green_monitor.exceptions.ItemNaoEncontradoException;
import br.com.fiap.green_monitor.service.ControleIrrigacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/controle-irrigacao")

public class ControleIrrigacaoController {

  @Autowired
  private ControleIrrigacaoService service;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ControleIrrigacaoDTO> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ControleIrrigacaoDTO> findById(@PathVariable Integer id) {
    try {
      return ResponseEntity.ok(service.findById(id));
    } catch (ItemNaoEncontradoException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ControleIrrigacaoDTO save(@RequestBody @Valid ControleIrrigacaoDTO controleIrrigacao) {
    return service.save(controleIrrigacao);
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

}
