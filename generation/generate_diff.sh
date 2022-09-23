#!/bin/bash

set -e

function retry_with_backoff {
  attempts_left=$1
  sleep_seconds=$2
  shift 2
  command=$@

  # store current flag state
  flags=$-

  # allow a failures to continue
  set +e
  ${command}
  exit_code=$?

  # restore "e" flag
  if [[ ${flags} =~ e ]]
  then set -e
  else set +e
  fi

  if [[ $exit_code == 0 ]]
  then
    return 0
  fi

  # failure
  if [[ ${attempts_left} -gt 0 ]]
  then
    echo "failure (${exit_code}), sleeping ${sleep_seconds}..."
    sleep ${sleep_seconds}
    new_attempts=$((${attempts_left} - 1))
    new_sleep=$((${sleep_seconds} * 2))
    retry_with_backoff ${new_attempts} ${new_sleep} ${command}
  fi

  return $exit_code
}

if [[ $(git branch | grep main-diff) ]]; then
  git checkout main-diff
else
  git checkout -b main-diff
fi

diff_java_branch="main-diff_java"
diff_non_java_branch="main-diff_non_java"
git checkout main-diff
git branch -D "${diff_java_branch}" "${diff_non_java_branch}"

modules=$(mvn help:evaluate -Dexpression=project.modules | grep '<.*>.*</.*>' | grep 'java' | sed -e 's/<.*>\(.*\)<\/.*>/\1/g')

for module in $modules; do
  echo "Running for ${module}"
  rm -rf "${module}"
  retry_with_backoff 3 10 git clone "https://github.com/googleapis/${module}"
  rm -rf "${module}/.git"
  echo "Done running for ${module}"
done

./generation/delete_non_generated_samples.sh

if [[ $(git branch | grep "${diff_java_branch}") ]]; then
  git checkout "${diff_java_branch}"
else
  git checkout -b "${diff_java_branch}"
fi
git add "*.java"
git commit -m "chore: Adding java diffs" --no-verify
git push origin "${diff_java_branch}" --force

git stash
git checkout main-diff
git stash pop

if [[ $(git branch | grep "${diff_non_java_branch}") ]]; then
  git checkout "${diff_non_java_branch}"
else
  git checkout -b "${diff_non_java_branch}"
fi
git add .
git commit -m "chore: Adding non-java diffs" --no-verify
git push origin "${diff_non_java_branch}" --force

git checkout main-diff
git clean -fd

echo "Done running script"