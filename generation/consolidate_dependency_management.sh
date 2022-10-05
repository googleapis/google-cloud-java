#!/bin/bash

# For each {module}/pom.xml
# Removes dependencyManagement and pluginManagement that should be handled in the parent

set -e

function removeDependency {
  dependency=$1
  for pomFile in $(find . -mindepth 2 -maxdepth 2 -name pom.xml | sort ); do

    if grep -q "${dependency}" "$pomFile"; then
      perl_command="s/\s*<dependency>\s*<groupId>[a-z\.]*<\/groupId>\s*<artifactId>${dependency}<\/artifactId>.*?<\/dependency>//s"
      # execute the replacement in pom.xml
      perl -0pe "$perl_command" "$pomFile" > "$pomfile".new && rm "$pomFile" && mv "$pomfile".new "$pomFile"
    fi

  done
}

removeDependency 'google-cloud-shared-dependencies'
removeDependency 'junit'