#!/bin/bash

set -ef

source .bazeliskrc
export BAZEL_VERSION=$USE_BAZEL_VERSION

echo "Installing Bazel ${BAZEL_VERSION}"
wget "https://github.com/bazelbuild/bazel/releases/download/${BAZEL_VERSION}/bazel-${BAZEL_VERSION}-installer-linux-x86_64.sh" \
    -O /tmp/bazel_install.sh && \
    bash /tmp/bazel_install.sh --user && \
    echo "Bazel installed" && \
    export PATH=$HOME/bin:$PATH && \
    bazel version

echo "Running Bazel for *-java targets"
bazel query 'filter("-java$", kind("rule", //...:*))' | xargs bazel build
echo "Finished Bazel build"
