# Copyright 2020 Google LLC
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

FROM openjdk:8-jre-alpine

ARG GOOGLE_JAVA_FORMAT_VERSION=1.7

RUN mkdir -p /workspace
WORKDIR /workspace
ADD https://repo1.maven.org/maven2/com/google/googlejavaformat/google-java-format/${GOOGLE_JAVA_FORMAT_VERSION}/google-java-format-${GOOGLE_JAVA_FORMAT_VERSION}.jar /workspace/google-java-format.jar
ADD entrypoint.sh /workspace

ENTRYPOINT [ "/workspace/entrypoint.sh" ]