#!/bin/bash

set -e

SITE_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -Ev '(^\[|\w+:)')
echo "Used the maven-help-plugin to determine that the version is $SITE_VERSION"
if [ -z "$SITE_VERSION" ]; then
    echo "Could not determine the version, so we're exiting."
    exit 1
fi

# Deploy the build artifacts to Sonatype
./utilities/deploy.sh "$SITE_VERSION"

if [ "${SITE_VERSION##*-}" != "SNAPSHOT" ]; then
    # Create website
    ./utilities/create_site.sh "$SITE_VERSION"

    cd tmp_gh-pages
    git commit --quiet -m "Added a new site for version $SITE_VERSION and updated the root directory's redirect. [ci skip]"
fi
