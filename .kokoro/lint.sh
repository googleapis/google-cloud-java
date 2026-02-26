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

if [ -n "${BASE_SHA}" ] && [ -n "${HEAD_SHA}" ]; then
    changed_file_list=$(git diff --name-only "${BASE_SHA}" "${HEAD_SHA}")
    echo "Changed files between ${BASE_SHA} and ${HEAD_SHA}:"
    echo "${changed_file_list}"

    modified_module_list=()
    has_code_change="false"

    while IFS= read -r changed_file; do
        if [ -n "${changed_file}" ] && [[ "${changed_file}" == *.java ]]; then
            has_code_change="true"
            module=$(echo "${changed_file}" | cut -d '/' -f1)
            # Add module if it's not already in the list
            if [[ ! " ${modified_module_list[*]} " =~ " ${module} " ]]; then
               modified_module_list+=("${module}")
            fi
        fi
    done <<< "${changed_file_list}"

    if [ "${has_code_change}" == "false" ]; then
        echo "No java modules affected. Skipping linter check."
        exit 0
    fi

    if [[ ${#modified_module_list[@]} -gt 0 ]]; then
        for module in "${modified_module_list[@]}"; do
            if [ -d "$module" ]; then
                echo "Running targeted format on module: $module"
                pushd "$module" > /dev/null
                mvn -B -ntp com.spotify.fmt:fmt-maven-plugin:check
                mvn -B -ntp checkstyle:check@checkstyle
                popd > /dev/null
            else
                echo "Module directory $module does not exist. Skipping."
            fi
        done
        exit 0
    else
        echo "Could not resolve valid modules to format for java changes. Formatting entire repository."
    fi
else
    echo "BASE_SHA or HEAD_SHA is empty. Skipping file difference check, formatting entire repository."
fi

mvn -B -ntp \
    -T 1.5C \
    com.spotify.fmt:fmt-maven-plugin:check
mvn -B -ntp checkstyle:check@checkstyle
