--liquibase formatted sql

--changeset sean.vanwyk:fertilizer:1
CREATE TABLE fertilizer_type (
  fertilizer_typeid serial PRIMARY KEY,
  fertilizer_type varchar NOT NULL
);
--rollback DROP TABLE fertilizer_type;