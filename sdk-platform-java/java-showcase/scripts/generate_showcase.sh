#!/bin/bash
# Generates the showcase library using the docker image, which is built
# from the current state of the repo in order to test local changes.
set -ex

trap cleanup ERR

readonly ROOT_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )/../.."
pushd "${ROOT_DIR}"
source "${ROOT_DIR}/java-showcase/scripts/showcase_utilities.sh"

cleanup() {
  if [[ -z "${api_def_dir}" ]]; then
    rm -rf "${api_def_dir}"
  fi
  if [[ -z "${showcase_def_dir}" ]]; then
    rm -rf "${showcase_def_dir}"
  fi
}

while [[ $# -gt 0 ]]; do
key="$1"
case "${key}" in
  --replace)
    replace="$2"
    shift
    ;;
  *)
    echo "Invalid option: [$1]"
    exit 1
    ;;
esac
shift
done

if [ -z "${replace}" ]; then
  replace="false"
fi


# download api definitions from googleapis repository
googleapis_commitish=$(grep googleapis_commitish generation_config.yaml | cut -d ":" -f 2 | xargs)
api_def_dir=$(mktemp -d)
git clone https://github.com/googleapis/googleapis.git "${api_def_dir}"

pushd "${api_def_dir}"
git checkout "${googleapis_commitish}"
# for local setups, we avoid permission issues when the docker image
# performs version-dependent operations.
rm -rf ".git/"
popd

append_showcase_to_api_defs "${api_def_dir}"

echo "building docker image"
DOCKER_BUILDKIT=1 docker build --file .cloudbuild/library_generation/library_generation.Dockerfile --iidfile image-id .

if [[ "${replace}" == "true" ]]; then
  generated_files_dir="${ROOT_DIR}"
else
  export generated_files_dir=$(mktemp -d)
  # here we store the generated library location for upstream scripts to use
  # it.
  echo "${generated_files_dir}/java-showcase" > "${ROOT_DIR}/generated-showcase-location"
  # we prepare the temp folder with the minimal setup to perform an incremental
  # generation.
  pushd "${ROOT_DIR}"
  cp -r generation_config.yaml java-showcase/ versions.txt "${generated_files_dir}"
  popd #ROOT_DIR
fi

GENERATOR_VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout -pl gapic-generator-java)

echo "generating showcase"
workspace_name="/workspace"
docker run \
  --rm \
  -u "$(id -u):$(id -g)" \
  -v "${generated_files_dir}:${workspace_name}" \
  -v "${api_def_dir}:${workspace_name}/googleapis" \
  -e GENERATOR_VERSION="${GENERATOR_VERSION}" \
  "$(cat image-id)" \
  --generation-config-path="${workspace_name}/generation_config.yaml" \
  --library-names="showcase" \
  --api-definitions-path="${workspace_name}/googleapis"

echo "generated showcase library in ${generated_files_dir}"
