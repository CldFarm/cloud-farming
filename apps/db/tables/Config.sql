--liquibase formatted sql

--changeset sean.vanwyk:config:1
CREATE TABLE "Config" (
  "ConfigID" serial PRIMARY KEY,
  "ConfigName" varchar NOT NULL,
  "Description" varchar NOT NULL,
  "AccountID" integer,
  "FertilizerTypeID" integer NOT NULL,
  "WaterPerHour" numeric NOT NULL
);
--rollback DROP TABLE "Config";

--changeset sean.vanwyk:config:2
ALTER TABLE "Config" ADD CONSTRAINT "Config_FertilizerTypeID_FK" FOREIGN KEY ("FertilizerTypeID") REFERENCES "FertilizerType" ("FertilizerTypeID");
--rollback ALTER TABLE "Config" DROP CONSTRAINT "Config_FertilizerTypeID_FK";

--changeset sean.vanwyk:config:3
ALTER TABLE "Config" ADD CONSTRAINT "Config_AccountID_FK" FOREIGN KEY ("AccountID") REFERENCES "Account" ("AccountID");
--rollback ALTER TABLE "Config" DROP CONSTRAINT "Config_AccountID_FK";
