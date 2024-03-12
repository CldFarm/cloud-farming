--liquibase formatted sql

--changeset sean.vanwyk:plottype:1
CREATE TABLE "PlotType" (
  "PlotTypeID" serial PRIMARY KEY,
  "PlotTypeName" varchar NOT NULL,
  "PlotSize" numeric NOT NULL,
  "ProduceID" integer NOT NULL,
  "DefaultConfigID" integer NOT NULL
);
-- rollback DROP TABLE "PlotType";

--changeset sean.vanwyk:plottype:2
ALTER TABLE "PlotType" ADD CONSTRAINT "PlotType_ProduceID_FK" FOREIGN KEY ("ProduceID") REFERENCES "Produce" ("ProduceID");
--rollback ALTER TABLE "PlotType" DROP CONSTRAINT "PlotType_ProduceID_FK";

--changeset sean.vanwyk:plottype:3
ALTER TABLE "PlotType" ADD CONSTRAINT "PlotType_DefaultConfigID_FK" FOREIGN KEY ("DefaultConfigID") REFERENCES "Config" ("ConfigID");
--rollback ALTER TABLE "Config" DROP CONSTRAINT "PlotType_DefaultConfigID_FK";
