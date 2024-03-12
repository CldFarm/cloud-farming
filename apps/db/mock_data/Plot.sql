--liquibase formatted sql

--changeset sean.vanwyk:plot:1
INSERT INTO "Plot" ("PlotName", "Description", "AccountID", "GrowZoneID", "PlotTypeID", "ConfigID", "CreationDate", "Terminated") VALUES
  ('Dave''s Plot', 'Plot that Dave made to grow Coffee on. Dave is poor. But Dave will have his Coffee', 1, 2, 1, 1, now, FALSE);
--rollback DROP FROM "Plot";