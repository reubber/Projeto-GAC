-- Table: public.atividades

-- DROP TABLE public.atividades;

CREATE TABLE public.atividades
(
  cod_atv integer NOT NULL DEFAULT nextval('atividades_cod_atv_seq'::regclass),
  nome_atv character varying(255),
  curso character varying,
  descricao character varying(255),
  categ_atv integer NOT NULL DEFAULT nextval('atividades_categ_atv_seq'::regclass),
  matricula character varying(55),
  situacao character varying(55),
  CONSTRAINT atv_cod PRIMARY KEY (cod_atv),
  CONSTRAINT atividades_categ_atv_fkey FOREIGN KEY (categ_atv)
      REFERENCES public.categorias (id_categ) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT atividades_matricula_key UNIQUE (matricula)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.atividades
  OWNER TO postgres;
