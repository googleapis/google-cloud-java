#!/bin/bash

set -e

# Generate BOM of the artifacts in this repository

bom_lines=""
# For modules that produce BOMs
for bom_directory in $(find . -maxdepth 3 -name 'google-*-bom' | sort --dictionary-order); do
  if [[ "${bom_directory}" = *gapic-libraries-bom ]]; then
    continue
  fi
  repo_metadata="${bom_directory}/../.repo-metadata.json"

  pom_file="${bom_directory}/pom.xml"
  groupId_line=$(grep --max-count=1 'groupId' "${pom_file}")
  artifactId_line=$(grep --max-count=1 'artifactId' "${pom_file}")
  version_line=$(grep --max-count=1 'x-version-update' "${pom_file}")

  if ! grep --quiet '"release_level": "stable"' "${repo_metadata}"; then
    # Not including non-GA libraries, except those that happened to be included
    # already in google-cloud-bom.
    if [[ $artifactId_line != *"google-cloud-datalabeling"* ]] \
        && [[ $artifactId_line != *"google-cloud-errorreporting"* ]] \
        && [[ $artifactId_line != *"google-cloud-mediatranslation"* ]] \
        && [[ $artifactId_line != *"google-cloud-phishingprotection"* ]]; then
      echo "Not adding ${pom_file} to the BOM because it's not stable."
      continue
    fi
  fi

  bom_lines+="      <dependency>\n\
      ${groupId_line}\n\
      ${artifactId_line}\n\
      ${version_line}\n\
        <type>pom</type>\n\
        <scope>import</scope>\n\
      </dependency>\n"
done

# For originally-handwritten modules that do not produce a BOM
for module in $(find . -mindepth 2 -maxdepth 2 -name pom.xml |sort --dictionary-order | xargs dirname); do
  if ls ${module}/*-bom 1> /dev/null 2>&1; then
    continue
  fi
  if ! test -f "${module}/.repo-metadata.json"; then
    continue
  fi

  pom_file="${module}/pom.xml"
  groupId_line=$(grep --max-count=1 'groupId' "${pom_file}")
  artifactId_line=$(grep --max-count=1 'artifactId' "${pom_file}")
  version_line=$(grep --max-count=1 'x-version-update' "${pom_file}")
  bom_lines+="      <dependency>\n\
      ${groupId_line}\n\
      ${artifactId_line}\n\
      ${version_line}\n\
      </dependency>\n"
done

mkdir -p gapic-libraries-bom

GENERATION_DIR=$(dirname -- "$0");
awk -v "dependencyManagements=$bom_lines" '{gsub(/BOM_ARTIFACT_LIST/,dependencyManagements)}1' \
    "${GENERATION_DIR}/bom.pom.xml" > gapic-libraries-bom/pom.xml
