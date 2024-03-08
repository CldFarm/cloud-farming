--changeset sean.vanwyk:plot:1
ALTER TABLE "Plot" ADD CONSTRAINT "Plot_PlotTypeID_FK" FOREIGN KEY ("PlotTypeID") REFERENCES "PlotType" ("PlotTypeID");
--rollback ALTER TABLE "Plot" DROP CONSTRAINT "Plot_PlotTypeID_FK";

--changeset sean.vanwyk:plot:2
ALTER TABLE "Plot" ADD CONSTRAINT "Plot_ConfigID_FK" FOREIGN KEY ("ConfigID") REFERENCES "Config" ("ConfigID");
--rollback ALTER TABLE "Plot" DROP CONSTRAINT "Plot_ConfigID_FK";

--changeset sean.vanwyk:plot:3
ALTER TABLE "Plot" ADD CONSTRAINT "Plot_GrowZoneID_FK" FOREIGN KEY ("GrowZoneID") REFERENCES "GrowZone" ("GrowZoneID");
--rollback ALTER TABLE "Plot" DROP CONSTRAINT "Plot_GrowZoneID_FK";

--changeset sean.vanwyk:plot:4
ALTER TABLE "Plot" ADD CONSTRAINT "Plot_AccountID_FK" FOREIGN KEY ("AccountID") REFERENCES "Account" ("AccountID");
--rollback ALTER TABLE "Plot" DROP CONSTRAINT "Plot_AccountID_FK";

--changeset sean.vanwyk:plottype:5
ALTER TABLE "PlotType" ADD CONSTRAINT "PlotType_ProduceID_FK" FOREIGN KEY ("ProduceID") REFERENCES "Produce" ("ProduceID");
--rollback ALTER TABLE "PlotType" DROP CONSTRAINT "PlotType_ProduceID_FK";

--changeset sean.vanwyk:plottype:6
ALTER TABLE "PlotType" ADD CONSTRAINT "PlotType_DefaultConfigID_FK" FOREIGN KEY ("DefaultConfigID") REFERENCES "Config" ("ConfigID");
--rollback ALTER TABLE "Config" DROP CONSTRAINT "PlotType_DefaultConfigID_FK";

--changeset sean.vanwyk:produce:7
ALTER TABLE "Produce" ADD CONSTRAINT "Produce_ProduceTypeID_FK" FOREIGN KEY ("ProduceTypeID") REFERENCES "ProduceType" ("ProduceTypeID");
--rollback ALTER TABLE "Produce" DROP CONSTRAINT "Produce_ProduceTypeID_FK";

--changeset sean.vanwyk:config:8
ALTER TABLE "Config" ADD CONSTRAINT "Config_FertilizerTypeID_FK" FOREIGN KEY ("FertilizerTypeID") REFERENCES "FertilizerType" ("FertilizerTypeID");
--rollback ALTER TABLE "Config" DROP CONSTRAINT "Config_FertilizerTypeID_FK";

--changeset sean.vanwyk:config:9
ALTER TABLE "Config" ADD CONSTRAINT "Config_AccountID_FK" FOREIGN KEY ("AccountID") REFERENCES "Account" ("AccountID");
--rollback ALTER TABLE "Config" DROP CONSTRAINT "Config_AccountID_FK";

--changeset sean.vanwyk:growzone:10
ALTER TABLE "GrowZone" ADD CONSTRAINT "GrowZone_RegionID_FK" FOREIGN KEY ("RegionID") REFERENCES "Region" ("RegionID");
--rollback ALTER TABLE "GrowZone" DROP CONSTRAINT "GrowZone_RegionID_FK";

--changeset sean.vanwyk:plotdata:11
ALTER TABLE "PlotData" ADD CONSTRAINT "PlotData_PlotID_FK" FOREIGN KEY ("PlotID") REFERENCES "Plot" ("PlotID");
--rollback ALTER TABLE "PlotData" DROP CONSTRAINT "PlotData_PlotID_FK";
