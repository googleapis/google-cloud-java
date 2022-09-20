#!/bin/bash

set -ef

pushd /workspace/googleapis
source .bazeliskrc
export BAZEL_VERSION=$USE_BAZEL_VERSION

echo "Installing Bazel ${BAZEL_VERSION}"
wget "https://github.com/bazelbuild/bazel/releases/download/${BAZEL_VERSION}/bazel-${BAZEL_VERSION}-installer-linux-x86_64.sh" \
    -O /tmp/bazel_install.sh && \
    bash /tmp/bazel_install.sh --user && \
    echo "Bazel installed" && \
    export PATH=$HOME/bin:$PATH && \
    bazel version

popd

pushd /workspace/synthtool

PROTOBUF_VERSION=3.16.0
echo "Installing Python protobuf package with version ${PROTOBUF_VERSION}"
echo "(because default invocation chooses the latest (3.21) which does notwork)"
python3 -m pip install --upgrade protobuf=="${PROTOBUF_VERSION}"


echo "Installing Python synthtool package with commit: $(git log --pretty=format:"%h%x09%an%x09%ad%x09%s")"
python3 -m pip install -e .
popd

export SYNTHTOOL_GOOGLEAPIS=/workspace/googleapis
export SYNTHTOOL_TEMPLATES=$HOME/synthtool/synthtool/gcp/templates

pushd /workspace/repo

python3 -m synthtool

popd
