--liquibase formatted sql

--changeset sean.vanwyk:config:1
CREATE TABLE config (
  configid serial PRIMARY KEY,
  config_name varchar NOT NULL,
  description varchar NOT NULL,
  accountid integer,
  fertilizertypeid integer NOT NULL,
  water_per_hour numeric NOT NULL
);
--rollback DROP TABLE config;

--changeset sean.vanwyk:config:2
ALTER TABLE config ADD CONSTRAINT "Config_FertilizerTypeID_FK" FOREIGN KEY (fertilizertypeid) REFERENCES fertilizer_type (fertilizertypeid);
--rollback ALTER TABLE config DROP CONSTRAINT "Config_FertilizerTypeID_FK";

--changeset sean.vanwyk:config:3
ALTER TABLE config ADD CONSTRAINT "Config_AccountID_FK" FOREIGN KEY (accountid) REFERENCES account (accountid);
--rollback ALTER TABLE config DROP CONSTRAINT "Config_AccountID_FK";
