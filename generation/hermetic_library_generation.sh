#!/bin/bash
# This script should be run at the root of the repository.
# This script is used to, when a pull request changes the generation
# configuration (generation_config.yaml by default):
# 1. compare generation configurations in the current branch (with which the
# pull request associated) and target branch (into which the pull request is
# merged);
# 2. generate changed libraries using library_generation image;
# 3. commit the change to the pull request
# 4. edit the pr body with generated pull request description, if applicable.

# The following commands need to be installed before running the script:
# 1. git
# 2. gh
# 3. docker

# The parameters of this script is:
# 1. target_branch, the branch into which the pull request is merged.
# 2. current_branch, the branch with which the pull request is associated.
# 3. image_tag, the tag of gcr.io/cloud-devrel-public-resources/java-library-generation.
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

if [ -z "${target_branch}" ]; then
  echo "missing required argument --target_branch"
  exit 1
fi

if [ -z "${current_branch}" ]; then
  echo "missing required argument --current_branch"
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

volume_name="repo"
workspace_name="/workspace/repo"
repo_volumes="${volume_name}:${workspace_name}"
baseline_generation_config="baseline_generation_config.yaml"
message="chore: generate libraries at $(date)"

git checkout "${target_branch}"
git checkout "${current_branch}"
# copy generation configuration from target branch to current branch.
git show "${target_branch}":"${generation_config}" > "${baseline_generation_config}"
diff "${generation_config}" "${baseline_generation_config}" || echo "config diff"
# bind docker volume to include the repository in docker running environment.
if [[ $(docker volume inspect ${volume_name}) != '[]' ]]; then
  docker volume rm ${volume_name}
fi
docker volume create \
  --name ${volume_name} \
  --opt "type=none" \
  --opt "device=$(pwd)" \
  --opt "o=bind"
# run hermetic code generation docker image.
docker run \
  --rm \
  -v "${repo_volumes}" \
  -v /tmp:/tmp \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -e "RUNNING_IN_DOCKER=true" \
  -e "REPO_BINDING_VOLUMES=-v ${repo_volumes}" \
  gcr.io/cloud-devrel-public-resources/java-library-generation:"${image_tag}" \
  python /src/cli/entry_point.py generate \
  --baseline-generation-config-path="${workspace_name}/${baseline_generation_config}" \
  --current-generation-config-path="${workspace_name}/${generation_config}" \
  --repository-path="${workspace_name}"
# commit the change to the pull request.
git add java-* pom.xml gapic-libraries-bom/pom.xml versions.txt "${generation_config}"
git commit --allow-empty -m "${message}"
git push
# set pr body if pr_description.txt is generated.
if [[ -f "pr_description.txt" ]]; then
  pr_num=$(gh pr list -s open -H "${current_branch}" -q . --json number | jq ".[] | .number")
  gh pr edit "${pr_num}" --body "$(cat pr_description.txt)"
fi
