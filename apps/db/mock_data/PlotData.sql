--liquibase formatted sql

--changeset sean:vanwyk:plotdata:1
INSERT INTO "PlotData" ("PlotID", "GrowthPercent", "Sunlight", "SoilMoisture", "TimeTaken") VALUES
  (1, 0, 40, 80, now);
--rollback DROP FROM "PlotData";