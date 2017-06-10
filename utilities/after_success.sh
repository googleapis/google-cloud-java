#!/bin/bash

# This script is used by Travis-CI to publish artifacts (binary, sorce and javadoc jars) when releasing snapshots.
# This script is referenced in .travis.yml.

echo "Travis branch:       " ${TRAVIS_BRANCH}
echo "Travis pull request: " ${TRAVIS_PULL_REQUEST}
echo "Travis JDK version:  " ${TRAVIS_JDK_VERSION}

if [ "${TRAVIS_JDK_VERSION}" == "oraclejdk7" ]; then
    mvn clean cobertura:cobertura coveralls:report --quiet -Djava.util.logging.config.file=logging.properties
    if [ "${TRAVIS_PULL_REQUEST}" == "false" -a "${TRAVIS_BRANCH}" == "master" ]; then
        source ./utilities/integration_test_env.sh
        SITE_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -Ev '(^\[|\w+:)')
        echo "Used the maven-help-plugin to determine that the version is $SITE_VERSION"
        if [ "$SITE_VERSION" == "" ]; then
            echo "Could not determine the version, so we're exiting."
            exit 1
        fi

        mvn clean deploy --quiet -Djava.util.logging.config.file=logging.properties -DskipTests=true -Dgpg.skip=true --settings ~/.m2/settings.xml -P release
    else
        echo "Not deploying artifacts. This is only done with non-pull-request commits to master branch with Oracle Java 7 builds."
    fi
else
    echo "Not deploying artifacts. This is only done with non-pull-request commits to master branch with Oracle Java 7 builds."
fi
