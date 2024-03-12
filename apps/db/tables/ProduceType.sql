--liquibase formatted sql

--changeset sean.vanwyk:producetype:1
CREATE TABLE "ProduceType" (
  "ProduceTypeID" serial PRIMARY KEY,
  "ProduceType" varchar NOT NULL
);
--rollback DROP TABLE "ProduceType";