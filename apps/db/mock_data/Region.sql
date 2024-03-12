--liquibase formatted sql

--changeset sean.vanwyk:region:1
INSERT INTO "Region" ("RegionName") VALUES
('South Africa'),
('Mars');
--rollback DROP FROM "Region";