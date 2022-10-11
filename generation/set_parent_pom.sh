#!/bin/bash

set -ef

# For each library module in current working directory, this script
# sets the parent to the root pom.xml

# Run this script at the root of google-cloud-java repository

# First, read the values from the root pom.xml
parent_version=$(perl -nle 'print $1 if m|<version>(.+)</version>|' pom.xml |head -1)
parent_group_id=$(perl -nle 'print $1 if m|<groupId>(.+)</groupId>|' pom.xml |head -1)
parent_artifact_id=$(perl -nle 'print $1 if m|<artifactId>(.+)</artifactId>|' pom.xml |head -1)

# Then, apply the values as the parent pom of each module
for module in $(find . -mindepth 2 -maxdepth 2 -name pom.xml |sort | xargs dirname); do
  # example value of module is "./java-accessapproval"
  if [[ "${module}" = *google-cloud-gapic-bom ]]; then
    continue
  fi
  echo "Processing module $module"
  pushd $module
  # Search for <parent> tag in module pom and replace the next three lines -- groupId, artifcatId, and version
  sed -i.bak -e "/<parent>/{N;s|<groupId>.*<\/groupId>|<groupId>${parent_group_id}<\/groupId>|;N;s|<artifactId>.*<\/artifactId>|<artifactId>${parent_artifact_id}<\/artifactId>|;N;s|<version>.*<\/version>|<version>${parent_version}<\/version><!-- {x-version-update:google-cloud-java:current} -->|;}" pom.xml && rm pom.xml.bak

  # update the bom projects as well
  if ls | grep 'bom'; then
    BOM=$(ls | grep 'bom')
    # Search for <parent> tag in module bom and replace the next three lines -- groupId, artifcatId, and version
    sed -i.bak -e "/<parent>/{N;s|<groupId>.*<\/groupId>|<groupId>${parent_group_id}<\/groupId>|;N;s|<artifactId>.*<\/artifactId>|<artifactId>${parent_artifact_id}<\/artifactId>|;N;s|<version>.*<\/version>|<version>${parent_version}<\/version><!-- {x-version-update:google-cloud-java:current} -->\n    <relativePath>..\/..\/pom.xml<\/relativePath>|;}" ${BOM}/pom.xml && rm ${BOM}/pom.xml.bak
  fi

  popd
done
