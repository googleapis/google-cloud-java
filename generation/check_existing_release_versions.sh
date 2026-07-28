#!/bin/bash

# Using Google Mirror to avoid unnecessary load to https://repo1.maven.org/maven2
MAVEN_SITE=https://maven-central.storage-download.googleapis.com/maven2

set -e

function find_existing_version_pom() {  
  local pom_file=$1
  if [ -z "${pom_file}" ]; then
    echo "Empty pom file name"
    exit 1
  fi
  local group_id=$(xmllint --xpath '/*[local-name()="project"]/*[local-name()="groupId"]/text()' \
      "${pom_file}")
  local artifact_id=$(xmllint --xpath '/*[local-name()="project"]/*[local-name()="artifactId"]/text()' \
      "${pom_file}")
  local version=$(xmllint --xpath '/*[local-name()="project"]/*[local-name()="version"]/text()' \
      "${pom_file}")
  echo -n "Checking ${group_id}:${artifact_id}:${version}:"
  if [ -z "${artifact_id}" ]; then
    echo "Couldn't parse artifact_id in the pom file: $pom_file"
    exit 1
  fi
  if [ -z "${group_id}" ] || [ -z "${version}" ]; then
    echo "Skipping file without explicit coordinates (likely inherits): $pom_file"
    return 0
  fi
  if [[ "${version}" == *SNAPSHOT* ]] && [ "${artifact_id}" != "google-cloud-java" ]; then
    echo " Release Please pull request contains SNAPSHOT version. Please investigate."
    return_code=1
  fi
  local group_id_dir="${group_id//\.//}"
  local URL="${MAVEN_SITE}/${group_id_dir}/${artifact_id}/${version}/${artifact_id}-${version}.pom"
  local status_code=$(curl --silent --head -o /dev/null -w "%{http_code}" $URL)
  if [ "${status_code}" == "200" ]; then
    echo " The version already exists at ${URL}. Please investigate."
    return_code=1
  else
    echo " The version does not exists (status_code ${status_code} for ${URL}). Good."
  fi
}

return_code=0

for pom_file in $(find . -maxdepth 3 -name pom.xml|sort --dictionary-order); do
  # Exclude java-vertexai because it has been archived and replaced with a dummy POM.
  # We do not plan to release any new versions for it, so we don't want to check if its
  # version (which already exists) is a duplicate.
  if [[ "${pom_file}" == *samples* || "${pom_file}" == *showcase* || "${pom_file}" == *coverage-report* || "${pom_file}" == *sdk-platform-java/pom.xml || "${pom_file}" == *java-vertexai* || "${pom_file}" == *storage-shared-benchmarking* || "${pom_file}" == *java-bigtable/test-proxy* || ( "${pom_file}" == */java-shared-config/pom.xml && "${pom_file}" != */java-shared-config/*/pom.xml ) ]]; then
      continue
  fi
  find_existing_version_pom "${pom_file}"
done

exit ${return_code}
