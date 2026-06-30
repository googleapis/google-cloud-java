#!/bin/bash

# This script sets the "current-version" written in versions.txt applied to all
# pom.xml files in this monorepo.
# This script plays supplemental role just in case Release Please pull request
# fails to update all files.

# Usage:
# # Run this script at the root of the monorepo
# bash generation/apply_current_versions.sh

set -e

versions_file=$1
column_name=$2
if [[ -z "$versions_file" || -z "$column_name" ]]; then
  echo "Replaces the versions annotated with the x-version-update tag in"
  echo "all pom.xml files in the current working directory and its subdirectories"
  echo "with the versions specified in the versions.txt file (current or released)."
  echo
  echo "Usage: $0 path/to/versions.txt (released|current)"
  exit 1
fi
if [[ "$column_name" == "released" ]]; then 
  column_index=2
elif [[ "$column_name" == "current" ]]; then
  column_index=3
elif [[ "$column_name" != "current" ]]; then
  echo "Error: column_name must be either 'released' or 'current'"
  exit 1
fi


SED_SCRIPT_FILE=$(mktemp) || exit 1
trap 'rm -f "$SED_SCRIPT_FILE"' EXIT

# The second column is 
for KV in $(cut -f1,"${column_index}" -d: $versions_file |grep -v "#"); do
  K=${KV%:*}; V=${KV#*:}
  echo Key:$K, Value:$V;
  echo "/x-version-update:$K:current/{s|<version>.*<\/version>|<version>$V<\/version>|;}" >> "$SED_SCRIPT_FILE"
done

echo "Running sed command. It may take few minutes."
find . -maxdepth 3 -name pom.xml |sort --dictionary-order |xargs sed -i.bak -f "$SED_SCRIPT_FILE"
find . -maxdepth 3 -name pom.xml.bak |xargs rm

