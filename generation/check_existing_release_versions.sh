#!/bin/bash

# Using Google Mirror to avoid unnecessary load to https://repo1.maven.org/maven2
MAVEN_SITE=https://maven-central.storage-download.googleapis.com/maven2

set -e

# Helper function to extract the content of the first matching XML tag from a file,
# ignoring <parent> blocks so parent coordinates are not accidentally matched.
function extract_xml_tag() {
  local tag=$1
  local file=$2
  [[ ! -f "${file}" ]] && return 0
  sed -n "/<parent>/,/<\/parent>/d; \|<${tag}[ >]|{s|.*<${tag}[^>]*>[[:space:]]*\([^<[:space:]]*\).*|\1|p; q;}" "${file}"
}

function find_existing_version_pom() {  
  local pom_file=$1
  if [ -z "${pom_file}" ]; then
    echo "Empty pom file name"
    exit 1
  fi
  local group_id=$(extract_xml_tag groupId "${pom_file}")
  local artifact_id=$(extract_xml_tag artifactId "${pom_file}")
  local version=$(extract_xml_tag version "${pom_file}")
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
  local status_code=$(curl --silent --head -o /dev/null -w "%{http_code}" "${URL}")
  if [ "${status_code}" == "200" ]; then
    echo " The version already exists at ${URL}. Please investigate."
    return_code=1
  else
    echo " The version does not exist (status_code ${status_code} for ${URL}). Good."
  fi
}

return_code=0

while IFS= read -r pom_file; do
  [[ -z "${pom_file}" ]] && continue
  # Exclude java-vertexai because it has been archived and replaced with a dummy POM.
  # We do not plan to release any new versions for it, so we don't want to check if its
  # version (which already exists) is a duplicate.
  case "${pom_file}" in
    *samples* | *showcase* | *coverage-report* | *sdk-platform-java/pom.xml | \
    *java-vertexai* | *storage-shared-benchmarking* | *java-bigtable/test-proxy*)
      continue
      ;;
    */java-shared-config/pom.xml)
      [[ "${pom_file}" != */java-shared-config/*/pom.xml ]] && continue
      ;;
  esac
  find_existing_version_pom "${pom_file}"
done < <(find . -maxdepth 3 -name pom.xml | sort --dictionary-order)

exit ${return_code}
