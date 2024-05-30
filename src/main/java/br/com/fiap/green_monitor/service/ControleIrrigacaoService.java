package br.com.fiap.green_monitor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.green_monitor.dto.ControleIrrigacaoDTO;
import br.com.fiap.green_monitor.exceptions.ItemNaoEncontradoException;
import br.com.fiap.green_monitor.model.ControleIrrigacao;
import br.com.fiap.green_monitor.repository.ControleIrrigacaoRepository;

@Service
public class ControleIrrigacaoService {

  @Autowired
  private ControleIrrigacaoRepository repository;

  public List<ControleIrrigacaoDTO> findAll() {
    return repository
        .findAll()
        .stream()
        .map(ControleIrrigacaoDTO::new)
        .toList();
  }

  public ControleIrrigacaoDTO findById(Integer id) {
    Optional<ControleIrrigacao> controleIrrigacaoOptional = repository.findById(id);
    if (controleIrrigacaoOptional.isPresent()) {
      return new ControleIrrigacaoDTO(controleIrrigacaoOptional.get());
    } else {
      throw new ItemNaoEncontradoException("Item não encontrado no banco de dados");
    }
  }

  public ControleIrrigacaoDTO save(ControleIrrigacaoDTO controleIrrigacaoDTO) {
    ControleIrrigacao controleIrrigacao = new ControleIrrigacao();
    BeanUtils.copyProperties(controleIrrigacaoDTO, controleIrrigacao);

    ControleIrrigacao controleIrrigacaoSalvo = repository.save(controleIrrigacao);
    return new ControleIrrigacaoDTO(controleIrrigacaoSalvo);
  }

  public void deleteById(Integer id) {
    Optional<ControleIrrigacao> ControleIrrigacao = repository.findById(id);
    if (ControleIrrigacao.isPresent()) {
      repository.deleteById(id);
    } else {
      throw new ItemNaoEncontradoException("Item não encontrado no banco de dados");
    }
  }

  public void deleteAll() {
    repository.deleteAll();
  }

  public ControleIrrigacao update(ControleIrrigacao ControleIrrigacao) {
    Optional<ControleIrrigacao> ControleIrrigacaoOptional = repository
        .findById(ControleIrrigacao.getId());
    if (ControleIrrigacaoOptional.isPresent()) {
      return repository.save(ControleIrrigacao);
    } else {
      throw new ItemNaoEncontradoException("Item não encontrado no banco de dados");
    }
  }

}
