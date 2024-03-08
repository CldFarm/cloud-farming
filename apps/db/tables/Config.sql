--changeset sean.vanwyk:config:1
CREATE TABLE "Config" (
  "ConfigID" serial PRIMARY KEY,
  "ConfigName" varchar NOT NULL,
  "Description" varchar NOT NULL,
  "AccountID" integer,
  "FertilizerTypeID" integer NOT NULL,
  "WaterPerHour" numeric NOT NULL
);
--rollback DROP TABLE "Config";