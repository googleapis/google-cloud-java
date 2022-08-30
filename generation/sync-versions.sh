#!/bin/bash

set -e

for module in $(find . -mindepth 2 -maxdepth 2 -name pom.xml |sort | xargs dirname); do

  if [[ "${module}" = *google-cloud-gapic-bom ]] || [[ "${module}" = *CoverageAggregator ]]; then
      continue
  fi

  version_file="${module}/versions.txt"

  artifactName_config=$(grep google- ${version_file} |head -1 |awk -F: '{print $1}')

  module_name="${module:2}"
  gapic_bom_directory="./google-cloud-gapic-bom/pom.xml"

  cat ${version_file} | while read line
        do
           if [[ ${line} =~ [0-9] ]] ; then
             artifact_name=$(echo "${line}" | awk -F':' '{print $1}')
             released_version=$(echo "${line}" | awk -F':' '{print $2}')
             new_version=$(echo ${released_version} |  awk -F'.' '{print $1"."$2"."$3+1}' |  sed s/[.]$//)
             artifact_directory="${module}/${artifact_name}"
             if [ -d "${artifact_directory}" ]; then
                 mvn -B -ntp -f ${artifact_directory} -DgenerateBackupPoms=false -U versions:set -DnewVersion="${new_version}"
             fi
           fi
        done

  module_released_version=$(grep google- ${version_file} |head -1 |awk -F: '{print $2}')

  #specific case
  if [[ ${module_name} == "java-grafeas" ]]; then
    module_released_version=$(grep grafeas ${version_file} |head -1 |awk -F: '{print $2}')
  fi

  new_version=$(echo ${module_released_version} |  awk -F'.' '{print $1"."$2"."$3+1}' |  sed s/[.]$//)
  #bumping to new version in module root pom
  mvn -B -ntp -f ${module} -U versions:set -DgenerateBackupPoms=false -DnewVersion="${new_version}"

  #specific case
  if [[ ${module_name} == "java-notification" ]]; then
    mvn -B -ntp -f ${module} -U versions:set -DgenerateBackupPoms=false -DnewVersion="${new_version}-beta"
  fi

  #bumping in module bom directory, if it exists
  bom_directory="${module-name}/${artifactName_config}-bom"
  if [ -d "${bom_directory}" ]; then
    mvn -B -ntp -f ${bom_directory} -U versions:set -DgenerateBackupPoms=false -DnewVersion="${new_version}"
  fi

  #updating google-cloud-gapic-bom pom.xml with non-snapshot versions"
  someVersion="<version>${new_version}-SNAPSHOT</version><!-- {x-version-update:${artifact_name}:current} -->"
  if grep -q "${someVersion}" "${gapic_bom_directory}"; then
    sed -i '' "s|<version>${new_version}-SNAPSHOT</version><!-- {x-version-update:${artifact_name}:current} -->|<version>${new_version}</version><!-- {x-version-update:${artifact_name}:current} -->|" ${gapic_bom_directory}
  fi

done


