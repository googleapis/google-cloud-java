#!/bin/bash

set -e

basedir=$(dirname "$(readlink -f "$0")")
temp_dir=$(mktemp -d)
echo "Temporary directory created: $temp_dir"

cp -r "${basedir}/testdata" "${temp_dir}"

python3 "${basedir}/split_release_note.py" \
    "${basedir}/testdata/main_release_note.txt" "${temp_dir}/testdata"

# Confirm the command is idempotent
python3 "${basedir}/split_release_note.py" \
    "${basedir}/testdata/main_release_note.txt" "${temp_dir}/testdata"

for module in java-analytics-admin java-maps-mapsplatformdatasets java-vertexai; do
  diff -u "${temp_dir}/testdata/${module}/CHANGELOG.md" "${basedir}/golden/${module}/CHANGELOG.md"
done

echo "Golden test passed"
