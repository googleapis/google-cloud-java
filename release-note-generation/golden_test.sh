#!/bin/bash

set -e

temp_dir=$(mktemp -d)
echo "Temporary directory created: $temp_dir"

cp -r release-note-generation/testdata "${temp_dir}"

python3 release-note-generation/split_release_note.py \
    release-note-generation/testdata/main_release_note.txt "${temp_dir}/testdata"

# Confirm the command is idempotent
python3 release-note-generation/split_release_note.py \
    release-note-generation/testdata/main_release_note.txt "${temp_dir}/testdata"

for module in java-analytics-admin java-maps-mapsplatformdatasets; do
  diff -u "${temp_dir}/testdata/${module}/CHANGELOG.md" "release-note-generation/golden/${module}/CHANGELOG.md"
done

echo "Golden test passed"
