#!/bin/bash
# Copyright 2021 Google LLC
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

scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
cd ${scriptDir}/..

outputFile="$scriptDir/../java-cloud-bom/dashboard/target/tmp/output.txt"

if [[ "${JOB_TYPE}" == "dashboard-units-check" ]]; then
  cd java-cloud-bom/dashboard/
  echo -e "\n******************** BUILDING THE DASHBOARD ********************"
  mvn test --fail-at-end
elif [[ "${JOB_TYPE}" == "dependency-convergence-check" ]]; then
  echo -e "\n******************** BUILDING DEPENDENCIES ********************"
  mvn install -pl java-cloud-bom/tests/dependency-convergence -am -Pquick-build -DskipTests -Denforcer.skip=true
  cd java-cloud-bom/tests/dependency-convergence/
  echo -e "\n******************** RUNNING DEPENDENCY CONVERGENCE CHECK ********************"
  mvn validate --fail-at-end
else
  echo "Unknown JOB_TYPE: ${JOB_TYPE}"
  exit 1
fi
