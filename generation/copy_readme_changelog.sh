#!/bin/bash

set -e

for path in $(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort | xargs dirname); do
  if [[ "${path}" =~ google-cloud-gapic-bom ]] || [[ "${path}" =~ CoverageAggregator ]]; then
    continue
  fi
  pushd "${path}"

  module_name="${path:2}"
  raw_readme_url="https://raw.githubusercontent.com/googleapis/${module_name}/main/README.md"
  raw_changelog_url="https://raw.githubusercontent.com/googleapis/${module_name}/main/CHANGELOG.md"

  curl -s "${raw_readme_url}" > README.md
  curl -s "${raw_changelog_url}" > CHANGELOG.md

  popd
done