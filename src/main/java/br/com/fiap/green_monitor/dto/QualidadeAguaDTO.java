package br.com.fiap.green_monitor.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.fiap.green_monitor.model.QualidadeAgua;
import jakarta.validation.constraints.NotNull;

public record QualidadeAguaDTO(
    int id,

    @NotNull(message = "Data e hora não pode ser nula") LocalDateTime dataHora,

    @NotNull(message = "Latitude não pode ser nula") double latitude,

    @NotNull(message = "Longitude não pode ser nula") double longitude,

    double ph,
    double turbidez,
    List<String> contaminantes) {

  public QualidadeAguaDTO(QualidadeAgua qualidadeAgua) {
    this(qualidadeAgua.getId(), qualidadeAgua.getDataHora(), qualidadeAgua.getLatitude(), qualidadeAgua.getLongitude(),
        qualidadeAgua.getPh(), qualidadeAgua.getTurbidez(), qualidadeAgua.getContaminantes());
  }
}
