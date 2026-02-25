#!/bin/bash
# Copyright 2026 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -eo pipefail

# This script is intended to be run from the root of the google-cloud-java repository.
# It evaluates the effective formatting plugin versions to see if they bumped, and if
# they did not, it targets the 'fmt' and 'checkstyle' maven targets to only the modules
# containing modified .java files.

source .kokoro/common.sh

if [ -n "${BASE_SHA}" ] && [ -n "${HEAD_SHA}" ]; then
    # Check if fmt-maven-plugin or checkstyle version changed
    # Extract the effective versions from the maven reactor at BASE_SHA and HEAD_SHA
    git checkout "${BASE_SHA}"
    fmt_base=$(mvn help:evaluate -Dexpression=project.pluginManagement.plugins -q -DforceStdout | grep -A 2 "fmt-maven-plugin" | grep "<version>" || true)
    checkstyle_base=$(mvn help:evaluate -Dexpression=project.pluginManagement.plugins -q -DforceStdout | grep -A 2 "maven-checkstyle-plugin" | grep "<version>" || true)

    git checkout "${HEAD_SHA}"
    fmt_head=$(mvn help:evaluate -Dexpression=project.pluginManagement.plugins -q -DforceStdout | grep -A 2 "fmt-maven-plugin" | grep "<version>" || true)
    checkstyle_head=$(mvn help:evaluate -Dexpression=project.pluginManagement.plugins -q -DforceStdout | grep -A 2 "maven-checkstyle-plugin" | grep "<version>" || true)

    if [ "${fmt_base}" != "${fmt_head}" ] || [ "${checkstyle_base}" != "${checkstyle_head}" ]; then
        echo "Formatter or Checkstyle plugin versions changed. Formatting entire repository."
        projects_arg=""
    else
        changed_file_list=$(git diff --name-only "${BASE_SHA}" "${HEAD_SHA}")
        echo "Changed files between ${BASE_SHA} and ${HEAD_SHA}:"
        echo "${changed_file_list}"

        modified_module_list=()
        has_code_change="false"

        # Generate the list of valid maven modules
        maven_modules_list=$(mvn help:evaluate -Dexpression=project.modules -q -DforceStdout | grep '<.*>.*</.*>' | sed -e 's/<.*>\(.*\)<\/.*>/\1/g' || true)
        maven_modules=(${maven_modules_list[*]})

        while IFS= read -r changed_file; do
            # Checks if the line is not empty AND if it matches a .java file
            if [ -n "${changed_file}" ] && [[ "${changed_file}" == *.java ]]; then
                has_code_change="true"
                module=$(echo "${changed_file}" | cut -d '/' -f1)
                if [[ " ${maven_modules[*]} " =~ " ${module} " ]]; then
                    # Add module if it's not already in the list
                    if [[ ! " ${modified_module_list[*]} " =~ " ${module} " ]]; then
                       modified_module_list+=("${module}")
                    fi
                fi
            fi
        done <<< "${changed_file_list}"

        if [ "${has_code_change}" == "false" ]; then
            echo "No java modules affected. Skipping linter check."
            exit 0
        fi

        if [[ ${#modified_module_list[@]} -gt 0 ]]; then
            module_list=$(IFS=,; echo "${modified_module_list[*]}")
            parse_all_submodules "$module_list"
            projects_arg="--projects $all_submodules"
            echo "Running targeted format on module sub-reactor: $all_submodules"
        else
            echo "Could not resolve valid modules to format for java changes. Formatting entire repository."
            projects_arg=""
        fi
    fi
else
    echo "BASE_SHA or HEAD_SHA is empty. Skipping file difference check."
    projects_arg=""
fi

mvn -B -ntp \
    -T 1.5C \
    ${projects_arg:-} \
    com.spotify.fmt:fmt-maven-plugin:check
mvn -B -ntp ${projects_arg:-} checkstyle:check@checkstyle
