#!/bin/bash

OWLBOT_VERSION=latest


# ROOT_DIR must have googleapis and google-cloud-java directories
ROOT_DIR=$HOME

set -ef

cd $ROOT_DIR/googleapis
# Build java GAPIC libraries
bazel query 'filter("-java$", kind("rule", //...:*))' | xargs bazel build

cd $ROOT_DIR/google-cloud-java

MODULE_LIST=`ls |grep java-`
TOTAL=`echo "${MODULE_LIST}" | wc -l`
INDEX=1
for MODULE in ${MODULE_LIST}; do
  echo
  echo "Processing $MODULE (${INDEX}/${TOTAL})"
  echo

  # Copy files from bazel-bin and saves to staging directory
  echo docker run --rm --user $(id -u):$(id -g) \
      -v $(pwd):/repo \
      -v ${ROOT_DIR}/googleapis/bazel-bin:/bazel-bin \
      gcr.io/cloud-devrel-public-resources/owlbot-cli:${OWLBOT_VERSION} copy-bazel-bin \
      --config-file=.github/.OwlBot.yaml \
      --source-dir /bazel-bin --dest /repo/${MODULE}

  # Extracts files from staging directory and post-process
  # the files via OwlBot. This includes templating, formatting, etc.
  echo docker run --rm --user $(id -u):$(id -g) \
      -v $(pwd)/${MODULE}:/workspace   -w /workspace \
      gcr.io/cloud-devrel-public-resources/owlbot-java

  INDEX=$((INDEX+1))
done



