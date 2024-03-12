--liquibase formatted sql

--changeset sean.vanwyk:plottype:1
CREATE TABLE plot_type (
  plottypeid serial PRIMARY KEY,
  plot_type_name varchar NOT NULL,
  plot_size numeric NOT NULL,
  produceid integer NOT NULL,
  defaultconfigid integer NOT NULL
);
-- rollback DROP TABLE plottype;

--changeset sean.vanwyk:plottype:2
ALTER TABLE plot_type ADD CONSTRAINT "PlotType_ProduceID_FK" FOREIGN KEY (produceid) REFERENCES produce (produceid);
--rollback ALTER TABLE plottype DROP CONSTRAINT "PlotType_ProduceID_FK";

--changeset sean.vanwyk:plottype:3
ALTER TABLE plot_type ADD CONSTRAINT "PlotType_DefaultConfigID_FK" FOREIGN KEY (defaultconfigid) REFERENCES config (configid);
--rollback ALTER TABLE plottype DROP CONSTRAINT "PlotType_DefaultConfigID_FK";
