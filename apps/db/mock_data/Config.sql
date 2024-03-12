--liquibase formatted sql

--changeset sean.vanwyk:config:1
INSERT INTO "Config" ("ConfigName", "Description", "AccountID", "FertilizerTypeID", "WaterPerHour") VALUES
  ("CloudFarm 1", "Default Config 1, Managed by CloudFarm", NULL, 1, 10),
  ("CloudFarm 2", "Default Config 2, Managed by CloudFarm", NULL, 2, 20),
  ("CloudFarm 3", "Default Config 3, Managed by CloudFarm", NULL, 3, 5),
  ("CloudFarm 4", "Default Config 4, Managed by CloudFarm", NULL, 4, 30),
  ("CloudFarm 5", "Default Config 5, Managed by CloudFarm", NULL, 5, 2),
  ("CloudFarm 6", "Default Config 6, Managed by CloudFarm", NULL, 6, 20),
  ("CloudFarm 7", "Default Config 7, Managed by CloudFarm", NULL, 7, 10),
  ("CloudFarm 8", "Default Config 8, Managed by CloudFarm", NULL, 8, 3),
  ("CloudFarm 9", "Default Config 9, Managed by CloudFarm", NULL, 9, 18),
  ("CloudFarm 10", "Default Config 10, Managed by CloudFarm", NULL, 10, 7),
  ("CloudFarm 11", "Default Config 11, Managed by CloudFarm", NULL, 11, 6),
  ("CloudFarm 12", "Default Config 12, Managed by CloudFarm", NULL, 12, 14),
  ("CloudFarm 13", "Default Config 13, Managed by CloudFarm", NULL, 13, 19),
  ("CloudFarm 14", "Default Config 14, Managed by CloudFarm", NULL, 14, 4),
  ("CloudFarm 15", "Default Config 15, Managed by CloudFarm", NULL, 15, 4),
  ("CloudFarm 16", "Default Config 16, Managed by CloudFarm", NULL, 16, 12),
  ("CloudFarm 17", "Default Config 17, Managed by CloudFarm", NULL, 17, 15),
  ("CloudFarm 18", "Default Config 18, Managed by CloudFarm", NULL, 18, 24),
  ("CloudFarm 19", "Default Config 19, Managed by CloudFarm", NULL, 19, 60),
  ("CloudFarm 20", "Default Config 20, Managed by CloudFarm", NULL, 20, 37),
  ("User 1's Config", "Config for User 1", 1, 4, 5);
--rollback DROP FROM "Config";