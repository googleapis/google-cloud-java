#!/bin/bash

set -eo pipefail
REPO=$1
set -x

# Make artifacts available for 'mvn validate' at the bottom
mvn install -DskipTests=true -Dmaven.javadoc.skip=true -Dgcloud.download.skip=true -B -V -q

# Read the current version of this BOM in the POM. Example version: '0.116.1-alpha-SNAPSHOT'
VERSION_POM=pom.xml
# Namespace (xmlns) prevents xmllint from specifying tag names in XPath
VERSION=`sed -e 's/xmlns=".*"//' ${VERSION_POM} | xmllint --xpath '/project/version/text()' -`

if [ -z "${VERSION}" ]; then
  echo "Version is not found in ${VERSION_POM}"
  exit 1
fi
echo "Version: ${VERSION}"

# Get version of doclet used to generate Cloud RAD
git clone https://github.com/googleapis/java-docfx-doclet.git
cd java-docfx-doclet/third_party/docfx-doclet-143274
git checkout 1.9.0
mvn package -Dmaven.test.skip=true

# work from the root directory
cd ../../../
docletPath=$(realpath "java-docfx-doclet/third_party/docfx-doclet-143274/target/docfx-doclet-1.0-SNAPSHOT-jar-with-dependencies.jar")
echo "This is the doclet path: ${docletPath}"

# Test with java-bigtable
git clone "https://github.com/googleapis/${REPO}.git" --depth=1
pushd ${REPO}

# replace version
xmllint --shell <(cat pom.xml) << EOF
setns x=http://maven.apache.org/POM/4.0.0
cd .//x:artifactId[text()="google-cloud-shared-config"]
cd ../x:version
set ${VERSION}
save pom.xml
EOF

mvn clean -B -ntp \
    -P docFX \
    -DdocletPath="${docletPath}" \
    -Dclirr.skip=true \
    -Denforcer.skip=true \
    -Dorg.slf4j.simpleLogger.showDateTime=true -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
    -Dcheckstyle.skip=true \
    -Dflatten.skip=true \
    -Danimal.sniffer.skip=true \
    javadoc:aggregate

# go back to the root directory
cd ..
# clean up clones
echo "Removing java-docfx-doclet clone"
rm -rf java-docfx-doclet
echo "Removing java-bigtable clone"
rm -rf ${REPO}