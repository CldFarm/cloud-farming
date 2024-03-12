--liquibase formatted sql

--changeset sean.vanwyk:growzone:1
CREATE TABLE "GrowZone" (
  "GrowZoneID" serial PRIMARY KEY,
  "GrowZoneName" varchar NOT NULL,
  "RegionID" integer NOT NULL
);
--rollback DROP TABLE "GrowZone";

--changeset sean.vanwyk:growzone:2
ALTER TABLE "GrowZone" ADD CONSTRAINT "GrowZone_RegionID_FK" FOREIGN KEY ("RegionID") REFERENCES "Region" ("RegionID");
--rollback ALTER TABLE "GrowZone" DROP CONSTRAINT "GrowZone_RegionID_FK";
