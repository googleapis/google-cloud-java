#!/bin/bash

# This script updates the pom.xml files to the next version number.
# This script is meant to be run manually (not by Travis)

# Argument (optional): new version number for pom.xml files
# Providing no argument defaults to incrementing revision number to 
# x.y.z+1-SNAPSHOT if the current version is x.y.z OR to x.y.z if the
# current version is x.y.z-SNAPSHOT.

set -e

# Get the previous maven project version.
CURRENT_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -Ev '(^\[|\w+:)')
CURRENT_VERSION_BASE=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -Ev '(^\[|\w+:)' | grep -Eo '[0-9]+\.[0-9]+\.[0-9]+')

# Get list of directories for which pom.xml must be updated
module_folders=($(find . -maxdepth 2 -type d | sed -E -n "/^\.\/(google-cloud-contrib\/|testing\/)?google-cloud(-[a-z0-9]+)+$/p") . ./google-cloud)

CURRENT_SNAPSHOT=""
if [ "${CURRENT_VERSION##*-}" == "SNAPSHOT" ]; then
    CURRENT_SNAPSHOT="-SNAPSHOT"
fi

NEW_SNAPSHOT=""
if [ $# -eq 1 ]; then
    NEW_VERSION_BASE=$1
    if [ "${NEW_VERSION_BASE##*-}" == "SNAPSHOT" ]; then
        NEW_SNAPSHOT="-SNAPSHOT"
    fi
elif [ "${CURRENT_VERSION##*-}" != "SNAPSHOT" ]; then
    NEW_VERSION_BASE="${CURRENT_VERSION%.*}.$((${CURRENT_VERSION##*.}+1))"
    NEW_SNAPSHOT="-SNAPSHOT"
else
    NEW_VERSION_BASE=${CURRENT_VERSION%%-*}
fi

echo "Changing version from ${CURRENT_VERSION_BASE}-*${CURRENT_SNAPSHOT} to ${NEW_VERSION_BASE}-*${NEW_SNAPSHOT} in pom.xml files"
for item in ${module_folders[*]}
do
    sed -ri "0,/<version>$CURRENT_VERSION_BASE/s/<version>${CURRENT_VERSION_BASE}(-[a-z]+)?[^<]*/<version>${NEW_VERSION_BASE}\1${NEW_SNAPSHOT}/" ${item}/pom.xml
    if [ -w ${item}/src/main/docker/Dockerfile ]
    then
      sed -ri "s/${CURRENT_VERSION_BASE}(-[a-z]+)?(-SNAPSHOT)?/${NEW_VERSION_BASE}\1${NEW_SNAPSHOT}/" ${item}/src/main/docker/Dockerfile
    fi
done
sed -ri "0,/<core.version>$CURRENT_VERSION_BASE/s/<core.version>${CURRENT_VERSION_BASE}(-[a-z]+)?[^<]*/<core.version>${NEW_VERSION_BASE}\1${NEW_SNAPSHOT}/" pom.xml
sed -ri "0,/<beta.version>$CURRENT_VERSION_BASE/s/<beta.version>${CURRENT_VERSION_BASE}(-[a-z]+)?[^<]*/<beta.version>${NEW_VERSION_BASE}\1${NEW_SNAPSHOT}/" pom.xml
