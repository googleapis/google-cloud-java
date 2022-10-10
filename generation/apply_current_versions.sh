#!/bin/bash

# This script sets the "current-version" written in versions.txt applied to all
# pom.xml files in this monorepo.
# This script plays supplemental role just in case Release Please pull request
# fails to update all files.

# Usage:
# # Run this script at the root of the monorepo
# bash generation/apply_current_versions.sh

function apply_module_versions_file() {
  versions_file=$1

  # Normally java-XXX. For the root pom.xml, it's "."
  MODULE=$(dirname $versions_file)

  for KV in $(cut -f1,3 -d: $versions_file |grep -v "#"); do
    K=${KV%:*}; V=${KV#*:}
    echo Key:$K, Value:$V;
    pom_files="$(find . -maxdepth 3 -name pom.xml)"
    for P in $pom_files; do
      sed -i.bak -e "/x-version-update:$K:current/{s|<version>.*<\/version>|<version>$V<\/version>|;}" $P && rm ${P}.bak
    done
  done
}

for versions_txt in $(find . -mindepth 0 -maxdepth 2 -name versions.txt \
    |sort --dictionary-order); do
  apply_module_versions_file "${versions_txt}"
done
