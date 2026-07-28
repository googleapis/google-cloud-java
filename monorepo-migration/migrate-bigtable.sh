#!/bin/bash
# Copyright 2026 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Exit on error
set -e

# Get absolute paths
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
MONOREPO_ROOT="$(dirname "$SCRIPT_DIR")"

echo "========================================================"
echo " Staging java-bigtable migration"
echo "========================================================"

# 1. Configure environment for the base migrate.sh script
export SOURCE_REPO_URL="https://github.com/googleapis/java-bigtable"
export MIGRATION_HEAD_BRANCH="main"
export SQUASH_COMMITS="false"
export CODEOWNER="@googleapis/bigtable-team" 
export BOM_SUBSTITUTIONS="gapic-libraries-bom:google-cloud-monitoring-bom" 
export PRE_INSTALL_DEPS="java-monitoring/google-cloud-monitoring-bom,java-monitoring/google-cloud-monitoring" 

# 2. Execute the central migration script
"${SCRIPT_DIR}/migrate.sh"

echo ""
echo "========================================================"
echo "Migration staged successfully!"
echo "Results are available in the isolated clone:"
echo "  migration-work/google-cloud-java-target"
echo "Current Branch: migrate-java-bigtable"
echo "Next Steps: cd migration-work/google-cloud-java-target && mvn clean install -DskipTests"
echo "========================================================"
