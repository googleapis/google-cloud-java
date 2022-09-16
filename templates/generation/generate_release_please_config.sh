#!/bin/bash

set -xe

echo "{" > .release-please-manifest.json

echo ""\""google-cloud-gapic-bom"\"": "\""0.0.0"\""," >> .release-please-manifest.json

GENERATION_DIR=$(dirname -- "$0");

num_modules=$(find . -mindepth 2 -maxdepth 2 -name pom.xml | wc -l)

rp_config_line=""
rp_manifest_line=""

for module in $(find . -mindepth 2 -maxdepth 2 -name pom.xml |sort | xargs dirname); do

  if [[ "${module}" = *google-cloud-gapic-bom ]] || [[ "${module}" = *CoverageAggregator ]] || grep -q 'SNAPSHOT<\/version>' "${module}/pom.xml" ; then
    continue
  fi

  version_file="${module}/versions.txt"

  module_name="${module:2}"

  module_released_version=$(grep google- ${version_file} |head -1 |awk -F: '{print $2}')
  module_snapshot_version=$(grep google- ${version_file} |head -1 |awk -F: '{print $3}')
  artifactName_config=$(grep google- ${version_file} |head -1 |awk -F: '{print $1}')

  #specific case
  if [[ ${module_name} == "java-grafeas" ]]; then
    module_released_version=$(grep grafeas ${version_file} |head -1 |awk -F: '{print $2}')
    artifactName_config=$(grep grafeas ${version_file} |head -1 |awk -F: '{print $1}')
  fi

  #concatenating module name and module version
  rp_manifest_line=""\""${module_name}"\"": "\""${module_released_version}"\"""

  rp_config_line+=""\""${module_name}"\"": {\n\
          "\""component"\"": ""\""${artifactName_config}"\"","\n\
          "\""skip-github-release"\"": "true"\n\
         }"

  #adding " , " where it's necessary
  if [[ ${num_modules} -gt 2 ]]; then
    rp_manifest_line+=","
    rp_config_line+=",\n    "
    num_modules=$((num_modules-1))
  fi

  #adding the line to manifest config file
  echo "${rp_manifest_line}" >> .release-please-manifest.json

  #bumping to snapshot in module root pom
  mvn -B -ntp -f ${module} -U versions:set -DnewVersion="${module_snapshot_version}" -DprocessAllModules -DgenerateBackupPoms=false -DprocessFromLocalAggregationRoot=false

done

echo "}" >> .release-please-manifest.json

awk -v "packagesList=$rp_config_line" '{gsub(/ALL_PACKAGES/,packagesList)}1' \
    ${GENERATION_DIR}/release_please_config_raw.json > release-please-config.json
