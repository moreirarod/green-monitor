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
@Table(name = "T_GM_CONTROLE_IRRIGACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ControleIrrigacao {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTROLE_IRRIGACAO")
  @SequenceGenerator(name = "SEQ_CONTROLE_IRRIGACAO", sequenceName = "SEQ_CONTROLE_IRRIGACAO", allocationSize = 1)
  @Column(name = "id_controle_irrigacao")
  private int id;

  @Column(name = "dt_data_hora_agendamento")
  private LocalDateTime dataHoraAgendamento;

  @Column(name = "vl_latitude")
  private double latitude;

  @Column(name = "vl_longitude")
  private double longitude;

  @Column(name = "vl_duracao")
  private int duracao;

  @Column(name = "ds_condicoes_climaticas")
  private String condicoesClimaticas;

}
