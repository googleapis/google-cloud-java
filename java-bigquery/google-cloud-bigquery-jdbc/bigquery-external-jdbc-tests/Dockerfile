FROM gcr.io/cloud-devrel-public-resources/java11

ARG JDBC_VERSION
ARG JDBC_JAR_PATH

ENV container_jdbc_jar_path=/jdbc/simba/GoogleBigQueryJDBC42.jar

COPY ./pom.xml /src/pom.xml
COPY ${JDBC_JAR_PATH} ${container_jdbc_jar_path}

# Override SIMBA_JDBC_JAR_PATH with path inside the container
ENV JDBC_VERSION=${JDBC_VERSION}
ENV JDBC_JAR_PATH=${container_jdbc_jar_path}
ENV JDBC_DOCKER_ENV=true

WORKDIR /src
RUN mvn install

ENTRYPOINT []
