--changeset sean.vanwyk:fertilizer:1
CREATE TABLE "FertilizerType" (
  "FertilizerTypeID" serial PRIMARY KEY,
  "FertilizerType" varchar NOT NULL
);
--rollback DROP TABLE "FertilizerType";