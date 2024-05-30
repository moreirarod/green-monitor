package br.com.fiap.green_monitor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.green_monitor.dto.QualidadeArDTO;
import br.com.fiap.green_monitor.exceptions.ItemNaoEncontradoException;
import br.com.fiap.green_monitor.model.QualidadeAr;
import br.com.fiap.green_monitor.repository.QualidadeArRepository;

@Service
public class QualidadeArService {

  @Autowired
  private QualidadeArRepository repository;

  public List<QualidadeArDTO> findAll() {
    return repository.findAll().stream().map(QualidadeArDTO::new).toList();
  }

  public QualidadeArDTO findById(Integer id) {
    Optional<QualidadeAr> qualidadeArOptional = repository.findById(id);
    if (qualidadeArOptional.isPresent()) {
      return new QualidadeArDTO(qualidadeArOptional.get());
    } else {
      throw new ItemNaoEncontradoException("Item não encontrado no banco de dados");
    }
  }

  public QualidadeArDTO save(QualidadeArDTO qualidadeArDTO) {
    QualidadeAr qualidadeAr = new QualidadeAr();
    BeanUtils.copyProperties(qualidadeArDTO, qualidadeAr);

    QualidadeAr qualidadeArSalvo = repository.save(qualidadeAr);
    return new QualidadeArDTO(qualidadeArSalvo);
  }

  public void deleteById(Integer id) {
    Optional<QualidadeAr> QualidadeAr = repository.findById(id);
    if (QualidadeAr.isPresent()) {
      repository.deleteById(id);
    } else {
      throw new ItemNaoEncontradoException("Item não encontrado no banco de dados");
    }
  }

  public void deleteAll() {
    repository.deleteAll();
  }

  public QualidadeAr update(QualidadeAr QualidadeAr) {
    Optional<QualidadeAr> QualidadeArOptional = repository
        .findById(QualidadeAr.getId());
    if (QualidadeArOptional.isPresent()) {
      return repository.save(QualidadeAr);
    } else {
      throw new ItemNaoEncontradoException("Item não encontrado no banco de dados");
    }
  }

}
