#!/bin/bash

# This script takes the following variables
export REPO=https://github.com/googleapis/java-spanner
export BRANCH=6.4.4-sp

# The sha256 is the oldest one I found in gcr.io. This version did not reqiure
# api_shortname in .repo-metadata.json.
export OWLBOT_JAVA_VERSION=@sha256:74e6e91f946530fa28ca045bc33f37490122c1ca57630372d2d6ec9ff3758ebe

rm -rf workspace
mkdir -p workspace

if /usr/bin/python3 -V |grep 'Python 3.8' ; then
  echo '/usr/bin/python3 points to Python3.8. Good'
else
  echo 'Please prepare /usr/bin/python3 to point to Python 3.8 for googleapis build'
  echo "Current python version: $(/usr/bin/python3 -V)"
  exit 1
fi



echo "Cloning ${REPO}'s ${BRANCH} as workspace/repo"
git clone -- $REPO workspace/repo

pushd workspace/repo

git checkout -b "${BRANCH}_patch" "origin/${BRANCH}"

echo "Checking .github/.OwlBot.yaml, which we use for owlbot-cli copy-bazel-bin."
if [ -r .github/.OwlBot.yaml ]; then
  echo ".github/.OwlBot.yaml exists in the repository."
else
  echo ".github/.OwlBot.yaml is not found in the repository. Copying one from origin/main." 
  git checkout origin/main -- .github/.OwlBot.yaml
  git checkout origin/main -- owlbot.py
  echo "Copied .github/.OwlBot.yaml and owlbot.py"
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
ls -alt .bazeliskrc
source .bazeliskrc
export BAZEL_VERSION=$USE_BAZEL_VERSION

# Searching for the line
#     urls = ["https://github.com/protocolbuffers/protobuf/archive/v3.15.3.tar.gz"],

protobuf_current_version=$(perl -nle 'print $1 if m|protocolbuffers/protobuf/archive/v(.+).tar.gz|' WORKSPACE)

popd


protobuf_target_version=$protobuf_current_version
curl "https://github.com/protocolbuffers/protobuf/archive/v${protobuf_target_version}.tar.gz" \
    --output workspace/protobuf.tar.gz


echo "Installing Bazel ${BAZEL_VERSION}"
wget "https://github.com/bazelbuild/bazel/releases/download/${BAZEL_VERSION}/bazel-${BAZEL_VERSION}-installer-linux-x86_64.sh" \
    -O workspace/bazel_install.sh && \
    bash workspace/bazel_install.sh --user && \
    echo "Bazel installed" && \
    bazel version

pushd workspace/googleapis
echo "Building workspace/googleapis by Bazel: $(bazel version)"
bazel query 'filter("-java$", kind("rule", //...:*))' | xargs bazel build

popd

OWLBOT_VERSION=latest
# Copy files from bazel-bin and saves to staging directory
# In a split repo, OwlBot.yaml is in this location
docker run --rm --user "$(id -u):$(id -g)" \
    -v "$(pwd)/workspace/repo:/repo" \
    -v "$(pwd)/workspace/googleapis/bazel-bin:/bazel-bin" \
    gcr.io/cloud-devrel-public-resources/owlbot-cli:${OWLBOT_VERSION} copy-bazel-bin \
    --config-file=.github/.OwlBot.yaml \
    --source-dir /bazel-bin --dest "/repo"

if [ ! -d workspace/repo/owl-bot-staging ]; then
  echo "Could not generate owl-bot-staging via copy-bazel-bin."
  exit 1
fi

# Extracts files from staging directory and post-process
# the files via OwlBot. This includes templating, formatting, etc.
# The sha256 is the oldest one I found in gcr.io. This version did not reqiure
# api_shortname in .repo-metadata.json.
docker run --rm --user "$(id -u):$(id -g)" \
    -v "$(pwd)/workspace/repo:/workspace"   -w /workspace \
    gcr.io/cloud-devrel-public-resources/owlbot-java:${OWLBOT_JAVA_VERSION}

# Exclude irrelevant changes
git checkout -- samples README.md .github .kokoro java.header renovate.json \
    versions.txt
git add ./**/*.java

git commit -m 'fix: applying a different protobuf'

echo "Create a pull request: "
echo "  cd workspace/repo && gh pr create --draft --base ${BRANCH} --title 'fix: applying a fix to old branch'"
