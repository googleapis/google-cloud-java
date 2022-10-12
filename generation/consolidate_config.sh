#!/bin/bash

# For each {module}/pom.xml
# Removes dependencyManagement and pluginManagement that should be handled in the parent
# Also removes other configuration that is handled in google-cloud-pom-parent and google-cloud-jar-parent

set -e

function runRegexOnPoms {
  perl_command=$1
  search=$2
  for pomFile in $(find . -mindepth 2 -maxdepth 3 -name pom.xml|grep -v google-cloud-examples \
      |sort --dictionary-order); do
    if [[ $pomFile =~ .*google-cloud-jar-parent.* ]]; then
      continue
    fi

    if grep -q "${search}" "$pomFile" && [[ $(wc -c < "$pomFile") !=  $(perl -0pe "$perl_command" "$pomFile" | wc -c) ]]; then
      # execute the replacement in pom.xml
      echo "Applying $perl_command for $pomFile"
      perl -i -0pe "$perl_command" "$pomFile"
    fi

  done
}

function removeArtifact {
  type=$1
  name=$2
  parent=$3
  perl_command="s/(<${parent}>.*?)\s*<${type}>\s*?<groupId>[a-z\-\.]*<\/groupId>\s*?<artifactId>${name//-/\-}<\/artifactId>.*?<\/${type}>(.*?<\/${parent}>)/\$1\$2/s"
  runRegexOnPoms "$perl_command" "$name"
}

function removeArtifactVersion {
  type=$1
  name=$2
  perl_command="s/(\s*<${type}>\s*?<groupId>[a-z\-\.]*<\/groupId>\s*?<artifactId>${name//-/\-}<\/artifactId>\s*?(<scope>.*?<\/scope>)?)\s*?<version>[^\\n]*?<\/version>(.*?<\/${type}>)/\$1\$3/s"
  runRegexOnPoms "$perl_command" "$name"
}

function annotateArtifactVersion {
  type=$1
  name=$2
  perl_command="s/(\s*<${type}>\s*?<groupId>[a-z\-\.]*<\/groupId>\s*?<artifactId>${name//-/\-}<\/artifactId>\s*?(<scope>.*?<\/scope>)?\s*?)(<version>[^\\n]*?<\/version>)([^:\\n]*\\n.*?<\/${type}>)/\$1\$3<!-- {x-version-update:${name//-/\-}:current} -->\$4/s"
  runRegexOnPoms "$perl_command" "$name"
}

function removeManagedDependency {
  dependency=$1
  removeArtifact 'dependency' "${dependency}" "dependencyManagement"
}

function removeElement {
  element=$1
  perl_command="s/\s*<${element}>.*?<\/${element}>//s"
  runRegexOnPoms "$perl_command" "<${element}>"
}

removeManagedDependency 'google-cloud-shared-dependencies'
removeManagedDependency 'junit'
removeManagedDependency 'joda-time'
removeManagedDependency 'truth'
removeManagedDependency 'easymock'
removeManagedDependency 'perfmark-api'
removeManagedDependency 'google-cloud-pubsub'
removeManagedDependency 'proto-google-cloud-pubsub-v1'
removeManagedDependency 'google-cloud-pubsub-bom'
removeManagedDependency 'google-api-services-translate'
removeElement 'reporting'
removeElement 'developers'
removeElement 'organization'
removeElement 'scm'
removeElement 'issueManagement'
removeElement 'licenses'
removeElement 'junit.version'
removeArtifact 'plugin' 'nexus-staging-maven-plugin' 'plugins'
removeArtifact 'dependency' 'checkstyle' 'plugins'
removeArtifactVersion 'dependency' 'junit'
removeArtifactVersion 'dependency' 'easymock'
removeArtifactVersion 'dependency' 'truth'
removeArtifactVersion 'dependency' 'grpc-google-common-protos'
removeArtifactVersion 'dependency' 'google-api-services-dns'
removeArtifactVersion 'dependency' 'google-api-services-translate'
removeArtifactVersion 'dependency' 'google-api-services-cloudresourcemanager'
removeArtifactVersion 'dependency' 'google-api-services-storage'
removeArtifactVersion 'dependency' 'google-cloud-storage'
removeArtifactVersion 'plugin' 'maven-checkstyle-plugin'
removeArtifactVersion 'dependency' 'mockito-all'
removeArtifactVersion 'dependency' 'objenesis'
annotateArtifactVersion 'dependency' 'grafeas'
annotateArtifactVersion 'dependency' 'proto-google-cloud-orgpolicy-v1'
annotateArtifactVersion 'dependency' 'proto-google-identity-accesscontextmanager-v1'
annotateArtifactVersion 'dependency' 'proto-google-cloud-os-config-v1'
annotateArtifactVersion 'dependency' 'google-cloud-resourcemanager'