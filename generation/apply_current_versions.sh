#!/bin/bash

# This script sets the "current-version" written in versions.txt applied to all
# pom.xml files in this monorepo.
# This script plays supplemental role just in case Release Please pull request
# fails to update all files.

# Usage:
# # Run this script at the root of the monorepo
# bash generation/apply_current_versions.sh

set -e

SED_OPTIONS=""
for versions_file in $(find . -mindepth 0 -maxdepth 2 -name versions.txt \
    |sort --dictionary-order); do
  for KV in $(cut -f1,3 -d: $versions_file |grep -v "#"); do
    K=${KV%:*}; V=${KV#*:}
    echo Key:$K, Value:$V;
    SED_OPTIONS="$SED_OPTIONS -e /x-version-update:$K:current/{s|<version>.*<\/version>|<version>$V<\/version>|;}"
  done
done

echo "Running sed command. It may take few minutes."
find . -maxdepth 3 -name pom.xml |sort --dictionary-order |xargs sed -i.bak $SED_OPTIONS
find . -maxdepth 3 -name pom.xml.bak |xargs rm
