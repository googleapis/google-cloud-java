#!/bin/bash
# This script is used by Circle-CI to run integration tests for one client..
# This script is referenced in .circleci/config.yml.

set -e

MODULE=$1
ARGS=${@:2:99}

if [ -z $MODULE ]; then
    echo "First arg (module) not provided, so we're exiting."
    exit 1
fi

export GCLOUD_PROJECT="$GCLOUD_PROJECT"
export GOOGLE_APPLICATION_CREDENTIALS=$(realpath "$GOOGLE_APPLICATION_CREDENTIALS")

echo "----- installing modules -----"
mvn -B install -DskipTests

echo "----- running integration tests -----"
mvn -B -pl $MODULE -DtrimStackTrace=false -fae verify ${ARGS}
