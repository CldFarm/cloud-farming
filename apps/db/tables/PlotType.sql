--liquibase formatted sql

--changeset sean.vanwyk:plottype:1
CREATE TABLE plot_type (
  plot_typeid serial PRIMARY KEY,
  plot_type_name varchar NOT NULL,
  plot_size numeric NOT NULL,
  produceid integer NOT NULL,
  default_configid integer NOT NULL
);
-- rollback DROP TABLE plottype;

--changeset sean.vanwyk:plottype:2
ALTER TABLE plot_type ADD CONSTRAINT "PlotType_ProduceID_FK" FOREIGN KEY (produceid) REFERENCES produce (produceid);
--rollback ALTER TABLE plottype DROP CONSTRAINT "PlotType_ProduceID_FK";

--changeset sean.vanwyk:plottype:3
ALTER TABLE plot_type ADD CONSTRAINT "PlotType_DefaultConfigID_FK" FOREIGN KEY (default_configid) REFERENCES config (configid);
--rollback ALTER TABLE plottype DROP CONSTRAINT "PlotType_DefaultConfigID_FK";

--changeset sean.vanwyk:plottype:4
ALTER TABLE plot_type ADD CONSTRAINT "PlotType_PositivePlotSize" CHECK (plot_size > 0);
--rollback ALTER TABLE plot_type DROP CONSTRAINT "PlotType_PositivePlotSize";
