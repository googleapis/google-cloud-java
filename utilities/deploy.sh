#!/bin/bash

set -e

SITE_VERSION=$1

if [ -z $SITE_VERSION ]; then
    echo "First arg (version) not provided, so we're exiting."
    exit 1
fi

if [ "${SITE_VERSION##*-}" == "SNAPSHOT" ]; then
    echo "Deploying Snapshot artifacts..."
    mvn clean deploy --quiet -Djava.util.logging.config.file=logging.properties -DskipTests=true -Dgpg.skip=true --settings ~/.m2/settings.xml -P release
else
    # Deploy Maven artifacts (if they don't exist yet) and update artifact version in READMEs.
    URL=https://oss.sonatype.org/content/repositories/releases/com/google/cloud/google-cloud/$SITE_VERSION/
    if curl --output /dev/null --silent --head --fail "$URL"; then
        echo "Not deploying artifacts because it seems like they already exist."
        echo "Existence was checked using the url $URL"
    else
        echo "Deploying Release artifacts..."
        mvn clean deploy --quiet -Djava.util.logging.config.file=logging.properties -DskipTests=true --settings ~/.m2/settings.xml -P release
    fi
fi
