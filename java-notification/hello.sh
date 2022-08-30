

version_file=./versions.txt

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
  new_version=$(echo ${module_released_version} |  awk -F'.' '{print $1"."$2"."$3+1}' |  sed s/[.]$//)
  #bumping to new version in module root pom
  mvn -B -ntp -U versions:set -DgenerateBackupPoms=false -DnewVersion="${new_version}"