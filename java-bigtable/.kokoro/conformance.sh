#!/bin/bash
# Copyright 2023 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -eo pipefail

## Get the directory of the build script
scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
## cd to the parent directory, i.e. the root of the git repo
cd ${scriptDir}/..

# include common functions
source ${scriptDir}/common.sh

# Print out Maven & Java version
mvn -version
echo ${JOB_TYPE}

# attempt to install 3 times with exponential backoff (starting with 10 seconds)
retry_with_backoff 3 10 \
  mvn install -B -V -ntp \
    -DskipTests=true \
    -Dclirr.skip=true \
    -Denforcer.skip=true \
    -Dmaven.javadoc.skip=true \
    -Dgcloud.download.skip=true \
    -T 1C

RETURN_CODE=0
set +e

# Build and start the proxy in a separate process
pushd .
cd test-proxy
mvn clean install -DskipTests
nohup java -Dport=9999 -jar target/google-cloud-bigtable-test-proxy-0.0.1-SNAPSHOT.jar &
proxyPID=$!
popd

# Run the conformance test
pushd .
cd cloud-bigtable-clients-test/tests
eval "go test -v -skip `cat ../../test-proxy/known_failures.txt` -proxy_addr=:9999"
RETURN_CODE=$?
popd

# Stop the proxy
kill $proxyPID

# fix output location of logs
bash .kokoro/coerce_logs.sh

echo "exiting with ${RETURN_CODE}"
exit ${RETURN_CODE}
