#!/bin/bash

set -e

GENERATION_DIR=$(dirname -- "$0");

# Find all Maven modules (a directory that contains pom.xml)
modules=$(find . -mindepth 2 -maxdepth 2 -name pom.xml |sort | xargs dirname \
    |sed -e 's|./||' | xargs -I '{}' echo "    <module>{}</module>")

awk -v MODULES="${modules}" '1;/<modules>/{print MODULES}' "${GENERATION_DIR}/parent.pom.xml"
