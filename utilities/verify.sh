#!/bin/bash
source ./utilities/integration_test_env.sh

# This script is used by Travis-CI to run tests.
# This script is referenced in .travis.yml.

if [ "${TRAVIS_BRANCH}" == "master" -a "${TRAVIS_PULL_REQUEST}" == "false" ]; then
    # Get signing tools and API keyfile
    openssl aes-256-cbc -K $encrypted_631490ecae8f_key -iv $encrypted_631490ecae8f_iv -in target/travis/signing-tools.tar.enc -out $TRAVIS_BUILD_DIR/signing-tools.tar -d
    mkdir $TRAVIS_BUILD_DIR/signing-tools
    chmod 700 $TRAVIS_BUILD_DIR/signing-tools
    tar xvf $TRAVIS_BUILD_DIR/signing-tools.tar -C $TRAVIS_BUILD_DIR/signing-tools
    # Run verify
    mvn verify
else
    mvn verify -DskipITs
fi
