#!/bin/bash

# This script updates the pom.xml files to the next version number.
# This script is meant to be run manually (not by Travis)

# Argument (optional): new version number for pom.xml files
# Providing no argument defaults to incrementing revision number to 
# x.y.z+1-SNAPSHOT if the current version is x.y.z OR to x.y.z if the
# current version is x.y.z-SNAPSHOT.

# Get the previous maven project version.
CURRENT_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -Ev '(^\[|\w+:)')
# Get list of directories for which pom.xml must be updated
module_folders=($(find . -maxdepth 1 -name 'gcloud-java*' -type d) .)

if [ $# -eq 1 ]; then
    NEW_VERSION=$1
elif [ "${CURRENT_VERSION##*-}" != "SNAPSHOT" ]; then
    NEW_VERSION="${CURRENT_VERSION%.*}.$((${CURRENT_VERSION##*.}+1))-SNAPSHOT"
else
    NEW_VERSION=${CURRENT_VERSION%%-*}
fi

echo "Changing version from $CURRENT_VERSION to $NEW_VERSION in pom.xml files"
for item in ${module_folders[*]}
do
    sed -i "0,/<version>$CURRENT_VERSION/s/<version>$CURRENT_VERSION/<version>$NEW_VERSION/" ${item}/pom.xml
done
