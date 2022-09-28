#!/bin/bash

set -e

rm .release-please-manifest.json
echo -e "{\n\t\"google-cloud-gapic-bom\": \"0.0.0\"," >.release-please-manifest.json

GENERATION_DIR=$(dirname -- "$0")

# We are manually excluding two modules -- TODO: Update this for any other exclusions
num_modules=$(find . -mindepth 2 -maxdepth 2 -name pom.xml | wc -l)
num_modules=$((num_modules - 2))
for path in $(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort | xargs dirname); do
  if [[ "${path}" = *google-cloud-gapic-bom ]] || [[ "${path}" = *CoverageAggregator ]]; then
    continue
  fi

  version_file="${path}/versions.txt"
  module_name="${path:2}"

  if [[ "${module_name}" = "java-grafeas" ]]; then
    module_line=$(grep -E "^grafeas:[0-9]+\.[0-9]+\.[0-9]+.*:[0-9]+\.[0-9]+\.[0-9]+.*$" "${path}/versions.txt")
  else
    module_line=$(grep -E "^google-.*:[0-9]+\.[0-9]+\.[0-9]+.*:[0-9]+\.[0-9]+\.[0-9]+.*$" "${path}/versions.txt")
  fi
  artifactName_config=$(echo "${module_line}" | cut -d ":" -f1)
  module_released_version=$(echo "${module_line}" | cut -d ":" -f2)
  module_snapshot_version=$(echo "${module_line}" | cut -d ":" -f3)

  #concatenating module name and module version
  rp_manifest_line="\t\"${module_name}\": \"${module_released_version}\""
  rp_config_line+="\t\t\"${module_name}\": {\n\t\t\t\"component\": \"${artifactName_config}\",\n\t\t\t\"skip-github-release\": \"true\"\n\t\t}"

  #adding " , " where it's necessary
  if [[ ${num_modules} -gt 1 ]]; then
    rp_manifest_line+=","
    rp_config_line+=",\n"
    num_modules=$((num_modules - 1))
  fi

  #adding the line to manifest config file
  echo -e "${rp_manifest_line}" >>.release-please-manifest.json

  #for multi-module libraries, sync the versions to released(non-snapshot):current(snapshot) type
  cat ${version_file} | while read line; do
    if [[ ${line} =~ [0-9] ]] && ! [[ ${line} == *"SNAPSHOT"* ]]; then
      artifact_name=$(echo "${line}" | awk -F':' '{print $1}')
      old_version=$(echo "${line}" | awk -F':' '{print $3}')
      new_version=$(echo ${old_version} | awk -F'.' '{print $1"."$2"."$3+1}' | sed s/[.]$//)
      new_version="${new_version}-SNAPSHOT"
      sed -i.bak -e "s|${artifact_name}:${old_version}:${old_version}|${artifact_name}:${old_version}:${new_version}|" "${version_file}" && rm "${version_file}".bak
    fi
  done
done

echo "}" >>.release-please-manifest.json

awk -v "packagesList=$rp_config_line" '{gsub(/ALL_PACKAGES/,packagesList)}1' \
  ${GENERATION_DIR}/release_please_config_raw.json >release-please-config.json
