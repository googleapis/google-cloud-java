#!/bin/bash

set -e

#-maxDepth 2 will just loop over all the packages we have, like java-vision etc, not maven submodules within it
for module in $(find . -mindepth 1 -maxdepth 3 -name pom.xml | sort | xargs dirname); do

  if [[ "${module}" = *google-cloud-gapic-bom ]] || [[ "${module}" = *CoverageAggregator ]]; then
    continue
  fi

  if [[ "${module}" = *samples* ]] ; then
      continue
  fi


  pom_file="${module}/pom.xml"
  groupId_line=$(grep --max-count=1 'groupId' "${pom_file}")
  artifactId_line=$(grep --max-count=1 'artifactId' "${pom_file}")
  version_line=$(grep --max-count=1 'x-version-update' "${pom_file}")

  #strip off everything from version line except digits and . to get the version
  version=$(echo "$version_line" | cut -d '>' -f 2 | cut -d '<' -f 1)

  prefix="  <groupId>"
  suffix="</groupId>"
  string=${groupId_line}
  foo=${string#"$prefix"}
  groupId=${foo%"$suffix"}

  prefix="  <artifactId>"
  suffix="</artifactId>"
  string=${artifactId_line}
  foo=${string#"$prefix"}
  artifactId=${foo%"$suffix"}

  #bom and parent artifacts do not have those 5 jars (javadoc, sources, test, .jar, pom) so just skip them for now. we can use the same logic to compare their jars
  if [[ "${artifactId}" == *bom* ]] || [[ "${artifactId}" == *parent* ]]  ; then
    continue
  fi

  #skipping this module for now because of confusion about groupId, should be com.google.cloud, but inheriting from parent so com.google.api
  if [[ "${artifactId}" == *notification* ]] ; then
      continue
  fi

  #for some modules, newer version exists on maven central
  #but just to be safe that the link will return me a jar, I'm searching maven central for a version older than what we staged, which will for sure exist.
  maven_version=$(echo ${version} |  awk -F'.' '{print $1"."$2"."$3-1}' |  sed s/[.]$//)

  echo "--------------------------"
  echo "${artifactId}"
  echo "staged version - ${version}"
  echo "maven-central version - ${maven_version}"

  sonatypeJarFile="${artifactId}-${version}-javadoc.jar"
  mavenJarFile="${artifactId}-${maven_version}-javadoc.jar"
#

  if [[ "${groupId}" == *google.cloud* ]] ; then
        echo "https://google.oss.sonatype.org/content/repositories/comgooglecloud-5374/com/google/cloud/${artifactId}/${version}/${sonatypeJarFile}"
        echo "https://repo1.maven.org/maven2/com/google/cloud/${artifactId}/${maven_version}/${mavenJarFile}"
#       wget -O sonatypeFile https://google.oss.sonatype.org/content/repositories/comgooglecloud-5374/com/google/cloud/${artifactId}/${version}/${artifactId}-${version}-javadoc.jar
#        wget -O mavenFile.zip https://repo1.maven.org/maven2/com/google/cloud/${artifact_name}/${artifact_version}/${mavenJarFile}
#        unzip -l ${sonatypeFile} >> "${sonatypeFile}-output1.txt"
        #  cat ${mavenFile}-output1.txt | awk '{print $4}' | sort -k3 >> "${mavenFile}-pre.txt"
  fi

##
  if [[ "${groupId}" == *grpc* ]] ; then
          echo "https://google.oss.sonatype.org/content/repositories/comgoogleapi-4857/com/google/api/grpc/${artifactId}/${version}/${sonatypeJarFile}"
          echo "https://repo1.maven.org/maven2/com/google/api/grpc/${artifactId}/${maven_version}/${mavenJarFile}"
  #        wget -O sonatypeFile https://google.oss.sonatype.org/content/repositories/comgooglecloud-5374/com/google/cloud/${artifactId}/${version}/${artifactId}-${version}-javadoc.jar
  #        unzip -l ${sonatypeFile} >> "${sonatypeFile}-output1.txt"
          #  cat ${mavenFile}-output1.txt | awk '{print $4}' | sort -k3 >> "${mavenFile}-pre.txt"
  fi
#

  if [[ "${groupId}" == *analytics* ]] ; then
            echo "https://google.oss.sonatype.org/content/repositories/comgoogleanalytics-1049/com/google/analytics/${artifactId}/${version}/${sonatypeJarFile}"
            echo "https://repo1.maven.org/maven2/com/google/analytics/${artifactId}/${maven_version}/${mavenJarFile}"
    #        wget -O sonatypeFile https://google.oss.sonatype.org/content/repositories/comgooglecloud-5374/com/google/cloud/${artifactId}/${version}/${artifactId}-${version}-javadoc.jar
    #        unzip -l ${sonatypeFile} >> "${sonatypeFile}-output1.txt"
            #  cat ${mavenFile}-output1.txt | awk '{print $4}' | sort -k3 >> "${mavenFile}-pre.txt"
  fi
##

  if [[ "${groupId}" == *grafeas* ]] ; then
              echo "https://google.oss.sonatype.org/content/repositories/iografeas-1036/io/grafeas/${artifactId}/${version}/${sonatypeJarFile}"
              echo "https://repo1.maven.org/maven2/io/grafeas/${artifactId}/${maven_version}/${mavenJarFile}"
      #        wget -O sonatypeFile https://google.oss.sonatype.org/content/repositories/comgooglecloud-5374/com/google/cloud/${artifactId}/${version}/${artifactId}-${version}-javadoc.jar
      #        unzip -l ${sonatypeFile} >> "${sonatypeFile}-output1.txt"
              #  cat ${mavenFile}-output1.txt | awk '{print $4}' | sort -k3 >> "${mavenFile}-pre.txt"
  fi

#  wget -v -O ${sonatypeFile} https://google.oss.sonatype.org/content/repositories/comgooglecloud-5374/com/google/cloud/${artifactId}/${version}/${sonatypeJarFile}
#
#  unzip -l ${mavenFile} >> "${mavenFile}-output1.txt"
#  cat ${mavenFile}-output1.txt | awk '{print $4}' | sort -k3 >> "${mavenFile}-pre.txt"
#
#  unzip -l ${sonatypeFile} >> "${sonatypeFile}-output1.txt"
#  cat ${sonatypeFile}-output1.txt | awk '{print $4}' | sort -k3 >> "${sonatypeFile}-pre.txt"
#
#  diff ${mavenFile}-pre.txt ${sonatypeFile}-pre.txt >> ${artifact_name}-final.txt

done

