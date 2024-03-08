--changeset sean.vanwyk:produce:1
CREATE TABLE "Produce" (
  "ProduceID" serial PRIMARY KEY,
  "ProduceName" varchar NOT NULL,
  "ProduceTypeID" integer NOT NULL
);
-- rollback DROP TABLE "Produce";