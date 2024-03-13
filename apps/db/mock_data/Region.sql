--liquibase formatted sql

--changeset sean.vanwyk:region:1 label:mock context:@mock
INSERT INTO region (region_name) VALUES
('South Africa'),
('Mars');
--rollback DROP FROM region;