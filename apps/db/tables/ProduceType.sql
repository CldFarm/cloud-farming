--liquibase formatted sql

--changeset sean.vanwyk:producetype:1
CREATE TABLE produce_type (
  produce_typeid serial PRIMARY KEY,
  produce_type varchar NOT NULL
);
--rollback DROP TABLE produce_type;