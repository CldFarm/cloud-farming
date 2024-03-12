--liquibase formatted sql

--changeset sean.vanwyk:producetype:1
INSERT INTO produce_type VALUES 
  ('Colour Beans'), 
  ('Location Beans'),
  ('Coffee Beans'),
  ('Otherworldly Beans');
--rollback DROP FROM "ProduceType";