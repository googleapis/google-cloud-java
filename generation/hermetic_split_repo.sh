#!/bin/bash

set -ef

# This script takes the following variables
if [ -z "$REPO" ]; then
  echo "Please set REPO. E.g., REPO=https://github.com/googleapis/java-spanner"
  exit 1
fi
if [ -z "$BRANCH" ]; then
  echo "Please set BRANCH. E.g., export BRANCH=6.4.4-sp"
  exit 1
fi

# The sha256 is the oldest one I found in gcr.io, built on Sep 8, 2021.
# This version did not reqiure api_shortname in .repo-metadata.json.
# This value will be overridden by .github/.OwlBot.lock.yaml below if the file
# is present.
export OWLBOT_JAVA_VERSION=sha256:74e6e91f946530fa28ca045bc33f37490122c1ca57630372d2d6ec9ff3758ebe

mkdir -p workspace
# Why not removing entire workspace? It's because it has bazel cache that makes
# the build faster.
rm -rf workspace/repo
rm -rf workspace/googleapis

echo "Cloning ${REPO}'s ${BRANCH} as workspace/repo"
git clone -- $REPO workspace/repo

pushd workspace/repo

git checkout -b "${BRANCH}_patch" "origin/${BRANCH}"

OWLBOT_YAML_NAME=.github/.OwlBot.yaml
echo "Checking ${OWLBOT_YAML_NAME}, which we use for owlbot-cli copy-bazel-bin."
if [ -r "${OWLBOT_YAML_NAME}" ]; then
  echo "${OWLBOT_YAML_NAME} exists in the repository."
else
  echo "${OWLBOT_YAML_NAME} is not found in the repository. Copying one from first appearance." 
  first_owlbot_yaml_commit=$(git log --oneline origin/main -- ${OWLBOT_YAML_NAME} |tail -1 |awk '{ print $1 }')
  git checkout $first_owlbot_yaml_commit -- ${OWLBOT_YAML_NAME}
  first_owlbot_py_commit=$(git log --oneline origin/main -- owlbot.py |tail -1 |awk '{ print $1 }')
  git checkout $first_owlbot_py_commit -- owlbot.py
  echo "Copied ${OWLBOT_YAML_NAME} (${first_owlbot_yaml_commit})"
  echo "  and owlbot.py (${first_owlbot_py_commit})"
fi

# Getting the last "Source-Link: " field for googleapis/googleapis repository
# from the commit log.
# e.g., "    Source-Link: https://github.com/googleapis/googleapis/commit/3b236df084cf9222c529a2890f90e3a4ff0f2dfd"
last_googleapis_commit_url=$(git log -1000 |grep 'Source-Link: https://github.com/googleapis/googleapis/commit' |head -1)
# e.g., "3b236df084cf9222c529a2890f90e3a4ff0f2dfd"
last_googleapis_commit=${last_googleapis_commit_url##*/}
popd

git clone --single-branch -- https://github.com/googleapis/googleapis workspace/googleapis

pushd workspace/googleapis

git fetch origin ${last_googleapis_commit}

last_googleapis_commit_short=${last_googleapis_commit:0:7}
git checkout -b "branch-from-${last_googleapis_commit_short}" ${last_googleapis_commit}
source .bazeliskrc
export BAZEL_VERSION=$USE_BAZEL_VERSION

# Searching for the line
#     urls = ["https://github.com/protocolbuffers/protobuf/archive/v3.15.3.tar.gz"],

protobuf_current_version=$(perl -nle 'print $1 if m|protocolbuffers/protobuf/archive/v(.+).tar.gz|' WORKSPACE)

popd


protobuf_target_version=$protobuf_current_version
curl "https://github.com/protocolbuffers/protobuf/archive/v${protobuf_target_version}.tar.gz" \
    --output workspace/protobuf.tar.gz


#echo "Installing Bazel ${BAZEL_VERSION}"
#wget "https://github.com/bazelbuild/bazel/releases/download/${BAZEL_VERSION}/bazel-${BAZEL_VERSION}-installer-linux-x86_64.sh" \
#    -O /tmp/bazel_install.sh && \
#    bash /tmp/bazel_install.sh --user && \
#    echo "Bazel installed" && \
#    export PATH=$HOME/bin:$PATH && \
#    bazel version

cp hermetic_bazel_command.sh workspace/

echo "Building workspace/googleapis by Bazel: $(bazel version)"

# Bazel requires USER environment variable
docker run --rm  --user "$(id -u):$(id -g)" --env HOME=/workspace --env USER=$(id -u -n) \
    -v $(pwd)/workspace:/workspace -w /workspace/googleapis \
    --entrypoint "/workspace/hermetic_bazel_command.sh" \
    -it gcr.io/repo-automation-bots/bazel-bot@sha256:bfdcd03c8ce2aec6e3663161a2c9ef5356594780c506011d35d62eecbd3b447e
# bazel query 'filter("-java$", kind("rule", //...:*))' | xargs bazel build


# Latest owlbot-cli seems working for old repository in 2021
OWLBOT_VERSION=latest
# Copy files from bazel-bin and saves to staging directory
# In a split repo, OwlBot.yaml is in this location
docker run --rm --user "$(id -u):$(id -g)" --env HOME=/workspace --env USER=$(id -u -n) \
    -v "$(pwd)/workspace:/workspace" \
    gcr.io/cloud-devrel-public-resources/owlbot-cli:${OWLBOT_VERSION} copy-bazel-bin \
    --config-file=.github/.OwlBot.yaml \
    --source-dir "/workspace/googleapis/bazel-bin" --dest "/workspace/repo"

if [ ! -d workspace/repo/owl-bot-staging ]; then
  echo "Could not generate owl-bot-staging via copy-bazel-bin."
  exit 1
fi

# Extracts files from staging directory and post-process
# the files via OwlBot. This includes templating, formatting, etc.
# The latest owlbot-java fails with processing old repository that did not have
# api_shortname field in .repo-metadata.json. The sha256 is the oldest one I found in gcr.io.
# This version did not reqiure api_shortname field in .repo-metadata.json.
OWLBOT_LOCK_FILE=workspace/repo/.github/.OwlBot.lock.yaml
if [ -r "$OWLBOT_LOCK_FILE" ]; then
  OWLBOT_JAVA_VERSION=$(grep 'digest:' "${OWLBOT_LOCK_FILE}"  |awk '{ print $2 }')
  echo "Found ${OWLBOT_LOCK_FILE} with ${OWLBOT_JAVA_VERSION} as owlbot-java version"
else
  echo "No ${OWLBOT_LOCK_FILE}"
fi
docker run --rm --user "$(id -u):$(id -g)" \
    -v "$(pwd)/workspace/repo:/workspace"   -w /workspace \
    "gcr.io/cloud-devrel-public-resources/owlbot-java@${OWLBOT_JAVA_VERSION}"

# Exclude irrelevant changes
pushd workspace/repo
git checkout "origin/${BRANCH}" -- samples README.md .github .kokoro java.header renovate.json \
    versions.txt ./**/*.xml
git add ./**/*.java

git commit -m 'fix: applying a different protobuf'
popd

echo "Changes are ready in workspace/repo. Create a pull request: "
echo "  cd workspace/repo && gh pr create --draft --base ${BRANCH} --title 'fix: applying a fix to old branch'"
