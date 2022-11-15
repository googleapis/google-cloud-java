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
  if [ -z "${group_id}" ] || [ -z "${group_id}" ] || [ -z "${artifact_id}" ]; then
    echo "Couldn't parse the pom file: $pom_file"
    exit 1
  fi
  echo -n "Checking ${group_id}:${artifact_id}:${version}:"
  if [[ "${version}" == *SNAPSHOT* ]] && [ "${artifact_id}" != "google-cloud-java" ]; then
    echo " Release Please pull request contains SNAPSHOT version. Please investigate."
    return_code=1
  fi
  local group_id_dir="${group_id//\.//}"
  local URL="${MAVEN_SITE}/${group_id_dir}/${artifact_id}/${version}/${artifact_id}-${version}.pom"
  local status_code=$(curl --silent --head -o /dev/null -w "%{http_code}" $URL)
  if [ "${status_code}" == "404" ]; then
    echo " The version does not exists. Good"
  else
    echo " The version already exists at ${URL}. Please investigate."
    return_code=1
  fi

}

return_code=0

for pom_file in $(find . -maxdepth 3 -name pom.xml|sort --dictionary-order); do
  find_existing_version_pom "${pom_file}"
done

exit ${return_code}
