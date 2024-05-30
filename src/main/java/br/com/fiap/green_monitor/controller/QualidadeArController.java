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

import br.com.fiap.green_monitor.dto.QualidadeArDTO;
import br.com.fiap.green_monitor.model.QualidadeAr;
import br.com.fiap.green_monitor.service.QualidadeArService;

@RestController
@RequestMapping("/api/qualidade-ar")

public class QualidadeArController {

  @Autowired
  private QualidadeArService service;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<QualidadeArDTO> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<QualidadeArDTO> findById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public QualidadeArDTO save(@RequestBody QualidadeArDTO qualidadeAr) {
    return service.save(qualidadeAr);
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
  public QualidadeAr update(@RequestBody QualidadeAr qualidadeAr) {
    return service.update(qualidadeAr);
  }

}
