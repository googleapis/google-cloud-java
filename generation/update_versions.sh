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

count=0
missing_artifacts=()

for path in $(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort | xargs dirname); do
  # BeyondCorp repos have not release an artifact to maven central
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
    if wget --spider "${maven_url}" 2>/dev/null; then
      metadata_file=$(retry_with_backoff 3 10 curl -s "${maven_url}" -H "Accept:application/xml" --limit-rate 200k)
      maven_metadata_version=$(echo "${metadata_file}" | grep 'latest' | cut -d '>' -f 2 | cut -d '<' -f 1)
      maven_latest_version=$(echo "${maven_metadata_version}"  | cut -d "-" -f1)
      maven_latest_trailing=$(echo "${maven_metadata_version}"  | cut -s -d "-" -f2-)

      major_version=$(echo "${maven_latest_version}" | cut -d "." -f1)
      minor_version=$(echo "${maven_latest_version}" | cut -d "." -f2)
      patch_version=$(echo "${maven_latest_version}" | cut -d "." -f3)
      patch_version_bump=$((patch_version + 1))
      if [[ -z "${maven_latest_trailing}" ]]; then
        maven_version_bump="${major_version}.${minor_version}.${patch_version_bump}"
        new_version="${artifactId}:${maven_latest_version}:${maven_version_bump}-SNAPSHOT"
      else
        maven_version_bump="${major_version}.${minor_version}.${patch_version_bump}-${maven_latest_trailing}"
        new_version="${artifactId}:${maven_latest_version}-${maven_latest_trailing}:${maven_version_bump}-SNAPSHOT"
      fi

      sed -i "s/${line}/${new_version}/g" "${path}/versions.txt"
    else
      missing_artifacts+=("${artifactId}")
    fi
  done
done

echo "These artifacts don't exist: ${missing_artifacts[*]}"
