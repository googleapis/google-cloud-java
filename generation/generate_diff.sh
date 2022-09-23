#!/bin/bash

set -e

modules=$(mvn help:evaluate -Dexpression=project.modules | grep '<.*>.*</.*>' | grep 'java' | sed -e 's/<.*>\(.*\)<\/.*>/\1/g')

for module in $modules; do
  echo "Running for ${module}"
  rm -rf "${module}"
  git clone "https://github.com/googleapis/${module}"
  rm -rf "${module}/.git"
  echo "Done running for ${module}"
done

current_branch=$(git branch | sed -n -e 's/^\* \(.*\)/\1/p')
git checkout -b main-diff_java
git add "*.java"
git commit -m "chore: Adding java diffs"
git checkout "${current_branch}"
git add .
git commit -m "chore: Adding non-java diffs"
git checkout "${current_branch}"

echo "Done running script"