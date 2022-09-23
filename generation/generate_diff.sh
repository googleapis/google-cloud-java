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

if [[ $(git branch | grep "main-diff_java") ]]; then
  git checkout main-diff_java
else
  git checkout -b main-diff_java
fi
git add "*.java"
git commit -m "chore: Adding java diffs" --no-verify

if [[ $(git branch | grep "main-diff_non_java") ]]; then
  git checkout main-diff_non_java
else
  git checkout -b main-diff_non_java
fi
git add .
git commit -m "chore: Adding non-java diffs" --no-verify
git checkout "${current_branch}"

echo "Done running script"