#!/bin/bash

# Requires bash version >= 4.

# This script updates pom.xml, README.md and other relevant files to the next version number.
# This script is meant to be run manually (not by Travis)
#
# This script should be ALWAYS executed from the repo root directory: ./utilities/update_versions.sh
#
# Arguments (all are optional):
# --modules= specifies coma separated list of modules to update (spaces are not allowed),
#   for example --modules=google-cloud-logging,google-cloud-vision
# --alpha= specifies new version for alpha modules in format
#   "major.minor.incremental.qualifier[-SNAPSHOT]",
#   for example --alpha=0.12.2-alpha-SNAPSHOT
# --beta= specifies new version for beta modules in format
#   "major.minor.incremental.qualifier[-SNAPSHOT]",
#   for example --beta=0.12.2-beta
# --rc= specifies new version for release candidate modules in format
#   "major.minor.incremental.qualifier[-SNAPSHOT]",
#   for example --rc=0.12.2-rc1
# --ga= specifies new version for GA modules in format
#   "major.minor.incremental.qualifier[-SNAPSHOT]",
#   for example --ga=0.12.2
#
# If at least one argument is provided it means that all the other modules, which do not belong
# to the argument's qualifier(s) ("alpha", "beta", "rc" and/or "ga"), will NOT be updated.
#
# Providing no argument defaults to incrementing revision number in ALL modules to
# major.minor.incremental+1-qualifier-SNAPSHOT if the current version is
# major.minor.incremental-qualifier OR to major.minor.incremental-qualifier if the
# current version is major.minor.incremental-qualifier-SNAPSHOT.
#
# This scripts assumes that all project modules have explicit
# <version>major.minor.incremental.qualifier[-SNAPSHOT]</version> element specified in each
# (parent and children) module's pom.xml
#
# Note, README.md files are updated only in case if the new version is NOT a SNAPSHOT one.
#
# Examples:
# ~$ ./utilities/update_versions.sh --modules=google-cloud-logging,google-cloud-speech
#   will update only modules google-cloud-logging and google-cloud-speech, ignoring others, using
#   default version bumping described above;
#
# ~$ ./utilities/update_versions.sh --alpha=0.12.3-alpha
#   will update all alpha modules to the specified version, ignoring others (beta, rc and ga);
#
# ~$ ./utilities/update_versions.sh --alpha=0.12.3-alpha-SNAPSHOT --rc=0.12.3-rc2-SNAPSHOT
#   will update only all alpha and rc modules to the specified versions respectively, as result all
#   alpha and rc modules within the repo will be of version 0.12.3-alpha-SNAPSHOT and
#   0.12.3-rc2-SNAPSHOT respectively;
#
# ~$ ./utilities/update_versions.sh --modules=google-cloud-logging,google-cloud-speech --beta=0.12.3-beta --ga=1.1.0
#   assuming on the moment of execution google-cloud-logging is in GA and google-cloud-speech
#   is in beta, the above command will update google-cloud-logging to 1.1.0 and google-cloud-speech
#   to 0.12.3-beta, ignoring all other modules.
#
# ~$ ./utilities/update_versions.sh --modules=google-cloud-speech --beta=1.0.0
#   assuming google-cloud-speech is in beta, the above command can be executed to move it to
#   GA stage.

set -e

RED='\033[1;31m'
GREEN='\033[1;32m'
BOLD='\033[1m'
NC='\033[0m'

MODULES=""
ALPHA_VERSION=""
BETA_VERSION=""
RC_VERSION=""
GA_VERSION=""

# uncomment module for GAE testing apps to enable detection (re-commented below)
sed -i -e 's:<!--<module>google-cloud-testing</module>-->:<module>google-cloud-testing</module>:' pom.xml

for i in "$@"
do
case $i in
  --modules=*)
  MODULES="${i#*=}"
  shift
  ;;
  --alpha=*)
  ALPHA_VERSION="${i#*=}"
  shift
  ;;
  --beta=*)
  BETA_VERSION="${i#*=}"
  shift
  ;;
  --rc=*)
  RC_VERSION="${i#*=}"
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

echo -e "\n${BOLD}Parameters passed:${NC} --modules=${MODULES} --alpha=${ALPHA_VERSION}, --beta=${BETA_VERSION}, --rc=${RC_VERSION}, --ga=${GA_VERSION}"

# Necessary step for the next "mvn dependency:tree" command to complete successuflly
echo -e "\n${BOLD}Executing${NC} mvn -q clean install -DskipTests -Dmaven.javadoc.skip=true"
mvn -q clean install -DskipTests -Dmaven.javadoc.skip=true

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

