-- Sequence: musicmanager_id_seq
 CREATE SEQUENCE musicmanager_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

ALTER TABLE musicmanager_id_seq
 OWNER TO docker;
