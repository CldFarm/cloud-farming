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