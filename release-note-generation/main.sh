#!/bin/bash

set -e

last_release_tag=$(git describe --tags $(git rev-list --tags --max-count=1))

commit_log_files=""
for H in $(git log "${last_release_tag}..HEAD" --pretty=format:"%H"); do
  file=commit_log/${H}.txt
  git log -1 "${H}" --pretty=format:"%B" > $file
  commit_log_files+=" $file"
done

for pom_file in $(ls java-*/pom.xml); do                                  git[branch:release-note-generation]
  export MODULE=$(dirname "${pom_file}")
  entry=$(generate_release_entry.sh ${commit_log_files})
done
