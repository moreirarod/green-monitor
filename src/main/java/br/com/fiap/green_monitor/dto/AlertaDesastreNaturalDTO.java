package br.com.fiap.green_monitor.dto;

import java.time.LocalDateTime;

import br.com.fiap.green_monitor.model.AlertaDesastreNatural;
import jakarta.validation.constraints.NotNull;

public record AlertaDesastreNaturalDTO(
    int id,

    @NotNull(message = "Tipo de desastre não pode ser nulo") String tipoDesastre,

    @NotNull(message = "Data e hora não pode ser nula") LocalDateTime dataHora,

    @NotNull(message = "Latitude não pode ser nula") double latitude,

    @NotNull(message = "Longitude não pode ser nula") double longitude,

    String intensidade) {

  public AlertaDesastreNaturalDTO(AlertaDesastreNatural alertaDesastreNatural) {
    this(alertaDesastreNatural.getId(), alertaDesastreNatural.getTipoDesastre(), alertaDesastreNatural.getDataHora(),
        alertaDesastreNatural.getLatitude(), alertaDesastreNatural.getLongitude(),
        alertaDesastreNatural.getIntensidade());
  }

}
