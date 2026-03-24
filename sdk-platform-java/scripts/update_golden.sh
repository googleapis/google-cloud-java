#!/bin/sh

set -o errexit

API_NAME=$1
RAW_SRCJAR=$(find . -name '*_java_gapic_srcjar_raw.srcjar')

rm -rf srcjar_unpacked
mkdir srcjar_unpacked
cd srcjar_unpacked
UNPACK_DIR=$PWD
unzip -q -c "../${RAW_SRCJAR}" temp-codegen.srcjar | jar x

mkdir -p ${BUILD_WORKSPACE_DIRECTORY}/test/integration/goldens/${API_NAME}
cd ${BUILD_WORKSPACE_DIRECTORY}/test/integration/goldens/${API_NAME}

# clear out existing Java and JSON files.
find . -name '*.java' -delete
find . -name 'gapic_metadata.json' -delete
find . -name 'reflect-config.json' -delete

mkdir -p ./src
cp -r ${UNPACK_DIR}/src/main/resources/* ./src
cp -r ${UNPACK_DIR}/src/main/java/* ./src
cp -r ${UNPACK_DIR}/src/test/java/* ./src
[ -d ${UNPACK_DIR}/proto ] && cp -r ${UNPACK_DIR}/proto/src/main/java/* ./src

mkdir -p ./samples/snippets/generated
cp -r ${UNPACK_DIR}/samples/snippets/generated/**/* ./samples/snippets/generated

find . -name '.DS_Store' -delete
find . -name 'PlaceholderFile.java' -delete
find . -type d -empty -delete
