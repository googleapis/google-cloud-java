#!/bin/bash

# Usage:
# set_owlbot_config.sh <.OwlBot.yaml path from the root>
# set_owlbot_config.sh java-dataform/.OwlBot.yaml

OWLBOT_FILE=$1

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
sed -i "s|\"/grpc-google|\"/${module_name}/grpc-google|" "${OWLBOT_FILE}"
sed -i "s|\"/proto-google|\"/${module_name}/proto-google|" "${OWLBOT_FILE}"
sed -i "s|\"/google-\.\*|\"/${module_name}/google-.*|" "${OWLBOT_FILE}"
sed -i "s|\"/samples|\"/${module_name}/samples|" "${OWLBOT_FILE}"
