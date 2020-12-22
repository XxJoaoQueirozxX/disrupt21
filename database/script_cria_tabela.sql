CREATE TABLE t_bttf_acontecimento (
    id_acontecimento  NUMBER(3) NOT NULL,
    ds_acontecimento  VARCHAR2(300) NOT NULL,
    nm_acontecimento  VARCHAR2(300) NOT NULL,
    dt_acontecimento  DATE NOT NULL,
    bl_alternativo    CHAR(1) NOT NULL,
    url_foto          VARCHAR2(300) NOT NULL,
    timeline          NUMBER (10) NOT NULL
);

ALTER TABLE t_bttf_acontecimento ADD CONSTRAINT pk_t_bttf_acontecimento PRIMARY KEY ( id_acontecimento );

CREATE TABLE t_bttf_consequencia (
    id_consequencia   NUMBER(3) NOT NULL,
    id_acontecimento  NUMBER(3) NOT NULL,
    ds_consequencia   VARCHAR2(600) NOT NULL
);


ALTER TABLE t_bttf_consequencia ADD CONSTRAINT pk_t_bttf_consequencia PRIMARY KEY ( id_consequencia );

CREATE TABLE t_bttf_personagem (
    id_personagem   NUMBER(3) NOT NULL,
    nm_personagem   VARCHAR2(60) NOT NULL,
    nm_ator         VARCHAR2(60) NOT NULL,
    ds_personagem   VARCHAR2(300) NOT NULL,
    relacao_marty   VARCHAR2(300) NOT NULL,
    url_foto        VARCHAR2(300) NOT NULL,
    bl_viajante     CHAR(1) NOT NULL,
    bl_alternativo  CHAR(1) NOT NULL
);

ALTER TABLE t_bttf_personagem ADD CONSTRAINT pk_t_bttf_personagem PRIMARY KEY ( id_personagem );

CREATE TABLE t_bttf_personagem_acont (
    id_personagem_acont  NUMBER(10) NOT NULL,
    id_acontecimento     NUMBER(3) NOT NULL,
    id_personagem        NUMBER(3) NOT NULL
);

ALTER TABLE t_bttf_personagem_acont ADD CONSTRAINT pk_t_bttf_personagem_acont PRIMARY KEY ( id_personagem_acont );

ALTER TABLE t_bttf_consequencia
    ADD CONSTRAINT fk_t_bttf_consequencia_acont FOREIGN KEY ( id_acontecimento )
        REFERENCES t_bttf_acontecimento ( id_acontecimento );

ALTER TABLE t_bttf_personagem_acont
    ADD CONSTRAINT fk_t_bttf_person_acont FOREIGN KEY ( id_acontecimento )
        REFERENCES t_bttf_acontecimento ( id_acontecimento );

ALTER TABLE t_bttf_personagem_acont
    ADD CONSTRAINT fk_t_bttf_person_acont_person FOREIGN KEY ( id_personagem )
        REFERENCES t_bttf_personagem ( id_personagem );
