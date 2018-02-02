#!/usr/bin/env bash

# This script pulls in upstream updates from the veneer code generator and rebases your local
# changes on top.
#
# Specifically it:
# - fetches changes from googleapis for updated protos
# - fetches changes from toolkit for updates to the code generator
# - fetches api-client-staging to use as a staging area for the generated grpc stubs
# - fetches google-cloud-java to use as a staging area for the generated GAPIC client
#
# This is meant to be used conjunction with install-deps.sh to regenerate the underlying client with
# the latest upstream changes.

set -eE # same as: `set -o errexit -o errtrace`
handle_error() {
  echo "Failed, exiting"
  exit 1
}
trap 'handle_error' ERR

PROJECT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )/.." && pwd )"
WORKDIR="$PROJECT_DIR/deps"


DIRS=( googleapis toolkit api-client-staging )

for DIR in "${DIRS[@]}"; do
  echo ">>> Updating $DIR"
  DIR="$WORKDIR/$DIR"

  echo "Fetching upstream"
  git -C "$DIR" fetch origin

  echo "Dropping uncommitted local changes"
  git -C "$DIR" reset --hard HEAD
  git -C "$DIR" clean -f

  echo "Rebasing local changes"
  git -C "$DIR" rebase origin/master
done
