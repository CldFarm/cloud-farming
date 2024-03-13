--liquibase formatted sql

--changeset sean.vanwyk:account:1 label:mock
insert into account (account_uid) values ('5ffb8c73-fe9c-4c3b-9d19-0d03c6730a4f');
insert into account (account_uid) values ('2d29a992-a250-4abc-9cdc-3f2375e0e10d');
insert into account (account_uid) values ('8a2443c5-5f7c-425a-861b-8829cb704613');
insert into account (account_uid) values ('164bd4e6-5bec-41ca-9ebf-6eacceedb1de');
insert into account (account_uid) values ('d99f9354-ddc9-4f1b-bbcb-df7d1dc52480');
insert into account (account_uid) values ('471006bc-6acc-4024-aa39-0546cf9f8637');
insert into account (account_uid) values ('08374b34-6fc4-4bed-b08b-c3cfdf920469');
insert into account (account_uid) values ('b9b9dd32-fab7-4544-b3c6-04972f5f07c1');
insert into account (account_uid) values ('1ac6aa77-dcaf-4819-961d-0a55280276d8');
insert into account (account_uid) values ('4709a7b6-8b20-4157-ab93-7a5bfb661bba');
insert into account (account_uid) values ('30225cbf-fcb9-41af-9f8c-6f6533d52f97');
insert into account (account_uid) values ('256de131-7695-4cd4-89f9-59164559a296');
insert into account (account_uid) values ('2f36fdad-2951-4bd1-84d7-5a3c0dad47e7');
insert into account (account_uid) values ('b5f4c586-753c-46b3-941d-8e0df079d54a');
insert into account (account_uid) values ('225750d6-8454-4bd8-82b1-0a6f5f3d3670');
insert into account (account_uid) values ('0f3872d3-752d-4cc3-9207-ab238fb4b190');
insert into account (account_uid) values ('73c64808-a6a2-4e2b-8205-c5fd744c9ff6');
insert into account (account_uid) values ('8c945f24-6d44-4559-9abb-74548f17efe7');
insert into account (account_uid) values ('f5e9fedf-e204-43e9-ad2d-1c20eef02dfc');
insert into account (account_uid) values ('53342c3c-21dd-44d2-81ad-7c13dfbca49c');
insert into account (account_uid) values ('801c4616-a41c-46b6-a815-9382f7e5c066');
insert into account (account_uid) values ('1d396906-d581-4578-a8fa-8f9998c14fb4');
insert into account (account_uid) values ('d502c5c6-4091-427a-8c02-bb211e63fa24');
insert into account (account_uid) values ('04fe7cdd-31bd-4db3-80dd-a000917ea748');
insert into account (account_uid) values ('317cf2f5-d0cc-4f70-8e1a-0e1e3bb5414c');
insert into account (account_uid) values ('110e2361-33ff-4429-b7f2-fb09d0a7e3b9');
insert into account (account_uid) values ('ec546778-d099-4352-89e5-1ac2b3657baa');
insert into account (account_uid) values ('b9b203e8-8ec9-4d3e-85fd-b937f3899e54');
insert into account (account_uid) values ('ce0472cd-f846-4712-8867-3320257eacdb');
insert into account (account_uid) values ('7347f968-ffc1-4dd2-ad2e-3be896421ff5');
insert into account (account_uid) values ('adb5afa4-0914-429a-b430-b3fe0df94407');
insert into account (account_uid) values ('3a71fe54-2050-4a9d-8c53-96098e8e2f35');
insert into account (account_uid) values ('88b384d9-3c53-41a6-9e68-f2b8c2e0a9b6');
insert into account (account_uid) values ('0b0a3fb8-5498-4c1b-a61e-1ce79a5c4965');
insert into account (account_uid) values ('5c4e98fd-badc-425c-acd7-1e3706c05080');
insert into account (account_uid) values ('67ecfd0a-c91a-4627-ac47-d60b28cc40de');
insert into account (account_uid) values ('1f6fd6b0-b2de-4cea-8228-d21fa933fe4c');
insert into account (account_uid) values ('3bf54ff3-04fa-45d9-bb53-6748e2d76cb1');
insert into account (account_uid) values ('16405717-4651-4366-80f4-466c50a648c7');
insert into account (account_uid) values ('d8604e41-8aa8-4591-bd74-6ae267ed3f9e');
insert into account (account_uid) values ('ff9fba7d-653a-48f0-bd2d-0035611d88b4');
insert into account (account_uid) values ('f601dd8c-6035-4d5a-9e66-294913d2f65f');
insert into account (account_uid) values ('7d65021e-bd2d-4cd8-84c3-f10597520cef');
insert into account (account_uid) values ('2185133f-7b2b-4180-a8ed-cb0ddf1725a7');
insert into account (account_uid) values ('51a25955-d170-4110-bf59-2a60f6361ad2');
insert into account (account_uid) values ('5e1fe6b4-1e34-4a43-90e9-87d57dcf5375');
insert into account (account_uid) values ('50bb69de-dd2b-4fa1-af09-0e985632ad3b');
insert into account (account_uid) values ('3f89c6f8-dfca-4119-92b5-cc29bb235f35');
insert into account (account_uid) values ('f25a0622-f372-4aee-96bc-2a3ee6ac59ec');
insert into account (account_uid) values ('4bba0cd0-39cb-4060-839c-aeda7efbdaff');
--rollback DROP FROM account;