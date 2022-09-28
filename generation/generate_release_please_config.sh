#!/bin/bash

set -e

GENERATION_DIR=$(dirname -- "$0")

# Hardcode the tab as two spaces instead of \t
tab="  "
release_please_manifest_file=".release-please-manifest.json"
release_please_config_file="release-please-config.json"

[ -e "${release_please_manifest_file}" ] && rm "${release_please_manifest_file}"
[ -e "${release_please_config_file}" ] && rm "${release_please_config_file}"

echo "{" > "${release_please_manifest_file}"

# We are manually excluding the CoverageAggregator module -- TODO: Update this for any other exclusions
num_modules=$(find . -mindepth 2 -maxdepth 2 -name pom.xml | wc -l)
num_modules=$((num_modules - 1))
for path in $(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort | xargs dirname); do
  if [[ "${path}" = *CoverageAggregator ]]; then
    continue
  fi

  # path starts with ./{module}, we need to exclude the first two chars
  module_name="${path:2}"
  version_file="${path}/versions.txt"

  # Java-Grafeas is a special case
  if [[ "${module_name}" = "java-grafeas" ]]; then
    module_line=$(grep -E "^grafeas:[0-9]+\.[0-9]+\.[0-9]+.*:[0-9]+\.[0-9]+\.[0-9]+.*$" "${version_file}")
  else
    module_line=$(grep -E "^google-.*:[0-9]+\.[0-9]+\.[0-9]+.*:[0-9]+\.[0-9]+\.[0-9]+.*$" "${version_file}")
  fi
  artifact_name=$(echo "${module_line}" | cut -d ":" -f1)
  module_released_version=$(echo "${module_line}" | cut -d ":" -f2)
  module_snapshot_version=$(echo "${module_line}" | cut -d ":" -f3)

  # concatenating module name and module version
  rp_manifest_line="${tab}\"${module_name}\": \"${module_released_version}\""
  # Generate the JSON block with formatting
  rp_config_line+="${tab}${tab}\"${module_name}\": {\n${tab}${tab}${tab}\"component\": \"${artifact_name}\",\n${tab}${tab}${tab}\"skip-github-release\": true\n${tab}${tab}}"

  # adding " , " where it's necessary
  if [[ ${num_modules} -gt 1 ]]; then
    rp_manifest_line+=","
    rp_config_line+=",\n"
    num_modules=$((num_modules - 1))
  fi

  # Adding the line to manifest config file
  echo -e "${rp_manifest_line}" >> "${release_please_manifest_file}"
done

# End the .json file with the closing bracket
echo "}" >> "${release_please_manifest_file}"

# Replace the package list where `ALL_PACKAGES` string is in the release_please_config_raw.json
awk -v "packagesList=${rp_config_line}" '{gsub(/ALL_PACKAGES/,packagesList)}1' \
  "${GENERATION_DIR}/release_please_config_raw.json" > "${release_please_config_file}"
