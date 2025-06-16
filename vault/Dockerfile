FROM hashicorp/vault:1.13.3

ENV VAULT_ADDR="http://0.0.0.0:8200"
ENV VAULT_API_ADDR="http://0.0.0.0:8200"

ENTRYPOINT ["vault", "server", "-config=/vault/config.hcl"]