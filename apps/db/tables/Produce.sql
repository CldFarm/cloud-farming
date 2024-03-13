--liquibase formatted sql

--changeset sean.vanwyk:produce:1
CREATE TABLE produce (
  produceid serial PRIMARY KEY,
  produce_name varchar NOT NULL,
  produce_typeid integer NOT NULL
);
-- rollback DROP TABLE produce;

--changeset sean.vanwyk:produce:2
ALTER TABLE produce ADD CONSTRAINT "Produce_ProduceTypeID_FK" FOREIGN KEY (produce_typeid) REFERENCES produce_type (produce_typeid);
--rollback ALTER TABLE produce DROP CONSTRAINT "Produce_ProduceTypeID_FK";
