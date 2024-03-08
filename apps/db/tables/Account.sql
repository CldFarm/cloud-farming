--changeset sean.vanwyk:account:1
CREATE TABLE "Account" (
  "AccountID" serial PRIMARY KEY,
  "AccountUID" varchar NOT NULL
);
--rollback DROP TABLE "Account";