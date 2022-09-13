#!/bin/bash

# This script takes the following variables
export REPO=https://github.com/googleapis/java-spanner
export BRANCH=6.4.4-sp


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
git clone --branch $BRANCH --single-branch -- $REPO workspace/repo

pushd workspace/repo
# Getting the last "Source-Link: " field for googleapis/googleapis repository
# from the commit log.
# e.g., "    Source-Link: https://github.com/googleapis/googleapis/commit/3b236df084cf9222c529a2890f90e3a4ff0f2dfd"
last_googleapis_commit_url=$(git log -1000 |grep 'Source-Link: https://github.com/googleapis/googleapis/commit' |head -1)
# e.g., "3b236df084cf9222c529a2890f90e3a4ff0f2dfd"
last_googleapis_commit=${last_googleapis_commit_url##*/}
popd

git clone  --single-branch -- https://github.com/googleapis/googleapis workspace/googleapis

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


echo "Exiting this for now"
exit 1


# This script takes 2 commit hash of googleapis/googleapis repository.
# The 1st commit is the last commit that has already been applied
# to google-cloud-java monorepo.
# The 2nd commit is the commit you want to apply to google-cloud-java
# monorepo (usually "origin/master").
# This script creates Git commits to this google-cloud-java monorepo that
# correspond to the googleapis commits in between the two commits.

# The following environment variables are needed (values below are examples):
# export GOOGLE_CLOUD_JAVA_DIR=$HOME/google-cloud-java-subject
# export GOOGLEAPIS_DIR=$HOME/googleapis
# export GOOGLEAPIS_COMMIT_FILE=googleapis_commit.txt

set -ef

start_commit=$1
end_commit=$2

if [ -z "$end_commit" ]; then
  echo "Please provide 2 commit hashes"
  exit 1
fi

if [ -z "$GOOGLEAPIS_DIR" ]; then
  export GOOGLEAPIS_DIR=$HOME/googleapis
fi

if [ -z "$GOOGLE_CLOUD_JAVA_DIR" ]; then
  echo 'Please specify GOOGLE_CLOUD_JAVA_DIR environment variable'
  echo "When developing this script, it's a good practice to clone"
  echo "github.com/googleapis/google-cloud-java"
  echo "as 'google-cloud-java-subject' and specify it as:"
  # shellcheck disable=SC2016
  echo 'export GOOGLE_CLOUD_JAVA_DIR=$HOME/google-cloud-java-subject'
  exit 1
fi

if [ ! -d "$GOOGLE_CLOUD_JAVA_DIR" ]; then
  echo "$GOOGLE_CLOUD_JAVA_DIR is not a directory"
  exit 1
fi

if [ -z "${GOOGLEAPIS_COMMIT_FILE}" ]; then
  echo "GOOGLEAPIS_COMMIT_FILE is not set"
  exit 1
fi

echo "Operating in ${GOOGLE_CLOUD_JAVA_DIR}"

cd "$GOOGLE_CLOUD_JAVA_DIR"

OWLBOT_VERSION=latest

if [ ! -d "$GOOGLEAPIS_DIR" ]; then
  echo "GOOGLEAPIS_DIR: $GOOGLEAPIS_DIR does not exist"
  exit 1
fi

pushd "$GOOGLEAPIS_DIR"

git checkout master
git pull

commit_range="${start_commit}..${end_commit}"

googleapis_commits=$(git log --format=%H "$commit_range" |tac)

if [ -z "${googleapis_commits}" ]; then
  echo "Ensure the commit exists in ${GOOGLEAPIS_DIR}"
  exit 1
fi

commit_message_dir=$(mktemp -d -t commit-messages-XXXXX)
for googleapis_commit in ${googleapis_commits}; do
  echo "$(date): writing commit log: ${googleapis_commit}"
  commit_message_file="${commit_message_dir}/${googleapis_commit}.message.txt"
  git log -1 --format=%B "${googleapis_commit}" > "${commit_message_file}"
  echo >> "$commit_message_file"
  echo "Source-Link: https://github.com/googleapis/googleapis/commit/${googleapis_commit}" >> $commit_message_file
  echo "$(date): wrote ${commit_message_file}"
done

popd

module_list=$(ls |grep java-)
total=$(echo "${module_list}" | wc -l)

function generate_gapic_libraries() {
  local googleapis_commit=$1
  pushd "$GOOGLEAPIS_DIR"
  git checkout "$googleapis_commit"

  # This may take few minutes
  bazel query $BAZEL_FLAGS  'filter("-java$", kind("rule", //...:*))' | xargs bazel build

  popd

  index=1
  for module in ${module_list}; do
    echo
    echo "$(date): Processing $module (${index}/${total})"
    echo

    # Copy files from bazel-bin and saves to staging directory
    docker run --rm --user "$(id -u):$(id -g)" \
        -v "$(pwd):/repo" \
        -v "${GOOGLEAPIS_DIR}/bazel-bin:/bazel-bin" \
        gcr.io/cloud-devrel-public-resources/owlbot-cli:${OWLBOT_VERSION} copy-bazel-bin \
        --config-file=.github/.OwlBot.yaml \
        --source-dir /bazel-bin --dest "/repo/${module}"

    # Extracts files from staging directory and post-process
    # the files via OwlBot. This includes templating, formatting, etc.
    docker run --rm --user "$(id -u):$(id -g)" \
        -v "$(pwd)/${module}:/workspace"   -w /workspace \
        gcr.io/cloud-devrel-public-resources/owlbot-java

    index=$((index+1))
  done
}

commit_count=0
# The list is sorted: the oldest comes first
for googleapis_commit in ${googleapis_commits}; do
  echo "$(date): Generating GAPIC Java libraries (${commit_count}): $googleapis_commit"
  generate_gapic_libraries "$googleapis_commit"
  commit_message_file="${commit_message_dir}/${googleapis_commit}.message.txt"

  # Record the last commit this script run with
  echo -n "${googleapis_commit}" > "${GOOGLEAPIS_COMMIT_FILE}"
  git add --all
  git commit --file="${commit_message_file}" --allow-empty
  commit_count=$((commit_count + 1))
done

echo "$(date): Successfully added ${commit_count} commits from googleapis (${GOOGLEAPIS_DIR}) to ${GOOGLE_CLOUD_JAVA_DIR}"
