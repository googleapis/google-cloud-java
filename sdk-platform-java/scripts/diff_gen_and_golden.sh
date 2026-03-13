#!/bin/sh

set -o errexit

API_NAME=$1
RAW_SRCJAR=$( find . -name '*_java_gapic_srcjar_raw.srcjar' )

mkdir unpacked src
cd unpacked
unzip -q -c "../${RAW_SRCJAR}" temp-codegen.srcjar | jar x

mkdir -p ../samples/snippets/generated/
cp -r samples/snippets/generated/**/* ../samples/snippets/generated

cp -r src/main/resources/* ../src
cp -r src/main/java/* ../src
cp -r src/test/java/* ../src
[ -d proto ] && cp -r proto/src/main/java/* ../src
cd ..

# Remove unneeded non-Java files, like MANIFEST
find src -type f ! -name '*.java' -a ! -name '*gapic_metadata.json' -a ! -name '*reflect-config.json' -delete
find src -type f -name 'PlaceholderFile.java' -delete
find src -type d -empty -delete
# This will not print diff_output to the console unless `--test_output=all` option
# is enabled, it only emits the comparison results to the test.log.
diff -ru test/integration/goldens/${API_NAME}/src src
diff -ru test/integration/goldens/${API_NAME}/samples samples