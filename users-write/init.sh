#!/usr/bin/env bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER"  --dbname "$POSTGRES_DB" <<-EOSQL
CREATE ROLE flyway_group;
CREATE ROLE app_group;

GRANT flyway_group TO "exampleUser" WITH ADMIN OPTION;
GRANT app_group TO "exampleUser" WITH ADMIN OPTION;

GRANT CONNECT ON DATABASE exchange TO flyway_group;
GRANT CONNECT ON DATABASE exchange TO app_group;

GRANT USAGE, CREATE ON SCHEMA public TO flyway_group;
EOSQL