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

# Use a multi-stage docker build to limit production dependencies.

FROM docker as docker
FROM debian:10


ENV ANSIBLE_USER=ansible SUDO_GROUP=sudo DOCKER_GROUP=docker DOCKER_TLS_CERTDIR=/certs

RUN set -eux; \
    apt-get update; \
    apt-get install -y --no-install-recommends \
    sudo \
    python3 \
    ca-certificates \
    curl \
    iptables \
    net-tools \
    openssl \
    pigz \
    xz-utils \
    git \
    build-essential \
    ; \
    rm -rf /var/lib/apt/lists/*

RUN update-alternatives --set iptables /usr/sbin/iptables-legacy
RUN update-alternatives --set ip6tables /usr/sbin/ip6tables-legacy

RUN set -xe \
    && groupadd -r ${ANSIBLE_USER} \
    && groupadd -r ${DOCKER_GROUP} \
    && useradd -m -g ${ANSIBLE_USER} ${ANSIBLE_USER} \
    && usermod -aG ${SUDO_GROUP} ${ANSIBLE_USER} \
    && usermod -aG ${DOCKER_GROUP} ${ANSIBLE_USER} \
    && sed -i "/^%${SUDO_GROUP}/s/ALL\$/NOPASSWD:ALL/g" /etc/sudoers

RUN mkdir /certs /certs/client && chmod 1777 /certs /certs/client

COPY --from=docker /usr/local/bin/ /usr/local/bin/

VOLUME /var/lib/docker


ENV PYENV_ROOT="/.pyenv" \
    PATH="/.pyenv/bin:/.pyenv/shims:$PATH"

RUN apt-get update
RUN apt-get install -y --no-install-recommends git ca-certificates curl
RUN curl -L https://github.com/pyenv/pyenv-installer/raw/master/bin/pyenv-installer | bash
RUN apt-get purge -y --auto-remove ca-certificates curl
RUN apt-get clean
RUN rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

RUN apt-get update
RUN apt-get install -y --no-install-recommends \
        make build-essential libssl-dev zlib1g-dev libbz2-dev libreadline-dev \
        libsqlite3-dev wget curl llvm libncurses5-dev xz-utils tk-dev \
        libxml2-dev libxmlsec1-dev libffi-dev \
        ca-certificates
RUN apt-get clean
RUN rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*


RUN pyenv install 3.9.13

COPY . /


RUN chmod 755 /entrypoint.sh
ENTRYPOINT [ "/bin/bash" ]
CMD [ "/entrypoint.sh" ]
