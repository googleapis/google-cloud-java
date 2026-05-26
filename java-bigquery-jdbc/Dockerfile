FROM gcr.io/cloud-devrel-public-resources/java11
ARG BRANCH=main
ENV JDBC_DOCKER_ENV=true

# Changes to `pom.xml` will trigger re-sync
COPY pom.xml /src/pom.xml

# Doing it via single command, so layer contains only installed moduled vs full repo
# Copy from local repo is taking forever. Doing via git clone will keep dependencies ~up to date.
# It will fail on old branches forcing to sync to latest main branch.
RUN bash -c " \
    mkdir /git \
    && cd /git \ 
    && git clone -b ${BRANCH} --depth 1 --single-branch https://github.com/googleapis/google-cloud-java.git \
    && cd /git/google-cloud-java \
    && source .kokoro/common.sh \
    && install_modules java-bigquery \
    && rm -rf /git"

# This will ensure all deps are present
WORKDIR /src
RUN mvn install

ENTRYPOINT []
