--liquibase formatted sql

--changeset sean.vanwyk:producetype:1 label:mock context:@mock
INSERT INTO produce_type (produce_type) VALUES 
  ('Colour Beans'), 
  ('Location Beans'),
  ('Coffee Beans'),
  ('Otherworldly Beans');
--rollback DROP FROM produce_type;