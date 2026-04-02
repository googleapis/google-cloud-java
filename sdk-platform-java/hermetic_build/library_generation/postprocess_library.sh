#!/bin/bash
#
# Main functions to interact with owlbot post-processor

# Runs the java owlbot post-processor. The resulting post-processed
# library gets stored in the $postprocessing_target argument
# Arguments
# 1 - postprocessing_target: path where the postprocessor will run. This folder
# has the following requirements
#   -  a .repo-metadata.json file must be present
#   -  an owlbot.py file must be present
#   -  an .OwlBot-hermetic.yaml file must be present
# 2 - preprocessed_sources_path: used to transfer the raw grpc, proto and gapic
# libraries into the postprocessing_target via copy-code
# 3 - versions_file: path to file containing versions to be applied to the poms
# 4 - owlbot_cli_source_folder: alternative folder with a structure exactly like
# googleapis-gen. It will be used instead of preprocessed_sources_path if
# 5 - is_monorepo: whether this library is a monorepo, which implies slightly
# different logic
# 6 - libraries_bom_version: used by our implementation of owlbot to render the
# readme
# 7 - library_version: used by our implementation of owlbot to render the
# readme
set -exo pipefail
scripts_root=$(dirname "$(readlink -f "$0")")

postprocessing_target=$1
preprocessed_sources_path=$2
versions_file=$3
owlbot_cli_source_folder=$4
is_monorepo=$5
libraries_bom_version=$6
library_version=$7
owlbot_yaml_file_name=".OwlBot-hermetic.yaml"

source "${scripts_root}"/utils/utilities.sh

declare -a required_inputs=("postprocessing_target" "versions_file" "is_monorepo")
for required_input in "${required_inputs[@]}"; do
  if [[ -z "${!required_input}" ]]; then
    echo "missing required ${required_input} argument, please specify one"
    exit 1
  fi
done

for owlbot_file in ".repo-metadata.json" "owlbot.py" "${owlbot_yaml_file_name}"
do
  if [[ $(find "${postprocessing_target}" -name "${owlbot_file}" | wc -l) -eq 0 ]]; then
    echo "necessary file for postprocessing '${owlbot_file}' was not found in postprocessing_target"
    echo "please provide a postprocessing_target folder that is compatible with the OwlBot Java postprocessor"
    exit 1
  fi
done

if [[ -z "${owlbot_cli_source_folder}" ]]; then
  owlbot_cli_source_folder=$(mktemp -d)
  build_owlbot_cli_source_folder "${postprocessing_target}" "${owlbot_cli_source_folder}" "${preprocessed_sources_path}"
fi


# we determine the location of the .OwlBot-hermetic.yaml file by checking if the target
# folder is a monorepo folder or not
if [[ "${is_monorepo}" == "true" ]]; then
  # the deep-remove-regex and deep-preserve-regex of the .OwlBot-hermetic.yaml
  # files in the monorepo libraries assume that `copy-code` is run
  # from the root of the monorepo. However, we call `copy-code` from inside each
  # library, so a path like `/java-asset/google-.*/src` will not have
  # any effect. We solve this by creating a temporary owlbot yaml with
  # the patched paths.
  # For example, we convert 
  # - "/java-asset/google-.*/src"
  # to
  # - "/google-.*/src"

  library_name=$(basename "${postprocessing_target}")
  cat "${postprocessing_target}/${owlbot_yaml_file_name}" \
    | sed "s/- \"\/${library_name}/ - \"/" \
    > "${postprocessing_target}/.OwlBot.hermetic.yaml"
  owlbot_yaml_relative_path=".OwlBot.hermetic.yaml"
else
  owlbot_yaml_relative_path=".github/${owlbot_yaml_file_name}"
fi

# Default values for running copy-code directly from host
repo_workspace="/workspace"
preprocessed_libraries_binding="${owlbot_cli_source_folder}"

pushd "${postprocessing_target}"

owl-bot copy-code \
  --source-repo-commit-hash=none \
  --source-repo="${owlbot_cli_source_folder}" \
  --config-file="${owlbot_yaml_relative_path}"


# clean the custom owlbot yaml
if [[ "${is_monorepo}" == "true" ]]; then
  rm "${postprocessing_target}/.OwlBot.hermetic.yaml"
fi

# run the postprocessor
echo 'running owl-bot post-processor'
pushd "${postprocessing_target}"
bash "${scripts_root}/owlbot/bin/entrypoint.sh" \
  "${scripts_root}" \
  "${versions_file}" \
  "${is_monorepo}" \
  "${libraries_bom_version}" \
  "${library_version}"

popd # postprocessing_target
