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
diff_java_branch="main-diff_java"
diff_non_java_branch="main-diff_non_java"

if [[ $(git branch | grep "${diff_java_branch}") ]]; then
  git checkout "${diff_java_branch}"
else
  git checkout -b "${diff_java_branch}"
fi
git add "*.java"
git commit -m "chore: Adding java diffs" --no-verify
git push origin "${diff_java_branch}"

if [[ $(git branch | grep "${diff_non_java_branch}") ]]; then
  git checkout "${diff_non_java_branch}"
else
  git checkout -b "${diff_non_java_branch}"
fi
git add .
git commit -m "chore: Adding non-java diffs" --no-verify
git push origin "${diff_non_java_branch}"

git checkout "${current_branch}"

echo "Done running script"