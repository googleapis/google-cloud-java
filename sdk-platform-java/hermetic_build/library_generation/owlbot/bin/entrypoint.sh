#!/bin/bash
# Copyright 2023 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# This is the entrypoint script for java owlbot. This is not intended to be
# called directly but rather be called from postproces_library.sh
# For reference, the positional arguments are
# 1: scripts_root: location of the root of the library_generation scripts. When
# in a Docker container, this value should be /src/
# 2: versions_file: points to a versions.txt containing versions to be applied
# both to README and pom.xml files
# 3: is_monorepo: whether we are postprocessing a monorepo
# 4: libraries_bom_version: used to render the readme
# 5: library_version: used to render the readme

# The scripts assumes the CWD is the folder where postprocessing is going to be
# applied

set -ex
scripts_root=$1
versions_file=$2
is_monorepo=$3
libraries_bom_version=$4
library_version=$5

if [[ "${is_monorepo}" == "true" ]]; then
  mv owl-bot-staging/* temp
  rm -rf owl-bot-staging/
  mv temp owl-bot-staging
fi

# templates as well as retrieving files from owl-bot-staging
echo "Retrieving files from owl-bot-staging directory..."
if [ -f "owlbot.py" ]
then
  # we copy the templates to a temp folder because we need to do a special
  # modification regarding libraries_bom_version that can't be handled by the
  # synthtool library considering the way owlbot.py files are written
  export SYNTHTOOL_TEMPLATES="${scripts_root}/owlbot/templates"
  export SYNTHTOOL_LIBRARIES_BOM_VERSION="${libraries_bom_version}"
  export SYNTHTOOL_LIBRARY_VERSION="${library_version}"
  # defaults to run owlbot.py
  python3 owlbot.py
  unset SYNTHTOOL_TEMPLATES
  unset SYNTHTOOL_LIBRARIES_BOM_VERSION
  unset SYNTHTOOL_LIBRARY_VERSION
fi
echo "...done"

# write or restore pom.xml files
echo "Generating missing pom.xml..."
python3 "${scripts_root}/owlbot/src/fix_poms.py" "${versions_file}" "${is_monorepo}"
echo "...done"

# write or restore clirr-ignored-differences.xml
echo "Generating clirr-ignored-differences.xml..."
"${scripts_root}"/owlbot/bin/write_clirr_ignore.sh "${scripts_root}"
echo "...done"

# fix license headers
echo "Fixing missing license headers..."
python3 "${scripts_root}/owlbot/src/fix-license-headers.py"
echo "...done"

echo "Reformatting source..."
"${scripts_root}"/owlbot/bin/format_source.sh "${scripts_root}"
echo "...done"
