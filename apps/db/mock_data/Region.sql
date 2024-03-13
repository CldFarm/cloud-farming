--liquibase formatted sql

--changeset sean.vanwyk:region:1 label:mock
INSERT INTO region (region_name) VALUES
('South Africa'),
('Mars');
--rollback DROP FROM region;