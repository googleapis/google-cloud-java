#!/bin/bash

set -e

violations=0
for pomFile in $(find . -mindepth 2 -name pom.xml | sort ); do
  # Filter out exempt modules and directories using native Bash pattern matching.
  # Shell glob patterns (*pattern*) evaluate directly in-memory without invoking
  # an external regex engine.
  case "${pomFile}" in
    *google-cloud-jar-parent* | \
    *google-cloud-pom-parent* | \
    *CoverageAggregator* | \
    *java-shared-dependencies* | \
    *java-bigquerystorage* | \
    *java-datastore* | \
    *java-logging-logback* | \
    *java-bigquery* | \
    *sdk-platform-java* | \
    *java-common-protos* | \
    *java-showcase* | \
    *java-iam* | \
    *java-spanner* | \
    *java-spanner-jdbc* | \
    *google-auth-library-java* | \
    *grpc-gcp* | \
    *java-storage* | \
    *java-storage-nio* | \
    *java-pubsub* | \
    *java-bigtable* | \
    *java-firestore* | \
    *java-cloud-bom* | \
    *java-shared-config* | \
    *java-vertexai* | \
    *java-compute* | \
    *.github* | \
    *owl-bot-postprocessor*)
      continue
      ;;
    *java-samples*)
      echo "Skipping version check for java-samples directory"
      continue
      ;;
    */samples/*)
      echo "Skipping version check for samples directory"
      continue
      ;;
  esac

  if grep -n '<version>.*</version>' "$pomFile" | grep -v 'x-version-update'; then
    echo "Found version declaration(s) without x-version-update in: $pomFile"
    violations=$((violations + 1))
    echo "---------------------------------------------------------"
  fi
done

echo "FOUND $violations VIOLATIONS!"

if [[ $violations -gt 0 ]]; then
  exit 1
fi