path "database/creds/DB_USER_FLYWAY" {
  capabilities = ["read"]
}

path "database/creds/DB_USER_EXCHANGE" {
  capabilities = ["read"]
}

path "database/creds/DB_USER_READ" {
  capabilities = ["read"]
}

path "auth/token/renew-self" {
  capabilities = ["update"]
}

path "sys/leases/renew" {
  capabilities = ["update"]
}
path "sys/leases/revoke" {
  capabilities = ["update"]
}

