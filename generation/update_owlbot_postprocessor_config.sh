#!/bin/bash

# For each module:
# Removes and excludes all OwlBot Post-Processor templates (https://github.com/googleapis/synthtool/tree/master/synthtool/gcp/templates/java_library),
# except for README.md

set -e

for dir in $(find . -mindepth 2 -maxdepth 2 -name owlbot.py | sort | xargs dirname ); do
  pushd "$dir"

  # form a perl command to replace java.common_templates() invocation
  perl_command='s/java\.common_templates\(.*\)/java.common_templates(excludes=['
  comma=""
  for exclusion in '.github/*' '.kokoro/*' 'samples/*' 'CODE_OF_CONDUCT.md' 'CONTRIBUTING.md' 'LICENSE' 'SECURITY.md' 'java.header' 'license-checks.xml' 'renovate.json'; do
    perl_command+="${comma}\n    $(echo "\"${exclusion}\"" | sed 's/\//\\\//g')"
    comma=","

    # delete files and directories
    if [[ ${exclusion: -2} == '/*' && ${exclusion%??} != 'samples' ]]; then
      rm -rf "${exclusion%??}" || true
    else
      rm "${exclusion}" || true
    fi
  done
  perl_command+='\n])/s'
  # execute the replacement in owlbot.py
  perl -0pe "$perl_command" 'owlbot.py' > 'owlbot.py.new' && rm 'owlbot.py' && mv 'owlbot.py.new' 'owlbot.py'

  popd

done
