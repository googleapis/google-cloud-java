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
  if [[ "${module}" = *google-cloud-gapic-bom ]] || [[ "${module}" = *CoverageAggregator ]]; then
    continue
  fi
  echo "Processing module $module"
  pushd $module
  # Search for <parent> tag in module pom and replace the next three lines -- groupId, artifcatId, and version
  perl_command="s/\s*<parent>.*?<\/parent>/\n\n  <parent>\n    <groupId>${parent_group_id}<\/groupId>\n    <artifactId>${parent_artifact_id}<\/artifactId>\n    <version>${parent_version}<\/version><!-- {x-version-update:google-cloud-java:current} -->\n  <\/parent>/s"
  # execute the replacement in pom.xml
  perl -0pe "$perl_command" pom.xml > pom.xml.new && rm pom.xml && mv pom.xml.new pom.xml

  # update the bom projects as well by removing parent
  if ls -1 | grep 'bom'; then
    BOM=$(ls -1 | grep 'bom')'/pom.xml'
    echo the bom is $BOM
    # Search for <parent> tag in module bom and replace the next three lines -- groupId, artifcatId, and version
    perl_command="s/\s*<parent>.*?<\/parent>//s"
    # execute the replacement in pom.xml
    perl -0pe "$perl_command" "$BOM" > "$BOM".new && rm "$BOM" && mv "$BOM".new "$BOM"
  fi

  popd
done
