#!/bin/bash
# Copyright 2023 Google LLC
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

commonScriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")

# In the given directory ($1),
#   update the pom.xml's dependency on the given artifact ($2) to the given version ($3)
# ex: update_dependency google-cloud-java/google-cloud-jar-parent google-cloud-shared-dependencies 1.2.3
function update_pom_dependency {
  pushd "$1" || exit 1
  xmllint --shell pom.xml &>/dev/null <<EOF
setns x=http://maven.apache.org/POM/4.0.0
cd .//x:artifactId[text()="$2"]
cd ../x:version
set $3
save pom.xml
EOF
  popd || exit 1
}

# Find all pom.xml files that declare a specific version for the given artifact ($1)
function find_all_poms_with_versioned_dependency {
  poms=($(find . -name pom.xml))
  for pom in "${poms[@]}"; do
    if xmllint --xpath "//*[local-name()='artifactId' and text()='$1']/following-sibling::*[local-name()='version']" "$pom" &>/dev/null; then
      found+=("$pom")
    fi
  done
  POMS=(${found[@]})
  unset found
  export POMS
}

# In the given directory ($1),
#   find and update all pom.xmls' dependencies on the given artifact ($2) to the given version ($3)
# ex: update_all_poms_dependency google-cloud-java google-cloud-shared-dependencies 1.2.3
function update_all_poms_dependency {
  pushd "$1" || exit 1
  find_all_poms_with_versioned_dependency "$2"
  for pom in $POMS; do
    update_pom_dependency "$(dirname "$pom")" "$2" "$3"
  done
  git diff
  popd || exit 1
}

# Parse the version of the pom.xml file in the given directory ($1)
# ex: VERSION=$(parse_pom_version java-shared-dependencies)
function parse_pom_version {
  # Namespace (xmlns) prevents xmllint from specifying tag names in XPath
  result=$(sed -e 's/xmlns=".*"//' "$1/pom.xml" | xmllint --xpath '/project/version/text()' -)

  if [ -z "${result}" ]; then
    echo "Version is not found in $1"
    exit 1
  fi
  echo "$result"
}

# ex: find_last_release_version java-bigtable
# ex: find_last_release_version java-storage 2.22.x
function find_last_release_version {
  repo=$1
  branch=${2-"main"} # Default to using main branch
  org=${3-"googleapis"}
  curl -s -o "versions_${repo}.txt" "https://raw.githubusercontent.com/${org}/${repo}/${branch}/versions.txt"

  # First check to see if there's an entry for the overall repo. Used for google-cloud-java.
  primary_artifact=$(grep -E "^${repo}" "versions_${repo}.txt" | head -n 1)
  if [ -z "${primary_artifact}" ]; then
    # Otherwise, use the first google-cloud-* artifact's version.
    primary_artifact=$(grep -E "^google-cloud-" "versions_$1.txt" | head -n 1)
  fi
  if [ -z "${primary_artifact}" ]; then
    echo "Unable to identify primary artifact for $1"
    exit 1
  fi

  parts=($(echo "$primary_artifact" | tr ":" "\n"))
  echo "${parts[1]}"
}

# copies settings.xml from the root of sdk-platform-java into Maven's home
# folder
function setup_maven_mirror {
  echo "Setup maven mirror"
  mkdir -p "${HOME}/.m2"
  cp "${commonScriptDir}/../../settings.xml" "${HOME}/.m2"
}

function install_repo_modules {
  target_projects="$1"
  projects_arg=""
  if [ -n "${target_projects}" ]; then
    projects_arg="--projects ${target_projects}"
  fi
  echo "Installing this repo's modules to local maven."
  mvn -q -B -ntp install ${projects_arg} \
    -Dcheckstyle.skip -Dfmt.skip -DskipTests -T 1C
}
