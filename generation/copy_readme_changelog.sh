#!/bin/bash

set -e

for path in $(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort | xargs dirname); do
  pushd "${path}"

  module_name="${path:2}"
  raw_readme_url="https://raw.githubusercontent.com/googleapis/${module_name}/main/README.md"
  raw_changelog_url="https://raw.githubusercontent.com/googleapis/${module_name}/main/CHANGELOG.md"

  if curl --output /dev/null --silent --head --fail "${raw_readme_url}"; then
    curl -s "${raw_readme_url}" > README.md
  fi
  if curl --output /dev/null --silent --head --fail "${raw_changelog_url}"; then
    curl -s "${raw_changelog_url}" > CHANGELOG.md
  fi

  popd
done