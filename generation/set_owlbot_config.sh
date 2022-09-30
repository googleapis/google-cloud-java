#!/bin/bash

# Adds module directory name into the paths in a OwlBot configuration file so
# that the paths correctly reference the files under the modules in this monorepo.
#
# Usage:
# set_owlbot_config.sh <.OwlBot.yaml path from the root>
# Example:
# $ set_owlbot_config.sh java-dataform/.OwlBot.yaml
#
# To apply the change to all OwlBot configuration files in all modules:
# $ for F in `find . -maxdepth 2 -name '.OwlBot.yaml'`; do sh generation/set_owlbot_config.sh $F; done
OWLBOT_FILE=$1

if [ -z "${OWLBOT_FILE}" ]; then
  echo "Please specify file name"
  exit 1
fi

if [ ! -r "${OWLBOT_FILE}" ]; then
  echo "File not found"
  exit 1
fi

dir_name=$(dirname "${OWLBOT_FILE}")
module_name=$(basename "${dir_name}")

if [ ! -d "${module_name}" ]; then
  echo "module ${module_name} does not exist"
  exit 1
fi

# For deep-remove-regex and deep-preserve-regex fields
sed -i.bak "s|\"/grpc-google|\"/${module_name}/grpc-google|" "${OWLBOT_FILE}" && rm "${OWLBOT_FILE}".bak
sed -i.bak "s|\"/proto-google|\"/${module_name}/proto-google|" "${OWLBOT_FILE}" && rm "${OWLBOT_FILE}".bak
sed -i.bak "s|\"/google-\.\*|\"/${module_name}/google-.*|" "${OWLBOT_FILE}" && rm "${OWLBOT_FILE}".bak
sed -i.bak "s|\"/google-cloud|\"/${module_name}/google-cloud|" "${OWLBOT_FILE}" && rm "${OWLBOT_FILE}".bak
sed -i.bak "s|\"/samples|\"/${module_name}/samples|" "${OWLBOT_FILE}" && rm "${OWLBOT_FILE}".bak

# In monorepo, the staging directory structure tells the destination module to
# which the OwlBot Java postprocessor copies the files.
if grep --quiet 'owl-bot-staging/$1' "${OWLBOT_FILE}"; then
  sed -i.bak "s|owl-bot-staging|owl-bot-staging/${module_name}|" "${OWLBOT_FILE}" && rm "${OWLBOT_FILE}".bak
fi
