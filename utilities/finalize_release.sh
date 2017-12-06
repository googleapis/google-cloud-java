#!/bin/bash

set -e

mvn nexus-staging:release

# Push the version and README updates
git push

# Push the gh-pages updates
pushd tmp_gh-pages
git push
popd

# Remove gh-pages temporary directory
rm -rf tmp_gh-pages
