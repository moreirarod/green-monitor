package br.com.fiap.green_monitor.dto;

import java.time.LocalDateTime;

import br.com.fiap.green_monitor.model.ControleIrrigacao;
import jakarta.validation.constraints.NotNull;

public record ControleIrrigacaoDTO(
    int id,

    @NotNull(message = "Data e hora de agendamento não pode ser nula") LocalDateTime dataHoraAgendamento,

    @NotNull(message = "Latitude não pode ser nula") double latitude,

    @NotNull(message = "Longitude não pode ser nula") double longitude,

    @NotNull(message = "Duração não pode ser nula") int duracao,

    String condicoesClimaticas) {

  public ControleIrrigacaoDTO(ControleIrrigacao controleIrrigacao) {
    this(controleIrrigacao.getId(), controleIrrigacao.getDataHoraAgendamento(), controleIrrigacao.getLatitude(),
        controleIrrigacao.getLongitude(), controleIrrigacao.getDuracao(), controleIrrigacao.getCondicoesClimaticas());
  }

}
