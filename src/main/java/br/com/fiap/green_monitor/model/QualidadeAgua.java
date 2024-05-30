package br.com.fiap.green_monitor.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_GM_QUALIDADE_AGUA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QualidadeAgua {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_QUALIDADE_AGUA")
  @SequenceGenerator(name = "SEQ_QUALIDADE_AGUA", sequenceName = "SEQ_QUALIDADE_AGUA", allocationSize = 1)
  @Column(name = "id_qualidade_agua")
  private int id;

  @Column(name = "dt_data_hora")
  private LocalDateTime dataHora;

  @Column(name = "vl_latitude")
  private double latitude;

  @Column(name = "vl_longitude")
  private double longitude;

  @Column(name = "vl_ph")
  private double ph;

  @Column(name = "vl_turbidez")
  private double turbidez;

  @Column(name = "ds_contaminantes")
  private List<String> contaminantes;
}
