FROM postgres:17.5-alpine

ENV POSTGRES_PASSWORD=examplePassword
ENV POSTGRES_USER=exampleUser
ENV POSTGRES_DB=exchange
COPY ./init.sh /docker-entrypoint-initdb.d/init.sh