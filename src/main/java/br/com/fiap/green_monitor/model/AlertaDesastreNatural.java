package br.com.fiap.green_monitor.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_GM_ALERTA_DESASTRE_NATURAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AlertaDesastreNatural {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ALERTA_DESASTRE_NATURAL")
  @Column(name = "id_alerta")
  private int id;

  @Column(name = "nm_tipo_desastre")
  private String tipoDesastre;

  @Column(name = "dt_data_hora")
  private LocalDateTime dataHora;

  @Column(name = "vl_latitude")
  private double latitude;

  @Column(name = "vl_longitude")
  private double longitude;

  @Column(name = "ds_intensidade")
  private String intensidade;

}
