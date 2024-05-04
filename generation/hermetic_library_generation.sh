#!/bin/bash
set -euo pipefail
# This script should be run at the root of the repository.
# This script is used to, when a pull request changes the generation
# configuration (generation_config.yaml by default):
# 1. Find whether the last commit in this pull request contains changes to
# the generation configuration and exit early if it doesn't have such a change
# since the generation result would be the same.
# 2. Compare generation configurations in the current branch (with which the
# pull request associated) and target branch (into which the pull request is
# merged);
# 3. Generate changed libraries using library_generation image;
# 4. Commit the changes to the pull request, if any.
# 5. Edit the PR body with generated pull request description, if applicable.

# Note that the pull request may come from a forked repository, e.g., renovate
# pull request. Special handling is needed in this case.

# The following commands need to be installed before running the script:
# 1. git
# 2. gh
# 3. docker

# The parameters of this script is:
# 1. base_ref, the branch into which the pull request is merged.
# 2. base_repo, the repository into which the pull request is merged.
# 3. head_ref, the branch with which the pull request is associated.
# 4. head_repo_url, the url of the repository with which the pull request is associated.
# 5. head_repo_name, the name of the repository with which the pull request is associated.
# 6. image_tag, the tag of gcr.io/cloud-devrel-public-resources/java-library-generation.
# 7. [optional] generation_config, the path to the generation configuration,
# the default value is generation_config.yaml in the repository root.
while [[ $# -gt 0 ]]; do
key="$1"
case "${key}" in
  --base_ref)
    base_ref="$2"
    shift
    ;;
  --base_repo)
      base_repo="$2"
      shift
      ;;
  --head_ref)
    head_ref="$2"
    shift
    ;;
  --head_repo_url)
      head_repo_url="$2"
      shift
      ;;
  --head_repo_name)
      head_repo_name="$2"
      shift
      ;;
  --image_tag)
    image_tag="$2"
    shift
    ;;
  --generation_config)
    generation_config="$2"
    shift
    ;;
  *)
    echo "Invalid option: [$1]"
    exit 1
    ;;
esac
shift
done

if [ -z "${base_ref}" ]; then
  echo "missing required argument --base_ref"
  exit 1
fi

if [ -z "${base_repo}" ]; then
  echo "missing required argument --base_repo"
  exit 1
fi

if [ -z "${head_ref}" ]; then
  echo "missing required argument --head_ref"
  exit 1
fi

if [ -z "${head_repo_url}" ]; then
  echo "missing required argument --head_repo_url"
  exit 1
fi

if [ -z "${head_repo_name}" ]; then
  echo "missing required argument --head_repo_name"
  exit 1
fi

if [ -z "${image_tag}" ]; then
  echo "missing required argument --image_tag"
  exit 1
fi

if [ -z "${generation_config}" ]; then
  generation_config=generation_config.yaml
  echo "Use default generation config: ${generation_config}"
fi

fork="forked-repo"
workspace_name="/workspace"
baseline_generation_config="baseline_generation_config.yaml"
message="chore: generate libraries at $(date)"

git checkout "${base_ref}"
if [[ "${head_repo_name}" == "${base_repo}" ]]; then
    git checkout "${head_ref}"
else
    echo "The pull request comes from a forked repository: ${head_repo_url}"
    git remote add "${fork}" "${head_repo_url}"
    git fetch "${fork}"
    git checkout -b "${head_ref}" "${fork}/${head_ref}"
    git branch --set-upstream-to="${fork}/${head_ref}"
fi
# if the last commit doesn't contain changes to generation configuration,
# do not generate again as the result will be the same.
contains_config_change=$(git diff-tree --no-commit-id --name-only HEAD~1..HEAD -r | grep "${generation_config}")
if [[ "${contains_config_change}" == "" ]]; then
    echo "The last commit doesn't contain any changes to the generation_config.yaml, skipping the whole generation process."
    exit 0
fi
# copy generation configuration from target branch to current branch.
git show "${base_ref}":"${generation_config}" > "${baseline_generation_config}"
config_diff=$(diff "${generation_config}" "${baseline_generation_config}")
# run hermetic code generation docker image.
docker run \
  --rm \
  -u "$(id -u):$(id -g)" \
  -v "$(pwd):${workspace_name}" \
  gcr.io/cloud-devrel-public-resources/java-library-generation:"${image_tag}" \
  --baseline-generation-config-path="${workspace_name}/${baseline_generation_config}" \
  --current-generation-config-path="${workspace_name}/${generation_config}"
# commit the change to the pull request.
git add java-* pom.xml gapic-libraries-bom/pom.xml versions.txt
changed_files=$(git diff --cached --name-only)
if [[ "${changed_files}" == "" ]]; then
    echo "There is no generated code change with the generation config change ${config_diff}."
    echo "Skip committing to the pull request."
    exit 0
fi

echo "Configuration diff:"
echo "${config_diff}"
git commit -m "${message}"
git push
# set pr body if pr_description.txt is generated.
if [[ -f "pr_description.txt" ]]; then
  pr_num=$(gh pr list -s open -H "${head_ref}" -q . --json number | jq ".[] | .number")
  gh pr edit "${pr_num}" --body "$(cat pr_description.txt)"
fi
