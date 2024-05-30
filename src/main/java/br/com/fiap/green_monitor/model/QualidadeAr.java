package br.com.fiap.green_monitor.model;

import java.time.LocalDateTime;

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
@Table(name = "T_GM_QUALIDADE_AR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QualidadeAr {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_QUALIDADE_AR")
  @SequenceGenerator(name = "SEQ_QUALIDADE_AR", sequenceName = "SEQ_QUALIDADE_AR", allocationSize = 1)
  @Column(name = "id_qualidade_ar")
  private int id;

  @Column(name = "dt_data_hora")
  private LocalDateTime dataHora;

  @Column(name = "vl_latitude")
  private double latitude;

  @Column(name = "vl_longitude")
  private double longitude;

  @Column(name = "vl_particulados")
  private double particulados;

  @Column(name = "vl_dioxido_carbono")
  private double dioxidoCarbono;

  @Column(name = "vl_ozonio")
  private double ozonio;
}
