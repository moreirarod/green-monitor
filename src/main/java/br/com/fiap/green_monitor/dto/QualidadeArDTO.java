package br.com.fiap.green_monitor.dto;

import java.time.LocalDateTime;

import br.com.fiap.green_monitor.model.QualidadeAr;
import jakarta.validation.constraints.NotNull;

public record QualidadeArDTO(
    int id,

    @NotNull(message = "Data e hora não pode ser nula") LocalDateTime dataHora,

    @NotNull(message = "Latitude não pode ser nula") double latitude,

    @NotNull(message = "Longitude não pode ser nula") double longitude,

    double particulados,
    double dioxidoCarbono,
    double ozonio) {

  public QualidadeArDTO(QualidadeAr qualidadeAr) {
    this(qualidadeAr.getId(), qualidadeAr.getDataHora(), qualidadeAr.getLatitude(), qualidadeAr.getLongitude(),
        qualidadeAr.getParticulados(), qualidadeAr.getDioxidoCarbono(), qualidadeAr.getOzonio());
  }

}
