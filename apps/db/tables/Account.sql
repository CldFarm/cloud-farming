--liquibase formatted sql

--changeset sean.vanwyk:account:1
CREATE TABLE account (
  accountid serial PRIMARY KEY,
  account_uid varchar NOT NULL
);
--rollback DROP TABLE account;