#!/bin/bash

# Requires bash version >= 4.

# This script updates pom.xml and other relevant files to the next version number.
# This script is meant to be run manually (not by Travis)

# Arguments (optional):
# --alpha= specifies new version for alpha modules in format
#   "major.minor.incremental.qualifier[-SNAPSHOT]",
#   for example --alpha=0.12.2-alpha-SNAPSHOT
# --beta= specifies new version for beta modules in format
#   "major.minor.incremental.qualifier[-SNAPSHOT]",
#   for example --beta=0.12.2-beta
# --ga= specifies new version for GA modules in format
#   "major.minor.incremental.qualifier[-SNAPSHOT]",
#   for example --ga=0.12.2
#
# If at least one argument is provided it means that all the other modules, which do not belong
# to the argument's qualifier(s) ("alpha", "beta" and/or "ga"), will NOT be updated.
#
# Providing no argument defaults to incrementing revision number in ALL modules to
# major.minor.incremental+1-qualifier-SNAPSHOT if the current version is
# major.minor.incremental-qualifier OR to major.minor.incremental-qualifier if the
# current version is major.minor.incremental-qualifier-SNAPSHOT.
#
# This scripts assumes that all project modules have explicit
# <version>major.minor.incremental.qualifier[-SNAPSHOT]</version> element specified in each
# (parent and children) module's pom.xml

set -e

RED='\033[1;31m'
GREEN='\033[1;32m'
BOLD='\033[1m'
NC='\033[0m'

ALPHA_VERSION=""
BETA_VERSION=""
GA_VERSION=""
SINGLE_MODULE=""

for i in "$@"
do
case $i in
  --alpha=*)
  ALPHA_VERSION="${i#*=}"
  shift
  ;;
  --beta=*)
  BETA_VERSION="${i#*=}"
  shift
  ;;
  --ga=*)
  GA_VERSION="${i#*=}"
  shift
  ;;
  *)
  ;;
esac
done

echo -e "\n${BOLD}Executing${NC} mvn -q clean install -DskipTests -Dmaven.javadoc.skip=true"
mvn -q clean install -DskipTests -Dmaven.javadoc.skip=true

echo -e "\n${BOLD}Parameters passed:${NC} --alpha=${ALPHA_VERSION}, --beta=${BETA_VERSION}, --ga=${GA_VERSION}"

echo -e "\n${BOLD}Checking modules${NC}"

modules=$(mvn dependency:tree | grep "\[INFO\] com\.google\." | sed -r "s/.*:(.*):(.*):(.*)/\1:\3/g")
declare -A module_version_map
root_module=""
for item in ${modules[*]}
do
  echo "Module: ${item}"
  module_version_map[${item%:*}]=${item#*:}
  if [ "${root_module}" = "" ];then
     root_module=${item%:*}
  fi
done


echo -e "\n${BOLD}Checking module folders${NC}"
module_folders=($(find . -maxdepth 2 -type d | sed -E -n "/^\.\/(google-cloud-contrib\/|google-cloud-testing\/)?google-cloud(-[a-z0-9]+)+$/p") . ./google-cloud)
declare -A module_folder_map

module_folder_map[${root_module}]="."
for item in ${module_folders[*]}
do
  echo "Module Folder: ${item}"
  module_folder_map[${item##*/}]=${item}
done

echo -e "\n${BOLD}Validating module folder mapping${NC}"
for item in ${!module_folder_map[@]}
do
  if [ "${item}" != "." ] && [ "${module_version_map[${item}]}" == "" ]; then
    echo -e "${RED}WARNING:${NC} Ignoring \"${module_folder_map[${item}]}\" folder, as there is no corresponding module found in the root pom"
  fi
done

echo -e "\n${BOLD}Updating versions${NC}"
for item in ${modules[*]}; do
  module="${item%:*}"
  folder="${module_folder_map[${module}]}"
  old_version="${module_version_map[${module}]}"

  # Determine current base_version (e.g. "0.12.1"), qualifier (e.g. "-alpha") and snapshot (e.g. "-SNAPSHOT" or "")
  base_version=${old_version}
  snapshot=""
  qualifier=""

  if [ "${base_version##*-}" == "SNAPSHOT" ]; then
      snapshot="-SNAPSHOT"
      base_version="${base_version%-*}"
  fi
  if [ "${base_version##*-}" == "alpha" ] || [ "${base_version##*-}" == "beta" ]; then
      qualifier="-${base_version##*-}"
      base_version="${base_version%-*}"
  fi

  # Determine new_version value
  new_version=""
  if [ "${ALPHA_VERSION}" != "" ] && [ "${qualifier}" == "-alpha" ]; then
    new_version=${ALPHA_VERSION}
  fi
  if [ "${BETA_VERSION}" != "" ] && [ "${qualifier}" == "-beta" ]; then
    new_version=${BETA_VERSION}
  fi
  if [ "${GA_VERSION}" != "" ] && [ "${qualifier}" == "" ]; then
    new_version=${GA_VERSION}
  fi

  if [ "${ALPHA_VERSION}" == "" ] && [ "${BETA_VERSION}" == "" ] && [ "${GA_VERSION}" == "" ]; then
    if [ "${snapshot}" == "" ]; then
        new_snapshot="-SNAPSHOT"
        new_base_version="${base_version%.*}.$((${base_version##*.}+1))"
      else
        new_snapshot=""
        new_base_version="${base_version}"
    fi
    new_version="${new_base_version}${qualifier}${new_snapshot}"
  fi

  if [ "${new_version}" == "" ]; then
    echo -e "${RED}WARNING:${NC} Ignoring module ${BOLD}${module}${NC}, as its qualifier ${BOLD}${qualifier}${NC} does not match command line arguments"
    continue
  fi

  echo -e "Updating module ${BOLD}${module}${NC} in folder ${folder} from version ${RED}${old_version}${NC} to ${GREEN}${new_version}${NC}"

  # Where the actual version changing happens (the only mutative operations in the script).
  module_suffix=${module##*-}
  sed -ri "s/(<${module_suffix}.version>\s*)((\w|-|\.)+)(\s*<\/${module_suffix}.version>)/\1${new_version}\4/" pom.xml
  mvn -q versions:set -DartifactId=${module} -DnewVersion=${new_version} -DprocessPlugins=false -DgenerateBackupPoms=false

  if [ -w ${folder}/src/main/docker/Dockerfile ]; then
    old_version="${module_version_map[${module}]}"
    echo "Updating ${folder}/src/main/docker/Dockerfile"
    sed -ri "s/${old_version}/${new_version}/" ${folder}/src/main/docker/Dockerfile
  fi
done
