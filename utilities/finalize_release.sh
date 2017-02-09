#!/bin/bash

set -e

mvn nexus-staging:release

# Push the version and README updates
git push

# Push the gh-pages updates
cd tmp_gh-pages
git push
