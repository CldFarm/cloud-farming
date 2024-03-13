--liquibase formatted sql

--changeset sean.vanwyk:plot:1 label:mock context:@mock
INSERT INTO plot (plot_name, description, accountid, grow_zoneid, plot_typeid, configid, creation_date, terminated) VALUES
  ('Dave''s Plot', 'Plot that Dave made to grow Coffee on. Dave is poor. But Dave will have his Coffee', 1, 2, 1, 1, '2024-03-13', FALSE),
  ('Frank''s Plot', 'Plot that Frank made to grow Sky Beans on. Frank is poor. But Frank will have his Sky Beans', 1, 4, 11, 8, '2023-10-01', TRUE);
--rollback DROP FROM plot;