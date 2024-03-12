--liquibase formatted sql

--changeset sean.vanwyk:growzone:1
CREATE TABLE grow_zone (
  grow_zoneid serial PRIMARY KEY,
  grow_zone_name varchar NOT NULL,
  regionid integer NOT NULL
);
--rollback DROP TABLE grow_zone;

--changeset sean.vanwyk:growzone:2
ALTER TABLE grow_zone ADD CONSTRAINT "GrowZone_RegionID_FK" FOREIGN KEY (regionid) REFERENCES region (regionid);
--rollback ALTER TABLE grow_zone DROP CONSTRAINT "GrowZone_RegionID_FK";
