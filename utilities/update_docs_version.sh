#!/bin/bash

# This script updates the READMEs with the latest non-SNAPSHOT version number.
# Example: Suppose that before running this script, the pom.xml reads 7.8.9.  This script will replace 
# all occurrences of <version>#.#.#</version> with <version>7.8.9</version> in the README files.

# Get the current maven project version.
RELEASED_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -Ev '(^\[|\w+:)')

if [ "${RELEASED_VERSION##*-}" != "SNAPSHOT" ]; then
    echo "Changing version to $RELEASED_VERSION in README files"
    # Get list of directories for which README.md must be updated
    module_folders=($(find . -maxdepth 1 -name 'gcloud-java*' -type d) .)
    for item in ${module_folders[*]}
    do
        sed -ri "s/<version>[0-9]+\.[0-9]+\.[0-9]+<\/version>/<version>${RELEASED_VERSION}<\/version>/g" ${item}/README.md
        sed -ri "s/:[0-9]+\.[0-9]+\.[0-9]+'/:${RELEASED_VERSION}'/g" ${item}/README.md
        sed -ri "s/\"[0-9]+\.[0-9]+\.[0-9]+\"/\"${RELEASED_VERSION}\"/g" ${item}/README.md
    done

    echo "Changing version to $((RELEASED_VERSION + 1))-SNAPSHOT in gcloud-java-nio-example README"
    sed -ri "s/gcloud-java-nio-examples-[0-9]+\.[0-9]+\.[0-9]+-SNAPSHOT'/gcloud-java-nio-examples-$((RELEASED_VERSION + 1))-SNAPSHOT'/g" gcloud-java-contrib/gcloud-java-nio-examples/README.md
    
    git add README.md */README.md
    git config --global user.name "travis-ci"
    git config --global user.email "travis@travis-ci.org"
    git commit -m "Updating version in README files. [ci skip]"
    git push --quiet "https://${CI_DEPLOY_USERNAME}:${CI_DEPLOY_PASSWORD}@github.com/GoogleCloudPlatform/gcloud-java.git" HEAD:master > /dev/null 2>&1
fi
