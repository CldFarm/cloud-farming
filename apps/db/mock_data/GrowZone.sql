--liquibase formatted sql

--changeset sean.vanwyk:growzone:1 label:mock
INSERT INTO grow_zone (grow_zone_name, regionid) VALUES
  ('za-1a', 1),
  ('za-1b', 1),
  ('za-1c', 1),
  ('mars-1a', 2),
  ('mars-1b', 2),
  ('mars-1c', 2);
--rollback DROP FROM grow_zone;
