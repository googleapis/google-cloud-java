#!/bin/bash

# Script to verify the presence of GraalVM docker test images tagged with the latest java-shared-config version.

set -o pipefail

# Output commands executed.
set -x

function fetch_image_names() {
  imageNames="$(grep "  - gcr.io/cloud-devrel-public-resources/" .cloudbuild/cloudbuild.yaml | cut -d "/" -f 3 | cut -d ":" -f 1)"
  export imageNames
  echo "$imageNames"
}

git config --global --add safe.directory /tmpfs/src/github/java-shared-config

# Get the directory of the build script
scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
# cd to the parent directory, i.e. the root of the git repo
cd ${scriptDir}/.. || exit

# Fetch the java-shared-config version in source of the current commit.
pushd java-shared-config
javaSharedConfigVersion="$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)"
popd

branchName=$(git name-rev "${KOKORO_GIT_COMMIT}" | sed 's/.* //')
gitCommitMessage=$(git log -1 "$(git rev-parse --short "${KOKORO_GIT_COMMIT}")" | grep "chore(main): release *")

# GraalVM docker images are not tagged with SNAPSHOT versions.
if [[ "${branchName}" == *"release-please--branches--main"* ]] && [[ ! $gitCommitMessage =~ "SNAPSHOT" ]]; then
  imageNames=$(fetch_image_names)
  for name in $imageNames; do
    fullContainerName="gcr.io/cloud-devrel-public-resources/${name}:${javaSharedConfigVersion}"
    echo "Verifying presence of ${fullContainerName}."
    gcloud container images describe "${fullContainerName}" > /dev/null; exit_status=$?
    if [[ $exit_status = 0 ]]; then
      echo "Success. Found $fullContainerName."
    else
      exit $exit_status
    fi
  done
else
  echo "Skipping check for non-release and SNAPSHOT update branches"
  exit 0
fi
