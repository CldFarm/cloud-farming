--liquibase formatted sql

--changeset sean.vanwyk:plotdata:1
CREATE TABLE plot_data (
  plot_dataid serial PRIMARY KEY,
  plotid integer NOT NULL,
  growth_percent numeric NOT NULL,
  sunlight numeric NOT NULL,
  soil_moisture numeric NOT NULL,
  time_taken timestamp NOT NULL
);
--rollback DROP TABLE plot_data;

--changeset sean.vanwyk:plotdata:2
ALTER TABLE plot_data ADD CONSTRAINT "PlotData_PlotID_FK" FOREIGN KEY (plotid) REFERENCES plot (plotid);
--rollback ALTER TABLE plot_data DROP CONSTRAINT "PlotData_PlotID_FK";

--changeset sean.vanwyk:plotdata:3
ALTER TABLE plot_data ADD CONSTRAINT "PlotData_PositiveGrowthPercent" CHECK (growth_percent >= 0);
--rollback ALTER TABLE plot_data DROP CONSTRAINT "PlotData_PositiveGrowthPercent";

--changeset sean.vanwyk:plotdata:4
ALTER TABLE plot_data ADD CONSTRAINT "PlotData_PositiveSunlight" CHECK (sunlight >= 0);
--rollback ALTER TABLE plot_data DROP CONSTRAINT "PlotData_PositiveSunlight";

--changeset sean.vanwyk:plotdata:5
ALTER TABLE plot_data ADD CONSTRAINT "PlotData_PositiveSoilMoisture" CHECK (soil_moisture >= 0);
--rollback ALTER TABLE plot_data DROP CONSTRAINT "PlotData_PositiveSoilMoisture";
