#!/bin/bash

set -e

GENERATION_DIR=$(dirname -- "$0");

# Find all Maven modules (a directory that contains pom.xml)
find . -mindepth 2 -maxdepth 2 -name pom.xml |sort --dictionary-order | xargs dirname \
    |sed -e 's|./||' | xargs -I '{}' echo "    <module>{}</module>" > /tmp/repo-modules.txt

sed -i.bak '/java-maps/d' /tmp/repo-modules.txt

awk -v MODULES="`awk -v ORS='\\\\n' '1' /tmp/repo-modules.txt`" '1;/<modules>/{print MODULES}' ${GENERATION_DIR}/parent.pom.xml
