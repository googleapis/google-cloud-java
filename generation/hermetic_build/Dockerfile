# Copyright 2021 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# build with:
# docker build -t gcr.io/repo-automation-bots/bazel-bot .

##########################################################
# Build the command-line tool that lets us sign JWTs.
FROM rust:1.49-buster
RUN git clone https://github.com/mike-engel/jwt-cli.git
WORKDIR /jwt-cli
RUN git checkout 652b5c4b2a9d9a236aa3826a8dd34204ca7e1dad
RUN cargo build --release

##########################################################
# Build the image.
FROM gcr.io/gapic-images/googleapis-bazel
COPY --from=0 /jwt-cli/target/release/jwt /bin/jwt

## Install the github command line tool, and jq to parse json responses.
#RUN apt-get install -y software-properties-common
#RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-key C99B11DEB97541F0
#RUN apt-add-repository https://cli.github.com/packages
#RUN apt-get update
#RUN apt-get install -y gh jq
#
## TODO: Remove this chunk when it gets added to the upstream gcr.io/gapic-images/googleapis-bazel
#### Requirement: Set the correct locale so Ruby strings default to UTF-8, needed for template engine to work
#ARG DEBIAN_FRONTEND=noninteractive
#RUN apt-get update && apt-get install -y --no-install-recommends \
#    locales \
#    && echo "en_US.UTF-8 UTF-8" > /etc/locale.gen \
#    && locale-gen en_US.UTF-8 \
#    && rm -f /var/lib/apt/lists/*_*
#ENV LANG=en_US.UTF-8 \
#    LANGUAGE=en_US:en
#
## Copy the source files from this directory.
#COPY generate-googleapis-gen.sh /generate-googleapis-gen.sh
#COPY install-credentials.sh /install-credentials.sh
#COPY docker-main.sh /docker-main.sh
#
#ENTRYPOINT ["/bin/bash"]
#CMD ["/docker-main.sh"]
ENTRYPOINT [ "/bin/bash", "-l", "-c" ]
