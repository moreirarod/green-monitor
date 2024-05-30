package br.com.fiap.green_monitor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.green_monitor.dto.QualidadeAguaDTO;
import br.com.fiap.green_monitor.exceptions.ItemNaoEncontradoException;
import br.com.fiap.green_monitor.model.QualidadeAgua;
import br.com.fiap.green_monitor.repository.QualidadeAguaRepository;

@Service
public class QualidadeAguaService {

  @Autowired
  private QualidadeAguaRepository repository;

  public List<QualidadeAguaDTO> findAll() {
    return repository.findAll().stream().map(QualidadeAguaDTO::new).toList();
  }

  public QualidadeAguaDTO findById(Integer id) {
    Optional<QualidadeAgua> qualidadeAguaOptional = repository.findById(id);
    if (qualidadeAguaOptional.isPresent()) {
      return new QualidadeAguaDTO(qualidadeAguaOptional.get());
    } else {
      throw new ItemNaoEncontradoException("Item não encontrado no banco de dados");
    }
  }

  public QualidadeAguaDTO save(QualidadeAguaDTO qualidadeAguaDTO) {
    QualidadeAgua qualidadeAgua = new QualidadeAgua();
    BeanUtils.copyProperties(qualidadeAguaDTO, qualidadeAgua);

    QualidadeAgua qualidadeAguaSalvo = repository.save(qualidadeAgua);
    return new QualidadeAguaDTO(qualidadeAguaSalvo);
  }

  public void deleteById(Integer id) {
    Optional<QualidadeAgua> QualidadeAgua = repository.findById(id);
    if (QualidadeAgua.isPresent()) {
      repository.deleteById(id);
    } else {
      throw new ItemNaoEncontradoException("Item não encontrado no banco de dados");
    }
  }

  public void deleteAll() {
    repository.deleteAll();
  }

  public QualidadeAgua update(QualidadeAgua QualidadeAgua) {
    Optional<QualidadeAgua> QualidadeAguaOptional = repository
        .findById(QualidadeAgua.getId());
    if (QualidadeAguaOptional.isPresent()) {
      return repository.save(QualidadeAgua);
    } else {
      throw new ItemNaoEncontradoException("Item não encontrado no banco de dados");
    }
  }

}
