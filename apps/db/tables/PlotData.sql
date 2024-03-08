--changeset sean.vanwyk:plotdata:1
CREATE TABLE "PlotData" (
  "PlotDataID" serial PRIMARY KEY,
  "PlotID" integer NOT NULL,
  "GrowthPercent" numeric NOT NULL,
  "Sunlight" numeric NOT NULL,
  "SoilMoisture" numeric NOT NULL,
  "TimeTaken" timestamp NOT NULL
);
--rollback DROP TABLE "PlotData";