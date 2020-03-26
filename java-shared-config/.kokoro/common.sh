#!/bin/bash
# Copyright 2020 Google LLC
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

# set -eo pipefail

function retry_with_backoff {
    attempts_left=$1
    sleep_seconds=$2
    shift 2
    command=$@

    echo "${command}"
    ${command}
    exit_code=$?

    if [[ $exit_code == 0 ]]
    then
        return 0
    fi

    # failure
    if [[ ${attempts_left} > 0 ]]
    then
        echo "failure (${exit_code}), sleeping ${sleep_seconds}..."
        sleep ${sleep_seconds}
        new_attempts=$((${attempts_left} - 1))
        new_sleep=$((${sleep_seconds} * 2))
        retry_with_backoff ${new_attempts} ${new_sleep} ${command}
    fi

    return $exit_code
}
