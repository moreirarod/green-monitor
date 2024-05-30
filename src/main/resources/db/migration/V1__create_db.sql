CREATE SEQUENCE SEQ_ALERTA_DESASTRE_NATURAL
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE SEQUENCE SEQ_QUALIDADE_AR
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE SEQUENCE SEQ_QUALIDADE_AGUA
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE SEQUENCE SEQ_CONTROLE_IRRIGACAO
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE TABLE T_GM_ALERTA_DESASTRE_NATURAL (
  id_alerta           NUMBER DEFAULT SEQ_ALERTA_DESASTRE_NATURAL.NEXTVAL PRIMARY KEY,
  nm_tipo_desastre    VARCHAR2(100) NOT NULL,
  dt_data_hora        TIMESTAMP NOT NULL,
  vl_latitude         NUMBER NOT NULL,
  vl_longitude        NUMBER NOT NULL,
  ds_intensidade      VARCHAR2(100)
);

CREATE TABLE T_GM_QUALIDADE_AR (
  id_qualidade_ar     NUMBER DEFAULT SEQ_QUALIDADE_AR.NEXTVAL PRIMARY KEY,
  dt_data_hora        TIMESTAMP NOT NULL,
  vl_latitude         NUMBER NOT NULL,
  vl_longitude        NUMBER NOT NULL,
  vl_particulados     NUMBER,
  vl_dioxido_carbono  NUMBER,
  vl_ozonio           NUMBER
);

CREATE TABLE T_GM_QUALIDADE_AGUA (
  id_qualidade_agua   NUMBER DEFAULT SEQ_QUALIDADE_AGUA.NEXTVAL PRIMARY KEY,
  dt_data_hora        TIMESTAMP NOT NULL,
  vl_latitude         NUMBER NOT NULL,
  vl_longitude        NUMBER NOT NULL,
  vl_ph               NUMBER,
  vl_turbidez         NUMBER,
  ds_contaminantes    VARCHAR2(1000)
);

CREATE TABLE T_GM_CONTROLE_IRRIGACAO (
  id_controle_irrigacao       NUMBER DEFAULT SEQ_CONTROLE_IRRIGACAO.NEXTVAL PRIMARY KEY,
  dt_data_hora_agendamento    TIMESTAMP NOT NULL,
  vl_latitude                 NUMBER NOT NULL,
  vl_longitude                NUMBER NOT NULL,
  vl_duracao                  NUMBER NOT NULL,
  ds_condicoes_climaticas     VARCHAR2(100)
);
