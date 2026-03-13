#!/bin/sh
# This script generates showcase in a temporary/untracked folder and compares
# its contents with the actual showcase libraries. 

set -oxe
readonly SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
readonly ROOT_DIR="${SCRIPT_DIR}/../.."
source "${SCRIPT_DIR}/showcase_utilities.sh"
readonly SHOWCASE_DIR="${SCRIPT_DIR}/.."

# generate sources
bash "${SCRIPT_DIR}/generate_showcase.sh" --replace "false"

generated_library_location=$(cat "${ROOT_DIR}/generated-showcase-location")

# compare library
diff -ru "${SHOWCASE_DIR}/" "${generated_library_location}"

cleanup $SCRIPT_DIR
