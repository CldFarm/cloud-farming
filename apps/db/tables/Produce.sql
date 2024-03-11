--liquibase formatted sql

--changeset sean.vanwyk:produce:1
CREATE TABLE "Produce" (
  "ProduceID" serial PRIMARY KEY,
  "ProduceName" varchar NOT NULL,
  "ProduceTypeID" integer NOT NULL
);
-- rollback DROP TABLE "Produce";

--changeset sean.vanwyk:produce:2
ALTER TABLE "Produce" ADD CONSTRAINT "Produce_ProduceTypeID_FK" FOREIGN KEY ("ProduceTypeID") REFERENCES "ProduceType" ("ProduceTypeID");
--rollback ALTER TABLE "Produce" DROP CONSTRAINT "Produce_ProduceTypeID_FK";
