#!/bin/bash

# This script is used by Travis-CI to publish artifacts (binary, sorce and javadoc jars) when releasing snapshots.
# This script is referenced in .travis.yml.

echo "Travis branch:       " ${TRAVIS_BRANCH}
echo "Travis pull request: " ${TRAVIS_PULL_REQUEST}
echo "Travis JDK version:  " ${TRAVIS_JDK_VERSION}
if [ "${TRAVIS_JDK_VERSION}" == "oraclejdk7" -a "${TRAVIS_BRANCH}" == "master" -a "${TRAVIS_PULL_REQUEST}" == "false" ]; then
    mvn cobertura:cobertura coveralls:report
    mvn deploy -DskipTests=true -Dgpg.skip=true --settings target/travis/settings.xml

    # Deploy site if not a SNAPSHOT
    SITE_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -Ev '(^\[|Download\w+:)')
    if [ "${SITE_VERSION##*-}" != "SNAPSHOT" ]; then
        mvn site-deploy -DskipTests=true --settings=target/travis/settings.xml

        # Update "latest" webpage
        git config --global user.name "travis-ci"
        git config --global user.email "travis@travis-ci.org"
        git clone --branch gh-pages --single-branch https://github.com/GoogleCloudPlatform/gcloud-java/ tmp_gh-pages
        cd tmp_gh-pages
        mkdir -p site/latest/
        echo "<html><head><meta http-equiv=\"refresh\" content=\"0; URL='http://GoogleCloudPlatform.github.io/gcloud-java/site/${SITE_VERSION}/index.html'\" /></head><body></body></html>" > site/latest/index.html
        git add site/latest/index.html

        # Update "Quickstart with Maven" block on landing page to reflect latest version
        sed -i "s/{{SITE_VERSION}}/$SITE_VERSION/g" site/${SITE_VERSION}/index.html
        git add site/${SITE_VERSION}/index.html

        git commit -m "Update the redirect in 'latest/index.html' and the version in the 'Quickstart with Maven' landing page box to $SITE_VERSION"
        git config --global push.default simple
        git push --quiet "https://${CI_DEPLOY_USERNAME}:${CI_DEPLOY_PASSWORD}@github.com/GoogleCloudPlatform/gcloud-java.git" > /dev/null 2>&1
    fi
else
    echo "Not deploying artifacts. This is only done with non-pull-request commits to master branch with Oracle Java 7 builds."
fi
