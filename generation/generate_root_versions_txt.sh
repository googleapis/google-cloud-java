#!/bin/bash

# This script adds the contents of a module's versions.txt to root versions.txt and then deletes it.
# This should be run during addition of a new-module to the monorepo

set -e

GENERATION_DIR=$(dirname -- "$0")

module_list=$(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort --dictionary-order |xargs dirname)

for path in $module_list; do
  FILE=${path}/versions.txt
  if [ -f ${FILE} ]; then
    cat ${path}/versions.txt | while read LINE; do
      if ! [[ $LINE == *"#"* ]] && [ "$LINE" != "" ]; then
        echo $LINE >> versions.txt
      fi
    done
  fi
  rm -f ${FILE}
done

