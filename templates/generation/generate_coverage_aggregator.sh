#!/bin/bash

set -e

GENERATION_DIR=$(dirname -- "$0");

# generate coverage report
mkdir CoverageAggregator
cp "${GENERATION_DIR}/coverage.pom.xml" CoverageAggregator/pom.xml

# create aggregator project for jacoco
mvn compile -Dexec.executable='echo' \
-Dexec.args='<dependency><groupId>${project.groupId}</groupId><artifactId>${project.artifactId}</artifactId><version>${project.version}</version></dependency>' \
exec:exec -q -B | grep -v 'CoverageAggregator\|bom\|parent\|proto\-\|grpc-\|google\-cloud\-java' > /tmp/coverage-modules.txt

if grep -q ERROR /tmp/coverage-modules.txt; then
  echo "There was an error in generating coverage-modules.txt"
  exit 1
fi

# insert processed modules into coverage aggregator pom.xml
awk -v MODULES="`awk -v ORS='\\\\n' '1' /tmp/coverage-modules.txt`" '1;/<dependencies>/{print MODULES}' "${GENERATION_DIR}/coverage.pom.xml" > CoverageAggregator/pom.xml

# add CoverageAggregator to root pom
awk -v MODULE='    <module>CoverageAggregator</module>' '/<\/modules>/{print MODULE};1' pom.xml > pom.xml.tmp && mv pom.xml.tmp pom.xml
