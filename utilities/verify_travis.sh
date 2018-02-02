#!/bin/bash
# This script is used by Travis-CI to run tests.
# This script is referenced in .travis.yml.

mvn verify -B -DtrimStackTrace=false -fae --quiet -DskipITs -Djava.util.logging.config.file=logging.properties -P release
