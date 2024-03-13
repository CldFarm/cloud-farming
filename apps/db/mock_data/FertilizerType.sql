--liquibase formatted sql

--changeset sean.vanwyk:fertilizer:1 label:mock context:@mock
insert into fertilizer_type (fertilizer_type) values ('Blue Umbrella-sedge');
insert into fertilizer_type (fertilizer_type) values ('Curvepod Fumewort');
insert into fertilizer_type (fertilizer_type) values ('Tulip');
insert into fertilizer_type (fertilizer_type) values ('Whitefoot Lipfern');
insert into fertilizer_type (fertilizer_type) values ('Narrowleaf Yerba Santa');
insert into fertilizer_type (fertilizer_type) values ('Alabama Maiden Fern');
insert into fertilizer_type (fertilizer_type) values ('Klamath Mountain Buckwheat');
insert into fertilizer_type (fertilizer_type) values ('Wright''s Bryum Moss');
insert into fertilizer_type (fertilizer_type) values ('Warnstorfia Moss');
insert into fertilizer_type (fertilizer_type) values ('Hybrid Rose');
insert into fertilizer_type (fertilizer_type) values ('Narrowleaf Evening Primrose');
insert into fertilizer_type (fertilizer_type) values ('Johnston''s Cryptantha');
insert into fertilizer_type (fertilizer_type) values ('Duchesne Rockcress');
insert into fertilizer_type (fertilizer_type) values ('Sensitive Partridge Pea');
insert into fertilizer_type (fertilizer_type) values ('Blue Mountain Catchfly');
insert into fertilizer_type (fertilizer_type) values ('Nodding Locoweed');
insert into fertilizer_type (fertilizer_type) values ('Guavaberry');
insert into fertilizer_type (fertilizer_type) values ('Fresno Mat');
insert into fertilizer_type (fertilizer_type) values ('Palmer''s Clover');
insert into fertilizer_type (fertilizer_type) values ('Wavyleaf Blazingstar');
--rollback DROP FROM fertilizer_type;