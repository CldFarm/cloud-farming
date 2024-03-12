--liquibase formatted sql

--changeset sean.vanwyk:region:1
CREATE TABLE "Region" (
  "RegionID" serial PRIMARY KEY,
  "RegionName" varchar NOT NULL
);
--rollback DROP TABLE "Region";