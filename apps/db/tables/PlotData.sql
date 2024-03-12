--liquibase formatted sql

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

--changeset sean.vanwyk:plotdata:2
ALTER TABLE "PlotData" ADD CONSTRAINT "PlotData_PlotID_FK" FOREIGN KEY ("PlotID") REFERENCES "Plot" ("PlotID");
--rollback ALTER TABLE "PlotData" DROP CONSTRAINT "PlotData_PlotID_FK";

--changeset sean.vanwyk:plotdata:3
ALTER TABLE "PlotData" ADD CONSTRAINT "PlotData_PositiveGrowthPercent" CHECK ("GrowthPercent" >= 0);
--rollback ALTER TABLE "PlotData" DROP CONSTRAINT "PlotData_PositiveGrowthPercent";

--changeset sean.vanwyk:plotdata:4
ALTER TABLE "PlotData" ADD CONSTRAINT "PlotData_PositiveSunlight" CHECK ("Sunlight" >= 0);
--rollback ALTER TABLE "PlotData" DROP CONSTRAINT "PlotData_PositiveSunlight";

--changeset sean.vanwyk:plotdata:5
ALTER TABLE "PlotData" ADD CONSTRAINT "PlotData_PositiveSoilMoisture" CHECK ("SoilMoisture" >= 0);
--rollback ALTER TABLE "PlotData" DROP CONSTRAINT "PlotData_PositiveSoilMoisture";