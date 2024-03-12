--liquibase formatted sql

--changeset sean.vanwyk:plot:1
CREATE TABLE "Plot" (
  "PlotID" serial PRIMARY KEY,
  "PlotName" varchar NOT NULL,
  "Description" varchar NOT NULL,
  "AccountID" integer NOT NULL,
  "GrowZoneID" integer NOT NULL,
  "PlotTypeID" integer NOT NULL,
  "ConfigID" integer NOT NULL,
  "CreationDate" timestamp NOT NULL,
  "Terminated" boolean NOT NULL
);
--rollback DROP TABLE Plot;

--changeset sean.vanwyk:plot:2
ALTER TABLE "Plot" ADD CONSTRAINT "Plot_PlotTypeID_FK" FOREIGN KEY ("PlotTypeID") REFERENCES "PlotType" ("PlotTypeID");
--rollback ALTER TABLE "Plot" DROP CONSTRAINT "Plot_PlotTypeID_FK";

--changeset sean.vanwyk:plot:3
ALTER TABLE "Plot" ADD CONSTRAINT "Plot_ConfigID_FK" FOREIGN KEY ("ConfigID") REFERENCES "Config" ("ConfigID");
--rollback ALTER TABLE "Plot" DROP CONSTRAINT "Plot_ConfigID_FK";

--changeset sean.vanwyk:plot:4
ALTER TABLE "Plot" ADD CONSTRAINT "Plot_GrowZoneID_FK" FOREIGN KEY ("GrowZoneID") REFERENCES "GrowZone" ("GrowZoneID");
--rollback ALTER TABLE "Plot" DROP CONSTRAINT "Plot_GrowZoneID_FK";

--changeset sean.vanwyk:plot:5
ALTER TABLE "Plot" ADD CONSTRAINT "Plot_AccountID_FK" FOREIGN KEY ("AccountID") REFERENCES "Account" ("AccountID");
--rollback ALTER TABLE "Plot" DROP CONSTRAINT "Plot_AccountID_FK";
