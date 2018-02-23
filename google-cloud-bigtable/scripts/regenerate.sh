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

# This script is used to regenerate protos & GAPIC stubs.
# It stages all of the generated code in deps/ and then installs it into the local maven repo.
# It is meant to be used to test changes to the gapic config before publishing
# To pull in upstream changes, please use update-deps.sh

set -o errexit -o errtrace

handle_error() {
  echo "Failed, exiting. See deps/output.log for more details"
  exit 1
}
trap 'handle_error' ERR


PROJECT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )/.." && pwd )"
WORKDIR="$PROJECT_DIR/deps"
LOG="$WORKDIR/output.log"

DOCKER_IMAGE=googleapis/artman:stable
TOOLKIT="$WORKDIR/toolkit"

function run {
  run_artman
  copy_api_client_staging
  copy_google_cloud_java
  install_protos

  echo "Successfully completed!"
}

function run_artman {
  rm -rf artman-genfiles/*

  run_gapic "google/bigtable/artman_bigtable.yaml"
  run_gapic "google/bigtable/admin/artman_bigtableadmin.yaml"
}

function run_gapic {
  CONFIG="$1"

  log "Running gapic for $CONFIG"

  INNER_CMD="artman --local \
    --config /googleapis/$CONFIG \
    --root-dir /googleapis \
    --output /tmp/artman-genfiles \
    generate java_gapic"

  DOCKER_CMD="docker run --name igor-artman --rm -it \
    -e RUNNING_IN_ARTMAN_DOCKER=True \
    -e HOST_USER_ID=$UID -e HOST_GROUP_ID=`id -g` \
    -v $WORKDIR/googleapis:/googleapis \
    -v $WORKDIR/artman-genfiles:/tmp/artman-genfiles"

  if [ -n "$TOOLKIT" ]; then
    DOCKER_CMD="$DOCKER_CMD -v $WORKDIR/toolkit:/toolkit"
  fi

  FULL_CMD="$DOCKER_CMD $DOCKER_IMAGE $INNER_CMD"
  log "$FULL_CMD"
  $FULL_CMD >>$LOG 2>&1
}

function copy_api_client_staging {
  log "Copying files to api-client-staging"

  rm -rf \
    "$WORKDIR/api-client-staging/generated/java/proto-google-cloud-bigtable-v2" \
    "$WORKDIR/api-client-staging/generated/java/proto-google-cloud-bigtable-admin-v2" \
    "$WORKDIR/api-client-staging/generated/java/grpc-google-cloud-bigtable-v2" \
    "$WORKDIR/api-client-staging/generated/java/grpc-google-cloud-bigtable-admin-v2" \
    "$WORKDIR/api-client-staging/generated/java/gapic-google-cloud-bigtable-v2" \
    "$WORKDIR/api-client-staging/generated/java/gapic-google-cloud-bigtable-admin-v2"

  cp -r \
    "$WORKDIR/artman-genfiles/java/grpc-google-cloud-bigtable-v2" \
    "$WORKDIR/artman-genfiles/java/grpc-google-cloud-bigtable-admin-v2" \
    "$WORKDIR/artman-genfiles/java/proto-google-cloud-bigtable-v2" \
    "$WORKDIR/artman-genfiles/java/proto-google-cloud-bigtable-admin-v2" \
    "$WORKDIR/artman-genfiles/java/gapic-google-cloud-bigtable-v2" \
    "$WORKDIR/artman-genfiles/java/gapic-google-cloud-bigtable-admin-v2" \
    "$WORKDIR/api-client-staging/generated/java/"
}

function copy_google_cloud_java {
  log "Copying google-cloud-java"

  # Delete old files
  xargs rm -f < autogen_files.lst
  cat /dev/null > autogen_files.lst

  # Update manual files
  find src -type f > $PROJECT_DIR/handwritten_files.lst

  # Generate a list of new files
  # Data
  pushd "$WORKDIR/artman-genfiles/java/gapic-google-cloud-bigtable-v2"
  find src -type f >> $PROJECT_DIR/autogen_files.lst
  cp -r "src" "$PROJECT_DIR"
  popd
  # Admin
  pushd "$WORKDIR/artman-genfiles/java/gapic-google-cloud-bigtable-admin-v2"
  find src -type f >> $PROJECT_DIR/autogen_files.lst
  cp -r "src" "$PROJECT_DIR"
  popd
}

function install_protos {
  log "Installing protos from api-client-staging"

  pushd "$WORKDIR/api-client-staging/generated/java" > /dev/null
  ./gradlew \
    :proto-google-cloud-bigtable-v2:install \
    :grpc-google-cloud-bigtable-v2:install \
    :proto-google-cloud-bigtable-admin-v2:install \
    :grpc-google-cloud-bigtable-admin-v2:install \
    -x javadoc \
    >>$LOG 2>&1

  popd > /dev/null
}

function log {
  echo ">>>>>>> $@"
  echo ">>>>>>> $@" >> $LOG
}

run
