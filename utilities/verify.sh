#!/bin/bash
# This script is used by Travis-CI to run tests.
# This script is referenced in .travis.yml.

mvn_opts="-DtrimStackTrace=false -fae --quiet -Djava.util.logging.config.file=logging.properties -P release"

if [ "${TRAVIS_PULL_REQUEST}" == "false" ]; then
    # Get signing tools and API keyfile
    openssl aes-256-cbc -K $encrypted_631490ecae8f_key -iv $encrypted_631490ecae8f_iv -in target/travis/signing-tools.tar.enc -out $TRAVIS_BUILD_DIR/signing-tools.tar -d
    mkdir $TRAVIS_BUILD_DIR/signing-tools
    chmod 700 $TRAVIS_BUILD_DIR/signing-tools
    tar xvf $TRAVIS_BUILD_DIR/signing-tools.tar -C $TRAVIS_BUILD_DIR/signing-tools
    echo $api_key_password | gpg --passphrase-fd 0 --output $TRAVIS_BUILD_DIR/signing-tools/api_key target/travis/api_key.gpg
    source ./utilities/integration_test_env.sh
else
    # Skip integration tests when testing pull requests.
    mvn_opts+=" -DskipITs"
fi

# We don't quote expansion here, since we actually want space to separate the arguments.
mvn verify $mvn_opts
