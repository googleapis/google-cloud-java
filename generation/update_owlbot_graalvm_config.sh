#!/bin/bash

# Adds module directory name into the paths in a OwlBot configuration file so
# that the paths correctly reference the files under the modules in this monorepo.
#
# Usage:
# update_owlbot_graalvm_config.sh <.OwlBot.yaml path from the root>
# Example:
# $ update_owlbot_graalvm_config.sh java-dataform/.OwlBot.yaml
#
# To apply the change to all OwlBot configuration files in all modules:
# $ for F in `find . -maxdepth 2 -name '.OwlBot.yaml'`; do sh generation/update_owlbot_graalvm_config.sh $F; done
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

main_config="/${module_name}/google-.*/src/main/resources/META-INF/native-image/*"
test_config="/${module_name}/google-.*/src/test/resources/META-INF/native-image/*"

yq_query=".\"deep-preserve-regex\" += [\"${main_config}\",\"${test_config}\"]"

new_config=$(cat "${OWLBOT_FILE}" | yq -y "${yq_query}" --sort-keys)

mv "${OWLBOT_FILE}" "${dir_name}/temp.yaml"
touch "${OWLBOT_FILE}"
printf "# Copyright 2022 Google LLC\n\
#\n\
# Licensed under the Apache License, Version 2.0 (the \"License\");\n\
# you may not use this file except in compliance with the License.\n\
# You may obtain a copy of the License at\n\
#\n\
#     http://www.apache.org/licenses/LICENSE-2.0\n\
#\n\
# Unless required by applicable law or agreed to in writing, software\n\
# distributed under the License is distributed on an \"AS IS\" BASIS,\n\
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n\
# See the License for the specific language governing permissions and\n\
# limitations under the License.\n" >> "${OWLBOT_FILE}"

printf "\n" >> "${OWLBOT_FILE}"

echo "${new_config}" >> "${OWLBOT_FILE}"
