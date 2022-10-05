#!/bin/bash

set -e

function retry_with_backoff {
  attempts_left=$1
  sleep_seconds=$2
  shift 2
  command=$@

  # store current flag state
  flags=$-

  # allow a failures to continue
  set +e
  ${command}
  exit_code=$?

  # restore "e" flag
  if [[ ${flags} =~ e ]]
  then set -e
  else set +e
  fi

  if [[ $exit_code == 0 ]]
  then
    return 0
  fi

  # failure
  if [[ ${attempts_left} -gt 0 ]]
  then
    echo "failure (${exit_code}), sleeping ${sleep_seconds}..."
    sleep ${sleep_seconds}
    new_attempts=$((${attempts_left} - 1))
    new_sleep=$((${sleep_seconds} * 2))
    retry_with_backoff ${new_attempts} ${new_sleep} ${command}
  fi

  return $exit_code
}

snapshot_flag=''
while getopts 's' flag; do
  case "${flag}" in
    s) snapshot_flag='true' ;;
    *) snapshot_flag='false' ;;
  esac
done

if [[ "${snapshot_flag}" = "true" ]]; then
  echo "Bump the current version to -SNAPSHOT"
else
  echo "Updating current version to latest from Maven"
fi

count=0
missing_artifacts=()

for path in $(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort | xargs dirname); do
  # As of 9/21/22: BeyondCorp repos do not have artifacts released to maven central
  if [[ "${path}" =~ google-cloud-gapic-bom ]] || [[ "${path}" =~ CoverageAggregator ]] || [[ "${path}" =~ .*samples.* ]] || [[ "${path}" =~ .*beyondcorp.* ]]; then
    continue
  fi

  versions_array=($(grep -E "^.*:[0-9]+\.[0-9]+\.[0-9]+.*:[0-9]+\.[0-9]+\.[0-9]+.*$" "${path}/versions.txt"))

  for line in "${versions_array[@]}"; do
    artifactId=$(echo "${line}" | cut -d ":" -f1)

    if [[ "${artifactId}" =~ .*grafeas.* ]]; then
      maven_url="https://repo1.maven.org/maven2/io/grafeas/${artifactId}/maven-metadata.xml"
    elif [[ "${artifactId}" =~ .*area120.* ]] && [[ "${artifactId}" =~ ^google- ]]; then
      maven_url="https://repo1.maven.org/maven2/com/google/area120/${artifactId}/maven-metadata.xml"
    elif [[ "${artifactId}" =~ .*analytics.* ]] && [[ "${artifactId}" =~ ^google- ]]; then
      maven_url="https://repo1.maven.org/maven2/com/google/analytics/${artifactId}/maven-metadata.xml"
    elif [[ "${artifactId}" =~ ^google- ]]; then
      maven_url="https://repo1.maven.org/maven2/com/google/cloud/${artifactId}/maven-metadata.xml"
    else
      maven_url="https://repo1.maven.org/maven2/com/google/api/grpc/${artifactId}/maven-metadata.xml"
    fi

    count=$((count + 1))
    echo "Module #${count} -- Downloading ${artifactId} from ${maven_url}"
    # Check if the artifact exists in Maven Central, otherwise add to missing_artifacts
    if curl --output /dev/null --silent --head --fail "${maven_url}"; then
      metadata_file=$(retry_with_backoff 3 10 curl -s "${maven_url}" -H "Accept:application/xml" --limit-rate 200k)

      # Versioning of artifacts in Maven Central follow SemVer (Major.Minor.Patch-{alpha|beta})
      # This keeps track of the additional versioning after the PATCH value (alpha/beta)
      # `cut` normally returns the entire string if the delimiter DNE. The `-s` makes cut return nothing
      # maven_latest_version stores Major.Minor.Patch or the entire version
      # maven_latest_trailing stores alpha/beta/etc. or nothing
      maven_metadata_version=$(echo "${metadata_file}" | grep 'latest' | cut -d '>' -f 2 | cut -d '<' -f 1)
      maven_latest_version=$(echo "${maven_metadata_version}" | cut -d "-" -f1)
      maven_latest_trailing=$(echo "${maven_metadata_version}" | cut -s -d "-" -f2-)

      major_version=$(echo "${maven_latest_version}" | cut -d "." -f1)
      minor_version=$(echo "${maven_latest_version}" | cut -d "." -f2)
      patch_version=$(echo "${maven_latest_version}" | cut -d "." -f3)
      patch_version_bump=$((patch_version + 1))
      if [[ -z "${maven_latest_trailing}" ]]; then
        maven_version_bump="${major_version}.${minor_version}.${patch_version_bump}"
      else
        maven_version_bump="${major_version}.${minor_version}.${patch_version_bump}-${maven_latest_trailing}"
      fi
      if [[ "${snapshot_flag}" = "true" ]]; then
        new_version="${artifactId}:${maven_metadata_version}:${maven_version_bump}-SNAPSHOT"
      else
        new_version="${artifactId}:${maven_metadata_version}:${maven_metadata_version}"
      fi

      sed -i.bak "s/${line}/${new_version}/g" "${path}/versions.txt" && rm "${path}/versions.txt.bak"
    else
      missing_artifacts+=("${artifactId}")
    fi
  done
done

echo "These artifacts don't exist: ${missing_artifacts[*]}"

echo "Generating the release-please configurations..."
./generation/generate_release_please_config.sh
echo "Done generating release-please configurations..."

echo "Copying over the README and CHANGELOG files"
./generation/copy_readme_changelog.sh
echo "Done copying over the README and CHANGELOG files"