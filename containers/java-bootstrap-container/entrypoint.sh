#!/bin/bash 
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
set -ex


MONO_REPO_NAME="google-cloud-java"
WORKSPACE_DIR="/workspace"

# workaround for local development (docker run -v
# path_to_monorepo:/workspace/google-cloud-java)
git config --global --add safe.directory /workspace/google-cloud-java

cd "$WORKSPACE_DIR/$MONO_REPO_NAME"
# looks like checking out a branch makes the changes to not be detected
# git checkout owlbot-bootstrapper-experiment

mkdir java-edgenetwork
cat > java-edgenetwork/owlbot.py <<- EOF
import synthtool as s
from synthtool.languages import java


for library in s.get_staging_dirs():
    # put any special-case replacements here
    s.move(library)

s.remove_staging_dirs()
java.common_templates(monorepo=True, )
EOF

cat > java-edgenetwork/.OwlBot.yaml <<- EOF
deep-remove-regex:
- "/java-edgenetwork/grpc-google-.*/src"
- "/java-edgenetwork/proto-google-.*/src"
- "/java-edgenetwork/google-.*/src"
- "/java-edgenetwork/samples/snippets/generated"

deep-preserve-regex:
- "/java-edgenetwork/google-.*/src/test/java/com/google/cloud/.*/v.*/it/IT.*Test.java"

deep-copy-regex:
- source: "/google/cloud/edgenetwork/(v.*)/.*-java/proto-google-.*/src"
  dest: "/owl-bot-staging/java-edgenetwork/\$1/proto-google-cloud-edgenetwork-\$1/src"
- source: "/google/cloud/edgenetwork/(v.*)/.*-java/grpc-google-.*/src"
  dest: "/owl-bot-staging/java-edgenetwork/\$1/grpc-google-cloud-edgenetwork-\$1/src"
- source: "/google/cloud/edgenetwork/(v.*)/.*-java/gapic-google-.*/src"
  dest: "/owl-bot-staging/java-edgenetwork/\$1/google-cloud-edgenetwork/src"
- source: "/google/cloud/edgenetwork/(v.*)/.*-java/samples/snippets/generated"
  dest: "/owl-bot-staging/java-edgenetwork/\$1/samples/snippets/generated"


api-name: edgenetwork
EOF

cat > java-edgenetwork/.repo-metadata.json <<- EOF
{
  "api_shortname": "edgenetwork",
  "name_pretty": "Distributed Cloud Edge Network API",
  "product_documentation": "https://cloud.google.com/distributed-cloud/edge/latest/docs/overview",
  "api_description": "Network management API for Distributed Cloud Edge.",
  "client_documentation": "https://cloud.google.com/java/docs/reference/google-cloud-edgenetwork/latest/overview",
  "release_level": "preview",
  "transport": "grpc",
  "language": "java",
  "repo": "googleapis/java-edgenetwork",
  "repo_short": "java-edgenetwork",
  "distribution_name": "com.google.cloud:google-cloud-edgenetwork",
  "api_id": "edgenetwork.googleapis.com",
  "library_type": "GAPIC_AUTO",
  "requires_billing": true
}
EOF

jq '. += {"owlbotYamlPath": "java-edgenetwork/.OwlBot.yaml"}' "${INTER_CONTAINER_VARS_PATH}" | sponge "${INTER_CONTAINER_VARS_PATH}"

