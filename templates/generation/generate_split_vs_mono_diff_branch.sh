#!/bin/bash

set -ex

SQAUSHED_MAIN_BRANCH=squashed_main_branch
SQAUSHED_SPLIT_BRANCH=squashed_split_branch

function squash_branch {
  SOURCE_BRANCH=$1
  OUTPUT_BRANCH=$2
  git checkout $SOURCE_BRANCH
  git checkout -B $OUTPUT_BRANCH
  LAST_COMMIT=$(git rev-parse --short HEAD)
  git reset $(git commit-tree HEAD^{tree} -m "squashed ${SOURCE_BRANCH} at ${LAST_COMMIT}")

  # reset versions managed by release please
  find . -name pom.xml -exec sed -i.bak 's/\<version\>.*x-version-update.*-->/\<version\>7.7.7-SNAPSHOT\<\/version\>/g' {} \; -exec rm {}.bak \;
  git commit -am 'chore: reset version'
}

squash_branch main $SQAUSHED_MAIN_BRANCH
squash_branch monorepo_script_output $SQAUSHED_SPLIT_BRANCH

# add merge commit from monorepo (main) to split (monorepo_script_output)
git checkout $SQAUSHED_SPLIT_BRANCH
git merge $SQAUSHED_MAIN_BRANCH --allow-unrelated-histories  --strategy-option theirs --no-edit --commit

git checkout main
#git branch -D $SQAUSHED_MAIN_BRANCH
#git branch -D $SQAUSHED_SPLIT_BRANCH