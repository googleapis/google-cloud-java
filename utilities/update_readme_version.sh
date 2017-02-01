#!/bin/bash

# This script updates the READMEs with the latest non-SNAPSHOT version number.
# Example: Suppose that before running this script, the pom.xml reads 7.8.9.  This script will replace 
# all occurrences of <version>#.#.#</version> with <version>7.8.9</version> in the README files.

set -e

# Get the current maven project version.
RELEASED_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -Ev '(^\[|\w+:)' | grep -Eo '[0-9]+\.[0-9]+\.[0-9]+')

if [ "${RELEASED_VERSION##*-}" != "SNAPSHOT" ]; then
    echo "Changing version to $RELEASED_VERSION in README files"
    # Get list of directories for which README.md must be updated
    module_folders=($(find . -maxdepth 2 -type d | sed -E -n "/^\.\/(google-cloud-contrib\/)?google-cloud(-[a-z]+)+$/p") . ./google-cloud)
    readmes=""
    for item in ${module_folders[*]}
    do
        if [ -f ${item}/README.md ]; then
            sed -ri "s/<version>[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+)?<\/version>/<version>${RELEASED_VERSION}\1<\/version>/g" ${item}/README.md
            sed -ri "s/:[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+)?'/:${RELEASED_VERSION}\1'/g" ${item}/README.md
            sed -ri "s/\"[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+)?\"/\"${RELEASED_VERSION}\1\"/g" ${item}/README.md
            readmes="$readmes ${item}/README.md"
        fi
    done
    NEW_VERSION=${RELEASED_VERSION%.*}.$((${RELEASED_VERSION##*.}+1))-alpha-SNAPSHOT
    echo "Changing version to $NEW_VERSION in google-cloud-nio-example README"
    sed -ri "s/google-cloud-nio-[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+)?-SNAPSHOT/google-cloud-nio-$NEW_VERSION/g" google-cloud-contrib/google-cloud-nio-examples/README.md
    sed -ri "s/google-cloud-nio-examples-[0-9]+\.[0-9]+\.[0-9]+(-[a-z]+)?-SNAPSHOT/google-cloud-nio-examples-$NEW_VERSION/g" google-cloud-contrib/google-cloud-nio-examples/README.md
    git add $readmes
fi
