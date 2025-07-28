#!/bin/bash
set -e
# This script should be run at the root of the repository.
# This script is used to update googleapis_commitish, gapic_generator_version,
# and libraries_bom_version in generation configuration at the time of running
# and create a pull request.

# The following commands need to be installed before running the script:
# 1. git
# 2. gh
# 3. jq

# Utility functions
# Get the latest released version of a Maven artifact.
function get_latest_released_version() {
    local group_id=$1
    local artifact_id=$2
    group_id_url_path="$(sed 's|\.|/|g' <<< "${group_id}")"
    url="https://repo1.maven.org/maven2/${group_id_url_path}/${artifact_id}/maven-metadata.xml"
    xml_content=$(curl -s --fail "${url}")
    latest=$(xmllint --xpath 'metadata/versioning/latest/text()' - <<< "${xml_content}")
    if [[ -z "${latest}" ]]; then
        echo "The latest version of ${group_id}:${artifact_id} is empty."
        echo "The returned json from maven.org is invalid: ${json_content}"
        exit 1
    else
        echo "${latest}"
    fi
}

# Update a key to a new value in the generation config.
function update_config() {
    local key_word=$1
    local new_value=$2
    local file=$3
    echo "Update ${key_word} to ${new_value} in ${file}"
    sed -i -e "s/^${key_word}.*$/${key_word}: ${new_value}/" "${file}"
}

# Update an action to a new version in GitHub action.
function update_action() {
    local key_word=$1
    local new_value=$2
    local file=$3
    echo "Update ${key_word} to ${new_value} in ${file}"
    # use a different delimiter because the key_word contains "/".
    sed -i -e "s|${key_word}@v.*$|${key_word}@v${new_value}|" "${file}"
}

# The parameters of this script is:
# 1. base_branch, the base branch of the result pull request.
# 2. repo, organization/repo-name, e.g., googleapis/google-cloud-java
# 3. [optional] generation_config, the path to the generation configuration,
# the default value is generation_config.yaml in the repository root.
# 4. [optional] workflow, the library generation workflow file,
# the default value is .github/workflows/hermetic_library_generation.yaml.
while [[ $# -gt 0 ]]; do
key="$1"
case "${key}" in
  --base_branch)
    base_branch="$2"
    shift
    ;;
  --repo)
    repo="$2"
    shift
    ;;
  --generation_config)
    generation_config="$2"
    shift
    ;;
  --workflow)
    workflow="$2"
    shift
    ;;
  *)
    echo "Invalid option: [$1]"
    exit 1
    ;;
esac
shift
done

if [ -z "${base_branch}" ]; then
  echo "missing required argument --base_branch"
  exit 1
fi

if [ -z "${repo}" ]; then
  echo "missing required argument --repo"
  exit 1
fi

if [ -z "${generation_config}" ]; then
  generation_config="generation_config.yaml"
  echo "Use default generation config: ${generation_config}"
fi

if [ -z "${workflow}" ]; then
    workflow=".github/workflows/hermetic_library_generation.yaml"
    echo "Use default library generation workflow file: ${workflow}"
fi

current_branch="generate-libraries-${base_branch}"
title="chore: Update generation configuration at $(date)"

git checkout "${base_branch}"
# Try to find a open pull request associated with the branch
pr_num=$(gh pr list -s open -H "${current_branch}" -q . --json number | jq ".[] | .number")
# Create a branch if there's no open pull request associated with the
# branch; otherwise checkout the pull request.
if [ -z "${pr_num}" ]; then
  git checkout -b "${current_branch}"
  # Push the current branch to remote so that we can
  # compare the commits later.
  git push -u origin "${current_branch}"
else
  gh pr checkout "${pr_num}"
fi

# Only allow fast-forward merging; exit with non-zero result if there's merging
# conflict.
git merge -m "chore: merge ${base_branch} into ${current_branch}" "${base_branch}"

mkdir tmp-googleapis
# Use partial clone because only commit history is needed.
git clone --filter=blob:none https://github.com/googleapis/googleapis.git tmp-googleapis
pushd tmp-googleapis
git pull
latest_commit=$(git rev-parse HEAD)
popd
rm -rf tmp-googleapis
update_config "googleapis_commitish" "${latest_commit}" "${generation_config}"

# Update gapic-generator-java version to the latest
latest_version=$(get_latest_released_version "com.google.api" "gapic-generator-java")
update_config "gapic_generator_version" "${latest_version}" "${generation_config}"

# Update composite action version to latest gapic-generator-java version
update_action "googleapis/sdk-platform-java/.github/scripts" \
  "${latest_version}" \
  "${workflow}"

# Update libraries-bom version to the latest
latest_version=$(get_latest_released_version "com.google.cloud" "libraries-bom")
update_config "libraries_bom_version" "${latest_version}" "${generation_config}"

git add "${generation_config}" "${workflow}"
changed_files=$(git diff --cached --name-only)
if [[ "${changed_files}" == "" ]]; then
    echo "The latest generation config is not changed."
    echo "Skip committing to the pull request."
else
    git commit -m "${title}"
fi

# There are potentially at most two commits: merge commit and change commit.
# We want to exit the script if no commit happens (otherwise this will be an
# infinite loop).
# `git cherry` is a way to find whether the local branch has commits that are
# not in the remote branch.
# If we find any such commit, push them to remote branch.
unpushed_commit=$(git cherry -v "origin/${current_branch}" | wc -l)
if [[ "${unpushed_commit}" -eq 0 ]]; then
    echo "No unpushed commits, exit"
    exit 0
fi

if [ -z "${pr_num}" ]; then
  git remote add remote_repo https://cloud-java-bot:"${GH_TOKEN}@github.com/${repo}.git"
  git fetch -q remote_repo
  git push -f remote_repo "${current_branch}"
  gh pr create --title "${title}" --head "${current_branch}" --body "${title}" --base "${base_branch}"
else
  git push
  gh pr edit "${pr_num}" --title "${title}" --body "${title}"
fi
