#!/bin/bash
# Generates the showcase library using librarian.
set -ex

echo "******** Generating Showcase ********"

trap cleanup ERR

readonly ROOT_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )/../.."
pushd "${ROOT_DIR}"
source "${ROOT_DIR}/java-showcase/scripts/showcase_utilities.sh"

cleanup() {
  if [[ -n "${generated_files_dir}" && "${replace}" != "true" ]]; then
    rm -rf "${generated_files_dir}"
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

if command -v librarian &> /dev/null; then
  LIBRARIAN_CMD="librarian"
else
  LIBRARIAN_CMD="go run github.com/googleapis/librarian/cmd/librarian@latest"
fi

if [[ "${replace}" == "true" ]]; then
  echo "generating showcase in place"
  $LIBRARIAN_CMD generate showcase
else
  export generated_files_dir=$(mktemp -d)
  echo "Temp generation directory: ${generated_files_dir}"
  
  # store the generated library location for verify.sh
  echo "${generated_files_dir}/java-showcase" > "${ROOT_DIR}/generated-showcase-location"
  
  # Symlink all contents of root directory except java-showcase and librarian.yaml
  for item in "${ROOT_DIR}"/*; do
    name=$(basename "$item")
    if [[ "$name" != "java-showcase" && "$name" != "librarian.yaml" ]]; then
      ln -s "$item" "${generated_files_dir}/${name}"
    fi
  done
  
  # Copy librarian.yaml and java-showcase to the temp directory
  cp -r "${ROOT_DIR}/librarian.yaml" "${ROOT_DIR}/java-showcase" "${generated_files_dir}/"
  
  # Convert local paths in librarian.yaml to absolute paths
  sed -i "s|local_path: sdk-platform-java|local_path: ${ROOT_DIR}/sdk-platform-java|g" "${generated_files_dir}/librarian.yaml"
  
  # Run librarian generate from the temp workspace
  pushd "${generated_files_dir}"
  $LIBRARIAN_CMD generate showcase
  popd
fi

echo "generated showcase library"
