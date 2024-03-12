--liquibase formatted sql

--changeset sean.vanwyk:produce:1
INSERT INTO produce (produce_name, produce_typeid) VALUES 
  ('Red Beans', 1),
  ('Black Beans', 1),
  ('Blue Beans', 1),
  ('Yellow Beans', 1),
  ('Pink Beans', 1),
  ('Green Beans', 1),
  ('White Beans', 1),
  ('Orange Beans', 1),
  ('Grey Beans', 1),
  ('Sky Beans', 2),
  ('Ground Beans', 2),
  ('Western Beans', 2),
  ('Eastern Beans', 2),
  ('Northern Beans', 2),
  ('Southern Beans', 2),
  ('Arabica Beans', 3),
  ('Robusta Beans', 3),
  ('Coffee Beans', 3),
  ('Venusian Beans', 4),
  ('Mercurian Beans', 4),
  ('Martian Beans', 4),
  ('Jovian Beans', 4),
  ('Solar Beans', 4);
-- ROLLBACK DROP FROM produce;



