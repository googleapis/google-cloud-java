#!/usr/bin/env bash

set -e
PROTO_PATH=$1
IS_CLOUD_SDK=$2
OUT_LAYER_FOLDER="${PROTO_PATH////-}-java"
if [ "${IS_CLOUD_SDK}" == true ]; then
  OUT_LAYER_FOLDER="${OUT_LAYER_FOLDER//google/google-cloud}"
fi

GOLDEN_ROOT=$(dirname "$(readlink -f "$0")")/golden
LIBRARY_GEN_OUT="${GOLDEN_ROOT}"/../../library_gen_out

# exclude gradle files since we do not use them.
diff -r "${GOLDEN_ROOT}"/"${OUT_LAYER_FOLDER}"/ "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}" -x "*gradle*"
