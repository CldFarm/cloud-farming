--liquibase formatted sql

--changeset sean.vanwyk:plot:1
CREATE TABLE plot (
  plotid serial PRIMARY KEY,
  plot_name varchar NOT NULL,
  description varchar NOT NULL,
  accountid integer NOT NULL,
  growzoneid integer NOT NULL,
  plottypeid integer NOT NULL,
  configid integer NOT NULL,
  creation_date timestamp NOT NULL,
  terminated boolean NOT NULL
);
--rollback DROP TABLE plot;

--changeset sean.vanwyk:plot:2
ALTER TABLE plot ADD CONSTRAINT "Plot_PlotTypeID_FK" FOREIGN KEY (plottypeid) REFERENCES plot_type (plottypeid);
--rollback ALTER TABLE plot DROP CONSTRAINT "Plot_PlotTypeID_FK";

--changeset sean.vanwyk:plot:3
ALTER TABLE plot ADD CONSTRAINT "Plot_ConfigID_FK" FOREIGN KEY (configid) REFERENCES config (configid);
--rollback ALTER TABLE plot DROP CONSTRAINT "Plot_ConfigID_FK";

--changeset sean.vanwyk:plot:4
ALTER TABLE plot ADD CONSTRAINT "Plot_GrowZoneID_FK" FOREIGN KEY (growzoneid) REFERENCES grow_zone (growzoneid);
--rollback ALTER TABLE plot DROP CONSTRAINT "Plot_GrowZoneID_FK";

--changeset sean.vanwyk:plot:5
ALTER TABLE plot ADD CONSTRAINT "Plot_AccountID_FK" FOREIGN KEY (accountid) REFERENCES account (accountid);
--rollback ALTER TABLE plot DROP CONSTRAINT "Plot_AccountID_FK";
