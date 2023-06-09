#!/usr/bin/env bash

set -e
PROTO_PATH=$1
IS_CLOUD_SDK=$2
OUT_LAYER_FOLDER="${PROTO_PATH////-}-java"
if [ "${IS_CLOUD_SDK}" == true ]; then
  OUT_LAYER_FOLDER="${OUT_LAYER_FOLDER//google/google-cloud}"
fi

REPO_ROOT=$(pwd)/..
cd "${REPO_ROOT}"
if [ ! -d googleapis-gen ]; then
  git clone https://github.com/googleapis/googleapis-gen.git
fi

GOOGLEAPIS_GEN_ROOT=${REPO_ROOT}/googleapis-gen
cd "${GOOGLEAPIS_GEN_ROOT}"
git checkout fd245b5c29cad9db7e2bd65b15e875493d4d7c03

# exclude gradle files since we do not use them.
diff -r "${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/ ../library_gen_out/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}" -x "*gradle*"
