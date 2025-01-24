# Copyright 2023 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

FROM ghcr.io/graalvm/graalvm-community:23.0.1-ol9-20241015

# native-image comes out of the box
RUN native-image --version

RUN microdnf update -y oraclelinux-release-el9 && \
    microdnf install -y wget unzip git && \
    # Install maven
    wget -q https://archive.apache.org/dist/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.zip -O /tmp/maven.zip && \
    unzip /tmp/maven.zip -d /tmp/maven && \
    mv /tmp/maven/apache-maven-3.9.4 /usr/local/lib/maven && \
    rm /tmp/maven.zip && \
    ln -s $JAVA_HOME/lib $JAVA_HOME/conf

ENV PATH $PATH:/usr/local/lib/maven/bin

# Install gcloud SDK
COPY google-cloud-sdk.repo /etc/yum.repos.d/google-cloud-sdk.repo
RUN microdnf install -y google-cloud-sdk

# Adding the package path to local
ENV PATH $PATH:/usr/local/gcloud/google-cloud-sdk/bin

# Install docker
# See also https://docs.docker.com/engine/install/rhel/#set-up-the-repository
COPY docker-ce.repo /etc/yum.repos.d/docker-ce.repo
RUN microdnf install -y docker-ce docker-ce-cli

# Install terraform
# See also https://www.hashicorp.com/official-packaging-guide
COPY hashicorp.repo /etc/yum.repos.d/hashicorp.repo
RUN microdnf -y install terraform

# Install jq
RUN microdnf -y install jq

WORKDIR /workspace
