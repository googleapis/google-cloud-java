#!/bin/bash

# This script generates a maven command to test unit and integration tests for
# the repo. The outputted maven command will be in the rough following format
# `mvn verify ... -D{dependency.name}.version={dependency.version]`. The variables
# ${dependency.name} and ${dependency.version} are parsed from the input to the script.
#
# Default invocation ./.github/scripts/test_dependency_compatibility.sh will use the default
# upper-bounds dependency file at the root of the repo.
# There are two potential inputs to the script:
# 1. -f {file}: Custom file/path for the upper-bound dependencies to test
# 2. -l {deps_list}: Comma-separated list of dependencies to test (e.g. protobuf=4.31.0,guava=33.4.8-jre)
# Note: Do not include the `-D` prefix or `.version` suffix. Those values will be appended when generating
# the maven command.
#
# If both inputs are supplied, the deps_list input has precedence. For Github Actions workflow,
# the default workflow will run with the upper-bounds file. A `workflow_dispatch` option takes in
# an input for the deps_list to manually run a subset of dependencies.
#
# The default upper-bound dependencies file is `dependencies.txt` located in the root
# of sdk-platform-java. See the upper-bound dependencies file for the dependency format.

set -ex

function print_help() {
  echo "Unexpected input argument for this script."
  echo "Use -f {file} for the directory of the upper-bound dependencies file."
  echo "Use -l {deps_list} for a comma-separated list of dependencies to test (Format: dep1=1.0,dep2=2.0)"
}

# Default to the upper bounds file in the root of the repo
file='dependencies.txt'
dependency_list=''

# The colon (:) after the letter means that there is an input associated with the flag
while getopts 'f:l:' flag; do
  case "${flag}" in
    f) file="${OPTARG}" ;;
    l) dependency_list="${OPTARG}" ;;
    *) print_help && exit 1
  esac
done

# Error if both the file and deps_list inputs is empty
if [[ -z "${file}" && -z "${dependency_list}" ]]; then
  print_help && exit 1
fi

MAVEN_COMMAND="mvn -ntp -B verify -Penable-integration-tests -Dclirr.skip -Dcheckstyle.skip -Dfmt.skip -Denforcer.skip"

# Check if a list of dependencies was provided as an argument. If the list of dependency inputted
# is empty, then run with the upper-bound dependencies file
if [ -z "${dependency_list}" ]; then
  UPPER_BOUND_DEPENDENCY_FILE=$file

  if [ ! -e "${UPPER_BOUND_DEPENDENCY_FILE}" ]; then
    echo "The inputted upper-bound dependency file '${UPPER_BOUND_DEPENDENCY_FILE}' cannot be found"
    exit 1
  fi

  # Read the file line by line
  while IFS= read -r line; do
    # Ignore any comments and blank lines
    if [[ "${line}" =~ ^[[:space:]]*# ]] || [[ -z "${line}" ]]; then
      continue
    fi
    # Format from `dependencies.txt`: {GroupID}:{ArtifactID},{PropertyName}={Version}
    propertyVersion=$(echo "${line}" | cut -d',' -f2)
    dependency=$(echo "${propertyVersion}" | cut -d'=' -f1)
    version=$(echo "${propertyVersion}" | cut -d'=' -f2)
    MAVEN_COMMAND+=" -D${dependency}.version=${version}"
  done < "${UPPER_BOUND_DEPENDENCY_FILE}"
else # This else block means that a list of dependencies was inputted
  # Set the Internal Field Separator (IFS) to a comma.
  # This tells 'read' to split the string by commas into an array named DEPS.
  # The 'read -ra' command reads the input into an array.
  IFS=',' read -ra DEPS <<< "${dependency_list}"

  # Loop through each item in the DEPS array.
  for DEP_PAIR in "${DEPS[@]}"; do
    # Skip any empty items that might result from trailing commas.
    if [ -z "${DEP_PAIR}" ]; then
      continue
    fi
    # Format: {MavenPropertyName}={Version}
    dependency=$(echo "${DEP_PAIR}" | cut -d'=' -f1)
    version=$(echo "${DEP_PAIR}" | cut -d'=' -f2)
    MAVEN_COMMAND+=" -D${dependency}.version=${version}"
  done
fi

# Run the generated maven command to test with the dependency versions
$MAVEN_COMMAND
