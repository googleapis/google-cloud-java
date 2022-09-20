#!/bin/bash

set -e

for path in $(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort | xargs dirname); do
  if [[ "${path}" =~ ^\.\/google-cloud-gapic-bom$ ]] || [[ "${path}" =~ ^\.\/CoverageAggregator$ ]] || [[ "${path}" =~ ^.*samples.*$ ]] || [[ "${path}" =~ ^.*beyondcorp.*$ ]]; then
    continue
  fi

  # Confirm the rest...
  if [[ "${path}" = *area120* ]] || [[ "${path}" = *grafeas* ]]; then
    continue
  fi

  versions_array=($(grep -E "^.*:[0-9]+\.[0-9]+\.[0-9]+:.*$" "${path}/versions.txt"))

  for line in "${versions_array[@]}"; do
    artifactId=$(echo "${line}" | cut -d ":" -f1)

    if [[ "${artifactId}" =~ ^.*analytics.*$ ]] && [[ "${artifactId}" =~ ^google- ]]; then
      maven_url="https://repo1.maven.org/maven2/com/google/analytics/${artifactId}/maven-metadata.xml"
    elif [[ "${artifactId}" =~ ^google- ]]; then
      maven_url="https://repo1.maven.org/maven2/com/google/cloud/${artifactId}/maven-metadata.xml"
    else
      maven_url="https://repo1.maven.org/maven2/com/google/api/grpc/${artifactId}/maven-metadata.xml"
    fi

    echo $maven_url
    maven_version=$(curl -s "${maven_url}" | grep 'latest')
    maven_latest_version=$(echo "$maven_version" | cut -d '>' -f 2 | cut -d '<' -f 1)

    major_version=$(echo "${maven_latest_version}" | cut -d "." -f1)
    minor_version=$(echo "${maven_latest_version}" | cut -d "." -f2)
    patch_version=$(echo "${maven_latest_version}" | cut -d "." -f3)
    patch_version_bump=$((patch_version + 1))

    maven_version_bump="${major_version}:${minor_version}:${patch_version_bump}"

    echo "${artifactId}'s latest version: ${maven_latest_version}"

    new_version="${artifactId}:${maven_latest_version}:${maven_version_bump}-SNAPSHOT"

    sed -i "s/${line}/${new_version}/g" "${path}/versions.txt"
  done
done
