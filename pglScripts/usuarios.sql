-- Table: public.usuarios

-- DROP TABLE public.usuarios;

CREATE TABLE public.usuarios
(
  id_user integer NOT NULL DEFAULT nextval('usuarios_id_user_seq'::regclass),
  user_nome character varying(55),
  user_senha character varying(55) NOT NULL,
  user_tipo character varying(55),
  CONSTRAINT user_id PRIMARY KEY (id_user),
  CONSTRAINT nome_user UNIQUE (user_nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuarios
  OWNER TO postgres;
