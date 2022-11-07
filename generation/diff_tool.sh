#!/bin/bash
#run this script from google-cloud-java directory
# google-cloud-java$ ./generation/diff_tool.sh
# not using set -e because failing diff command is ok
# was thinking to use staging-directory ID as an argument to this script, but we have different staging ID's for different
# group ID artifacts so it will complicate the command.
# latest repositories Id -> comgooglecloud-5570, comgoogleapi-5038, comgoogleanalytics-1052
# Whenever staging happens, search the logs for the latest-ids and edit them below

set -x

cloudRepoId=comgooglecloud-5570
apiRepoId=comgoogleapi-5038
analyticsRepoId=comgoogleanalytics-1052

#-maxDepth 2 will just loop over all the packages we have, like java-vision etc, not maven submodules within it
#-maxDepth 3 and 4 output same number of modules (more than 2 ofcourse) so 3 is covering all the modules
for module in $(find . -mindepth 1 -maxdepth 3 -name pom.xml | sort | xargs dirname); do

  if [[ "${module}" = *google-cloud-gapic-bom ]] || [[ "${module}" = *CoverageAggregator ]]; then
    continue
  fi

  if [[ "${module}" = *samples* ]]; then
    continue
  fi

  #these modules do not exist on maven-central yet
  if [[ "${module}" = *beyondcorp* ]]; then
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
  new_string=${string#"$prefix"}
  groupId=${new_string%"$suffix"}

  prefix="  <artifactId>"
  suffix="</artifactId>"
  string=${artifactId_line}
  new_string=${string#"$prefix"}
  artifactId=${new_string%"$suffix"}

  #bom and parent artifacts do not have those 4 jars and a pom (javadoc, sources, test, .jar, pom) so just skip them for now. we can use the same logic to compare their jars
  if [[ "${artifactId}" == *bom* ]] || [[ "${artifactId}" == *parent* ]]; then
    continue
  fi

  if [[ "${groupId}" == *grafeas* ]]; then
    continue
  fi

  if [[ "${groupId}" == *google.cloud* ]]; then

    maven_version=$(curl -s "https://repo1.maven.org/maven2/com/google/cloud/${artifactId}/maven-metadata.xml" | grep --max-count=1 'latest')
    maven_latest_version=$(echo "$maven_version" | cut -d '>' -f 2 | cut -d '<' -f 1)

    for w in sources javadoc tests; do

      sonatypeJarFile="${artifactId}-${version}-$w.jar"
      mavenJarFile="${artifactId}-${maven_latest_version}-$w.jar"

      sonatypeURL="https://google.oss.sonatype.org/content/repositories/${cloudRepoId}/com/google/cloud/${artifactId}/${version}/${sonatypeJarFile}"
      mavenURL="https://repo1.maven.org/maven2/com/google/cloud/${artifactId}/${maven_latest_version}/${mavenJarFile}"

      ./generation/diff_jar.sh ${mavenURL} ${sonatypeURL} ${artifactId} $w
    done

    ./generation/diff_jar.sh "https://repo1.maven.org/maven2/com/google/cloud/${artifactId}/${maven_latest_version}/${artifactId}-${maven_latest_version}.jar" \
      "https://google.oss.sonatype.org/content/repositories/${cloudRepoId}/com/google/cloud/${artifactId}/${version}/${artifactId}-${version}.jar" \
      "${artifactId}" "jar"

    ./generation/diff_pom.sh "https://repo1.maven.org/maven2/com/google/cloud/${artifactId}/${maven_latest_version}/${artifactId}-${maven_latest_version}.pom" \
      "https://google.oss.sonatype.org/content/repositories/${cloudRepoId}/com/google/cloud/${artifactId}/${version}/${artifactId}-${version}.pom" \
      "${artifactId}" "pom"
  fi

  if [[ "${groupId}" == *grpc* ]]; then

    maven_version=$(curl -s "https://repo1.maven.org/maven2/com/google/api/grpc/${artifactId}/maven-metadata.xml" | grep --max-count=1 'latest')
    maven_latest_version=$(echo "$maven_version" | cut -d '>' -f 2 | cut -d '<' -f 1)

    for w in sources javadoc tests; do

      sonatypeJarFile="${artifactId}-${version}-$w.jar"
      mavenJarFile="${artifactId}-${maven_latest_version}-$w.jar"

      sonatypeURL="https://google.oss.sonatype.org/content/repositories/${apiRepoId}/com/google/api/grpc/${artifactId}/${version}/${sonatypeJarFile}"
      mavenURL="https://repo1.maven.org/maven2/com/google/api/grpc/${artifactId}/${maven_latest_version}/${mavenJarFile}"

      ./generation/diff_jar.sh ${mavenURL} ${sonatypeURL} ${artifactId} $w
    done

    ./generation/diff_jar.sh "https://repo1.maven.org/maven2/com/google/api/grpc/${artifactId}/${maven_latest_version}/${artifactId}-${maven_latest_version}.jar" \
      "https://google.oss.sonatype.org/content/repositories/${apiRepoId}/com/google/api/grpc/${artifactId}/${version}/${artifactId}-${version}.jar" \
      "${artifactId}" "jar"

    ./generation/diff_pom.sh "https://repo1.maven.org/maven2/com/google/api/grpc/${artifactId}/${maven_latest_version}/${artifactId}-${maven_latest_version}.pom" \
      "https://google.oss.sonatype.org/content/repositories/${apiRepoId}/com/google/api/grpc/${artifactId}/${version}/${artifactId}-${version}.pom" \
      "${artifactId}" "pom"
  fi

  if [[ "${groupId}" == *analytics* ]]; then

    maven_version=$(curl -s "https://repo1.maven.org/maven2/com/google/analytics/${artifactId}/maven-metadata.xml" | grep --max-count=1 'latest')
    maven_latest_version=$(echo "$maven_version" | cut -d '>' -f 2 | cut -d '<' -f 1)

    for w in sources javadoc tests; do

      sonatypeJarFile="${artifactId}-${version}-$w.jar"
      mavenJarFile="${artifactId}-${maven_latest_version}-$w.jar"

      sonatypeURL="https://google.oss.sonatype.org/content/repositories/${analyticsRepoId}/com/google/analytics/${artifactId}/${version}/${sonatypeJarFile}"
      mavenURL="https://repo1.maven.org/maven2/com/google/analytics/${artifactId}/${maven_latest_version}/${mavenJarFile}"

      ./generation/diff_jar.sh ${mavenURL} ${sonatypeURL} ${artifactId} $w
    done

    ./generation/diff_jar.sh "https://repo1.maven.org/maven2/com/google/analytics/${artifactId}/${maven_latest_version}/${artifactId}-${maven_latest_version}.jar" \
      "https://google.oss.sonatype.org/content/repositories/${analyticsRepoId}/com/google/analytics/${artifactId}/${version}/${artifactId}-${version}.jar" \
      "${artifactId}" "jar"

    ./generation/diff_pom.sh "https://repo1.maven.org/maven2/com/google/analytics/${artifactId}/${maven_latest_version}/${artifactId}-${maven_latest_version}.pom" \
      "https://google.oss.sonatype.org/content/repositories/${analyticsRepoId}/com/google/analytics/${artifactId}/${version}/${artifactId}-${version}.pom" \
      "${artifactId}" "pom"
  fi

done


cat modulesDiff.txt >>diffSummary.txt
cat allDifferencesFound.txt >>diffSummary.txt
rm -f modulesDiff.txt
rm -f allDifferencesFound.txt
