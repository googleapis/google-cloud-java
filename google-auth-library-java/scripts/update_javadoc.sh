#!/bin/bash

# Copyright 2017, Google Inc. All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are
# met:
#
#    * Redistributions of source code must retain the above copyright
# notice, this list of conditions and the following disclaimer.
#    * Redistributions in binary form must reproduce the above
# copyright notice, this list of conditions and the following disclaimer
# in the documentation and/or other materials provided with the
# distribution.
#
#    * Neither the name of Google Inc. nor the names of its
# contributors may be used to endorse or promote products derived from
# this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
# A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
# OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
# SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
# LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
# DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
# THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
# (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
# OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

set -e

VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -Ev '(^\[|\w+:)')

if [ -z "$VERSION" ]; then
    echo "Error updating Javadoc: could not obtain version number from maven-help-plugin."
    exit 1
fi

git clone --branch gh-pages --single-branch git@github.com:googleapis/google-auth-library-java.git tmp_gh-pages
mkdir -p tmp_gh-pages/releases/$VERSION

mvn javadoc:aggregate

pushd tmp_gh-pages/
cp -r ../target/site/* releases/$VERSION/
git add releases/$VERSION

# copy to latest
rm -rf releases/latest
cp -r releases/$VERSION releases/latest
git add releases/latest

echo "<html><head><meta http-equiv=\"refresh\" content=\"0; URL='http://googleapis.github.io/google-auth-library-java/releases/${VERSION}/apidocs/index.html'\" /></head><body></body></html>" > index.html
git add index.html

git commit --quiet -m "Add version $VERSION and update root redirect [ci skip]"
git push

popd
rm -rf tmp_gh-pages
