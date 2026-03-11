FROM gcr.io/cloud-devrel-public-resources/java11

ENV JDBC_DOCKER_ENV=true
RUN apt-get update && apt-get install -y zip && rm -rf /var/lib/apt/lists/*

RUN mkdir /tst
COPY ./pom.xml /src/pom.xml
COPY ./java.header /src/java.header
COPY ./license-checks.xml /src/license-checks.xml
COPY ./google-cloud-bigquery-jdbc/pom.xml /src/google-cloud-bigquery-jdbc/pom.xml

COPY ./google-cloud-bigquery /src/google-cloud-bigquery
COPY ./google-cloud-bigquery-bom /src/google-cloud-bigquery-bom


WORKDIR /src
RUN mvn install -DskipTests

WORKDIR /src/google-cloud-bigquery-jdbc

ENTRYPOINT []
