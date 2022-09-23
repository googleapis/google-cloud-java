#!/bin/bash

set -e

modules=$(mvn help:evaluate -Dexpression=project.modules | grep '<.*>.*</.*>' | sed -e 's/<.*>\(.*\)<\/.*>/\1/g' | grep 'java')

for module in "${modules[@]}"; do
  rm -rf "${module}"
  git clone "https://github.com/googleapis/${module}"
  rm -rf "${module}/.git"
  ./delete_non_generated_samples.sh
done