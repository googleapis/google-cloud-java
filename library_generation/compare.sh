#!/usr/bin/env bash

set -e

REPO_ROOT=$(pwd)/..
cd "${REPO_ROOT}"
if [ ! -d googleapis-gen ]; then
  git clone https://github.com/googleapis/googleapis-gen.git
fi

GOOGLEAPIS_GEN_ROOT=${REPO_ROOT}/googleapis-gen
cd "${GOOGLEAPIS_GEN_ROOT}"
git checkout fd245b5c29cad9db7e2bd65b15e875493d4d7c03

# exclude gradle files since we do not use them.
diff -r google/monitoring/v3/google-cloud-monitoring-v3-java/ ../library_gen_out/google/monitoring/v3/google-cloud-monitoring-v3-java -x "*gradle*"
