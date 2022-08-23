#!/bin/bash

set -e

# generate BOM of the artifacts in this repository
bom_lines=""
for bom_directory in $(find . -name 'google-*-bom' | sort); do
  if [[  "${bom_directory}" = *google-cloud-gapic-bom ]]; then
    continue
  fi
  repo_metadata="${bom_directory}/../.repo-metadata.json"

  if ! grep --quiet '"release_level": "stable"' "${repo_metadata}"; then
    # Not including non-GA libraries, except those that happened to be included
    # already in google-cloud-bom.
    if [[ $artifactId_line != *"google-cloud-datalabeling"* ]] \
        && [[ $artifactId_line != *"google-cloud-errorreporting"* ]] \
        && [[ $artifactId_line != *"google-cloud-logging-logback"* ]] \
        && [[ $artifactId_line != *"google-cloud-mediatranslation"* ]] \
        && [[ $artifactId_line != *"google-cloud-nio"* ]] \
        && [[ $artifactId_line != *"google-cloud-notification"* ]] \
        && [[ $artifactId_line != *"google-cloud-phishingprotection"* ]]; then
      echo "Not adding ${pom_file} to the BOM because it's not stable."
      continue
    fi
  fi
  pom_file="${bom_directory}/pom.xml"
  groupId_line=$(grep --max-count=1 'groupId' "${pom_file}")
  artifactId_line=$(grep --max-count=1 'artifactId' "${pom_file}")
  version_line=$(grep --max-count=1 'x-version-update' "${pom_file}")

  bom_lines+="      <dependency>\n\
      ${groupId_line}\n\
      ${artifactId_line}\n\
      ${version_line}\n\
        <type>pom</type>\n\
        <scope>import</scope>\n\
      </dependency>\n"

  pushd "${bom_directory}"
  mvn install -Denforcer.skip -Dcheckstyle.skip -Danimal.sniffer.skip -Dclirr.skip
  popd
done

mkdir -p google-cloud-gapic-bom

GENERATION_DIR=$(dirname -- "$0");
awk -v "dependencyManagements=$bom_lines" '{gsub(/BOM_ARTIFACT_LIST/,dependencyManagements)}1' \
    "${GENERATION_DIR}/bom.pom.xml" > google-cloud-gapic-bom/pom.xml
