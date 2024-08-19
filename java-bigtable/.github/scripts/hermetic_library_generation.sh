#!/bin/bash
set -e
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

# The following commands need to be installed before running the script:
# 1. git
# 2. gh
# 3. docker

# The parameters of this script is:
# 1. target_branch, the branch into which the pull request is merged.
# 2. current_branch, the branch with which the pull request is associated.
# 3. [optional] generation_config, the path to the generation configuration,
# the default value is generation_config.yaml in the repository root.
while [[ $# -gt 0 ]]; do
key="$1"
case "${key}" in
  --target_branch)
    target_branch="$2"
    shift
    ;;
  --current_branch)
    current_branch="$2"
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

if [ -z "${target_branch}" ]; then
  echo "missing required argument --target_branch"
  exit 1
fi

if [ -z "${current_branch}" ]; then
  echo "missing required argument --current_branch"
  exit 1
fi

if [ -z "${generation_config}" ]; then
  generation_config=generation_config.yaml
  echo "Using default generation config: ${generation_config}"
fi

workspace_name="/workspace"
baseline_generation_config="baseline_generation_config.yaml"
message="chore: generate libraries at $(date)"

git checkout "${target_branch}"
git checkout "${current_branch}"
# if the last commit doesn't contain changes to generation configuration,
# do not generate again as the result will be the same.
change_of_last_commit="$(git diff-tree --no-commit-id --name-only HEAD~1..HEAD -r)"
if [[ ! ("${change_of_last_commit}" == *"${generation_config}"*) ]]; then
    echo "The last commit doesn't contain any changes to the generation_config.yaml, skipping the whole generation process." || true
    exit 0
fi
# copy generation configuration from target branch to current branch.
git show "${target_branch}":"${generation_config}" > "${baseline_generation_config}"
config_diff=$(diff "${generation_config}" "${baseline_generation_config}" || true)

# parse image tag from the generation configuration.
image_tag=$(grep "gapic_generator_version" "${generation_config}" | cut -d ':' -f 2 | xargs)

# run hermetic code generation docker image.
docker run \
  --rm \
  -u "$(id -u):$(id -g)" \
  -v "$(pwd):${workspace_name}" \
  gcr.io/cloud-devrel-public-resources/java-library-generation:"${image_tag}" \
  --baseline-generation-config-path="${workspace_name}/${baseline_generation_config}" \
  --current-generation-config-path="${workspace_name}/${generation_config}"


# commit the change to the pull request.
if [[ $(basename $(pwd)) == "google-cloud-java" ]]; then
  git add java-* pom.xml gapic-libraries-bom/pom.xml versions.txt
else
  # The image leaves intermediate folders and files it works with. Here we remove them
  rm -rdf output googleapis "${baseline_generation_config}"
  git add --all -- ':!pr_description.txt'
fi
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
  pr_num=$(gh pr list -s open -H "${current_branch}" -q . --json number | jq ".[] | .number")
  gh pr edit "${pr_num}" --body "$(cat pr_description.txt)"
fi
