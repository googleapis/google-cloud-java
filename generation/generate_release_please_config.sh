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

  #for multi-module libraries, sync the versions to released(non-snapshot):current(snapshot) type
  cat ${version_file} | while read line
      do
         if [[ ${line} =~ [0-9] ]] && ! [[ ${line} == *"SNAPSHOT"* ]] ; then
           artifact_name=$(echo "${line}" | awk -F':' '{print $1}')
           old_version=$(echo "${line}" | awk -F':' '{print $3}')
           new_version=$(echo ${old_version} |  awk -F'.' '{print $1"."$2"."$3+1}' |  sed s/[.]$//)
           new_version="${new_version}-SNAPSHOT"
           sed -i.bak -e "s|${artifact_name}:${old_version}:${old_version}|${artifact_name}:${old_version}:${new_version}|" "${version_file}" && rm "${version_file}".bak
           artifact_directory="${module}/${artifact_name}"
           mvn -B -ntp -f ${artifact_directory} -U versions:set -DnewVersion=${new_version} -DgenerateBackupPoms=false
         fi
      done

  snapshot_version=$(echo ${module_released_version} |  awk -F'.' '{print $1"."$2"."$3+1}' |  sed s/[.]$//)

  #bumping to snapshot in module bom directory, if it exists
  bom_directory="${module-name}/${artifactName_config}-bom"
  if [ -d "${bom_directory}" ]; then
    mvn -B -ntp -f ${bom_directory} -U versions:set -DnewVersion="${snapshot_version}-SNAPSHOT" -DgenerateBackupPoms=false
  fi

  #bumping to snapshot in module root pom
  mvn -B -ntp -f ${module} -U versions:set -DnewVersion="${snapshot_version}-SNAPSHOT"
  mvn versions:commit

  #specific case
  if [[ ${module_name} == "java-notification" ]]; then
    mvn -B -ntp -f ${module} -U versions:set -DnewVersion="${snapshot_version}-beta-SNAPSHOT" -DgenerateBackupPoms=false
  fi

done

echo "}" >> .release-please-manifest.json

awk -v "packagesList=$rp_config_line" '{gsub(/ALL_PACKAGES/,packagesList)}1' \
    ${GENERATION_DIR}/release_please_config_raw.json > release-please-config.json
