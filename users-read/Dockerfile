FROM mongo:8.0.6
ENV MONGO_INITDB_ROOT_USERNAME=exampleuser
ENV MONGO_INITDB_ROOT_PASSWORD=examplepassword

COPY ./init.js /docker-entrypoint-initdb.d/init.js