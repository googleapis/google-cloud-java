#!/bin/bash

# Script to generate libraries.json as part of the README generation job.
# The libraries.json file is used to index the repositories for Google Cloud
# client libraries. The libraries.json is concatenation of .repo-metadata.json
# files in each module.

total=$(find . -maxdepth 2 -name .repo-metadata.json|wc -l)
total=$((total))
counter=0
echo '[' > libraries.json
for F in $(find . -maxdepth 2 -name .repo-metadata.json| sort --dictionary-order); do
  cat $F >> libraries.json
  counter=$((counter + 1))
  if [[ "$counter" -lt "$total" ]]; then
    echo ',' >> libraries.json
  fi
done
echo ']' >> libraries.json
