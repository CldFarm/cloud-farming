--liquibase formatted sql

--changeset sean.vanwyk:region:1
CREATE TABLE region (
  regionid serial PRIMARY KEY,
  region_name varchar NOT NULL
);
--rollback DROP TABLE region;