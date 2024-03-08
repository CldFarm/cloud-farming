--changeset sean.vanwyk:growzone:1
CREATE TABLE "GrowZone" (
  "GrowZoneID" serial PRIMARY KEY,
  "GrowZoneName" varchar NOT NULL,
  "RegionID" integer NOT NULL
);
--rollback DROP TABLE "GrowZone";