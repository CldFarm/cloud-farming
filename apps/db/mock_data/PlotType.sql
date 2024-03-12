--liquibase formatted sql

--changeset sean.vanwyk:plottype:1
INSERT INTO "PlotType" ("PlotTypeName", "PlotSize", "ProduceId", "DefaultConfigID") VALUES
  ('coffee.t1.micro', 5, 16, 6),
  ('coffee.t1.mini', 10, 16, 3),
  ('coffee.t1.medium', 20, 16, 2),
  ('coffee.t1.large', 40, 16, 1),
  ('beans.red1.micro', 2, 1, 20),
  ('beans.red1.mini', 4, 1, 18),
  ('beans.red1.medium', 6, 1, 14),
  ('beans.red1.large', 8, 1, 12),
  ('beans.sky1.micro', 20, 10, 13),
  ('beans.sky1.mini', 40, 10, 11),
  ('beans.sky1.medium', 60, 10, 8),
  ('beans.sky1.large', 80, 10, 9),
--rollback DROP FROM "PlotType";