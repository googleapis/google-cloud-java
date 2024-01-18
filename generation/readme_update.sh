#!/bin/bash
# This script should run as a part of new-library generation process.
# This script introduces release-please annotations if they don't exist in the readme file

for module in $(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort | xargs dirname); do

  if [[ "${module}" = *java-core ]] || [[ "${module}" = *java-shared-dependencies ]]; then
    continue
  fi

  readme_file="${module}/README.md"

  if [ -e ${readme_file} ] && ! [[ $(grep "x-version-update-start" ${readme_file}) ]]; then

    artifactId_line=$(grep --max-count=1 'artifactId' "${readme_file}")

    prefix="  <artifactId>"
    suffix="</artifactId>"
    string=${artifactId_line}
    new_string=${string#"$prefix"}
    artifactId=${new_string%"$suffix"}

    echo "Handling ${artifactId}"

    line_number=$(grep -n -m 1 "<dependency>" ${readme_file} | sed 's/\([0-9]*\).*/\1/')
    start_line=${line_number}-2
    line_number_end=$(grep -n -m 1 "Scala" ${readme_file} | sed 's/\([0-9]*\).*/\1/')
    end_line=${line_number_end}+4

    start_line_append="<!-- {x-version-update-start:${artifactId}:released} -->"

    printf '%s\n' H ${start_line}i "${start_line_append}" . w | ed -s ${readme_file}
    printf '%s\n' H ${end_line}i "<!-- {x-version-update-end} -->" . w | ed -s ${readme_file}

  fi

done
