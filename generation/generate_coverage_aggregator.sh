#!/bin/bash

set -e

GENERATION_DIR=$(dirname -- "$0");

# generate coverage report
mkdir -p CoverageAggregator
cp "${GENERATION_DIR}/coverage.pom.xml" CoverageAggregator/pom.xml

# create aggregator project for jacoco
module_lines=""
# For modules that produce coverage
for pom_file in $(find . -mindepth 2 -maxdepth 3 -name pom.xml | sort); do

  groupId_line=$(grep --max-count=1 'groupId' "${pom_file}")
  artifactId_line=$(grep --max-count=1 'artifactId' "${pom_file}")

  if echo $artifactId_line | grep -q 'CoverageAggregator\|bom\|parent\|proto\-\|grpc-\|google\-cloud\-java\|samples' ; then
    echo skipping: $pom_file
    continue
  fi

  echo including: $pom_file

  version_line=$(grep --max-count=1 'x-version-update' "${pom_file}")

  module_lines+="    <dependency>\n\
    ${groupId_line}\n\
    ${artifactId_line}\n\
    ${version_line}\n\
    </dependency>\n"
done

# insert processed modules into coverage aggregator pom.xml
awk -v "modules=$module_lines" '{gsub(/MODULES/,modules)}1' \
    "${GENERATION_DIR}/coverage.pom.xml" > CoverageAggregator/pom.xml
