--changeset sean.vanwyk:plottype:1
CREATE TABLE "PlotType" (
  "PlotTypeID" serial PRIMARY KEY,
  "PlotTypeName" varchar NOT NULL,
  "PlotSize" numeric NOT NULL,
  "ProduceID" integer NOT NULL,
  "DefaultConfigID" integer NOT NULL
);
-- rollback DROP TABLE "PlotType";