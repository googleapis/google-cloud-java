#!/bin/bash
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

set -eo pipefail

cd ${KOKORO_ARTIFACTS_DIR}/github/java-bigtable

# Disable buffering, so that the logs stream through.
export PYTHONUNBUFFERED=1

# Kokoro exposes this as a file, but the scripts expect just a plain variable.
export GITHUB_TOKEN=$(cat ${KOKORO_KEYSTORE_DIR}/73713_yoshi-automation-github-key)

# Setup git credentials
echo "https://${GITHUB_TOKEN}:@github.com" >> ~/.git-credentials
git config --global credential.helper 'store --file ~/.git-credentials'

python3.6 -m pip install git+https://github.com/googleapis/synthtool.git#egg=gcp-synthtool

set +e
python3.6 -m autosynth.synth \
    --repository=googleapis/java-bigtable \
    --synth-file-name=.github/readme/synth.py \
    --metadata-path=.github/readme/synth.metadata \
    --pr-title="chore: regenerate README" \
    --branch-suffix="readme"

# autosynth returns 28 to signal there are no changes
RETURN_CODE=$?
if [[ ${RETURN_CODE} -ne 0 && ${RETURN_CODE} -ne 28 ]]
then
    exit ${RETURN_CODE}
fi
