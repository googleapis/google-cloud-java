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
else
  echo "Error: column_name must be either 'released' or 'current'"
  exit 1
fi

SED_SCRIPT=$(mktemp)
trap "rm -f $SED_SCRIPT" EXIT

for KV in $(cut -f1,"${column_index}" -d: $versions_file |grep -v "#"); do
  K=${KV%:*}; V=${KV#*:}
  echo "Key:$K, Value:$V";
  # Pattern 1: XML <version> tags and property tags (e.g., <google-cloud-shared-dependencies.version>)
  echo "/x-version-update:$K:\(current\|released\)/{s|>\([^<]*\)<|>$V<|;}" >> "$SED_SCRIPT"
  # Pattern 2: YAML _VERSION: '...' or "..."
  echo "/x-version-update:$K:\(current\|released\)/{s|: [\'\"][^\'\"]*[\'\"]|: \'$V\'|;}" >> "$SED_SCRIPT"
  # Pattern 3: Java static final String VERSION = "..."
  echo "/x-version-update-start:$K:\(current\|released\)/{n;s|\".*\"|\"$V\"|;}" >> "$SED_SCRIPT"
done


echo "Running sed command. It may take few minutes."
# Including pom.xml, *.yaml, and Version.java files.
FILES=$(find . \( -name pom.xml -o -name "*.yaml" -o -name "Version.java" \) | sort --dictionary-order)
TOTAL_FILES=$(echo "$FILES" | grep -c .)
CURRENT_FILE=0
while read -r FILE; do
  CURRENT_FILE=$((CURRENT_FILE + 1))
  echo -ne "Progress: $CURRENT_FILE/$TOTAL_FILES ($((CURRENT_FILE * 100 / TOTAL_FILES))%)\r"
  sed -i -f "$SED_SCRIPT" "$FILE"
done <<< "$FILES"
echo
