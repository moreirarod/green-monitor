package br.com.fiap.green_monitor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.green_monitor.dto.AlertaDesastreNaturalDTO;
import br.com.fiap.green_monitor.exceptions.ItemNaoEncontradoException;
import br.com.fiap.green_monitor.model.AlertaDesastreNatural;
import br.com.fiap.green_monitor.repository.AlertaDesastreNaturalRepository;

@Service
public class AlertaDesastreNaturalService {

  @Autowired
  private AlertaDesastreNaturalRepository repository;

  public List<AlertaDesastreNaturalDTO> findAll() {
    return repository
        .findAll()
        .stream()
        .map(AlertaDesastreNaturalDTO::new)
        .toList();
  }

  public AlertaDesastreNaturalDTO findById(Integer id) {
    Optional<AlertaDesastreNatural> alertaDesastreNaturalOptional = repository.findById(id);
    if (alertaDesastreNaturalOptional.isPresent()) {
      return new AlertaDesastreNaturalDTO(alertaDesastreNaturalOptional.get());
    } else {
      throw new ItemNaoEncontradoException("Alerta não encontrado no banco de dados");
    }
  }

  public AlertaDesastreNaturalDTO save(AlertaDesastreNaturalDTO alertaDesastreNaturalDTO) {
    AlertaDesastreNatural alertaDesastreNatural = new AlertaDesastreNatural();
    BeanUtils.copyProperties(alertaDesastreNaturalDTO, alertaDesastreNatural);

    AlertaDesastreNatural alertaDesastreNaturalSalvo = repository.save(alertaDesastreNatural);
    return new AlertaDesastreNaturalDTO(alertaDesastreNaturalSalvo);
  }

  public void deleteById(Integer id) {
    Optional<AlertaDesastreNatural> alertaDesastreNatural = repository.findById(id);
    if (alertaDesastreNatural.isPresent()) {
      repository.deleteById(id);
    } else {
      throw new ItemNaoEncontradoException("Alerta não encontrado no banco de dados");
    }
  }

  public void deleteAll() {
    repository.deleteAll();
  }

  public AlertaDesastreNatural update(AlertaDesastreNatural alertaDesastreNatural) {
    Optional<AlertaDesastreNatural> alertaDesastreNaturalOptional = repository
        .findById(alertaDesastreNatural.getId());
    if (alertaDesastreNaturalOptional.isPresent()) {
      return repository.save(alertaDesastreNatural);
    } else {
      throw new ItemNaoEncontradoException("Alerta não encontrado no banco de dados");
    }
  }

}
