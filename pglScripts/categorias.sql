-- Table: public.categorias

-- DROP TABLE public.categorias;

CREATE TABLE public.categorias
(
  id_categ integer NOT NULL DEFAULT nextval('categoria_id_categ_seq'::regclass),
  categ_nome character varying(55),
  CONSTRAINT categ_id PRIMARY KEY (id_categ)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.categorias
  OWNER TO postgres;
