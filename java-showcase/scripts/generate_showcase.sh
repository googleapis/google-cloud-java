#!/bin/bash
# Generates the showcase library using librarian.
set -ex

echo "******** Generating Showcase ********"

readonly ROOT_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )/../.."
# Export PYTHONPATH so that owlbot.py scripts run by Librarian
# can resolve local synthtool under the hermetic build directory.
export PYTHONPATH="${ROOT_DIR}/sdk-platform-java/hermetic_build/library_generation/owlbot"
cd "${ROOT_DIR}"

readonly LIBRARIAN_VER=$(go run github.com/googleapis/librarian/cmd/librarian@latest config get version)
readonly LIBRARIAN_CMD="go run github.com/googleapis/librarian/cmd/librarian@${LIBRARIAN_VER}"

echo "generating showcase in place"
$LIBRARIAN_CMD generate showcase

echo "generated showcase library"
