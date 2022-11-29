# Copyright 2022 Google LLC
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

# Specifying our own image is more reliable than 3rd-party image, which
# may become unavailable per their maintenance policy.
FROM gcr.io/cloud-devrel-public-resources/java17

RUN apt-get update && \
    apt-get -y upgrade && \
    apt-get install wget && \
    apt-get install unzip && \
    apt -y install git && \
    apt-get install -y --no-install-recommends libxml2-utils apt-transport-https ca-certificates gnupg && \
    rm -rf /var/cache/apt

# Install python. Pyenv is installed in gcr.io/cloud-devrel-public-resources/java17 already
RUN pyenv install 3.10.8 && \
    pyenv global 3.10.8 && \
    python3 -m pip install --upgrade pip setuptools

# Install docker
RUN apt-get update && apt-get install -y \
        apt-transport-https \
        ca-certificates \
        curl \
        gnupg-agent \
        lsb-release \
        software-properties-common && \
    curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - && \
    add-apt-repository \
        "deb [arch=amd64] https://download.docker.com/linux/debian \
        bullseye \
        stable" && \
    apt-get update && \
    apt-get install -y docker-ce docker-ce-cli containerd.io

# Install Terraform
RUN apt-get update && apt-get install -y gnupg software-properties-common curl && \
    curl -fsSL https://apt.releases.hashicorp.com/gpg | apt-key add - && \
    apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main" && \
    apt-get update && apt-get install terraform

# Install jq
RUN apt-get -y install jq

# Owl Bot service brings the branch of the repository copy to /workspace
WORKDIR /workspace

# Build context is owl-bot-postprocessor
COPY requirements.txt /synthtool/requirements.txt

RUN python3 -m pip install --require-hashes -r /synthtool/requirements.txt

CMD [ "owl-bot-postprocessor/main.sh" ]
