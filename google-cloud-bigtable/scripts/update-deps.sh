#!/usr/bin/env bash
#
# Copyright 2018 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# This script pulls in upstream updates from the veneer code generator and rebases your local
# changes on top.
#
# Specifically it:
# - fetches changes from googleapis for updated protos
# - fetches changes from toolkit for updates to the code generator
# - fetches api-client-staging to use as a staging area for the generated grpc stubs
#
# This is meant to be used conjunction with update-deps.sh to regenerate the underlying client with
# the latest upstream changes.

set -o errexit -o errtrace

handle_error() {
  echo "Failed, exiting. See deps/output.log for more details"
  exit 1
}
trap 'handle_error' ERR

PROJECT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )/.." && pwd )"
WORKDIR="$PROJECT_DIR/deps"
LOG="$WORKDIR/output.log"

DIRS=( googleapis toolkit api-client-staging )

DOCKER_IMAGE=googleapis/artman:stable

function run {
  init
  update
}

# Make sure all of the dependencies are checked out
function init() {
  mkdir -p "$WORKDIR"
  echo "" > $WORKDIR/output.log

  log "Pulling docker image"
  docker pull "$DOCKER_IMAGE" >>$LOG 2>&1

  if [ ! -d "$WORKDIR/googleapis" ]; then
    log "Fetching googleapis"
    git clone "https://github.com/googleapis/googleapis.git" "$WORKDIR/googleapis" >>$LOG 2>&1
  fi

  if [ ! -d "$WORKDIR/toolkit" ]; then
    log "Fetching toolkit"
    git clone "https://github.com/googleapis/toolkit.git" "$WORKDIR/toolkit" >>$LOG 2>&1
  fi

  if [ ! -d "$WORKDIR/api-client-staging" ]; then
    log "Fetching api-client-staging"
    git clone "https://github.com/googleapis/api-client-staging.git" "$WORKDIR/api-client-staging" >>$LOG 2>&1
  fi
}

function update() {
  for DIR in "${DIRS[@]}"; do
    log "Updating $DIR"
    DIR="$WORKDIR/$DIR"

    log "Fetching upstream"
    git -C "$DIR" fetch origin >>$LOG 2>&1

    log "Dropping uncommitted local changes"
    git -C "$DIR" reset --hard HEAD >>$LOG 2>&1
    git -C "$DIR" clean -f >>$LOG 2>&1

    log "Rebasing local changes"
    git -C "$DIR" rebase origin/master >>$LOG 2>&1
  done
}

function log {
  echo ">>>>>>> $@"
  echo ">>>>>>> $@" >> $LOG
}

run
