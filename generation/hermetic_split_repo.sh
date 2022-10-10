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

if [ -z "${PROTOBUF_VERSION}" ]; then
  echo "Please set PROTOBUF_VERSION. E.g., export PROTOBUF_VERSION=3.16.1"
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
rm -rf workspace/synthtool
rm -rf workspace/.cache/synthtool

echo "Cloning ${REPO}'s ${BRANCH} as workspace/repo"
git clone -- $REPO workspace/repo

pushd workspace/repo

git checkout -B "${BRANCH}_patch" "origin/${BRANCH}"

OWLBOT_YAML_NAME=.github/.OwlBot.yaml
echo "Checking ${OWLBOT_YAML_NAME}, which we use for owlbot-cli copy-bazel-bin."
if [ -r "${OWLBOT_YAML_NAME}" ]; then
  echo "${OWLBOT_YAML_NAME} exists in the repository."
  use_synthtool=false
else
  echo "${OWLBOT_YAML_NAME} is not found in the repository. Going to use Synthtool."
  use_synthtool=true
fi

googleapis_commits=$(git log -1000 |grep 'Source-Link: https://github.com/googleapis/googleapis/commit' |perl -nle 'print $1 if m|commit/(.+)|')
if [ -z "${googleapis_commits}" ]; then
  echo "No history of googleapis commit in commit history"
  echo "Maybe the library is purely hand-written Java code and no need to regenerate with protoc"
  exit 1
fi
synthtool_commits=$(git log -1000 |grep 'Source-Link: https://github.com/googleapis/synthtool/commit' |perl -nle 'print $1 if m|commit/(.+)|')

popd

if [ ! -d workspace/googleapis ]; then
  git clone -- https://github.com/googleapis/googleapis workspace/googleapis
fi

pushd workspace/googleapis

git reset --hard HEAD

# Sort the commits by the date. Choose the latest one.
last_googleapis_commit=$(for C in $googleapis_commits; do
  git --no-pager log -1 --format='%H %at %ai' $C
done |sort -k 2 -r |head -1 |cut -d ' ' -f1)

echo "The last googleapis commit on the branch ${BRANCH} was:"
git log --pretty=format:"%h%x09%an%x09%ad%x09%s" -1 $last_googleapis_commit
echo "Checking out this commit from googleapis/googleapis repository:"

last_googleapis_commit_short=${last_googleapis_commit:0:7}
git checkout -B "branch-from-${last_googleapis_commit_short}" ${last_googleapis_commit}

# Searching for the line
#     urls = ["https://github.com/protocolbuffers/protobuf/archive/v3.15.3.tar.gz"],

protobuf_current_version=$(perl -nle 'print $1 if m|protocolbuffers/protobuf/archive/v(.+).(zip\|tar\.gz)|' WORKSPACE)
echo "Overriding WORKSPACE to use Protobuf ${PROTOBUF_VERSION} from ${protobuf_current_version} (original in WORKSPACE)"

# WORKSPACE file has the following section to declare Protobuf version.
# sha256 field is optional.
#
# http_archive(
#    name = "com_google_protobuf",
#    sha256 = "b10bf4e2d1a7586f54e64a5d9e7837e5188fc75ae69e36f215eb01def4f9721b",
#    strip_prefix = "protobuf-3.15.3",
#    urls = ["https://github.com/protocolbuffers/protobuf/archive/v3.15.3.tar.gz"],
#)
sed -i.bak -e "/com_google_protobuf/{N;s|sha256 = .*||;N;s|\"protobuf-.*\"|\"protobuf-${PROTOBUF_VERSION}\"|;N;s|/v.*\"|/v${PROTOBUF_VERSION}\.tar\.gz\"|}" WORKSPACE
rm WORKSPACE.bak

if grep PROTOBUF_MAVEN_ARTIFACTS WORKSPACE > /dev/null ; then
  echo "WORKSPACE file has maven_install section defined already."
else
  echo "WORKSPACE file does not have maven_install section. Adding it."
  sed -i $'/_gax_java_version =/{e cat ../../hermetic_maven_install_protobuf_section.txt\n}' WORKSPACE
fi

if ! grep $PROTOBUF_VERSION WORKSPACE; then
  echo "Could not update Protobuf version section. Please check regular expression in script above."
  exit 1
fi

popd

function regenerate_with_owlbot() {
  cp hermetic_bazel_command.sh workspace/

  echo "Building workspace/googleapis"

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
}

function regenerate_with_synthtool() {
  cp hermetic_synthtool_command.sh workspace/

  echo "Preparing an old synthtool revision"

  git clone https://github.com/googleapis/synthtool workspace/synthtool

  pushd workspace/synthtool

  # Sort the commits by the date. Choose the last one.
  last_synthtool_commit=$(for C in $synthtool_commits; do
    git --no-pager log -1 --format='%H %at %ai' $C
  done |sort -k 2 -r |head -1 |cut -d ' ' -f1)
  echo "The last synthtool commit on the branch ${BRANCH} was:"
  git log --pretty=format:"%h%x09%an%x09%ad%x09%s" -1 $last_synthtool_commit
  echo "Checking out this commit from googleapis/synthtool repository:"
  last_synthtool_commit_short=${last_synthtool_commit:0:7}
  git checkout -B "branch-from-${last_synthtool_commit_short}" ${last_synthtool_commit_short}
  popd

  docker run --rm  --user "$(id -u):$(id -g)" --env HOME=/workspace \
      --env USER=$(id -u -n) -v $(pwd)/workspace:/workspace \
      -w /workspace/repo \
      --entrypoint "/workspace/hermetic_synthtool_command.sh" \
      -it gcr.io/repo-automation-bots/bazel-bot@sha256:bfdcd03c8ce2aec6e3663161a2c9ef5356594780c506011d35d62eecbd3b447e
}

if [ "true" = "${use_synthtool}" ]; then
  regenerate_with_synthtool
else
  regenerate_with_owlbot
fi

# Exclude irrelevant changes
pushd workspace/repo
git checkout "origin/${BRANCH}" -- README.md .github .kokoro java.header renovate.json \
    versions.txt ./**/*.xml
# java-commons-protos doesn't have samples
if [ -d samples ]; then
  git checkout "origin/${BRANCH}" -- samples
fi

git add ./**/*.java

# It's possible that there's no code change.
git commit -m 'fix: applying a different code generation' --allow-empty
popd

echo "Changes are ready in workspace/repo. Create a pull request: "
echo "  cd workspace/repo && gh pr create --base ${BRANCH} \
    --title 'deps: regenerating with new Protobuf'" \
    --body "This PR was generated by Protobuf ${PROTOBUF_VERSION}. Source-Link: https://github.com/googleapis/googleapis/commit/${last_googleapis_commit}"