echo -e "\n${BOLD}Validating explicitly specified modules${NC}"
declare -A specified_modules_map
if [ "${MODULES}" != "" ]; then
  specified_modules_arr=(${MODULES//,/ })

  for item in ${specified_modules_arr[*]}; do
    if [ "${module_version_map[${item}]}" != "" ]; then
      specified_modules_map[${item}]=${module_version_map[${item}]}
    else
      echo -e "${RED}WARNING:${NC} Module \"${item}\" module, specified in --modules parameter could not be found, ignoring \"${item}\""
    fi
  done
fi

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

  # Check if we need to update only the specified modules, and if we do, ignore the other modules
  if [ "${MODULES}" != "" ]; then
    if [ "${specified_modules_map[${module}]}" ==  "" ]; then
      echo -e "${RED}WARNING:${NC} Ignoring \"${item}\" module, as it is not specified in --modules= non-empty parameter"
      continue
    fi
  fi

  # Determine current base_version (e.g. "0.12.1"), qualifier (e.g. "-alpha" or "-rc1") and snapshot (e.g. "-SNAPSHOT" or "")
  base_version=${old_version}
  qualifier=""
  snapshot=""

  if [ "${base_version##*-}" == "SNAPSHOT" ]; then
      snapshot="-SNAPSHOT"
      base_version="${base_version%-*}"
  fi
  if [[ "${base_version##*-}" =~ [a-z]+[0-9]* ]]; then
      qualifier="-${base_version##*-}"
      base_version="${base_version%-*}"
  fi

  # Determine new_version value
  new_version=""
  if [ "${ALPHA_VERSION}" != "" ] && [[ "${qualifier}" =~ -alpha[0-9]* ]]; then
    new_version=${ALPHA_VERSION}
  fi
  if [ "${BETA_VERSION}" != "" ] && [[ "${qualifier}" =~ -beta[0-9]* ]]; then
    new_version=${BETA_VERSION}
  fi
  if [ "${RC_VERSION}" != "" ] && [[ "${qualifier}" =~ -rc[0-9]* ]]; then
    new_version=${RC_VERSION}
  fi
  if [ "${GA_VERSION}" != "" ] && [ "${qualifier}" == "" ]; then
    new_version=${GA_VERSION}
  fi
  # echo -e "base_version=${base_version}, qualifier=${qualifier}, snapshot=${snapshot}"

  if [ "${ALPHA_VERSION}" == "" ] && [ "${BETA_VERSION}" == "" ] && [ "${RC_VERSION}" == "" ] && [ "${GA_VERSION}" == "" ]; then
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

   # Determine new base_version (e.g. "0.13.1"), new qualifier (e.g. "-alpha" or "-rc2") and new snapshot (e.g. "-SNAPSHOT" or "")
  new_base_version=${new_version}
  new_qualifier=""
  new_snapshot=""

  if [ "${new_base_version##*-}" == "SNAPSHOT" ]; then
      new_snapshot="-SNAPSHOT"
      new_base_version="${new_base_version%-*}"
  fi
  if [[ "${new_base_version##*-}" =~ [a-z]+[0-9]* ]]; then
      new_qualifier="-${new_base_version##*-}"
      new_base_version="${new_base_version%-*}"
  fi
  # echo -e "new_base_version=${new_base_version}, new_qualifier=${new_qualifier}, new_snapshot=${new_snapshot}"

  echo -e "Updating module ${BOLD}${module}${NC} in folder ${folder} from version ${RED}${old_version}${NC} to ${GREEN}${new_version}${NC}"
  if [ "${module}" == "google-cloud" ]; then
    module_suffix="cloud"
  else
    module_suffix="${module##google-cloud-}"
  fi

  # Where the actual version changing happens (the only mutative operations in the script).

  # 1) Update version properties (used to define dependencies between google-cloud modules).
  echo -e "    Updating ${module_suffix}.version property in root pom.xml"
  sed -ri "s/(<${module_suffix}.version>\s*)((\w|-|\.)+)(\s*<\/${module_suffix}.version>)/\1${new_version}\4/" pom.xml

  # 2) Update version of the module. If the module is a parent of other modules
  # (like the root module or the google-cloud-contrib), then the parent secion of its child modules
  # will be updated too.
  echo -e "    Updating version in ${folder}/pom.xml and the parent version in the corresponding children modules if exist"
  mvn -q versions:set -DartifactId=${module} -DnewVersion=${new_version} -DprocessPlugins=false -DgenerateBackupPoms=false

  # 3) Update Google App Engine application dockerfile, if it exists.
  if [ -w ${folder}/src/main/docker/Dockerfile ]; then
    old_version="${module_version_map[${module}]}"
    echo -e "    Updating ${folder}/src/main/docker/Dockerfile"
    sed -ri "s/${old_version}/${new_version}/" ${folder}/src/main/docker/Dockerfile
  fi

  # 4) Update README.md
  if [ -f ${folder}/README.md ] && [ "${new_snapshot}" == "" ]; then
    readme_version="${new_version}"
    if [ "${module}" != "google-cloud-nio-examples" ]; then
      echo -e "    Updating ${folder}/README.md to the version ${readme_version}"
      sed -ri "s/<version>[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+[0-9]*)?<\/version>/<version>${readme_version}<\/version>/g" ${folder}/README.md
      sed -ri "s/:[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+[0-9]*)?'/:${readme_version}'/g" ${folder}/README.md
      sed -ri "s/\"[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+[0-9]*)?\"/\"${readme_version}\"/g" ${folder}/README.md
    else
      readme_version="${new_base_version%.*}.$((${new_base_version##*.}+1))${new_qualifier}-SNAPSHOT"
      echo -e "    Updating ${folder}/README.md to the version ${readme_version}"
      sed -ri "s/google-cloud-nio-[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+[0-9]*)?-SNAPSHOT/google-cloud-nio-${readme_version}/g" ${folder}/README.md
      sed -ri "s/google-cloud-nio-examples-[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+[0-9]*)?-SNAPSHOT/google-cloud-nio-examples-${readme_version}/g" ${folder}/README.md
    fi
  fi
done

# re-comment module for GAE testing apps
sed -i -e 's:<module>google-cloud-testing</module>:<!--<module>google-cloud-testing</module>-->:' pom.xml
