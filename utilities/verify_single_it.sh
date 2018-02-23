#!/bin/bash
# This script is used by Circle-CI to run integration tests for one client..
# This script is referenced in .circleci/config.yml.

set -e

MODULE=$1

if [ -z $MODULE ]; then
    echo "First arg (module) not provided, so we're exiting."
    exit 1
fi

export GCLOUD_PROJECT="$GCLOUD_PROJECT"
export GOOGLE_APPLICATION_CREDENTIALS=$(realpath "$GOOGLE_APPLICATION_CREDENTIALS")

echo "----- building and installing google-cloud-bom -----"
mvn -B -pl google-cloud-bom install -DskipTests

echo "----- building and installing parent pom -----"
mvn -B -N install -DskipTests

echo "----- building and installing shared modules -----"
# storage is present because google-cloud-bigquery and google-cloud-notification depend on it
# pubsub is present because google-cloud-notification depends on it
mvn -B -pl google-cloud-core,google-cloud-core-http,google-cloud-core-grpc,google-cloud-storage,google-cloud-pubsub install -DskipTests

echo "----- running integration tests -----"
mvn -B -pl $MODULE -DtrimStackTrace=false -fae verify
