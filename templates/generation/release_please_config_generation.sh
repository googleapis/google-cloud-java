
set -e

rp_config_line=""
for bom_directory in $(find . -name 'google-*-bom' | sort); do
  if [[ "${bom_directory}" = *google-cloud-gapic-bom ]]; then
    continue
  fi

  pom_file="${bom_directory}/pom.xml"
  artifactId_line=$(grep --max-count=1 'artifactId' "${pom_file}")

  # extracting module name
  prefix="  <artifactId>"
  suffix="-bom</artifactId>"
  artifactName=${artifactId_line#"$prefix"}
  artifactName=${artifactName%"$suffix"}
  artifactName_config=${artifactName};
  prefix="./"
  suffix="/${artifactName}-bom"
  module=${bom_directory#"$prefix"}
  module=${module%"$suffix"}

  version_line=$(grep --max-count=1 'x-version-update' "${pom_file}")

  version_file="${bom_directory}/../versions.txt"

  module_released_version=$(grep google- ${version_file} |head -1 |awk -F: '{print $2}')
  module_snapshot_version=$(grep google- ${version_file} |head -1 |awk -F: '{print $3}')
  pom_directory="${bom_directory}/../pom.xml"
  snapshot_version=""

  if  [[ "${module_snapshot_version}" =~ .*SNAPSHOT ]]; then
      # increment the third digit of the version and overwrite it.
      snapshot_version=$(echo ${module_released_version} |  awk -F'.' '{print $1"."$2"."$3+1}' |  sed s/[.]$//)

      mvn -B -ntp -f ${pom_directory} -U versions:set -DnewVersion=${snapshot_version}
      mvn -B -ntp -f ${bom_directory} -U versions:set -DnewVersion=${snapshot_version}
      #updating gapic bom pom.xml with the snapshot version
      version_line="${version_line/${module_snapshot_version}/${snapshot_version}}"
    fi

  if ! [[ "${module_snapshot_version}" =~ .*SNAPSHOT ]]; then
    # increment the third digit of the version and overwrite it.
    snapshot_version=$(echo ${module_released_version} |  awk -F'.' '{print $1"."$2"."$3+1}' |  sed s/[.]$//)

    mvn -B -ntp -f ${pom_directory} -U versions:set -DnewVersion=${snapshot_version}
    mvn -B -ntp -f ${bom_directory} -U versions:set -DnewVersion=${snapshot_version}
    #updating gapic bom pom.xml with the snapshot version
    version_line="${version_line/${module_snapshot_version}/${snapshot_version}}"
  fi

  #for modules which have artifacts with different versions, we need to bump to snapshot version
  cat ${version_file} | while read line
    do
       if [[ ${line} =~ [0-9] ]] && ! [[ ${line} == *"SNAPSHOT"* ]] ; then
         artifact_name=$(echo "${line}" | awk -F':' '{print $1}')
         old_version=$(echo "${line}" | awk -F':' '{print $3}')
         new_version=$(echo ${old_version} |  awk -F'.' '{print $1"."$2"."$3+1}' |  sed s/[.]$//)
         new_version="${new_version}-SNAPSHOT"
         sed -i.bak "s|${artifact_name}:${old_version}:${old_version}|${artifact_name}:${old_version}:${new_version}|" ${version_file}
         artifact_directory="${bom_directory}/../${artifact_name}"
         mvn -B -ntp -f ${artifact_directory} -U versions:set -DnewVersion=${new_version}
       fi
    done

  cat ${version_file} | while read line
      do
         if [[ ${line} =~ [0-9] ]] && [[ ${line} == *"SNAPSHOT"* ]] ; then
           artifact_name=$(echo "${line}" | awk -F':' '{print $1}')
           old_version=$(echo "${line}" | awk -F':' '{print $2}')
           new_version=$(echo ${old_version} |  awk -F'.' '{print $1"."$2"."$3+1}' |  sed s/[.]$//)
           artifact_directory="${bom_directory}/../${artifact_name}"
           mvn -B -ntp -f ${artifact_directory} -U versions:set -DnewVersion=${new_version}
         fi
      done

  #concatenating module name and module version
  rp_manifest_line=""\""${module}"\"": "\""${module_released_version}"\"""

  rp_config_line+=""\""${module}"\"": {\n\
        "\""component"\"": ""\""${artifactName_config}"\"","\n\
        "\""skip-github-release"\"": "true"\n\
       }"

  #adding " , " where it's necessary
  if [[ $num_modules -gt 1 ]]; then
    rp_manifest_line+=","
    rp_config_line+=",\n    "
    num_modules=$((num_modules-1))
  fi

  #adding the line to manifest config file
  echo "${rp_manifest_line}" >> .release-please-manifest.json
done

echo "}" >> .release-please-manifest.json

GENERATION_DIR=$(dirname -- "$0");

awk -v "packagesList=$rp_config_line" '{gsub(/ALL_PACKAGES/,packagesList)}1' \
    ${GENERATION_DIR}/release_please_config_raw.json > release-please-config.json
