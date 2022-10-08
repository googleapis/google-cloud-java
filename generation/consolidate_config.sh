#!/bin/bash

# For each {module}/pom.xml
# Removes dependencyManagement and pluginManagement that should be handled in the parent
# Also removes other configuration that is handled in google-cloud-pom-parent and google-cloud-jar-parent

set -e

function runRegexOnPoms {
  perl_command=$1
  search=$2
  for pomFile in $(find . -mindepth 2 -maxdepth 3 -name pom.xml | sort ); do
    if [[ $pomFile =~ .*google-cloud-jar-parent.* ]]; then
      continue
    fi

    if grep -q "${search}" "$pomFile"; then
      # execute the replacement in pom.xml
      perl -0pe "$perl_command" "$pomFile" > "$pomfile".new && rm "$pomFile" && mv "$pomfile".new "$pomFile"
    fi

  done
}

function removeDependency {
  dependency=$1
  perl_command="s/\s*<dependency>\s*<groupId>[a-z\.]*<\/groupId>\s*<artifactId>${dependency}<\/artifactId>.*?<\/dependency>//s"
  runRegexOnPoms "$perl_command" "$dependency"
}

function removeElement {
  element=$1
  perl_command="s/\s*<${element}>.*?<\/${element}>//s"
  runRegexOnPoms "$perl_command" "<${element}>"
}

removeDependency 'google-cloud-shared-dependencies'
removeDependency 'junit'
removeElement 'reporting'
removeElement 'developers'
removeElement 'organization'
removeElement 'scm'
removeElement 'issueManagement'
removeElement 'licenses'
