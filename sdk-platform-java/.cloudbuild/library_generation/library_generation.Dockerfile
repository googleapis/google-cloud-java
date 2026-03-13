# Copyright 2024 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# install gapic-generator-java in a separate layer so we don't overload the image
# with the transferred source code and jars


FROM docker.io/library/maven:3.9.9-eclipse-temurin-17-alpine@sha256:969014ee8852c9910ff5ef09de17541c2587819364b79d7dc044634dfb8a3388 AS ggj-build

WORKDIR /sdk-platform-java
COPY . .
# {x-version-update-start:gapic-generator-java:current}
ENV DOCKER_GAPIC_GENERATOR_VERSION="2.67.1-SNAPSHOT"
# {x-version-update-end}

# Download the java formatter
RUN mvn -pl gapic-generator-java-pom-parent help:evaluate -Dexpression='google-java-format.version' -q -DforceStdout > /java-formatter-version
RUN cat /java-formatter-version
RUN V=$(cat /java-formatter-version) && curl -o "/google-java-format.jar" "https://maven-central.storage-download.googleapis.com/maven2/com/google/googlejavaformat/google-java-format/${V}/google-java-format-${V}-all-deps.jar"

# Compile and install packages
RUN mvn install -B -ntp -T 1.5C -DskipTests -Dcheckstyle.skip -Dclirr.skip -Denforcer.skip -Dfmt.skip
RUN cp "/root/.m2/repository/com/google/api/gapic-generator-java/${DOCKER_GAPIC_GENERATOR_VERSION}/gapic-generator-java-${DOCKER_GAPIC_GENERATOR_VERSION}.jar" \
  "./gapic-generator-java.jar"

FROM docker.io/library/python:3.13.2-slim@sha256:6b3223eb4d93718828223966ad316909c39813dee3ee9395204940500792b740 as final

ARG OWLBOT_CLI_COMMITTISH=3a68a9c0de318784b3aefadcc502a6521b3f1bc5
ARG PROTOC_VERSION=33.2
ARG GRPC_VERSION=1.76.3
ENV HOME=/home
ENV OS_ARCHITECTURE="linux-x86_64"

# install OS tools
RUN apt update && apt install -y curl unzip rsync jq nodejs npm git openjdk-17-jdk

SHELL [ "/bin/bash", "-c" ]

# copy source code
COPY hermetic_build/common /src/common
COPY hermetic_build/library_generation /src/library_generation

# install protoc
WORKDIR /protoc
RUN source /src/library_generation/utils/utilities.sh \
	&& download_protoc "${PROTOC_VERSION}" "${OS_ARCHITECTURE}"
# we indicate protoc is available in the container via env vars
ENV DOCKER_PROTOC_LOCATION=/protoc/bin
ENV DOCKER_PROTOC_VERSION="${PROTOC_VERSION}"

# install grpc
WORKDIR /grpc
RUN source /src/library_generation/utils/utilities.sh \
	&& download_grpc_plugin "${GRPC_VERSION}" "${OS_ARCHITECTURE}"
# similar to protoc, we indicate grpc is available in the container via env vars
ENV DOCKER_GRPC_LOCATION="/grpc/protoc-gen-grpc-java.exe"

RUN python -m pip install --upgrade pip

# install main scripts as a python package
WORKDIR /
RUN python -m pip install --require-hashes -r src/common/requirements.txt
RUN python -m pip install src/common
RUN python -m pip install --require-hashes -r src/library_generation/requirements.txt
RUN python -m pip install src/library_generation

# install the owl-bot CLI
WORKDIR /tools
RUN git clone https://github.com/googleapis/repo-automation-bots
WORKDIR /tools/repo-automation-bots/packages/owl-bot
RUN git checkout "${OWLBOT_CLI_COMMITTISH}"
RUN npm i && npm run compile && npm link
RUN owl-bot copy-code --version
RUN chmod o+rx $(which owl-bot)

# copy the Java formatter
COPY --from=ggj-build "/google-java-format.jar" "${HOME}"/.library_generation/google-java-format.jar
RUN chmod 755 "${HOME}"/.library_generation/google-java-format.jar
ENV JAVA_FORMATTER_LOCATION="${HOME}/.library_generation/google-java-format.jar"

# Here we transfer gapic-generator-java from the previous stage.
# Note that the destination is a well-known location that will be assumed at runtime
# We hard-code the location string to avoid making it configurable (via ARG) as
# well as to avoid it making it overridable at runtime (via ENV).
COPY --from=ggj-build "/sdk-platform-java/gapic-generator-java.jar" "${HOME}/.library_generation/gapic-generator-java.jar"
RUN chmod 755 "${HOME}/.library_generation/gapic-generator-java.jar"
ENV GAPIC_GENERATOR_LOCATION="${HOME}/.library_generation/gapic-generator-java.jar"

# allow users to access the script folders
RUN chmod -R o+rx /src

# set dummy git credentials for the empty commit used in postprocessing
# we use system so all users using the container will use this configuration
RUN git config --system user.email "cloud-java-bot@google.com"
RUN git config --system user.name "Cloud Java Bot"

# allow read-write for /home and execution for binaries in /home/.nvm
RUN chmod -R a+rw /home

WORKDIR /workspace
ENTRYPOINT [ "python", "/src/library_generation/cli/entry_point.py", "generate" ]
